package com.AtlantisGames.fundrinksex.Fragments;


import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import com.AtlantisGames.fundrinksex.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class RuletaFragment extends Fragment {


    private VideoView videoView;
    private ConstraintLayout constraintLayout;

    public RuletaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view =  inflater.inflate(R.layout.fragment_ruleta, container, false);

        videoView= view.findViewById(R.id.videoView);
        constraintLayout= view.findViewById(R.id.constraintLayout);
        //________________________________________________________________________________________
        //VIDEO RULETA
        //________________________________________________________________________________________
        Uri uriRuleta = Uri.parse("android.resource://" + getActivity().getPackageName() + "/"+R.raw.prueba);
        Uri uriParada = Uri.parse("android.resource://" + getActivity().getPackageName() + "/"+R.raw.prueba2);
        videoView.setVideoURI(uriRuleta);
        videoView.requestFocus();
        videoView.setOnPreparedListener (new MediaPlayer.OnPreparedListener()
        {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
                videoView.start();
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
                
            }
        });

        return view;
    }

}
