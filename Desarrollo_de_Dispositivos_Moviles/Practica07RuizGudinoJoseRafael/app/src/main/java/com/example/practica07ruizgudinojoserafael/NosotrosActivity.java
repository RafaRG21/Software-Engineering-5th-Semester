package com.example.practica07ruizgudinojoserafael;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class NosotrosActivity extends AppCompatActivity {
    TextView nosotros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nosotros);
        nosotros = (TextView) findViewById(R.id.tvwNosotrosInfo);
        String aboutUs = "En Costume Shop pensamos que disfrazarse siempre es un planazo. Por eso, desde nuestras oficinas, trabajamos cada día para llevar la diversión a miles de hogares de México a través de nuestros productos.\n" +
                "\n" +
                "Actualmente somos una de las principales empresas de venta de disfraces, accesorios y decoración para fiestas, vamos ¡que tenemos de todo\n" +
                "\n" +
                "En resumen, estamos enamorados del Carnaval, Halloween y bueno... de cualquier excusa para disfrazarse.";
        nosotros.setText(aboutUs);
    }
}