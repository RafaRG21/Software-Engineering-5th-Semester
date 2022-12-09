package com.example.practica05_ruiz_gudino_jose_rafael;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Objetos para asociar componentes
    private EditText codigo, marca, modelo, costo;
    private RadioButton tallaChica, tallaMediana, tallaGrande;
    private CheckBox colorBlanco, colorNegro, colorAzul,colorRojo, colorNaranja;
    //Arreglo de objetos para almacenar la información
    RopaDeportiva[] ropa;
    //Contador
    int cont=0;
    //tamaño
    int tam = 15;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Asociar objetos con componentes gráficos
        codigo = findViewById(R.id.txtNCodigo);
        marca = findViewById(R.id.txtMarca);
        modelo = findViewById(R.id.txtModelo);
        costo = findViewById(R.id.txtCosto);
        //Radiobutton
        tallaChica = findViewById(R.id.rdbTallaChica);
        tallaMediana = findViewById(R.id.rdbTallaMediana);
        tallaGrande = findViewById(R.id.rdbTallaGrande);
        //Checkbox
        colorBlanco = findViewById(R.id.chkColorBlanco);
        colorNegro = findViewById(R.id.chkColorNegro);
        colorAzul = findViewById(R.id.chkColorAzul);
        colorNaranja = findViewById(R.id.chkColorNaranja);
        colorRojo = findViewById(R.id.chkColorRojo);
        //Inicializacion del arreglo de objetos
        ropa = new RopaDeportiva[tam];
        for(int i=0;i<tam;i++){
            ropa[i] = new RopaDeportiva();
        }
        tallaMediana.setChecked(true);

    }//onCreate

    public void registrarDatos(View view){
    int numCodigo=0;
    float numCosto=0;
    String color="";
    //Llenado de informacion
        if (cont < tam && codigo.getText().length()>0&&marca.getText().length()>0) {
            numCodigo = (int) Integer.parseInt(codigo.getText().toString());
            numCosto = (float) Float.parseFloat(costo.getText().toString());

            ropa[cont].setCodigo(numCodigo);
            ropa[cont].setCosto(numCosto);
            ropa[cont].setMarca(marca.getText().toString());
            ropa[cont].setModelo(modelo.getText().toString());
            //Talla
            if (tallaChica.isChecked())
                ropa[cont].setTalla("Chica");
            else if (tallaMediana.isChecked())
                ropa[cont].setTalla("Mediana");
            else if (tallaGrande.isChecked())
                ropa[cont].setTalla("Grande");
            //Colores
            if (colorBlanco.isChecked())
                color += "-Blanco ";
            if (colorNegro.isChecked())
                color += "-Negro ";
            if (colorAzul.isChecked())
                color += "-Azul ";
            if (colorRojo.isChecked())
                color += "-Rojo ";
            if (colorNaranja.isChecked())
                color += "-Naranja";
            ropa[cont].setColores(color);
            //Aumento del contador
            cont++;
            //Aviso
            limpiar();
            codigo.requestFocus();
            Toast.makeText(this,"Registro creado",Toast.LENGTH_SHORT).show();
        }//if(cont<15)
        else{
            if(cont>=tam)
                Toast.makeText(this,"¡Registro Lleno!",Toast.LENGTH_SHORT).show();
            else Toast.makeText(this,"Llenar todos los campos",Toast.LENGTH_SHORT).show();
        }
    }//registrarDatos

    public void buscarObjeto(View view){
        int posicion=0;
            posicion = buscar();
            if (posicion>=0) {
                String talla, color;
                marca.setText(ropa[posicion].getMarca());
                modelo.setText(ropa[posicion].getModelo());
                costo.setText(String.valueOf(ropa[posicion].getCosto()));
                talla = ropa[posicion].getTalla();
                color = ropa[posicion].getColores();
                switch (talla) {
                    case "Chica":
                        tallaChica.setChecked(true);
                        break;
                    case "Mediana":
                        tallaMediana.setChecked(true);
                        break;
                    case "Grande":
                        tallaGrande.setChecked(true);
                        break;
                }//switch
                if (color.indexOf("Negro") > 0)
                    colorNegro.setChecked(true);
                if (color.indexOf("Blanco") > 0)
                    colorBlanco.setChecked(true);
                if (color.indexOf("Azul") > 0)
                    colorAzul.setChecked(true);
                if (color.indexOf("Naranja") > 0)
                    colorNaranja.setChecked(true);
                if (color.indexOf("Rojo") > 0)
                    colorRojo.setChecked(true);
                Toast.makeText(this, "Ropa encontrada", Toast.LENGTH_SHORT).show();


            }//if(encontrado)
            else
                Toast.makeText(this, "Ropa no encontrada", Toast.LENGTH_SHORT).show();

    }//buscarDatos
    public int buscar(){

      int code=0,pos;
      boolean found=false;
      pos=-1;
        try {
            code = Integer.parseInt(codigo.getText().toString());
        }catch(Exception ex){
            Toast.makeText(this,"Escribe un código de ropa",Toast.LENGTH_SHORT).show();
            return pos;
        }
        try {
            for (int i = 0; i < tam; i++) {
                if (code == ropa[i].getCodigo()) {
                    pos = i;
                    break;
                }
            }
        }catch (Exception e){
            Toast.makeText(this,"Sin registros",Toast.LENGTH_SHORT).show();
        }
          return pos;

    }
    public void limpiarDatos(View view){
        limpiar();
    }
    public void limpiar(){
        //Limpieza de componentes
        codigo.setText("");
        marca.setText("");
        modelo.setText("");
        costo.setText("");
        tallaChica.setChecked(false);
        tallaMediana.setChecked(true);
        tallaGrande.setChecked(false);
        colorBlanco.setChecked(false);
        colorNegro.setChecked(false);
        colorAzul.setChecked(false);
        colorNaranja.setChecked(false);
        colorRojo.setChecked(false);
        codigo.requestFocus();
    }//limpiar

    public void eliminarDatos(View view){
        int pos = buscar();
        if (pos >= 0) {

            if(marca.getText().length()<1){
                Toast.makeText(this,"Busque primero el registro para eliminar",Toast.LENGTH_SHORT).show();
            }
            else {
                if (pos == tam-1) {
                    ropa[pos] = new RopaDeportiva();
                } else {
                    for (int i = pos; i < tam; i++) {
                        //se recorre el arreglo
                        ropa[pos] = new RopaDeportiva();
                        ropa[pos].setColores(ropa[pos + 1].getColores());
                        ropa[pos].setModelo(ropa[pos + 1].getModelo());
                        ropa[pos].setMarca(ropa[pos + 1].getMarca());
                        ropa[pos].setCosto(ropa[pos + 1].getCosto());
                        ropa[pos].setTalla(ropa[pos + 1].getTalla());
                        ropa[pos].setCodigo(ropa[pos + 1].getCodigo());
                    }
                }
                //Se disminuye el contador
                cont--;
                limpiar();
                Toast.makeText(this, "Registro elminado ", Toast.LENGTH_SHORT).show();
            }
        }//if

    }//eliminar
}//Class