package com.AtlantisGames.fundrinksex.Modos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ModosDeJuego
{
    /*********************************************************
     *                 DECLARACIÓN DE LISTAS
     *********************************************************/
    //PRUEBA
    private static List<String> pruebaEnunciados = new ArrayList<>();
    private static List<String> pruebaObjectivos = new ArrayList<>();
    //VERSUS
    private static List<String> versusEnunciados = new ArrayList<>();
    private static List<String> versusPruebas = new ArrayList<>();
    //PODERES
    private static List<String> poderes = new ArrayList<>();
    //CASTIGOS
    private static List<String> castigos = new ArrayList<>();


    /*********************************************************
     *                 TEXTOS DE LAS LISTAS
     *********************************************************/
    //________________________________________________________
    //                 PRUEBA-enunciado
    //________________________________________________________
    public static List<String> getPruebaEnunciados()
    {

        pruebaEnunciados= Arrays.asList
        (
                "Esto sería una prueba de la lista de ENUNCIADO de PRUEBAS",
                "Esto sería una prueba-2 de la lista de ENUNCIADO de PRUEBAS",
                "Esto sería una prueba-3 de la lista de ENUNCIADO de PRUEBAS",
                "Esto sería una prueba-4 de la lista de ENUNCIADO de PRUEBAS"
        );

        return pruebaEnunciados;
    }
    //________________________________________________________
    //                 PRUEBA-objetivos
    //________________________________________________________
    public static List<String> getPruebaObjectivos()
    {
        pruebaObjectivos= Arrays.asList
        (
                "Esto sería una prueba de la lista de OBJETIVOS de PRUEBAS",
                "Esto sería una prueba-2 de la lista de OBJETIVOS de PRUEBAS",
                "Esto sería una prueba-3 de la lista de OBJETIVOS de PRUEBAS",
                "Esto sería una prueba-4 de la lista de OBJETIVOS de PRUEBAS"
        );

        return pruebaObjectivos;
    }

    //________________________________________________________
    //                 VERSUS-Enunciado
    //________________________________________________________
    public static List<String> getVersusEnunciados()
    {
        versusEnunciados=Arrays.asList
        (
                "Esto sería una prueba de la lista de ENUNCIADO de VERSUS",
                "Esto sería una prueba-2 de la lista de ENUNCIADO de VERSUS",
                "Esto sería una prueba-3 de la lista de ENUNCIADO de VERSUS",
                "Esto sería una prueba-4 de la lista de ENUNCIADO de VERSUS"
        );

        return versusEnunciados;
    }
    //________________________________________________________
    //                 VERSUS-pruebas
    //________________________________________________________
    public static List<String> getVersusPruebas()
    {

        versusPruebas= Arrays.asList
        (
                "Esto sería una prueba de la lista de PRUEBAS de VERSUS",
                "Esto sería una prueba-2 de la lista de PRUEBAS de VERSUS",
                "Esto sería una prueba-3 de la lista de PRUEBAS de VERSUS",
                "Esto sería una prueba-4 de la lista de PRUEBAS de VERSUS"

        );

        return versusPruebas;
    }

    //________________________________________________________
    //                 PODERES
    //________________________________________________________
    public static List<String> getPoderes()
    {
        poderes= Arrays.asList
        (
                "Esto sería una prueba de la lista de PODERES",
                "Esto sería una prueba-2 de la lista de PODERES",
                "Esto sería una prueba-3 de la lista de PODERES",
                "Esto sería una prueba-4 de la lista de PODERES"
        );
        return poderes;
    }

    //________________________________________________________
    //                 CASTIGOS
    //________________________________________________________
    public static List<String> getCastigos()
    {
        castigos= Arrays.asList
        (
                "Esto sería una prueba de la lista de CASTIGOS",
                "Esto sería una prueba-2 de la lista de CASTIGOS",
                "Esto sería una prueba-3 de la lista de CASTIGOS",
                "Esto sería una prueba-4 de la lista de CASTIGOS"

        );
        return castigos;
    }
}
