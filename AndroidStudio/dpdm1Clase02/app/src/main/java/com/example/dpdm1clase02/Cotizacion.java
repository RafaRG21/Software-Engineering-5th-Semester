package com.example.dpdm1clase02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Cotizacion extends AppCompatActivity {
    //Objeto para almacenar información
    private Vivienda datosCasa;
    //private Vivienda[] arreglo = new Vivienda[5];
    //objeto para asociar con componente
    private TextView datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cotizacion);
        //Asociar objeto con componente gráfico
        datos = (TextView) findViewById(R.id.tvwDetalles);
        //Se obtiene el objeto que se envío como paramaetro a la Activoty
        datosCasa = (Vivienda) getIntent().getSerializableExtra("objeto");
        //arreglo = (Vivienda) get
        //varaibles para extraer tipo vivienda();
        int tv = datosCasa.getTipoVivienda();
        int costo = 0;
        String tipo = "";
        switch (tv){
            case 1: tipo = "Dos Recamaras"; costo = 1500000; break;
            case 2: tipo = "Tres Recamaras"; costo =2200000; break;
            case 3: tipo = "Cuatro Recamaras"; costo = 3500000; break;
        }
        //Extraer los detalles
        String valorDetalle = datosCasa.getDetalle();
        String detalle = "";
        int costoDetalle = 0;
        if(valorDetalle.indexOf("A")>=0){
            detalle += "Cocina Integral $250000\n";
            costoDetalle += 25000;
        }
        if(valorDetalle.indexOf("B")>=0){
            detalle += "Acabados de mármol $550000\n";
            costoDetalle += 55000;
        }
        if(valorDetalle.indexOf("C")>=0){
            detalle += "Aire Acondicionado $30000\n";
            costoDetalle += 30000;
        }
        //Mostrar el contenido en el textView
        datos.setText("Folio: "+datosCasa.getFolio()+"\n"+"Cliente: "+datosCasa.getCliente()
                      +"\n"+"Tipo vivienda: "+tipo +"\n"+"Costo Vivienda: $"+costo+"\n"
                        +"Tipo de detalles: "+detalle+"\n"+"Costo de detalles: $"
                        +costoDetalle+ "\n"+"Teléfono: "+datosCasa.getTelefono()+"\n");
    }//onCreate
    public void regresar(View view){
        //Objeto para asociar con la primera Acitivu
        Intent intent = new Intent(this,MainActivity.class);
        //Ejecutar la activity
        startActivity(intent);
        //Se libera la activity actual
        finish();
    }//regresar
}