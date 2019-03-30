package com.AtlantisGames.fundrinksex.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.AtlantisGames.fundrinksex.Modos.ModosDeJuego;
import com.AtlantisGames.fundrinksex.R;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class VersusFragment extends Fragment {

    private TextView tvNombre,tvEnunciado, tvObjetivo;


    public VersusFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.fragment_versus, container, false);


        tvNombre=view.findViewById(R.id.tvNombre);
        tvEnunciado= view.findViewById(R.id.tvEnunciado);
        tvObjetivo= view.findViewById(R.id.tvObjetivos);

        Random random=new Random();
        //____________________________________________________________
        //                        NOMBRE
        //____________________________________________________________
        int rand= random.nextInt(AddPlayersFragment.jugadores.getJugaddores().size());
        tvNombre.setText(AddPlayersFragment.jugadores.getJugaddores().get(rand).getName());

        //____________________________________________________________
        //              Se elige un enun y objetivo (alet.)
        //____________________________________________________________
        //Enunciado
        int random1= random.nextInt(ModosDeJuego.getVersusEnunciados().size());
        tvEnunciado.setText(ModosDeJuego.getVersusEnunciados().get(random1));
        //Pruebas
        int random2= random.nextInt(ModosDeJuego.getVersusPruebas().size());
        tvObjetivo.setText(ModosDeJuego.getVersusPruebas().get(random2));
        // Inflate the layout for this fragment
        return view;
    }

}
