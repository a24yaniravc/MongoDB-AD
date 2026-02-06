package com.programa;

import java.util.List;

import org.bson.Document;

import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;

/**
 * Clase encargada de gestionar las consultas sobre las partidas registradas
 * en la BD
 */
public class GestorPartidas {
    /**
     * Puntuación total por xogador
     */
    public void puntuacionTotalPorXogador() {
        System.out.println("Puntuación total por xogador:");
        try (MongoProvider mongoProvider = new MongoProvider()) {
            mongoProvider.getCollection("partidas").aggregate(
                    List.of(
                            Aggregates.group("$xogador", 
                            Accumulators.sum("totalPuntuacion", "$puntuacion"))))
                    .forEach(doc -> System.out.println(doc));
        } catch (Exception e) {
            System.err.println("Error al calcular puntuación total por xogador: " + e.getMessage());
        }
    }

    /**
     * Mejor partida de cada jugador
     */
    public void mejorPartidaDeCadaJugador() {
        System.out.println("Mejor partida de cada jugador:");
        try (MongoProvider mongoProvider = new MongoProvider()) {
            mongoProvider.getCollection("partidas").aggregate(
                    List.of(
                            Aggregates.group("$xogador", 
                            Accumulators.max("mejorPuntuacion", "$puntuacion"))))
                    .forEach(doc -> System.out.println(doc));
        } catch (Exception e) {
            System.err.println("Error al calcular mejor partida de cada jugador: " + e.getMessage());
        }
    }

    /**
     * Duración mínima rexistrada entre todas as partidas dese xogo
     */
    public void partidaMasCortaPorJuego() {
        System.out.println("Duración mínima rexistrada entre todas as partidas dese xogo:");
        try (MongoProvider mongoProvider = new MongoProvider()) {
            mongoProvider.getCollection("partidas").aggregate(
                    List.of(
                            Aggregates.group("$xogo", 
                            Accumulators.min("duracionMinima", "$duracion"))))
                    .forEach(doc -> System.out.println(doc));
        } catch (Exception e) {
            System.err.println("Error al calcular partida más corta por juego: " + e.getMessage());
        }
    }

    /**
     * Ranking de jugadores por puntuación total (mayor a menor)
     */
    public void rankingJugadoresPorPuntuacionTotal() {
        System.out.println("Ranking de jugadores por puntuación total:");
        try (MongoProvider mongoProvider = new MongoProvider()) {
            mongoProvider.getCollection("partidas").aggregate(
                    List.of(
                            Aggregates.group("$xogador", 
                            Accumulators.sum("totalPuntuacion", "$puntuacion")),
                            Aggregates.sort(new Document("totalPuntuacion", -1))))
                    .forEach(doc -> System.out.println(doc));
        } catch (Exception e) {
            System.err.println("Error al calcular ranking de jugadores por puntuación total: " + e.getMessage());
        }
    }

    /**
     * Lista simplificada de partidas (Jugador, juego, puntuación)
     */
    public void listaSimplificadaPartidas() {
        System.out.println("Lista simplificada de partidas (Jugador, juego, puntuación):");
        try (MongoProvider mongoProvider = new MongoProvider()) {
            mongoProvider.getCollection("partidas").find()
                    .projection(new Document("xogador", 1)
                        .append("xogo", 1)
                        .append("puntuacion", 1)
                        .append("_id", 0))
                    .forEach(doc -> System.out.println(doc));
        } catch (Exception e) {
            System.err.println("Error al obtener lista simplificada de partidas: " + e.getMessage());
        }
    }

    /**
     * Juegos más puntuables (juegos con mayor puntuación media)
     */
    public void juegosMasPuntuables() {
        System.out.println("Juegos más puntuables (juegos con mayor puntuación media):");
        try (MongoProvider mongoProvider = new MongoProvider()) {
            mongoProvider.getCollection("partidas").aggregate(
                    List.of(
                            Aggregates.group("$xogo", 
                            Accumulators.avg("puntuacionMedia", "$puntuacion")),
                            Aggregates.sort(new Document("puntuacionMedia", -1))))
                    .forEach(doc -> System.out.println(doc));
        } catch (Exception e) {
            System.err.println("Error al calcular juegos más puntuables: " + e.getMessage());
        }
    }
}
