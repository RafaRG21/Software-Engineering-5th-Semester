package com.example.dpdmclase04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainConsulta extends AppCompatActivity {
    //Instancias
    private BecaTransporte beca;
    private TextView datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_consulta);
        //Obtener los datos enviados como parametros
        beca = (BecaTransporte) getIntent().getSerializableExtra("Beca");
        //Asociar instancia a componente gráfico
        datos = (TextView) findViewById(R.id.txtDatos);
        //Mostrar datos en TextView
        datos.setText(
                "\nFolio: " + beca.getFolio() + "\n" +
                "Institución: " + beca.getInstitucion() + "\n" +
                "Nombre(s): " + beca.getNombre() + "\n" +
                "Apellidos: " + beca.getApellidos() + "\n" +
                "Monto: $" + beca.getMonto());
    }//onCreatera
}//Class