package com.example.elmarvin.examesnestest1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartTestActivity extends AppCompatActivity {

    private Button buttonEmpezar;
    private TextView textViewNroPreguntas;
    private TextView textViewCedula;
    Controlador c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_test);
        c = new Controlador();
        c.setCedula(this.getIntent().getExtras().getString("CEDULA"));
        textViewNroPreguntas = (TextView) findViewById(R.id.textViewNroPreguntas);
        textViewCedula = (TextView) findViewById(R.id.textViewCedula);
        buttonEmpezar = (Button)findViewById(R.id.buttonStart);
        textViewNroPreguntas.setText(String.valueOf(c.nroPreguntas()));

        buttonEmpezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartTestActivity.this, Pregunta4Activity.class);
                Bundle b = new Bundle();
                b.putSerializable("CONTROLADOR", c);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

    }
}
