package com.example.dpdmclase05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText mail, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Se asocian componentes a instancias
        mail = (EditText) findViewById(R.id.txtMainCorreo);
        password = (EditText) findViewById(R.id.txtMainPassword);
    }//onCreate
    public void ingresarMenu(View view){
        //se obtienen los datos de las cajas de texto
        String usr = mail.getText().toString().trim();
        String con = password.getText().toString().trim();
        //Se validadn si son datos correctos
        if(usr.equals("admin")&&con.equals("12345")){
            Intent intent = new Intent(getApplicationContext(),MenuLateralActivity.class);
            startActivity(intent);
        } else{
            Toast.makeText(this,"Datos incorrectos, intente de nuevo",Toast.LENGTH_SHORT).show();
        }
    }//ingresarMenu
    public void salirMenu(View view){
        //Finalizar Activity
        finish();
    }//salirMenu
}//Class