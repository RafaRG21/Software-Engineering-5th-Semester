package com.example.prctica09_ruiz_gudino_jose_rafael;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ControladorMenu extends FragmentPagerAdapter {
    int numOpciones;

    public ControladorMenu(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        //Variable para obtener cantidad de opciones del menú
        numOpciones = behavior;
    }//ControladorMenu

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new PrincipalFragment();
            case 1: return new GaleriaFragment();
            case 2: return new FormularioFragment();
            default: return null;
        }//switch
    }//getItem

    @Override
    public int getCount() {
        //Retorna el número de opciones
        return numOpciones;
    }//getCount
}//class
