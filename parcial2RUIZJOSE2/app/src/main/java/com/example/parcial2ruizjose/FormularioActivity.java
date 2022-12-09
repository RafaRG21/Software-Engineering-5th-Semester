package com.example.parcial2ruizjose;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class FormularioActivity extends AppCompatActivity {
    private EditText codigo, marca, modelo;
    private RadioButton tallaChica, tallaMediana, tallaGrande;
    private CheckBox colorBlanco, colorNegro, colorAzul;
    int tam = 5;
    int cont=0;
    Mueble[] mueble;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        codigo = (EditText) findViewById(R.id.txtNCodigo);
        marca = (EditText) findViewById(R.id.txtMarca);
        modelo = (EditText) findViewById(R.id.txtModelo);
        //Inicializacion del arreglo de objetos mueble
        tallaChica = findViewById(R.id.rdbtamañoChica);
        tallaMediana = findViewById(R.id.rbdTamMediano);
        tallaGrande = findViewById(R.id.rdbTamGrande);
        colorAzul = findViewById(R.id.chkColorAzul);
        colorBlanco = findViewById(R.id.chkColorBlanco);
        colorNegro = findViewById(R.id.chkColorNegro);
        mueble = new Mueble[tam];
        for(int i=0;i<tam;i++){
            mueble[i] = new Mueble();
        }
    }//onCreate
    public void registrarDatos(View view){
        int numCodigo=0;
        String color="";
        //Llenado de informacion
        if (cont < tam && codigo.getText().length()>0&&marca.getText().length()>0) {
            numCodigo = (int) Integer.parseInt(codigo.getText().toString());

            mueble[cont].setCodigo(numCodigo);
            mueble[cont].setMarca(marca.getText().toString());
            mueble[cont].setModelo(modelo.getText().toString());
            //Talla
            if (tallaChica.isChecked())
                mueble[cont].setTalla("Chico");
            else if (tallaMediana.isChecked())
                mueble[cont].setTalla("Mediano");
            else if (tallaGrande.isChecked())
                mueble[cont].setTalla("Grande");
            //Colores
            if (colorBlanco.isChecked())
                color += "-Blanco ";
            if (colorNegro.isChecked())
                color += "-Negro ";
            if (colorAzul.isChecked())
                color += "-Azul ";
            mueble[cont].setColores(color);
            //Aumento del contador
            cont++;
            Toast.makeText(this,"Registro creado",Toast.LENGTH_SHORT).show();
        }//if(cont<5)
        else{
            if(cont>=tam)
                Toast.makeText(this,"¡Registro Lleno!",Toast.LENGTH_SHORT).show();
            else Toast.makeText(this,"Llenar todos los campos",Toast.LENGTH_SHORT).show();
        }
    }//registrarDatos
    public void buscarObjeto(View view){
        //Se busca con el codigo de mueble
        int posicion=0;
        //con buscar se verifica si existe
        posicion = buscar();

        if (posicion>=0) {
            //despues se llena
            String talla, color;
            marca.setText(mueble[posicion].getMarca());
            modelo.setText(mueble[posicion].getModelo());
            talla = mueble[posicion].getTalla();
            color = mueble[posicion].getColores();
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
            //Colores muebles
            if (color.indexOf("Negro") > 0)
                colorNegro.setChecked(true);
            if (color.indexOf("Blanco") > 0)
                colorBlanco.setChecked(true);
            if (color.indexOf("Azul") > 0)
                colorAzul.setChecked(true);
            Toast.makeText(this, "Mueble encontrado", Toast.LENGTH_SHORT).show();


        }//if(encontrado)
        else
            Toast.makeText(this, "Mueble no encontrado", Toast.LENGTH_SHORT).show();

    }//buscarDatos
    public int buscar(){

        int code=0,pos;
        boolean found=false;
        pos=-1;
        try {
            code = Integer.parseInt(codigo.getText().toString());
        }catch(Exception ex){
            Toast.makeText(this,"Escribe un código de mueble",Toast.LENGTH_SHORT).show();
            return pos;
        }
        try {
            for (int i = 0; i < tam; i++) {
                if (code == mueble[i].getCodigo()) {
                    pos = i;
                    break;
                }
            }
        }catch (Exception e){
            Toast.makeText(this,"Sin registros",Toast.LENGTH_SHORT).show();
        }
        return pos;

    }
    public void ActualizarObjeto(View view){
        //Se busca con el codigo de mueble
        int posicion=0;
        //con buscar se verifica si existe
        posicion = buscar();

        if (posicion>=0) {
            int numCodigo=0;
            String color="";
            //despues se actualiza
            mueble[posicion].setCodigo(numCodigo);
            mueble[posicion].setMarca(marca.getText().toString());
            mueble[posicion].setModelo(modelo.getText().toString());
            //Talla
            if (tallaChica.isChecked())
                mueble[posicion].setTalla("Chico");
            else if (tallaMediana.isChecked())
                mueble[posicion].setTalla("Mediano");
            else if (tallaGrande.isChecked())
                mueble[posicion].setTalla("Grande");
            //Colores
            if (colorBlanco.isChecked())
                color += "-Blanco ";
            if (colorNegro.isChecked())
                color += "-Negro ";
            if (colorAzul.isChecked())
                color += "-Azul ";
            mueble[posicion].setColores(color);
            Toast.makeText(this, "Mueble actualizado", Toast.LENGTH_SHORT).show();


        }//if(encontrado)
        else
            Toast.makeText(this, "Mueble no encontrado", Toast.LENGTH_SHORT).show();

    }//ActualizarDatos

    public void eliminarRegistros(View view){
        int pos = buscar();
        if(pos==-1){
            Toast.makeText(this,"No existe el mueble",Toast.LENGTH_SHORT).show();
        }
        else{
            if(pos==tam-1){
                mueble[pos] = new Mueble();
            }
            else{
                for(int i=pos;i<mueble.length-1;i++){
                    mueble[i] = new Mueble();
                    mueble[i].setCodigo(mueble[i+1].getCodigo());
                    mueble[i].setMarca(mueble[i+1].getMarca());
                    mueble[i].setModelo(mueble[i+1].getModelo());
                    mueble[i].setTalla(mueble[i+1].getTalla());
                    mueble[i].setColores(mueble[i+1].getColores());
                }
            }
            cont--;
            Toast.makeText(this,"Mueble eliminado",Toast.LENGTH_SHORT).show();
        }
    }//eliminarRegistros
}//class