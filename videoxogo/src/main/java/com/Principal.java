package com;

import java.util.Scanner;

import com.programa.GestorPartidas;
import com.programa.InicializarDatos;

/**
 * Clase principal que ejecuta la aplicación
 */
public class Principal {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String iniciar = "";

        System.out.println("¿Desea inicializar los datos? (s/n)");
        iniciar = scanner.nextLine();

        if (iniciar.equalsIgnoreCase("s")) {
            InicializarDatos inicializarDatos = new InicializarDatos();
            inicializarDatos.inicializar();
        }

        // Consultas
        GestorPartidas gestorPartidas = new GestorPartidas();

        // Puntuación total por xogador
        System.out.println("-----------------------------------");
        gestorPartidas.puntuacionTotalPorXogador();
        System.out.println("-----------------------------------");

        // Mejor partida de cada jugador
        System.out.println("-----------------------------------");
        gestorPartidas.mejorPartidaDeCadaJugador();
        System.out.println("-----------------------------------");

        // Duración mínima rexistrada entre todas as partidas dese xogo
        System.out.println("-----------------------------------");
        gestorPartidas.partidaMasCortaPorJuego();
        System.out.println("-----------------------------------");
        
        // Ranking de jugadores por puntuación total (mayor a menor)
        System.out.println("-----------------------------------");
        gestorPartidas.rankingJugadoresPorPuntuacionTotal();
        System.out.println("-----------------------------------");

        // Lista simplificada de partidas (Jugador, juego, puntuación)
        System.out.println("-----------------------------------");
        gestorPartidas.listaSimplificadaPartidas();
        System.out.println("-----------------------------------");
        
        // Juegos más puntuables (juegos con mayor puntuación media)
        System.out.println("-----------------------------------");
        gestorPartidas.juegosMasPuntuables();
        System.out.println("-----------------------------------");
    }
}