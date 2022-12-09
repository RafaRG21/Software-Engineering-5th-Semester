package com.example.practica07ruizgudinojoserafael;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ProductosActivity extends AppCompatActivity {
    ListView productos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);
        productos = findViewById(R.id.lstvProductos);
        //Definicion Arreglo de productos
        String[] listaProductos = {"Disfraz de Among Us Espacial", "Disfraz de Batman",
                "Set de Pirata Intrépido", "Sombrero Sheriff Fieltro", "Disfraz de Vampiro Morado",
                "Disfraz de Dama Medieval Davinia"};

        ArrayAdapter<String> productosAdapter = new ArrayAdapter<String>(this,
                androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item, listaProductos);
        productos.setAdapter(productosAdapter);
        productos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0:
                        toastAmongUs(view);
                        break;
                    case 1:
                        toastBatman(view);
                        break;
                    case 2:
                        toastPirata(view);
                        break;
                    case 3:
                        toastSheriff(view);
                        break;
                    case 4:
                        toastVampiro(view);
                        break;
                    case 5:
                        toastDama(view);
                        break;
                }
            }
        });
    }//onCreate
    //Toasts para cada producto
    private void toastAmongUs(View view){
        String amongUs = "Descripción: Disfraz de Among Us Amarillo Espacial para adulto para carnaval y fiestas temáticas\nTallas: Chica, Mediana y Grande\n"+
                "Costo: $650";
        Toast.makeText(this, amongUs, Toast.LENGTH_LONG).show();
    }//toastAmongUs
    private void toastBatman(View view){
        String batman = "Descripción: ¡El amanecer de la justicia!\n" +
                "Protagoniza una lucha sin precedentes unido a Superman con este Disfraz de Batman Doj Classic™ para adulto"+
                "\nTallas: Mediana y Grande" + "\nCosto: $1200";
        Toast.makeText(this,batman,Toast.LENGTH_LONG).show();
    }//toastBatman
    private void toastPirata(View v){
        String pirata = "Descripción: Set de Pirata Intrépido para carnaval y fiesta de piratas. Descubre todos los complementos para el disfraz de pirata y surca los 7 mares en busca de tesoros perdidos. Prepárate para tu mayor aventura" +
                "\nTallas: Chica, Mediana y Grande" + "\n Costo: $200";
        Toast.makeText(this,pirata,Toast.LENGTH_LONG).show();
    }//toastPirata
    private void toastSheriff(View v){
        String sheriff  = "Descripción: Sombrero Sheriff Fieltro para carnaval y fiestas disfraces. Complementos disfraces de indios y vaqueros para viajar al viejo oeste"+
                            "\nTalla: Chica, Mediana y Grande" + "\nCosto: $90";
        Toast.makeText(this,sheriff,Toast.LENGTH_LONG).show();
    }//toastSheriff
    private void toastVampiro(View v){
        String vampiro  = "Descripción: El disfraz de vampiro morado para bebé es un traje con mucha personalidad para caracterizar a los más pequeños en halloween. \nSerán las estrellas de la guardería cuando celebren las fiestas de temática terrorífica o para carrozas de carnavales con vampiros y dráculas" +
                "\nTalla: Chica, Mediana y Grande" + "\nCosto: $400";
        Toast.makeText(this,vampiro,Toast.LENGTH_LONG).show();
    }//toastVampiro
    private void toastDama(View v){
        String dama  = "Descripción: Disfraz de Dama Medieval Davinia para mujer para fiestas medievales y carnaval. El disfraz medieval y la decoración medieval son ideales para ambientar los mercados medievales que se celebran en pueblos históricos" +
                "\nTalla: Chica, Mediana y Grande" + "\nCosto: $550";
        Toast.makeText(this,dama,Toast.LENGTH_LONG).show();
    }//toastDama
}//class