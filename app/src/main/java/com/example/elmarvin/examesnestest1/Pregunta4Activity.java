package com.example.elmarvin.examesnestest1;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Pregunta4Activity extends AppCompatActivity {

    private TextView    textViewPreguntaNro;
    private TextView    textViewEncabezadoPregunta;
    private RadioGroup  radioGroupRespuestas;
    private RadioButton radioButtonResp1;
    private RadioButton radioButtonResp2;
    private RadioButton radioButtonResp3;
    private RadioButton radioButtonResp4;
    private RadioButton radioButtonResp5;
    private RadioButton radioButtonResp6;
    private TextView    textViewEstadoPregunta;
    private Controlador controlador;
    private Button buttonAceptar;
    private boolean aux = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta4);
        textViewPreguntaNro = (TextView)findViewById(R.id.textViewPreguntaNro);
        radioGroupRespuestas = (RadioGroup) findViewById(R.id.radioGroupRespuestas);
        textViewEncabezadoPregunta = (TextView)findViewById(R.id.textViewEncabezadoPregunta);
        radioGroupRespuestas = (RadioGroup)findViewById(R.id.radioGroupRespuestas);
        radioButtonResp1 = (RadioButton)findViewById(R.id.radio_respuesta1);
        radioButtonResp2 = (RadioButton)findViewById(R.id.radio_respuesta2);
        radioButtonResp3 = (RadioButton)findViewById(R.id.radio_respuesta3);
        radioButtonResp4 = (RadioButton)findViewById(R.id.radio_respuesta4);
        radioButtonResp5 = (RadioButton)findViewById(R.id.radio_respuesta5);
        radioButtonResp6 = (RadioButton)findViewById(R.id.radio_respuesta6);
        textViewEstadoPregunta = (TextView)findViewById(R.id.textViewEstadoRespuesta);
        buttonAceptar = (Button)findViewById(R.id.buttonAceptar);
        controlador = (Controlador) this.getIntent().getExtras().getSerializable("CONTROLADOR");

        textViewEncabezadoPregunta.setText(controlador.getPreguntaActual().getEncabezado().toString());
        radioButtonResp1.setText(controlador.getPreguntaActual().getRespuestaNro(0).getEncabezado().toString());
        radioButtonResp2.setText(controlador.getPreguntaActual().getRespuestaNro(1).getEncabezado().toString());
        radioButtonResp3.setText(controlador.getPreguntaActual().getRespuestaNro(2).getEncabezado().toString());
        radioButtonResp4.setText(controlador.getPreguntaActual().getRespuestaNro(3).getEncabezado().toString());
        radioButtonResp5.setText(controlador.getPreguntaActual().getRespuestaNro(4).getEncabezado().toString());
        radioButtonResp6.setText(controlador.getPreguntaActual().getRespuestaNro(5).getEncabezado().toString());
        textViewPreguntaNro.setText("Pregunta Nro "+(controlador.getPregunta_actual()+1));


        buttonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((controlador.getPregunta_actual()+1)<=controlador.nroPreguntas()){
                    if(aux){
                        Intent intent = new Intent(Pregunta4Activity.this, Pregunta4Activity.class);
                        Bundle b = new Bundle();
                        b.putSerializable("CONTROLADOR", controlador);
                        intent.putExtras(b);
                        startActivity(intent);
                    }else{
                        comprobarRespuesta(v);
                        controlador.setMasUnoPreguntaActual();
                    }
                }else{
                    Intent intent2 = new Intent(Pregunta4Activity.this, ResumenTestActivity.class);
                    Bundle b2 = new Bundle();
                    b2.putSerializable("CONTROLADOR", controlador);
                    intent2.putExtras(b2);
                    startActivity(intent2);
                }

            }
        });

    }

    public void comprobarRespuesta(View view) {
        if (radioGroupRespuestas.getCheckedRadioButtonId() == R.id.radio_respuesta1) {
            controlador.getPreguntaActual().getRespuestaNro(0).setElegida(true);
            if(controlador.getPreguntaActual().getRespuestaNro(0).isEstado()){
                controlador.setMasUnoPositivas();
                radioButtonResp1.setBackgroundColor(Color.parseColor("#33ff33"));
                textViewEstadoPregunta.setText("Respuesta Correcta");
            }else{
                controlador.setMasUnoNegativas();
                radioButtonResp1.setBackgroundColor(Color.parseColor("#ff3333"));
                textViewEstadoPregunta.setText("Respuesta Incorrecta");
            }
        }
        if (radioGroupRespuestas.getCheckedRadioButtonId() == R.id.radio_respuesta2) {
            controlador.getPreguntaActual().getRespuestaNro(1).setElegida(true);
            if(controlador.getPreguntaActual().getRespuestaNro(1).isEstado()){
                controlador.setMasUnoPositivas();
                radioButtonResp2.setBackgroundColor(Color.parseColor("#33ff33"));
                textViewEstadoPregunta.setText("Respuesta Correcta");
            }else{
                controlador.setMasUnoNegativas();
                radioButtonResp2.setBackgroundColor(Color.parseColor("#ff3333"));
                textViewEstadoPregunta.setText("Respuesta Incorrecta");
            }
        }
        if (radioGroupRespuestas.getCheckedRadioButtonId() == R.id.radio_respuesta3) {
            controlador.getPreguntaActual().getRespuestaNro(2).setElegida(true);
            if(controlador.getPreguntaActual().getRespuestaNro(2).isEstado()){
                controlador.setMasUnoPositivas();
                radioButtonResp3.setBackgroundColor(Color.parseColor("#33ff33"));
                textViewEstadoPregunta.setText("Respuesta Correcta");
            }else{
                controlador.setMasUnoNegativas();
                radioButtonResp3.setBackgroundColor(Color.parseColor("#ff3333"));
                textViewEstadoPregunta.setText("Respuesta Incorrecta");
            }
        }
        if (radioGroupRespuestas.getCheckedRadioButtonId() == R.id.radio_respuesta4) {
            controlador.getPreguntaActual().getRespuestaNro(3).setElegida(true);
            if(controlador.getPreguntaActual().getRespuestaNro(3).isEstado()){
                controlador.setMasUnoPositivas();
                radioButtonResp4.setBackgroundColor(Color.parseColor("#33ff33"));
                textViewEstadoPregunta.setText("Respuesta Correcta");
            }else{
                controlador.setMasUnoNegativas();
                radioButtonResp4.setBackgroundColor(Color.parseColor("#ff3333"));
                textViewEstadoPregunta.setText("Respuesta Incorrecta");
            }
        }
        if (radioGroupRespuestas.getCheckedRadioButtonId() == R.id.radio_respuesta5) {
            controlador.getPreguntaActual().getRespuestaNro(4).setElegida(true);
            if(controlador.getPreguntaActual().getRespuestaNro(4).isEstado()){
                controlador.setMasUnoPositivas();
                radioButtonResp5.setBackgroundColor(Color.parseColor("#33ff33"));
                textViewEstadoPregunta.setText("Respuesta Correcta");
            }else{
                controlador.setMasUnoNegativas();
                radioButtonResp5.setBackgroundColor(Color.parseColor("#ff3333"));
                textViewEstadoPregunta.setText("Respuesta Incorrecta");
            }
        }
        if (radioGroupRespuestas.getCheckedRadioButtonId() == R.id.radio_respuesta6) {
            controlador.getPreguntaActual().getRespuestaNro(5).setElegida(true);
            controlador.setMasUnoNoSabe();
            radioButtonResp6.setBackgroundColor(Color.parseColor("#b300b3"));
        }
        //textViewEncabezadoPregunta.setText(String.valueOf(controlador.getPositivas()+""+controlador.getNegativas()+""+controlador.getNosabe()));
        radioButtonResp1.setEnabled(false);
        radioButtonResp2.setEnabled(false);
        radioButtonResp3.setEnabled(false);
        radioButtonResp4.setEnabled(false);
        radioButtonResp5.setEnabled(false);
        radioButtonResp6.setEnabled(false);
        buttonAceptar.setText("Siguiente Pregunta");
        aux = true;
    }

    @Override
    public void onBackPressed() {

    }
}
