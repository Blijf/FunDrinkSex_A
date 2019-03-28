package com.AtlantisGames.fundrinksex.Fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.AtlantisGames.fundrinksex.Objects.Jugadores;
import com.AtlantisGames.fundrinksex.Objects.Player;
import com.AtlantisGames.fundrinksex.R;

import androidx.navigation.NavController;

import static androidx.navigation.Navigation.findNavController;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddPlayersFragment extends Fragment
{


    private Button buttonComenzar;
    private TextView textViewColumna1;
    private TextView textViewColumna2;
    private TextView textViewColumna3;
    private EditText editTextNames;
    private boolean comenzar;
    private final static int size=15;//núm. jugadores
    private final static int minplayers=2;//núm. jugadores
    private Jugadores jugadores;
    public AddPlayersFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view= inflater.inflate(R.layout.fragment_add_players, container, false);

        buttonComenzar= view.findViewById(R.id.buttonComenzar);
        textViewColumna1= view.findViewById(R.id.textView1Columna);
        textViewColumna2= view.findViewById(R.id.textView2Columna);
        textViewColumna3= view.findViewById(R.id.textView3Columna);
        editTextNames =view.findViewById(R.id.editTextNames);

        textViewColumna1.setText("");
        textViewColumna2.setText("");
        textViewColumna3.setText("");

        jugadores= new Jugadores(15);


        //------------------------------------------------------------------
        //AÑADIR PLAYERS
        //------------------------------------------------------------------
        editTextNames.requestFocus();
//        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
//        imm.showSoftInput(editTextNames, InputMethodManager.SHOW_IMPLICIT);

        editTextNames.setOnEditorActionListener(new TextView.OnEditorActionListener()
        {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event)
            {
                boolean handled = false;

                if (actionId == EditorInfo.IME_ACTION_DONE)
                {
                    gestJugadores(v.getText().toString());
                    handled = true;

                }
                return handled;

            }
        });


        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        final NavController navController= findNavController(view);
        //Vamos al Fragment de Ruleta
        //------------------------------------------------------------------
        //BOTÓN COMENZAR
        //------------------------------------------------------------------
//        buttonComenzar.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.ruletaFragment));
        buttonComenzar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

//                navController.navigate(R.id.ruletaFragment);

                if(jugadores.minPlayersToPLay(minplayers))
                    navController.navigate(R.id.ruletaFragment);
                else
                    Toast.makeText(getContext(), "El mín. de jugadores es: "+minplayers,Toast.LENGTH_LONG).show();

            }
        });
    }


    /*************************************************************************************
     *                                   METHODS
     */
    public void gestJugadores(String name)
    {
        Player player = new Player(name); //jugador

        //
        //comprobamos is el texto introducido esta vacio
        if(name.equals(""))
        {
            Toast.makeText(getContext(), "Nombre vacio",Toast.LENGTH_SHORT).show();
        }
        //Comprobamos si el nombre es repertido(existe en la lista de jugadores)
        if(!jugadores.nameExists(player)&&!name.equals(""))
        {
            jugadores.addListPlayer(player);

            int currentSize=jugadores.getJugaddores().size();
            //Mostramos los jugadores que se han agregado al juego.
            //5 para cada cuadro
            if(currentSize<=5)
            {
                textViewColumna1.setText(textViewColumna1.getText()+String.valueOf(player.getId())+". "+name+"\n");

            }
            else if(currentSize<=10)
            {
                textViewColumna2.setText(textViewColumna2.getText()+String.valueOf(player.getId())+". "+name+"\n");
            }
            else if(currentSize<=size)
            {
                textViewColumna3.setText(textViewColumna3.getText()+String.valueOf(player.getId())+". "+name+"\n");
            }
            else
            {
                Toast.makeText(getContext(), "Lista completa",Toast.LENGTH_SHORT).show();
            }

        }
        else if(jugadores.nameExists(player))
        {
            Toast.makeText(getContext(), "Nombre repetido",Toast.LENGTH_SHORT).show();
        }

        editTextNames.setText("");
    }

}
