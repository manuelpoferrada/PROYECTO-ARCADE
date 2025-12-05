package utils;

import model.Jugador;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Utils {

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
     * Pedimos una cadena controlando las excepciones
     * @param mensaje
     * @return
     */
    public static String pideCadena(String mensaje) {
        Scanner sc = new Scanner(System.in);
        String cadena;
        boolean esValido = false;

        do {
            System.out.print(mensaje);
            cadena = sc.nextLine();

            //Si ha introducido algo en la cadena nos salimos del bucle
            if (cadena.length() > 0) {
                esValido = true;
            // En caso de estar el campo vacio que salte un error
            } else {
                System.out.println("Error: No puede dejar este campo vacío.");
            }
        } while (!esValido);
        return cadena;
    }

    /**
     * Mostramos el menu por pantalla y pedimos una opcion
     * @return
     */
    public static int menu (){
        System.out.println("");
        System.out.println("");
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
        System.out.println("----------------------------");
        int opcion = pideNumero(0,14,"Qué opción desea hacer: ","Error, debe ser un numero entero entre 0 y 14");
        return opcion;
    }

    //public static Jugador pedirJugador (){
    //    Jugador nuevoJugador = null;
    //    String nombre = pideCadena("Introduce el nombre del jugador: ");
    //    String id = pideCadena("introduce identi...:")
    //    nuevoJugador = new Jugador(nombre,)
    //}

    /**
     * Generamos un numero Aleatorio entre 0 y 9999 para saber cuanta puntuacion tiene un usuario
     * @return
     */
    public static int generarAleatorio(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("El límite inferior (min) no puede ser mayor que el límite superior (max).");
        }
        Random random = new Random();
        // nextInt(max - min + 1) genera números desde 0 hasta (max - min)
        return random.nextInt(max - min + 1) + min;
    }
}
