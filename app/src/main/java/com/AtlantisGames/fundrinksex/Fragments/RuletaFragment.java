package com.AtlantisGames.fundrinksex.Fragments;


import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import com.AtlantisGames.fundrinksex.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import androidx.navigation.NavController;

import static androidx.navigation.Navigation.findNavController;


/**
 * A simple {@link Fragment} subclass.
 */
public class RuletaFragment extends Fragment {


    private VideoView videoView,videoView2;
    private ConstraintLayout constraintLayout;
    private String transitions ;
    private List<Uri> paradasUri;
    private int choise;
    private Uri uriRuleta;
    public RuletaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view =  inflater.inflate(R.layout.fragment_ruleta, container, false);

        videoView= view.findViewById(R.id.videoView);
        videoView2= view.findViewById(R.id.videoView);
        constraintLayout= view.findViewById(R.id.constraintLayout);

        paradasUri = new ArrayList<>();

        //location de los videos
        uriRuleta = Uri.parse("android.resource://" + getActivity().getPackageName() + "/"+R.raw.prueba);

        final Uri uriParada_prueba = Uri.parse("android.resource://" + getActivity().getPackageName() + "/"+R.raw.prueba2);//amarilllo
        final Uri uriParada_versus = Uri.parse("android.resource://" + getActivity().getPackageName() + "/"+R.raw.prueba2);//azul
        final Uri uriParada_poder = Uri.parse("android.resource://" + getActivity().getPackageName() + "/"+R.raw.prueba2);//verde
        final Uri uriParada_castigo = Uri.parse("android.resource://" + getActivity().getPackageName() + "/"+R.raw.prueba2);//rojo
        final Uri uriParada_afinidad = Uri.parse("android.resource://" + getActivity().getPackageName() + "/"+R.raw.prueba2);//rosa

        //rellenamos la lista de paradasUri con las posibles paradasUri
        paradasUri.add(uriParada_prueba);paradasUri.add(uriParada_versus);paradasUri.add(uriParada_poder);
        paradasUri.add(uriParada_castigo);paradasUri.add(uriParada_afinidad);

        return view;
    }

    /**
     *PASAMOS A LA PANTALLA DE PRUEBAS
     */
    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        final NavController navController= findNavController(view);
        //________________________________________________________________________________________
        //VIDEO RULETA
        //________________________________________________________________________________________
        videoView.setVideoURI(uriRuleta);
        videoView.requestFocus();
        transitions="play";
        videoView.setOnPreparedListener (new MediaPlayer.OnPreparedListener()
        {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(false);
                videoView.start();

            }
        });

        //Se comprueba si el video ha finalizado
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
        {
            @Override
            public void onCompletion(MediaPlayer mp)
            {
                switch (transitions)
                {

                    case "play":
                        videoView.start();
                        break;

                    case "parado_bucle":
                        videoView.suspend();
                        //------------------
                        //VIDEO PARADA
                        //Elegimos el video de parada de forma aleatoria donde se va a pasar
                        Random random= new Random();
                        choise= random.nextInt(5);
//                        choise=3;
                        videoView2.setVideoURI(paradasUri.get(choise));
                        videoView2.requestFocus();
                        videoView2.start();
                        transitions="parada_video";
                        break;

                    case "parada_video":
                        //-----------------
                        //PASAMOS A PANTALLA
                        switch (choise)
                        {
                            case 0:
                                findNavController(view).navigate(R.id.pruebaFragment);
                                break;
                            case 1:
                                findNavController(view).navigate(R.id.versusFragment);
                                break;
                            case 2:
                                findNavController(view).navigate(R.id.poderFragment);
                                break;
                            case 3:
                                findNavController(view).navigate(R.id.castigoFragment);
                                break;
                            case 4:
                                findNavController(view).navigate(R.id.afinidadFragment);
                                break;
                        }
//                        Toast.makeText(getContext(), "pasamos a pantalla",Toast.LENGTH_SHORT).show();
                        break;
                }


            }
        });


        //________________________________________________________________________________________
        //VIDEO PARADA
        //________________________________________________________________________________________
        //Se pulsa la pantalla
        constraintLayout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                transitions ="parado_bucle";
//                Toast.makeText(getContext(), "pulsado",Toast.LENGTH_SHORT).show();

            }
        });


    }
}
