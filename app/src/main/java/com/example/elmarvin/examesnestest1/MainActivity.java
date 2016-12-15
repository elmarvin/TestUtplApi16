package com.example.elmarvin.examesnestest1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.nio.BufferUnderflowException;

public class MainActivity extends AppCompatActivity {

    private EditText editTextCedula;
    private TextView textViewInformacion;
    private Button buttonValidar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCedula = (EditText)findViewById(R.id.editTextCedula);
        textViewInformacion = (TextView)findViewById(R.id.textViewInformacion);
        buttonValidar = (Button) findViewById(R.id.buttonValidar);


        buttonValidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (valida(editTextCedula.getText().toString())){
                    textViewInformacion.setText("Validado");
                    Intent intent = new Intent(MainActivity.this, StartTestActivity.class);
                    Bundle b = new Bundle();
                    b.putString("CEDULA", editTextCedula.getText().toString());
                    intent.putExtras(b);
                    startActivity(intent);
                }else{
                    textViewInformacion.setText("Nro No Válido");
                }

            }
        });

    }


    public boolean valida(String x) {
        int suma = 0;
        if (x.length() == 9) {
            return false;
        } else {
            int a[] = new int[x.length() / 2];
            int b[] = new int[(x.length() / 2)];
            int c = 0;
            int d = 1;
            for (int i = 0; i < x.length() / 2; i++) {
                a[i] = Integer.parseInt(String.valueOf(x.charAt(c)));
                c = c + 2;
                if (i < (x.length() / 2) - 1) {
                    b[i] = Integer.parseInt(String.valueOf(x.charAt(d)));
                    d = d + 2;
                }
            }

            for (int i = 0; i < a.length; i++) {
                a[i] = a[i] * 2;
                if (a[i] > 9) {
                    a[i] = a[i] - 9;
                }
                suma = suma + a[i] + b[i];
            }
            int aux = suma / 10;
            int dec = (aux + 1) * 10;
            if ((dec - suma) == Integer.parseInt(String.valueOf(x.charAt(x.length() - 1))))
                return true;
            else if (suma % 10 == 0 && x.charAt(x.length() - 1) == '0') {
                return true;
            } else {
                return false;
            }

        }
    }
}
