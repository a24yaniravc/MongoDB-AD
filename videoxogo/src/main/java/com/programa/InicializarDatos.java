package com.programa;

import java.util.List;

import org.bson.Document;

/**
 * Clase encargada de inicializar los datos en la BD
 */
public class InicializarDatos {
    /**
     * Inicializa la colección "partidas" con datos de ejemplo
     */
    public void inicializar() {
        System.out.println("Inicializando datos...");

        try (MongoProvider mongoProvider = new MongoProvider()) {
            mongoProvider.createCollection("partidas");

            mongoProvider.getCollection("partidas").insertMany(
                    List.of(
                            new Document()
                                    .append("xogador", "Mario")
                                    .append("xogo", "Space Invaders")
                                    .append("puntuacion", 1200)
                                    .append("duracion", 15)
                                    .append("nivel", 3),
                            new Document()
                                    .append("xogador", "Luigi")
                                    .append("xogo", "Pac-Man")
                                    .append("puntuacion", 900)
                                    .append("duracion", 12)
                                    .append("nivel", 3),
                            new Document()
                                    .append("xogador", "Luigi")
                                    .append("xogo", "Space Invaders")
                                    .append("puntuacion", 800)
                                    .append("duracion", 10)
                                    .append("nivel", 2),
                            new Document()
                                    .append("xogador", "Mario")
                                    .append("xogo", "Space Invaders")
                                    .append("puntuacion", 1500)
                                    .append("duracion", 20)
                                    .append("nivel", 4),
                                new Document()
                                    .append("xogador", "Peach")
                                    .append("xogo", "Tetris")
                                    .append("puntuacion", 1100)
                                    .append("duracion", 18)
                                    .append("nivel", 3),
                                new Document()
                                    .append("xogador", "Peach")
                                    .append("xogo", "Tetris")
                                    .append("puntuacion", 1300)
                                    .append("duracion", 22)
                                    .append("nivel", 4),
                                new Document()
                                    .append("xogador", "Bowser")
                                    .append("xogo", "Space Invaders")
                                    .append("puntuacion", 700)
                                    .append("duracion", 8)
                                    .append("nivel", 1),
                                new Document()
                                    .append("xogador", "Bowser")
                                    .append("xogo", "Tetris")
                                    .append("puntuacion", 600)
                                    .append("duracion", 14)
                                    .append("nivel", 2)));
            System.out.println("Datos inicializados correctamente.");
        } catch (Exception e) {
            System.err.println("Error al inicializar datos: " + e.getMessage());
        }
    }
}
