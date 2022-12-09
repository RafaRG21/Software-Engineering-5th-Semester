package com.example.practica07ruizgudinojoserafael;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MisComprasActivity extends AppCompatActivity {
    Pedido pedido;
    TextView compras;
    int tam = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_compras);
        //Obtener los datos enviados como parametros
        pedido = (Pedido) getIntent().getSerializableExtra("pedido");
        compras = (TextView) findViewById(R.id.tvwMisComprasDatos);

        String datos="";
            datos = "\nNombre: " + pedido.getNombre().toString() + "\n" +
                "Domicilio: " + pedido.getDomicilio().toString() +"\n" +
                 "Producto: " +pedido.getProducto().toString() + "\n" +
                 "Talla: " + pedido.getTalla().toString() + "\n" +
                 "Número de Contacto: " + String.valueOf(pedido.getTelefono());
        compras.setText(datos);

    }

}