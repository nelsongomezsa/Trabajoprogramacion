package controller;

import model.Coche;
import java.util.ArrayList;
import java.util.Random;

public class CarreraController {
    private Random random = new Random();


    public void simularVuelta(ArrayList<Coche> coches) {
        for (Coche c : coches) {
            int avance = random.nextInt(31) + 20;
            c.addKm(avance);
        }
    }

    public void asignarPuntos(ArrayList<Coche> coches) {
        coches.sort((c1, c2) -> Integer.compare(c2.getKm(), c1.getKm()));

        // Sistema de puntuación del PDF [cite: 50, 88]
        if (coches.size() >= 1) coches.get(0).addPuntos(10);
        if (coches.size() >= 2) coches.get(1).addPuntos(8);
        if (coches.size() >= 3) coches.get(2).addPuntos(6);
    }
}