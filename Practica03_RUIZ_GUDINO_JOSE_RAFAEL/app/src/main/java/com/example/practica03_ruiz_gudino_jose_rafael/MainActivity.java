package com.example.practica03_ruiz_gudino_jose_rafael;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Instancias para componentes graficos
    private EditText marca, modelo, numSerie, velocidadMax, capacidadTanque;
    //Variables Globales
    int tam = 10; //tamaño del arreglo
    int cantReg = 0; //Contador de Registros
    //Arreglo de objetos
    Motocicleta motos[] = new Motocicleta[tam];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"Bienvenido",Toast.LENGTH_SHORT).show();
        numSerie = (EditText) findViewById(R.id.txtNumSerie);
        marca = (EditText) findViewById(R.id.txtMarca);
        modelo = (EditText) findViewById(R.id.txtModelo);
        velocidadMax = (EditText) findViewById(R.id.txtVelocidadMax);
        capacidadTanque = (EditText) findViewById(R.id.txtCapacidadTanque);
        //Inicializacion del arreglo
        for(int i=0;i<tam;i++){
            motos[i] = new Motocicleta();
        }
    }
    public void agregar(View view){
        //Validar que exista espacio dentro del arreglo
        if(cantReg<tam&&numSerie.getText().toString().length()>0){
            //Copiar el contenido de los componentes al arreglo
            motos[cantReg].setMarca(marca.getText().toString());
            motos[cantReg].setModelo(modelo.getText().toString());
            int num = Integer.parseInt(numSerie.getText().toString());
            int speed = Integer.parseInt(velocidadMax.getText().toString());
            int capacity = Integer.parseInt(capacidadTanque.getText().toString());
            motos[cantReg].setNumSerie(num);
            motos[cantReg].setVelocidadMaxima(speed);
            motos[cantReg].setCapacidadTanque(capacity);
            //Incremento del contador
            cantReg++;
            //Mensaje de aviso
            Toast.makeText(this,"Moto agregada",Toast.LENGTH_SHORT).show();
            //Limpieza de componentes
            marca.setText("");
            modelo.setText("");
            numSerie.setText("");
            velocidadMax.setText("");
            capacidadTanque.setText("");
            //Establecer el foco principal
            numSerie.requestFocus();

        }else{
            if(cantReg>=tam)
                Toast.makeText(this,"Registro Lleno",Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this,"Campos incompletos",Toast.LENGTH_SHORT).show();
        }
    }
    public void buscar(View view){
        if(cantReg>0){
            //posicion en la que se encuentra el registro a buscar
            int posicion=0;
            //bandera para verificar si existe el registro
            boolean found = false;
            //variables auxiliares para obtener el valor de la caja de texto
            int arrayNumSerie=0, num=0;
            try {
                num = Integer.parseInt(numSerie.getText().toString().trim());
            }catch(Exception ex){
                Toast.makeText(this,"Escribe un numero de serie",Toast.LENGTH_SHORT).show();
            }
                //Recorrido de busqueda
                for (int x = 0; x < cantReg; x++) {
                    arrayNumSerie = motos[x].getNumSerie();
                    if (arrayNumSerie == num) {
                        marca.setText(motos[x].getMarca());
                        modelo.setText(motos[x].getModelo());
                        velocidadMax.setText(String.valueOf(motos[x].getVelocidadMaxima()));
                        capacidadTanque.setText(String.valueOf(motos[x].getCapacidadTanque()));
                        found = true;
                        break;
                    }

                }
                if (found) {
                    Toast.makeText(this, "Moto encontrada", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Moto no encontrada", Toast.LENGTH_SHORT).show();
                }


        }else{
            Toast.makeText(this,"No hay Registros aún",Toast.LENGTH_SHORT).show();
        }
    }

    public void limpiar(View view){
        marca.setText("");
        modelo.setText("");
        numSerie.setText("");
        velocidadMax.setText("");
        capacidadTanque.setText("");
        numSerie.requestFocus();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"Adios",Toast.LENGTH_SHORT);
    }
}