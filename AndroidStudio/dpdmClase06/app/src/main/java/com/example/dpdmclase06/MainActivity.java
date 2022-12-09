package com.example.dpdmclase06;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    //Instancias para objeto multilinea e intent
    private EditText editor;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Asociar con componentes gráficos
        editor = (EditText) findViewById(R.id.edtEditor);
        //Leer el parámetro si existe información para colocar dentro del texto miltilinea
        editor.setText(getIntent().getStringExtra("contenido"));

    }//onCreate
    //Método para los casos menú

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //Obtener el item identificador del item
        int id = item.getItemId();
        //Estrucutura de casos para cada item
        switch (id){
            case R.id.itemAbrir:
                abrirArchivo();
                break;
            case R.id.itemGuardar:
                guardarArchivo();
                break;
            case R.id.itemAbrirSD:
                //Crear intent para llamar a la Activity ArchivoActivity
                intent = new Intent(MainActivity.this,ArchivoActivity.class);
                //Pasar un parámetro para indicar el modo de abrir el archivo, valor 1
                intent.putExtra("modo",1);
                //Ejecutar la Activity
                startActivity(intent);
                //Editar este vacío
                editor.setText("");
                break;
            case R.id.itemGuardarSD:
                //Crear intent para llamar a la Activity ArchivoActivity
                intent = new Intent(MainActivity.this,ArchivoActivity.class);
                //Pasar un parámetro para indicar el modo de escribir el archivo, valor 2
                intent.putExtra("modo",2);
                //Pasar la informacion a guardar como párametro
                intent.putExtra("contenido",editor.getText().toString());
                //Ejecutar la Activity
                startActivity(intent);
                //Editar este vacio
                editor.setText("");
                break;
        }
        return super.onOptionsItemSelected(item);
    }//onOptionsItemSelected
    //Método para mostrar/ocultar el menu overflow
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Asociar el menu_archivo.xml
        getMenuInflater().inflate(R.menu.menu_archivo,menu);
        return super.onCreateOptionsMenu(menu);
    }//onCreateOptionsMenu
    //Metodo para validar la existencia del archivo dentro del dispositivo
    private boolean existeArchivo(String[] archivos, String archivoBuscado){
        //Recorrer la lista de archivos para validar la existencia del nombre a buscar
        for(int i=0;i< archivos.length;i++){
            //Valida la existencia del archivo a buscar
            if(archivoBuscado.equals(archivos[i])){
                //En caso de estar el archivo dentro de la lista, retorna verdadero
                return true;
            }
        }//for
        //Si concluye el ciclo for sin existo, retorna falso (no existe el archivo a buscar)
        return false;
    }//existeArchivo
    //Método para abrir archivos dentro del dispositivo (almacenamiento interno)
    private void abrirArchivo(){
        //Obtener la lista de archivos internos del dispositivo
        String listaArchivos[] = fileList();
        //Validar la existencia del archivo interno
        if(existeArchivo(listaArchivos,"archivoDatos.txt")){
            //Manejo de exexpcion para abrir archicos internos
            try {
                //Abrir el archivo para leer contenido
                //1.Crear la instancia para asociar el archivo a leer
                InputStreamReader archivoInterno = new InputStreamReader(openFileInput("archivoDatos.txt"));
                //2.- Crear la instancia para leer el contenido del archivo
                BufferedReader leerArchivo = new BufferedReader(archivoInterno);
                //3.- Leer el contenido del archivo y colocarlo en una variable
                String linea = leerArchivo.readLine();
                //4.- Variable que guarda el contenido
                String textoleido ="";
                //5.- Ciclo repetitivo para leer contenido del archivo
                while(linea!=null){
                    textoleido += linea +"\n"; //Se lee la linea y se agrega un salto
                    linea = leerArchivo.readLine(); //Se lee contenido del archivo
                }//while
                //Cerrar el archivo
                leerArchivo.close();
                //Cerrar el flujo del archivo
                archivoInterno.close();
                //Colocar el contenido dentro del componente multilinea
                editor.setText(textoleido);
            }catch (IOException e){
                //Enviar mensaje en caso de error al leer el archivo
                Toast.makeText(MainActivity.this, "Error al leer archivo", Toast.LENGTH_LONG).show();
            }//catch
        }else{
            //El archivo no existe, informar al usuario
            Toast.makeText(MainActivity.this, "El archivo no existe", Toast.LENGTH_LONG).show();
        }
    }//abrirArchivo
    private void guardarArchivo(){
        //En un excepcion colocar las instrucciones de lectura del archivo
        try {
            //Definir una instancia para asociar con el archivo a escribir, EN MODO PRIVADO
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput("archivoDatos.txt", Activity.MODE_PRIVATE));
            //Escribir la información del texto multilinea en el archivo
            archivo.write(editor.getText().toString());
            //limpiar el buffer
            archivo.flush();
            //Cerar el archivo
            archivo.close();
        }catch (IOException e){
            Toast.makeText(MainActivity.this, "Error al escribir en el archivo", Toast.LENGTH_LONG).show();
        }//catch
        //Se borra el contenido del editor
        editor.setText("");
    }//guardarArchivo
}//class