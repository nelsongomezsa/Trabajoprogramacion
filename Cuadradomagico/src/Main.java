import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Introduce el tamaño de la matriz (n): "); // [cite: 31, 52]
        int n = scanner.nextInt();

        int[][] matriz = new int[n][n]; // [cite: 25]
        long intentos = 0;
        boolean encontrado = false;

        System.out.println("Buscando el cuadrado mágico...");


        while (!encontrado) {
            intentos++;


            matriz = generarMatriz(n);


            int sumaMagica = 0;
            for (int j = 0; j < n; j++) {
                sumaMagica += matriz[0][j];
            }


            if (esMagico(matriz, n, sumaMagica)) {
                encontrado = true;


                System.out.println("\n=== CUADRADO MÁGICO ENCONTRADO ==="); // [cite: 53]
                imprimirMatriz(matriz, n); //
                System.out.println("Constante mágica: " + sumaMagica); // [cite: 49, 63]
                System.out.println("Intentos realizados: " + intentos); // [cite: 50, 64]
            }
        }
    }

    // Método para generar la matriz aleatoria [cite: 35]
    public static int[][] generarMatriz(int n) {
        int tam = n * n;
        int[] numeros = new int[tam];

        for (int i = 0; i < tam; i++) {
            numeros[i] = i + 1; // Rango del 1 al n2
        }


        for (int i = 0; i < tam; i++) {
            int aleatorio = (int) (Math.random() * tam);
            int temp = numeros[i];
            numeros[i] = numeros[aleatorio];
            numeros[aleatorio] = temp;
        }

        int[][] m = new int[n][n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = numeros[k++];
            }
        }
        return m;
    }

    // Método de validación de filas, columnas y diagonales [cite: 42, 43, 44, 45]
    public static boolean esMagico(int[][] m, int n, int suma) {
        for (int i = 0; i < n; i++) {
            int sFila = 0;
            for (int j = 0; j < n; j++) sFila += m[i][j];
            if (sFila != suma) return false;
        }

        for (int j = 0; j < n; j++) {
            int sCol = 0;
            for (int i = 0; i < n; i++) sCol += m[i][j];
            if (sCol != suma) return false;
        }

        int d1 = 0;
        for (int i = 0; i < n; i++) d1 += m[i][i];
        if (d1 != suma) return false;
        int d2 = 0;
        for (int i = 0; i < n; i++) d2 += m[i][n - 1 - i];
        if (d2 != suma) return false;

        return true;
    }

    public static void imprimirMatriz(int[][] m, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }
    }
}