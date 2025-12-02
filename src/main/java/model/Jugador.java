package model;

import utils.utils;

/**
 * Creamos los atributos del Array "Jugador"
 */

public class Jugador {
    private String nombreJugador;
    private String identificadorJugador;
    private int creditosDisponibles;
    private int numeroPartidasJugador;


    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public void setCreditosDisponibles(int creditosDisponibles) {
        this.creditosDisponibles = creditosDisponibles;
    }

    public int getNumeroPartidasJugador() {
        return numeroPartidasJugador;
    }

    public int getCreditosDisponibles() {
        return creditosDisponibles;
    }

    public String getIdentificadorJugador() {
        return identificadorJugador;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    /**
     * Creamos el constructor para poder crear el jugador de forma más rápida en nuestro Main
     * @param nombreJugador
     * @param identificadorJugador
     * @param creditosDisponibles
     * @param numeroPartidasJugador
     */
    public Jugador(String nombreJugador, String identificadorJugador, int creditosDisponibles, int numeroPartidasJugador){
        this.nombreJugador = nombreJugador;
        this.identificadorJugador = identificadorJugador;
        this.creditosDisponibles = creditosDisponibles;
        this.numeroPartidasJugador = numeroPartidasJugador;
    }

    /**
     * Funcionalidades mínimas:
     *      --> Recargar créditos
     *      --> Gastar créditos (solo si tiene suficientes)
     *      --> Incrementar el número de partidas jugadas
     *      --> Mostrar información del jugador
     */

    /**
     * Recargamos los creditos del jugador
     */
    public void recargarCreditos (){
        int creditosSumar = utils.pideNumero(10,100,"Ingrese desde 10 hasta 100 Créditos: ","¡¡ ERROR, debe ser un numero entero entre 10 y 100 !! ");
        this.creditosDisponibles += creditosSumar;
    }

    /**
     * Creamos el metodo para gastar los creditos en la máquina
     */


    /**
     * Incrementamos el numero de las partidas jugadas
     */


    /**
     * Mostramos la información del jugador
     * @return
     */
    public String toString(){
        return "El nombre del jugador es: "+this.nombreJugador+
                "\nEl identificador del jugador es: "+this.identificadorJugador+
                "\nEl jugador tiene "+this.creditosDisponibles+"C" +
                "\nHa jugado "+this.numeroPartidasJugador+" partidas";  //No hace falta poner el this pq no hay posibilidad de confunsión,
        //pero es para afianzar bien que el this se refiere a los datos de fuera.
    }
}





