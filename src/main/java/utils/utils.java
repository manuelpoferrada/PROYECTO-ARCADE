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

    /**
     * Pedimos un numero entre un rango controlando las excepciones
     * @param numeroMin será el valor minimo del número que estamos pidiendo
     * @param numeroMax será el valor máximo del número que estamos pidiendo
     * @param mensaje mensaje que queremos mostrar por pantalla para que el usuario nos responda
     * @param mensajeError mensaje en caso de que se encuentre algún fallo en la respuesta
     * @return
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


    /**
     * Mostramos el menu por pantalla y pedimos una opcion
     * @return
     */
    public static int menu (){
        System.out.println("===== M E N Ú =====");
        System.out.println("1. Registrar nuevo jugador");
        System.out.println("2. Registrar una nueva máquina arcade");
        System.out.println("3. Recargar créditos a un jugador");
        System.out.println("4. Listar jugadores");
        System.out.println("5. Listar maquinas");
        System.out.println("6. Listar maquinas activas");
        System.out.println("7. Realizar el mantenimiento a una máquina");
        System.out.println("8. Jugar una partida (Introduciendo el ID del jugador y máquina)");
        System.out.println("9. Mostrar el jugador más activo");
        System.out.println("10. Mostrar la máquina más usada");
        System.out.println("11. Mostrar el ranking de una máquina concreta");
        System.out.println("12. Dar de baja una máquina arcade");
        System.out.println("13. Editar una máquina arcade");
        System.out.println("14. Editar un jugador");
        int opcion = pideNumero(0,14,"Qué opción desea hacer: ","Error, debe ser un numero entero entre 0 y 14");
        return opcion;
    }

    public static void ejecucionDeResultado (int opcion){
        switch (opcion){
            case 1: //RegistrarNuevoJugador; beak;
            case 2: //Registrar una nueva máquina de arcade; break;
            case 3: //Recargar créditos a un jugador; break;
            case 4: //Listar jugadores; break;
            case 5: //Listar maquinas; break;
            case 6: //Listar maquinas activas; break;
            case 7: //Realizar el mantenimiento a una maquina (reactivarla); break;
            case 8: //Jugar una partida; break;
            case 9: //Mostrar el jugador más activo; break;
            case 10: //Mostrar la máquina mas usada; break;
            case 11: //Mostrar el ranking de una maquina; break;
            case 12: //Dar de baja una máquina; break;
            case 13: //Editar una maquina de arcade; break;
            case 14: //Editar un jugador; break;
        }
    }

}
