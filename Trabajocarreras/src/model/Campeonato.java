package model;

import java.util.ArrayList;

public class Campeonato {
    private ArrayList<Coche> clasificacion;

    public Campeonato(ArrayList<Coche> coches) {
        this.clasificacion = coches;
    }

    public ArrayList<Coche> getClasificacion() { return clasificacion; }
}