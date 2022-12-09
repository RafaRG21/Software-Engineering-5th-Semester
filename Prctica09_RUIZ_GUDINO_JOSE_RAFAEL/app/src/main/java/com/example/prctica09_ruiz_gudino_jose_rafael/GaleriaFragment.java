package com.example.prctica09_ruiz_gudino_jose_rafael;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GaleriaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GaleriaFragment extends Fragment {
    //Instancias
    private Button efecto, musica;
    private View vista; // para acceder a los botones del fragment
    SoundPool sp; // objeto para reproducir audio corto
    MediaPlayer mp; //objeto para reproducir audio largo
    int sonido_de_reproduccion;
    boolean reproducir;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GaleriaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GaleriaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GaleriaFragment newInstance(String param1, String param2) {
        GaleriaFragment fragment = new GaleriaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Devolver la referencia del xml
        vista = inflater.inflate(R.layout.fragment_galeria, container, false);
        //Por medio de la instancia vista se accede al botón del fragment
        //tal como se realiza con el Activity
        efecto = (Button) vista.findViewById(R.id.btnGalleryEfecto);
        musica = (Button) vista.findViewById(R.id.btnGalleryAudio);
        //Bandera de reproduccion
        reproducir = false;
        //Se define el escucha para el botón reproducir efecto
        efecto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Reproducción de Efecto", Toast.LENGTH_SHORT).show();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    //Define los atributos de reproducción
                    AudioAttributes atributos = new AudioAttributes.Builder()
                            .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                            .build();
                    //Maximo de reproducciones: 1, con los atributos anteriores
                    sp = new SoundPool.Builder()
                            .setMaxStreams(1)
                            .setAudioAttributes(atributos)
                            .build();
                } else {
                    //Para versiones anteriores al API 21
                    //Máximo de reproducciones: 1, Tipo de stream: audio, Calidad de reproducción: 1
                    sp = new SoundPool(1, AudioManager.STREAM_MUSIC,1);
                }
                sonido_de_reproduccion = sp.load(getContext(),R.raw.short_sound,1);
                sp.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
                    @Override
                    public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                        sp.play(sonido_de_reproduccion,1,1,1,0,1);

                    }
                });//setOnLoadCompleteListener

            }//onClick
        });
        //Se define el escucha para el boton reproducir musica
        musica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!reproducir){
                    Toast.makeText(getContext(), "Reproduciendo", Toast.LENGTH_SHORT).show();
                    //Instancia que se asocia al archivo de audio de larga duracion
                    mp = MediaPlayer.create(getContext(),R.raw.musica);
                    //El metodo reproduce el archivo
                    mp.start();
                    reproducir = true;
                } else{
                    mp.stop();
                    Toast.makeText(getContext(), "Detenido", Toast.LENGTH_SHORT).show();
                    reproducir = false;
                }
            }
        });
        return vista;

    }
}