package com.example.dpdmclase06;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ArchivoActivity extends AppCompatActivity {
    //Definir instancias
    private EditText nombreArchivo;
    private Button accion;
    //Variables
    String contenido; //Colocar el contenido del archivo
    int modo; //Modo del archivo
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archivo);
        //Asociar al componente gráfico
        nombreArchivo = findViewById(R.id.editNombre);
        //Se obtiene el parámetro para indicar el modo (leer -1  escribir -2) del archivo
        modo = getIntent().getIntExtra("modo", 1);
        //Validar según modo, cambiar el texto del botón
        switch (modo){
            case 1:
                accion.setText("Abrir");
                break;
            case 2:
                accion.setText("Guardar");
                //Se lee el contenido de la informacion a guardar(escribir) en el archivo
                contenido = getIntent().getStringExtra("contenido");
                break;
        }//switch
    }//onCreate
    public void realizaAccion(View view){
        //Se obtiene lo escrito en el cuadro de texto
        String nomArch = nombreArchivo.getText().toString();
        //Se valida que no este vacio
        if(!nomArch.isEmpty()){
            //De acuerdo al tipo de acción se ejecuta el método correspondiente
            switch (modo){
                case 1: abrirArchivoSD(nomArch); break;
                case 2: guardarArchivoSD(nomArch); break;
            }//switch
            finish();
        }//if
        else{
            Toast.makeText(this, "Debes escribir un nombre.", Toast.LENGTH_SHORT).show();
        }
    }//realizaAccion

    private void abrirArchivoSD(String nomArch) {
        try {
            //Se obtiene la ruta del almacenamiento externo
            File tarjetaSD = Environment.getExternalStorageDirectory();
            //Se define el nombre del archivo y la ruta donde será guardado
            File archivo = new File(tarjetaSD.getPath(),nomArch);
            //Abrir rl archivi
            InputStreamReader abrirArchivo = new InputStreamReader(openFileInput(archivo.getName()));
            //Asocia el flujo con el archivo, para obtener la informacion
            BufferedReader leerArchivo = new BufferedReader(abrirArchivo);
            //lectura del archivo y colocar en una variable de tipo cadena
            String linea = leerArchivo.readLine();
            //Variable que guardará la información leida desde el archivo, se inicializa en vacío
            String textoLeido = "";

            //Ciclo para leer el contenido del archivo
            while (linea!=null){
                textoLeido += linea +'\n';
                linea = leerArchivo.readLine();
            }//while

            //Cerrar el flujo del archivo
            leerArchivo.close();
            //Cerrar el archivo
            abrirArchivo.close();

            //Objeto para conectar a otra Activity para guardar archivo
            Intent intent = new Intent(this,MainActivity.class);
            intent.putExtra("contenido",textoLeido);
            //Iniciar la Activity
            startActivity(intent);
        }catch (IOException ex){
            Toast.makeText(this, "El archivo no se pudo leer.", Toast.LENGTH_SHORT).show();
        }//trycatch
    }//abrirArchivoSD

    private void guardarArchivoSD(String nomArch) {
        try{
            //Se obtiene la ruta de almacenamiento externo
            File tarjetaSD = Environment.getExternalStorageDirectory();
            //Se muestra la ruta
            Toast.makeText(this, tarjetaSD.getPath(), Toast.LENGTH_SHORT).show();
            //Se define el nombre del archivo y la ruta donde será guardado
            File archivo = new File(tarjetaSD.getPath(),nomArch);
            //Crea el archivo y establece el modo de acceso
            OutputStreamWriter crearArchivo = new OutputStreamWriter(openFileOutput(archivo.getName(), Activity.MODE_PRIVATE));
            //Se excribe el contenido en el archivo
            crearArchivo.write(contenido);
            //Se limpia el buffer
            crearArchivo.flush();
            //Se cierra el archivo
            crearArchivo.close();
            Toast.makeText(this, "Información almacenada!", Toast.LENGTH_SHORT).show();

        }catch (IOException ex){
            Toast.makeText(this,"El archivo no se pudo guardar.",Toast.LENGTH_SHORT);
        }
    }//guardarArchivoSD
}