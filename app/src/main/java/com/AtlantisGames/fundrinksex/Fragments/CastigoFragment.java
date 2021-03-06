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
public class CastigoFragment extends Fragment {

    private TextView tvNombre,tvEnunciado;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.fragment_castigo, container, false);

        tvNombre=view.findViewById(R.id.tvNombre);
        tvEnunciado= view.findViewById(R.id.tvEnunciado);


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
        int random1= random.nextInt(ModosDeJuego.getCastigos().size());
        tvEnunciado.setText(ModosDeJuego.getCastigos().get(random1));


        // Inflate the layout for this fragment
        return view;
    }

}
