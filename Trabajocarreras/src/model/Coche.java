package model;

public class Coche {
    private String piloto;
    private int dorsal;
    private int km;
    private int puntos;

    public Coche(String piloto, int dorsal) {
        this.piloto = piloto;
        this.dorsal = dorsal;
        this.km = 0;
        this.puntos = 0;
    }

    // Metodo para usar en la carrea
    public String getPiloto() { return piloto; }
    public int getDorsal() { return dorsal; }
    public int getKm() { return km; }
    public void addKm(int avance) { this.km += avance; }
    public void resetKm() { this.km = 0; }
    public int getPuntos() { return puntos; }
    public void addPuntos(int p) { this.puntos += p; }
}