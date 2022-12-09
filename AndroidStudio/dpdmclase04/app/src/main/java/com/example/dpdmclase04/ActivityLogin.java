package com.example.dpdmclase04;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class ActivityLogin extends AppCompatActivity {
    //Instancias de objetos
    private EditText mail, password;
    private CheckBox guardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Asociar los componentes gráficos con las instancias
        mail = findViewById(R.id.txtCorreologin);
        password = findViewById(R.id.txtPasswordLogin);
        guardar = findViewById(R.id.chkDatosLogin);
    }//onCreate

    //Metodo para acceder al menu
    public void ingresarMenu(View view){
        //Instancia de la clase Usuario
        Usuario usuario = new Usuario(mail.getText().toString().trim(),password.getText().toString().trim(),true);
        //Validar si guarda los datos como preferencia
        if(guardar.isChecked()){
            //Metodo para guardar los datos en el dispositivo
            guardarPreferencias(usuario);
        }
        //Llamada al activity principal
        Intent intent = new Intent(ActivityLogin.this,MainActivity.class);
        startActivity(intent);
        finish();
    }//ingresarMenu
    private void guardarPreferencias(Usuario usr){
        //Crear un objeto donde se almacenen las preferencias de usuario y contraseña
        SharedPreferences preferencias = getSharedPreferences("user.dat",MODE_PRIVATE);
        //Se cambia a modo edicion para guardar los valores
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putString("usuario",usr.getCorreo());
        editor.putString("contrasena",usr.getContrasena());
        editor.putBoolean("registrado",usr.isRegistrado());
        editor.apply();//Guardar los cambios
    }//guardarPreferencias
    public void salirMenu(View view){
        finish();
    }//SalirMenu
}//class