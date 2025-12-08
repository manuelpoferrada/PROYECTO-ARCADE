package model;

import utils.Utils;

/**
 * Creamos los atributos del Array "Jugador"
 */
public class Jugador {
    private String nombreJugador;
    private String identificadorJugador;
    private int creditosDisponibles;
    private int numeroPartidasJugador;

    /**
     * SETTERS
     * @param nombreJugador
     */
    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public void setCreditosDisponibles(int creditosDisponibles) {
        this.creditosDisponibles = creditosDisponibles;
    }
    public void setIdentificadorJugador(String identificadorJugador) { this.identificadorJugador = identificadorJugador; }
    public void setNumeroPartidasJugador(int numeroPartidasJugador) { this.numeroPartidasJugador = numeroPartidasJugador; }

    /**
     * GETTERS
     * @return
     */
    public int getNumeroPartidasJugador() { return numeroPartidasJugador; }
    public int getCreditosDisponibles() {
        return creditosDisponibles;
    }
    public String getIdentificadorJugador() {
        return identificadorJugador;
    }
    public String getNombreJugador() {
        return nombreJugador;
    }

    //MÉTODOS DE NUESTRO JUGADOR MÍNIMOS PARA HACER QUE FUNCIONE

    /**
     * Creamos el constructor para poder crear el jugador de forma más rápida en nuestro Main
     * @param nombreJugador
     * @param identificadorJugador
     */
    public Jugador(String nombreJugador, String identificadorJugador){
        this.nombreJugador = nombreJugador;
        this.identificadorJugador = identificadorJugador;
        this.creditosDisponibles = 100;
        this.numeroPartidasJugador = 0;
    }

    /**
     * Recargamos los creditos del jugador
     */
    public void recargarCreditos (int creditosSumar){
        this.creditosDisponibles += creditosSumar;
    }

    /**
     * Creamos el metodo para gastar los creditos en la máquina
     */
    public boolean gastarCreditos(int costePartida) {
        boolean gastoExitoso = false;

        if (costePartida > 0 && this.creditosDisponibles >= costePartida) {
            this.creditosDisponibles -= costePartida;
            gastoExitoso = true;
        }
        return gastoExitoso;
    }

    /**
     * Incrementamos el numero de las partidas jugadas
     */
    public int incrementarNumPartidas (){
        numeroPartidasJugador++;
        return numeroPartidasJugador;
    }


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





