package com.example.diana.mutiplicacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class inicio extends AppCompatActivity {

    //Math.random()*12 +1
    public TextView operacion;
    public EditText resultado;
    public int num1;
    public int num2;
    public int num_ejercicios = 0;
    public Toast mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        operacion = (TextView) findViewById(R.id.txt_operacion);
        resultado = (EditText) findViewById(R.id.txt_resultado);

        numeros();
    }

    public void numeros(){
        num1 = (int) (Math.random()*12 +1);
        num2 = (int) (Math.random()*12 +1);

        String v1 = String.valueOf(num1);
        String v2 = String.valueOf(num2);

        operacion.setText(v1+" X "+v2);
    }

    public void verificar(View view) {
        int resul = num1 * num2;
        int r_txt = Integer.valueOf(resultado.getText().toString());

        if (resul == r_txt) {
            num_ejercicios += 1;
            if (num_ejercicios < 5) {
                this.numeros();
                this.mensaje = Toast.makeText(getApplicationContext(),getResources().getString(R.string.msg1) + String.valueOf(5-num_ejercicios) + getResources().getString(R.string.msg2), Toast.LENGTH_SHORT);
                this.mensaje.show();
                this.resultado.setText("");
            }
            else {
                this.mensaje = Toast.makeText(getApplicationContext(),"Felicidades, terminaste tus ejercicios diarios", Toast.LENGTH_SHORT);
                this.mensaje.show();
                this.resultado.setText("");
            }
        }
        else {
            this.numeros();
            this.mensaje = Toast.makeText(getApplicationContext(),"Fallaste, El resultado es " + String.valueOf(resul), Toast.LENGTH_SHORT);
            this.mensaje.show();
            this.resultado.setText("");
        }
    }

    public void about(View view) {
        Intent i = new Intent(this, About.class );
        startActivity(i);
    }
}
