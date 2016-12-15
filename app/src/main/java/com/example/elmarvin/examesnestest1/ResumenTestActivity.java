package com.example.elmarvin.examesnestest1;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.entity.StringEntity;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.util.EntityUtils;

public class ResumenTestActivity extends AppCompatActivity {
    private Controlador controlador;
    private TextView    textViewCalificacionCualitativa;
    private TextView    textViewCalificacionCuantitativa;
    private TextView    textViewPositivas;
    private TextView    textViewNegativas;
    private TextView    textViewNoSabe;
    private Button      buttonGuardarFinalizar;
    private final static String DATE_PATTERN = "yyyy-MM-dd'T'hh:mm:ss";
    private boolean flag = false;
    private boolean flagsave = false;
    private boolean flagbutton = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen_test);
        controlador = (Controlador) this.getIntent().getExtras().getSerializable("CONTROLADOR");
        textViewCalificacionCualitativa = (TextView)findViewById(R.id.textViewCalificacionCualitativo);
        textViewCalificacionCuantitativa= (TextView)findViewById(R.id.textViewCalificacionCuantitativo);
        textViewPositivas= (TextView)findViewById(R.id.textViewPositivas);
        textViewNegativas= (TextView)findViewById(R.id.textViewNegativas);
        textViewNoSabe= (TextView)findViewById(R.id.textViewNoSabe);
        buttonGuardarFinalizar = (Button)findViewById(R.id.buttonGuardarFinalizar);

        textViewCalificacionCuantitativa.setText(String.valueOf(controlador.getCalificacion_cuantitativa_string()));
        textViewCalificacionCualitativa.setText(controlador.getCalificacion_cualitativa());

        textViewPositivas.setText(String.valueOf(controlador.getPositivas())+" positivas");
        textViewNegativas.setText(String.valueOf(controlador.getNegativas())+" negativas");
        textViewNoSabe.setText(String.valueOf(controlador.getNosabe())+" no sabe");

        buttonGuardarFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TareaRegistrar tarea_a = new TareaRegistrar();
                tarea_a.execute();
                controlador.guardarControlador2();
                buttonGuardarFinalizar.setText("Guardado... :)");
                buttonGuardarFinalizar.setEnabled(false);
            }
        });

    }

    @Override
    public void onBackPressed() {

    }

    private class TareaRegistrar extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... params){

            HttpClient httpClient = new DefaultHttpClient();

            //Log.i("URL DE PETICION-> ", config.getApiRegistroUrl());
            Gson gson = new GsonBuilder().setDateFormat(DATE_PATTERN).disableHtmlEscaping().create();
            String json = gson.toJson(controlador);
            Log.d("R", json);

            HttpPost post = new HttpPost("https://nodejs-apirest.herokuapp.com/api/registros");
            post.setHeader("content-type", "application/json");

            try{

                StringEntity entity = new StringEntity(json);
                post.setEntity(entity);

                HttpResponse response = httpClient.execute(post);
                String respuesta = EntityUtils.toString(response.getEntity());
                Log.i("ID DEL USUARIO ->", respuesta.toString());
                //usuario_logueado = objeto;


            }catch (Exception e){
                flagsave=false;
                Log.i("ID DEL NUEVO USUARIO ->", "Fallo la peticion **************");
                Log.i("ID DEL NUEVO USUARIO ->", e.getMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result){

            Intent intent = new Intent(ResumenTestActivity.this, MainActivity.class);
            startActivity(intent);
            flagsave = true;
        }

    }
}
