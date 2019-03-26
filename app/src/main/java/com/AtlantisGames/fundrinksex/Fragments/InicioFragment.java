package com.AtlantisGames.fundrinksex.Fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.AtlantisGames.fundrinksex.R;

import androidx.navigation.Navigation;


/**
 * A simple {@link Fragment} subclass.
 */
public class InicioFragment extends Fragment {

    Button btToAddPlayers;

    public InicioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        View view= inflater.inflate(R.layout.fragment_inicio, container, false);

        btToAddPlayers= view.findViewById(R.id.btToAddplayers);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        //Vamos al Fragment de Addplayers
        btToAddPlayers.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.addPlayersFragment));

    }
}
