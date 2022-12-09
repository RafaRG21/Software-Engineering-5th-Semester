package com.example.dpdm1clase03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//componer los listview y spinner
    //dos formas de trabajar listas
    private EditText codigo, descripcion, cantidad, costo;
    private Spinner marca;
    private ListView modelo;
    private TextView resultados;
    //Tamaño del arreglo
    int tam = 3;
    int cantProd = 0;
    //Arreglo de objetos
    Producto[] productos = new Producto[tam];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Asociar objetos con componentes gráficos
        codigo = findViewById(R.id.txtnCodigo);
        descripcion = findViewById(R.id.txtDescripcion);
        cantidad = findViewById(R.id.txtnCantidad);
        costo = findViewById(R.id.txtnCosto);
        //Definicion del Arreglo de Marcas
        String[] listaMarcas = {"HP","Dell","Lanix","Macintosh"};
        String[] listaModelos = {"abs","xyz","lmn","a22","b55"};
        // Asociar el arreglo de cadenas de Marca con el componente spinner
        ArrayAdapter<String> adapterMarca = new ArrayAdapter<String>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,listaMarcas);
        // Asociar el arreglo de cadenas de Modelo con el componente spinner
        ArrayAdapter<String> adapterModelo = new ArrayAdapter<String>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,listaModelos);
        //Asociar el adapter con el objeto correspondiente
        marca.setAdapter(adapterMarca);
        modelo.setAdapter(adapterModelo);
        //Inicializar el arreglo de objetos
        for(int i=0;i<tam;i++){
            productos[i] = new Producto();
        }
    }//onCreate
    public void registrarProducto(View view){
        //Variables locales
        int cod, can;
        float cos;
        //Validar que exista informacion
        if(codigo.getText().toString().isEmpty() && descripcion.getText().toString().isEmpty()){
            Toast.makeText(this,"Se requiere capturar información",Toast.LENGTH_SHORT).show();
        }else{
            //convertir cadenas a enteros o reales
            cod = Integer.parseInt(codigo.getText().toString());
            can = Integer.parseInt(cantidad.getText().toString());
            cos = Integer.parseInt(costo.getText().toString());
            //Agregar la información al arreglo
            productos[cantProd].setCantidad(can);
            productos[cantProd].setCodigo(cod);
            productos[cantProd].setDescripcion(descripcion.getText().toString());
            productos[cantProd].setMarca(marca.getSelectedItem().toString());
            productos[cantProd].setModelo(modelo.getSelectedItem().toString());
            productos[cantProd].setCostoUnitario(cos);
            //Mensaje Informativo
            Toast.makeText(this,"Producto Registrado",Toast.LENGTH_SHORT).show();

        }
    }//registrarProducto
}