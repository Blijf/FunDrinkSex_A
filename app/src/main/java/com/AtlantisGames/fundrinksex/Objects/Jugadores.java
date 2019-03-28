package com.AtlantisGames.fundrinksex.Objects;

import java.util.ArrayList;
import java.util.List;

public class Jugadores
{
    private int size;
    private List<Player> players;

    //CONSTRUCTOR
    //------------------------------------------------------
    public Jugadores (int size)
    {
        this.size=size;
        players = new ArrayList<>();
    }

    //METHODS
    //------------------------------------------------------
    public void addListPlayer(Player player)
    {

        if(players.size()<size)
        {
            players.add(player);
            player.setId(players.size());
        }
    }


    public List<Player> getJugaddores(){return players;}

    public boolean nameExists(Player player)
    {
        boolean exists=false;

        for (int i = 0; i < players.size(); i++)
        {
            if(players.get(i).getName().equals(player.getName()))
            {
                exists=true;
            }
            else{exists=false;}
        }

        return exists;
    }

    public boolean isEmpty()
    {
        return players.size() == 0;
    }

    public boolean minPlayersToPLay(int cant)
    {
        return players.size() >= cant;
    }
}
