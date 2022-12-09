package com.example.dpdmclase04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ActivityRegistro extends AppCompatActivity {
    //Instancias para los campos del formulario
    private EditText fol, inst, nom, ape, mon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        //Asociar los componentes gráficos con instancias
        fol = findViewById(R.id.txtnRegistroFolio);
        inst = findViewById(R.id.txtRegistroInstitucion);
        nom = findViewById(R.id.txtRegistroNombre);
        ape = findViewById(R.id.txtRegistroApellido);
        mon = findViewById(R.id.txtfRegistroMonto);
    }//onCreate
    //Método para guardar información, se asocia al botón Registrar
    public void registrarBeca(View view) {
        //Objeto para guardar datos
        BecaTransporte beca = new BecaTransporte();
        //Guardar datos del componente al objeto
        beca.setFolio(Integer.parseInt(fol.getText().toString()));
        beca.setInstitucion(inst.getText().toString());
        beca.setNombre(nom.getText().toString());
        beca.setApellidos(ape.getText().toString());
        beca.setMonto(Float.parseFloat(mon.getText().toString()));
        //Enviar el objeto para parametro a la Activity Menu
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("Beca", beca);
        startActivity(intent);
        finish();
    }//RrgistrarBeca
    //Mètodo para limpiar componentes, se asocia al botón Limpiar
    public void limpiarComponentes(View view){
        fol.setText("");
        inst.setText("");
        ape.setText("");
        nom.setText("");
        mon.setText("");
        fol.requestFocus();
    }//limpiarComponentes
}//Class