package com.example.practica07ruizgudinojoserafael;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
//Instancias
    private Pedido pedido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //Obtener información de la instancias
        pedido = (Pedido) getIntent().getSerializableExtra("pedido");
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
        switch (opc){
            case R.id.itemPedido:
                Intent pedidoIntent = new Intent(this,PedidoActivity.class);
                startActivity(pedidoIntent);
                break;
            case R.id.itemProductos:
                Intent productos = new Intent(this,ProductosActivity.class);
                startActivity(productos);
                break;
            case R.id.itemMisCompras:
                if(pedido==null)
                    Toast.makeText(this,"No hay compras realizadas aún",Toast.LENGTH_SHORT).show();
                else {
                    Intent compras = new Intent(this, MisComprasActivity.class);
                    compras.putExtra("pedido", pedido);
                    startActivity(compras);
                }
                break;
            case R.id.itemNosotros:
                Intent nosotros = new Intent(this,NosotrosActivity.class);
                startActivity(nosotros);
                break;
            case R.id.itemCerrarSesion:
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
        Intent intent =  new Intent(this,MainActivity.class);
        //Inicializar las banderas para comenzar la Activity, como si fuera la primera vez
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }//cerrarSesion
}//class