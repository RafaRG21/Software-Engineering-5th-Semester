package com.example.parcial2ruizjose;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner usuarios;
    EditText contrasena;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Conraseña
        contrasena = findViewById(R.id.txtpaswd);
        usuarios = findViewById(R.id.spnUsr);
        //Definicion del arreglo de usuarios
        String[] listaUsuarios = {"Rafael","Luis","Miguel"};
        ArrayAdapter<String> usuariosAdapter = new ArrayAdapter<String>(this,
                androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item,listaUsuarios);
        //Asociacion con el componentes
        usuarios.setAdapter(usuariosAdapter);
        //inicializacion de los objetos
    }//onCreate
    public void salir(View view){
        Toast.makeText(this, "Saliendo, adios", Toast.LENGTH_SHORT).show();
        finish();
    }//salir
    public void ingreso(View view){
        int contra = Integer.parseInt(contrasena.getText().toString());
        String user = usuarios.getSelectedItem().toString();
        if(user.equals("Rafael")&&contra == 1234||user.equals("Luis")&&contra==5269||user.equals("Miguel")&&contra==321){
            Intent form = new Intent(MainActivity.this,FormularioActivity.class);
            startActivity(form);
            finish();
        } else{
            Toast.makeText(this, "Usuario o contraseña incorrecto", Toast.LENGTH_SHORT).show();
        }
    }
}