package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class utils {

    /**
     *
     * @param
     * @return
     * public static boolean validaDNI(String dni){
     *         boolean esValido = false;
     *         if (dni != null && !dni.isEmpty()){
     *             if (dni.length() == 9){
     *                 esValido = true;
     *             }
     *         }
     *         return esValido;
     *
     *     }
     */

    public static int pideNumero(int numeroMin, int numeroMax, String mensaje, String mensajeError) {
        Scanner sc = new Scanner(System.in);
        int numero = 0;
        boolean esValido = true;
        do {
            try {
                System.out.print(mensaje);
                numero = sc.nextInt();
                if (numero < numeroMin || numero > numeroMax) {
                    System.out.println(mensajeError);
                    esValido = false;
                } else {
                    esValido = true;
                }
            } catch (InputMismatchException e) {
                System.out.println(mensajeError);
                esValido = false;
                sc.nextLine();
            }
        } while (!esValido);
        return numero;
    }


    //por aqui me he quedado
    public int menu (int opcion){
        System.out.println("===== M E N Ú =====");
        System.out.println("1. Registrar nuevo jugador");
        System.out.println("2. Registrar una nueva máquina arcade");
        System.out.println("3. Recargar créditos a un jugador");
        System.out.println("4. Listar jugadores");
        System.out.println("5. Listar maquinas");
        System.out.println("6. Listar maquinas activas");
        System.out.println("7. Realizar el mantenimiento a una máquina reactivarla");
        System.out.println("");
        opcion = pideNumero(0,14,"¿Qué opción desea hacer?","Error, debe ser un numero entero entre 0 y 14");

        return opcion;
    }

}
