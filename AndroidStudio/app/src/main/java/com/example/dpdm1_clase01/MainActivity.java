package com.example.dpdm1_clase01;

import static android.widget.Toast.makeText;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //instancias para componentes graficos
    private EditText nombre, edad;
    protected TextView resultado;
    //variable global
    int tam = 3; // TAMAÑO DEL ARREGLO
    int cantReg = 0; //contador de registros capturados
    //Declarar el arreglo de objetos
    Alumno arreglo[]  = new Alumno[tam];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"OnCreate",Toast.LENGTH_SHORT).show();
        nombre = (EditText)  findViewById(R.id.txtNombre);
        edad = (EditText)  findViewById(R.id.txtEdad);
        resultado = (TextView)  findViewById(R.id.tvwResultados);
        //Inicializar el arreglo de objetos
        for(int i=0;i<tam;i++){
            arreglo[i] = new Alumno();
        }
    }
    public void registrarDato(View view){
        //validar que exista espacio dentro del arrrelgo
        if(cantReg<tam){
            //copiar la informacion de la instancia del componente al arreglo
            arreglo[cantReg].setNombre(nombre.getText().toString());
            int e = Integer.parseInt(edad.getText().toString()); //convirtiendo string a int
            arreglo[cantReg].setEdad(e);
            //incrementar el contador de registros
            cantReg++;
            //mensaje informativo
            makeText(this,"Alumno registrado",Toast.LENGTH_SHORT).show();
            //Limpiar los componentes
            nombre.setText("");
            edad.setText("");
            nombre.requestFocus(); //  establecer el foco de control en el componente

        }
        else {
            makeText(this, "Arreglo lleno", Toast.LENGTH_SHORT).show();
        }
    }
    public void mostrarDato(View view){
        //variable que contendra la informacion a colocar en el componente textView
        String datos = "Registros Capturados:\n";
        //valdidar que existan registros en el arreglo
        if(cantReg>0){
            // se incorpora a la variable anterior, los datos del arreglo
            for(int x=0;x<cantReg;x++){
                datos+= "Nombre: "+ arreglo[x].getNombre() + "\n";
                datos+= "Edad: "+ arreglo[x].getEdad() + "\n";
            }
            //colocar los datos dentro del componete
            resultado.setText(datos);
            //Mensaje informativo


        } else{
            //Mensaje informativo
            Toast.makeText(this,"Sin datos en el arreglo",Toast.LENGTH_SHORT).show();

        }

        makeText(this,"Datos almacenados en el arreglo",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"onStart",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"onStop",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"onPause",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"onDestroy",Toast.LENGTH_SHORT).show();

    }
}