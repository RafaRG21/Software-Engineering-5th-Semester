package com.example.dpdmclase04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //crear un objeto de la clase TimerTask que genera un hilo para determinar cual
        //activity se ejecutara, dependiendo de las preferencias de datos almacenados
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                //Crear un objeto intent para asignarle la Activity correspondiente
                Intent intent;
                //Evaluar si existen datos de preferencia almacenados en el dispositivo
                if(nuevoUsuario()){
                    //Existen datos almacenados, se ejecuta el activity del menu
                    intent = new Intent(MainActivity.this,MenuActivity.class);
                } else{
                    //No existen datos almacenados, se ejecuta el activity del login
                    intent = new Intent(MainActivity.this,ActivityLogin.class);
                }
                //Ejecutar la activity correspondiente
                startActivity(intent);
                //Eliminar la activity actual
                finish();
            }//run
        };//tarea
        //Definir un tiempo de espera de 2 segundos
        Timer tiempo = new Timer();
        tiempo.schedule(tarea,2000);
    }//onCreate

    //Método para conocer si hay datos almacenados de correo y contraseña
    //dentro del dispositivo. Para ello se utiliza la clase SharedPreferences
    //que permite almacenar valores de configuracion dentro del dispositivo movil
    private boolean nuevoUsuario(){
        //Definir el objeto donde se almacenan las preferencias
        SharedPreferences preferencias = getSharedPreferences("user.dat",MODE_PRIVATE);
        //Devuelve el estatus de existencia de informacion (true), devuelve falso en caso de no existir
        //algo almacenado previamente (sin datos almacendados previamnete)
        //registrado es el nombre del campo donde se almacena el valor lógico
        return preferencias.getBoolean("registrado",false);
    }//nuevoUsuario
}