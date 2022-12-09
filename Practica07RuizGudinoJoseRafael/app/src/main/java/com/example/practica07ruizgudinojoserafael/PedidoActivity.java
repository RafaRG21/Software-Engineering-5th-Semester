package com.example.practica07ruizgudinojoserafael;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.prefs.Preferences;

public class PedidoActivity extends AppCompatActivity {
    //Instancias para los campos del formulario
    EditText nombre, domicilio, telefono;
    Spinner producto, talla;
//Objeto
    Pedido pedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);
        //Asociaciòn de componentes
        nombre = findViewById(R.id.txtPedidoNombre);
        domicilio = findViewById(R.id.txtPedidoDomicilio);
        telefono = findViewById(R.id.txtPedidoTelefono);
        producto = findViewById(R.id.spnPedidoProducto);
        talla = findViewById(R.id.spnPedidoTalla);
        //Definicion Arreglo de productos
        String[] listaProductos = {"Disfraz de Among Us Espacial", "Disfraz de Batman",
                "Set de Pirata Intrépido", "Sombrero Sheriff Fieltro", "Disfraz de Vampiro Morado",
                "Disfraz de Dama Medieval Davinia"};
        //Definicion Arreglo de tallas
        String[] listaTallas = {"Chica", "Mediana", "Grande"};
        //Adapter para las listas
        ArrayAdapter<String> productosAdapter = new ArrayAdapter<String>(this,
                androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item, listaProductos);
        ArrayAdapter<String> tallaAdapter = new ArrayAdapter<String>(this,
                androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item, listaTallas);
        //Asociacion con los objetos
        producto.setAdapter(productosAdapter);
        talla.setAdapter(tallaAdapter);
        pedido = new Pedido();
    }//onCreate
    public void registrarDatos(View view){
        if(nombre.getText().toString().isEmpty()||domicilio.getText().toString().isEmpty()||telefono.getText().toString().isEmpty()){

                Toast.makeText(this,"Ingresar datos en todos los campos",Toast.LENGTH_SHORT).show();
        } else{
            pedido.setNombre(nombre.getText().toString());
            pedido.setDomicilio(domicilio.getText().toString());
            pedido.setProducto(producto.getSelectedItem().toString());
            pedido.setTalla(talla.getSelectedItem().toString());
            pedido.setTelefono(Long.parseLong(telefono.getText().toString()));
            Toast.makeText(this,"Pedido Realizado",Toast.LENGTH_SHORT);
            limpiar();
            //Enviar el objeto para parametro a la Activity Menu
            Intent registro = new Intent(this,MenuActivity.class);
            registro.putExtra("pedido",pedido);
            startActivity(registro);
            finish();
        }
    }//registrarDatos

    public void limpiar(){
        nombre.setText("");
        domicilio.setText("");
        telefono.setText("");
        producto.setSelected(false);
        talla.setSelected(false);
        nombre.requestFocus();
    }//limpiar
    public void cancelar(View view){
        Intent cancelar = new Intent(this,MenuActivity.class);
        startActivity(cancelar);
        finish();
    }

}//Class