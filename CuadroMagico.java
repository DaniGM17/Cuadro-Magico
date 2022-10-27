import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author dania
 */
public class CuadroMagico {

    public static BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
    public static String entrada;

    public static int[][] cuadroAleatorio(int tamaño) {
        int[][] cuadroMagico = new int[tamaño][tamaño];
        for (int i = 0; i < cuadroMagico.length; i++) {
            for (int j = 0; j < cuadroMagico[i].length; j++) {
                cuadroMagico[i][j] = (int) (Math.random() * 9) + 1;
            }
        }
        return cuadroMagico;
    }

    public static int[][] rellenarMatriz(int tamaño) throws IOException {
        int[][] array = new int[tamaño][tamaño];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.println("Escribe el valor [" + i + "][" + j + "]:");
                entrada = bufer.readLine();
                array[i][j] = Integer.parseInt(entrada);
            }
        }
        return array;
    }

    public static void imprimirCuadro(int[][] cuadro) {
        for (int i = 0; i < cuadro.length; i++) {
            for (int j = 0; j < cuadro[i].length; j++) {
                System.out.printf("%4d", cuadro[i][j]);
            }
            System.out.println();
        }
    }

    public static int suma(int[][] cuadro) {
        int suma = 0;
        for (int i = 0; i < cuadro[0].length; i++) {
            suma = suma + cuadro[0][i];
        }
        return suma;
    }

    public static boolean comparacionRenglones(int[][] cuadro, int suma) {
        boolean esCuadro = true;
        int sumaRenglones = 0;
        for (int i = 0; i < cuadro.length; i++) {
            for (int j = 0; j < cuadro[i].length; j++) {
                sumaRenglones = sumaRenglones + cuadro[i][j];
            }
            if (sumaRenglones != suma) {
                esCuadro = false;
                break;
            }
            sumaRenglones = 0;
        }
        return esCuadro;
    }

    public static boolean comparacionColumnas(int[][] cuadro, int suma) {
        boolean esCuadro = true;
        int sumaColumnas = 0;
        for (int i = 0; i < cuadro.length; i++) {
            for (int j = 0; j < cuadro[i].length; j++) {
                sumaColumnas = sumaColumnas + cuadro[j][i];
            }
            if (sumaColumnas != suma) {
                esCuadro = false;
                break;
            }
            sumaColumnas = 0;
        }
        return esCuadro;
    }

    public static void comparacionColumnasI(int[][] cuadro, int suma) {
        boolean esCuadro = true;
        int sumaColumnas = 0;
        for (int i = 0; i < cuadro.length; i++) {
            for (int j = 0; j < cuadro[i].length; j++) {
                sumaColumnas = sumaColumnas + cuadro[j][i];
            }
            System.out.println(sumaColumnas);
            if (sumaColumnas != suma) {
                esCuadro = false;
                System.out.println(esCuadro);
                break;
            }
            sumaColumnas = 0;
        }
    }

    public static boolean comparecionDiagonalP(int[][] cuadro, int suma) {
        boolean esCuadro = true;
        int sumaDiagonalP = 0;

        for (int i = 0; i < cuadro.length; i++) {
            for (int j = 0; j < cuadro[i].length; j++) {
                if (i == j) {
                    sumaDiagonalP = sumaDiagonalP + cuadro[i][j];
                }
            }
        }
        if (sumaDiagonalP != suma) {
            esCuadro = false;
        }
        return esCuadro;
    }

    public static boolean comparecionDiagonalS(int[][] cuadro, int suma) {
        boolean esCuadro = true;
        int sumaDiagonalS = 0;

        for (int i = 0; i < cuadro.length; i++) {
            for (int j = 0; j < cuadro[i].length; j++) {
                if (i + j == cuadro.length - 1) {
                    sumaDiagonalS = sumaDiagonalS + cuadro[i][j];
                }
            }
        }
        if (sumaDiagonalS != suma) {
            esCuadro = false;
        }
        return esCuadro;
    }

    public static boolean esCuadro(int[][] cuadro) {
        int suma;
        suma = suma(cuadro);
        while (true) {
            if (!comparacionRenglones(cuadro, suma)) {
                return false;
            }
            if (!comparacionColumnas(cuadro, suma)) {
                return false;
            }
            if (!comparecionDiagonalP(cuadro, suma)) {
                return false;
            }
            if (!comparecionDiagonalS(cuadro, suma)) {
                return false;
            }
            return true;
        }
    }

    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        int modo, tamaño, suma;
        int[][] cuadro;
        boolean esCuadro;

        System.out.println("Programa que verifica si es un Cuadro Mágico");
        System.out.println("¿Quieres verificar un cuadro aleatorio o ingresar los valores por tu cuenta?");
        System.out.println("1.- Aleatorio");
        System.out.println("2.- Propio");
        entrada = bufer.readLine();
        modo = Integer.parseInt(entrada);
        System.out.println("¿De qué tamaño sera el Cuadro?");
        entrada = bufer.readLine();
        tamaño = Integer.parseInt(entrada);

        if (modo == 1) {
            cuadro = cuadroAleatorio(tamaño);
            imprimirCuadro(cuadro);
            if (esCuadro(cuadro)) {
                System.out.println("El cuadro es un cuadro mágico");
            } else {
                System.out.println("El cuadro no es un cuadro mágico");
            }
        }
        if (modo == 2) {
            cuadro = rellenarMatriz(tamaño);
            imprimirCuadro(cuadro);
            if (esCuadro(cuadro)) {
                System.out.println("El cuadro es un cuadro mágico");
            } else {
                System.out.println("El cuadro no es un cuadro mágico");
            }
        }
    }
}
