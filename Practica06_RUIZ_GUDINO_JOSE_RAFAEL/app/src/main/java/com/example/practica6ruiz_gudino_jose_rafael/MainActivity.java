package com.example.practica6ruiz_gudino_jose_rafael;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Componentes
    EditText codigo, Asientos, costo;
    TextView resultados;
    Spinner destino;
    RadioButton vueloFirst, vueloBusiness, vueloEconomy;
    //Tamaño del arreglo
    int tam = 10;
    //contador del arreglo
    int cantReg = 0;
    //Declaracion arreglo de objetos
    Viaje[] viajes = new Viaje[tam];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Asociar objetos con componentes
        codigo = findViewById(R.id.txtnCodigo);
        Asientos  = findViewById(R.id.txtnAsientos);
        costo = findViewById(R.id.txtnCosto);
        vueloBusiness = findViewById(R.id.rbdBusiness);
        vueloEconomy = findViewById(R.id.rbdEconomy);
        vueloFirst = findViewById(R.id.rbdFirst);
        resultados = findViewById(R.id.tvwDatos);
        destino = findViewById(R.id.spnDestino);
        //Definicion del arreglo de destinos
        String[] listaDestino = {"CDMX","Los Angeles","Toronto","Londres","Moscu","Berlin"};
        ArrayAdapter<String> destinoAdapter = new ArrayAdapter<String>(this,
                androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item,listaDestino);
        //Asociacion con el componentes
        destino.setAdapter(destinoAdapter);
        //inicializacion de los objetos
        for(int i=0;i<tam;i++){
            viajes[i] = new Viaje();
        }
    }//onCreate
    public void registrarDatos(View view){
        int cod, cantAsiento;
        float cost;
        String tipoVuelo;
        if(codigo.getText().toString().isEmpty()||costo.getText().toString().isEmpty()||Asientos.getText().toString().isEmpty()||cantReg>=tam){
            if(cantReg>=tam)
                Toast.makeText(this,"Registro Lleno",Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this,"Ingresar datos en todos los campos",Toast.LENGTH_SHORT).show();

        }
        else{
            cod = Integer.parseInt(codigo.getText().toString());
            cantAsiento = Integer.parseInt(Asientos.getText().toString());
            cost = Float.parseFloat(costo.getText().toString());
            viajes[cantReg].setCodigo(cod);
            viajes[cantReg].setNumAsientos(cantAsiento);
            viajes[cantReg].setCosto(cost);
            viajes[cantReg].setDestino(destino.getSelectedItem().toString());
            //RadioButton
            if(vueloFirst.isChecked())
                viajes[cantReg].setClase("First");
            else if(vueloEconomy.isChecked())
                viajes[cantReg].setClase("Economy");
            else if(vueloBusiness.isChecked())
                viajes[cantReg].setClase("Business");
            else
                viajes[cantReg].setClase("Economy");
            Toast.makeText(this,"Registro completado",Toast.LENGTH_SHORT).show();
            cantReg++;
            limpiar();
        }
    }//registrarDatos
    public void buscarRegistro(View view){
        int pos;
        String res="";
        if(codigo.getText().toString().isEmpty()&&cantReg<=0){
            if(cantReg<=tam)
                Toast.makeText(this,"Sin registros",Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this,"Ingresar código a buscar",Toast.LENGTH_SHORT).show();

        }
        else{
            pos = buscar();
            if(pos==-1)
                Toast.makeText(this,"Viaje no encontrado",Toast.LENGTH_SHORT).show();
            else{
                res = "Código: " + String.valueOf(viajes[pos].getCodigo()) + "\n" + "Número de Asientos: " + String.valueOf(viajes[pos].getNumAsientos()) + "\n" +
                        "Destino: " + viajes[pos].getDestino() + "\n" + "Costo: " + String.valueOf(viajes[pos].getCosto()) + "\n" + "Tipo de vuelo: " +
                        viajes[pos].getClase().toString();
                resultados.setText(res);
                Toast.makeText(this,"Viaje encontrado",Toast.LENGTH_SHORT).show();
            }
        }
    }//buscarRegistro
    public int buscar(){
        int code=0,pos;
        boolean found=false;
        pos=-1;
        try {
            code = Integer.parseInt(codigo.getText().toString());
        }catch(Exception ex){
            Toast.makeText(this,"Escribe un código de viaje",Toast.LENGTH_SHORT).show();
            return pos;
        }
        try {
            for (int i = 0; i < tam; i++) {
                if (code == viajes[i].getCodigo()) {
                    pos = i;
                    break;
                }
            }
        }catch (Exception e){
            Toast.makeText(this,"Sin registros",Toast.LENGTH_SHORT).show();

        }
        return pos;

    }//buscar
    public void limpiarComponentes(View view){
        limpiar();
    }//limpiarComponentes
    public void limpiar(){
        codigo.setText("");
        Asientos.setText("");
        destino.setSelected(false);
        costo.setText("");
        vueloBusiness.setChecked(false);
        vueloEconomy.setChecked(false);
        vueloFirst.setChecked(false);
        resultados.setText("");
        codigo.requestFocus();
    }
    public void eliminarRegistros(View view){
        int pos = buscar();
        if(pos==-1){
            Toast.makeText(this,"No existe el viaje",Toast.LENGTH_SHORT).show();
        }
        else{
            if(pos==tam-1){
                viajes[pos] = new Viaje();
            }
            else{
                for(int i=pos;i<viajes.length-1;i++){
                    viajes[i] = new Viaje();
                    viajes[i].setCodigo(viajes[i+1].getCodigo());
                    viajes[i].setDestino(viajes[i+1].getDestino());
                    viajes[i].setNumAsientos(viajes[i+1].getNumAsientos());
                    viajes[i].setCosto(viajes[i+1].getCosto());
                    viajes[i].setClase(viajes[i+1].getClase());
                }
            }
            cantReg--;
            limpiar();
            Toast.makeText(this,"Viaje eliminado",Toast.LENGTH_SHORT).show();
        }
    }//eliminarRegistros
}