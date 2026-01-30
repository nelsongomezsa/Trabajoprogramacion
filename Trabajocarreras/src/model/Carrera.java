package model;

import java.util.ArrayList;

public class Carrera {
    private int kmMeta;
    private ArrayList<Coche> participantes;

    public Carrera(int kmMeta, ArrayList<Coche> participantes) {
        this.kmMeta = kmMeta;
        this.participantes = participantes;
    }

    public int getKmMeta() { return kmMeta; }
    public ArrayList<Coche> getParticipantes() { return participantes; }
}
