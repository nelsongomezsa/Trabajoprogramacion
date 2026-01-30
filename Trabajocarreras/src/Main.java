import model.Coche;
import controller.CarreraController;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarreraController control = new CarreraController();
        ArrayList<Coche> competidores = new ArrayList<>();

        System.out.println("--- CONFIGURACIÓN DEL CAMPEONATO ---");
        System.out.print("¿Cuántos coches participan?: ");
        int nCoches = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < nCoches; i++) {
            System.out.print("Nombre piloto " + (i + 1) + ": ");
            String nombre = scanner.nextLine();
            System.out.print("Dorsal: ");
            int dorsal = scanner.nextInt();
            scanner.nextLine();
            competidores.add(new Coche(nombre, dorsal)); // [cite: 148]
        }

        System.out.print("¿Cuántas carreras tiene el campeonato?: ");
        int nCarreras = scanner.nextInt();
        System.out.print("¿Cuántos km tiene cada carrera?: ");
        int kmMeta = scanner.nextInt();

        for (int r = 1; r <= nCarreras; r++) {
            System.out.println("\n=== CARRERA " + r + " ===");

            // Resetear km de los coches [cite: 155]
            for (Coche c : competidores) c.resetKm();

            boolean alguienLlego = false;
            while (!alguienLlego) {
                control.simularVuelta(competidores);
                for (Coche c : competidores) {
                    if (c.getKm() >= kmMeta) alguienLlego = true;
                }
            }

            control.asignarPuntos(competidores);

            System.out.println("1º: " + competidores.get(0).getPiloto() + " (10 pts)");
            System.out.println("2º: " + competidores.get(1).getPiloto() + " (8 pts)");
            System.out.println("3º: " + competidores.get(2).getPiloto() + " (6 pts)");
        }

        System.out.println("\n=== CLASIFICACIÓN FINAL DEL CAMPEONATO ===");
        competidores.sort((c1, c2) -> Integer.compare(c2.getPuntos(), c1.getPuntos()));
        for (Coche c : competidores) {
            System.out.println(c.getPiloto() + " - Puntos totales: " + c.getPuntos());
        }
    }
}