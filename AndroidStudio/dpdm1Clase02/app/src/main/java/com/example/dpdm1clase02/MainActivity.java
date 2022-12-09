package com.example.dpdm1clase02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Objetos para asociar con componentes
    private EditText folio, nombre, telefono;
    private RadioButton tipo1, tipo2, tipo3;
    private CheckBox detalle1, detalle2, detalle3;
    //Objeto para almacenar información
    Vivienda casa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Asociar objetos con componentes graficos
        folio = findViewById(R.id.txtFolio);
        nombre = findViewById(R.id.txtCliente);
        telefono = findViewById(R.id.txtTelefono);
        tipo1 = findViewById(R.id.rdbTipo1);
        tipo2 = findViewById(R.id.rdbTipo2);
        tipo3 = findViewById(R.id.rdbTipo3);
        detalle1  =findViewById(R.id.chkDetalle1);
        detalle2 = findViewById(R.id.chkDetalle2);
        detalle3 = findViewById(R.id.chkDetalle3);
        //Inicializar objeto casa
        casa = new Vivienda();
    }//onCreate
    public void registrarDatos(View view){
        int numFolio, tel;
        //Convertir cadenas a enteros
        numFolio = Integer.parseInt(folio.getText().toString());
        tel = Integer.parseInt(telefono.getText().toString());
        //Guardar los datos en el objeto
        casa.setFolio(numFolio);
        casa.setTelefono(tel);
        casa.setCliente(nombre.getText().toString());
        //Validar el tipo de vivienda seleccionada
        if(tipo1.isChecked())
            casa.setTipoVivienda(1);
        else if(tipo2.isChecked())
            casa.setTipoVivienda(2);
        else if(tipo3.isChecked())
            casa.setTipoVivienda(3);
        else
            casa.setTipoVivienda(1); //Predeterminado
        //Validar el tipo de detalle
        if(detalle1.isChecked())
            casa.setDetalle(casa.getDetalle() + "A-");
        else if(detalle2.isChecked())
            casa.setDetalle(casa.getDetalle() + "B-");
        else if(detalle3.isChecked())
            casa.setDetalle(casa.getDetalle() + "C-");
        //Mensaje informativo
        Toast.makeText(this,"Datos registrados.",Toast.LENGTH_SHORT).show();
        //limpieza del formulario
        limpiar();
    }//registrarDatos
    public void cotizarCasa(View view){
    //Declarar e inicializar un objeto para conectar con otra Activity
        Intent intent  =new Intent(this,Cotizacion.class);
        //Se pasa como parametro el objeto de la clase vivienda
        intent.putExtra("objeto",casa);
        //intent.putExtra("arreglo",arregloCasas);
        //limpiar los componentes
        limpiar();
        //Ejecitar la otra activity (coizacion)
        startActivity(intent);
    }//cotizarCasa
    public void limpiarComponentes(View view){
        //limpiar formulario
        limpiar();
    }//limpiarComponentes
    public void limpiar(){
        folio.setText("");
        nombre.setText(null);
        telefono.setText("");
        tipo1.setChecked(false);
        tipo2.setChecked(false);
        tipo3.setChecked(false);
        detalle1.setChecked(false);
        detalle2.setChecked(false);
        detalle3.setChecked(false);
        folio.requestFocus(); //Colocar el prompt
    }//limpiar
}//Class