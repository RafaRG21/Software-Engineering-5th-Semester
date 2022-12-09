package com.example.dpdmclase04;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MenuActivity extends AppCompatActivity {
    //Instancia
    private BecaTransporte beca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //Obtener información de la instancias
        beca = (BecaTransporte) getIntent().getSerializableExtra("Beca");
    }//onCreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Asociar el XML del menuoverflow con el Activity
        getMenuInflater().inflate(R.menu.menu_overflow,menu);
        return true;
    }//onCreateOptionsMenu

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //Variable para identificar la opcion
        int opc = item.getItemId();
        switch(opc){
            case R.id.mItemRegistrar:
                Intent registro = new Intent(this,ActivityRegistro.class);
                startActivity(registro);
                break;
            case R.id.mItemConsultar:
                Intent consulta = new Intent(this,MainConsulta.class);
                //Pasar parametro a la activity con objeto BecaTransporte
                consulta.putExtra("Beca",beca);
                startActivity(consulta);
                break;
            case R.id.itemCerrar:
                cerrarSesion();
                break;
        }
        return super.onOptionsItemSelected(item);
    }//onOptionsItemSelected
    public void cerrarSesion(){
        SharedPreferences preferencias = getSharedPreferences("user.dat",MODE_PRIVATE);
        //Poner en modo editor para borrar los datos
        SharedPreferences.Editor editor = preferencias.edit();
        editor.clear(); //Se borran los datos almacenados
        editor.apply(); // Se guardan los cambios
        //Regresar a Activity Login
        Intent intent =  new Intent(this,ActivityLogin.class);
        //Inicializar las banderas para comenzar la Activity, como si fuera la primera vez
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }//cerrarSesion
}//class