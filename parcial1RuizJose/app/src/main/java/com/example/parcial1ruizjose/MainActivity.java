package com.example.parcial1ruizjose;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText marca, modelo, costoBase, plazo;
    private TextView resultados;
    Cotizacion cotiza;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"Bienvenido",Toast.LENGTH_SHORT).show();
        marca = (EditText) findViewById(R.id.txtMarca);
        modelo = (EditText) findViewById(R.id.txtModelo);
        costoBase = (EditText) findViewById(R.id.txtCostoBase);
        plazo = (EditText) findViewById(R.id.txtPlazo);
        resultados = (TextView) findViewById(R.id.tvwResultados);
        //Creacion de la instancia
        cotiza = new Cotizacion();
    }
    public void registar(View view){
        float enganche, mensualidad, comision;
        cotiza.setMarca(marca.getText().toString());
        cotiza.setModelo(modelo.getText().toString());
        int costoaux = (int) Integer.parseInt(costoBase.getText().toString());
        int plazoaux = (int) Integer.parseInt(plazo.getText().toString());
        cotiza.setCostoBase(costoaux);
        cotiza.setPlazo(plazoaux);
        enganche = (float) (costoaux * 0.30);
        mensualidad  = (float) ((costoaux * 0.70) / 36);
        comision = (float) (costoaux * 0.02);
        cotiza.setEnganche(enganche);
        cotiza.setMensualidad(mensualidad);
        cotiza.setComision(comision);
        //Aviso
        Toast.makeText(this, "Cotización agregada",Toast.LENGTH_SHORT).show();

    }
    public void cotizar(View view){
    String datos = "Marca: " + cotiza.getMarca().toString()+"\n";
    datos += "Modelo: " + cotiza.getModelo().toString()+"\n";
    datos += "Costo Base: " + String.valueOf(cotiza.getCostoBase())+"\n";
    datos += "Plazo: " + String.valueOf(cotiza.getPlazo())+"\n";
    datos += "Mensualidad: " + String.valueOf(cotiza.getMensualidad()) + "\n";
    datos += "Enganche: " + String.valueOf(cotiza.getEnganche()) +"\n";
    datos += "Comision: " + String.valueOf(cotiza.getComision()) + "\n";
    resultados.setText(datos);
    Toast.makeText(this,"Cotizacion mostrada",Toast.LENGTH_SHORT);


    }

    public void limpiar(View view){
        marca.setText("");
        modelo.setText("");
        costoBase.setText("");
        plazo.setText("");
        marca.requestFocus();
        resultados.setText("");
        marca.requestFocus();
        Toast.makeText(this, "Limpieza realizada",Toast.LENGTH_SHORT);
    }
}