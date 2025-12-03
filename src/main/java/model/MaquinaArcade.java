package model;

import utils.Utils;

/**
 * Creamos los atributos del Array "MaquinaArcade"
 */

public class MaquinaArcade {
    private String nombreMaquina;
    private String generoMaquina;
    private int precioPartida;
    private boolean estaActiva;
    private int contadorPartidasJugadas;
    private int [] mejoresPuntuaciones;
    private Jugador [] mejoresJugadores;

    /**
     * SETTERS
     * He escogido todos porque quiero poder modificar todos los atributos de MaquinaArcade
     */
    public void setContadorPartidasJugadas(int contadorPartidasJugadas) {
        this.contadorPartidasJugadas = contadorPartidasJugadas;
    }
    public void setEstaActiva(boolean estaActiva) {
        this.estaActiva = estaActiva;
    }
    public void setPrecioPartida(int precioPartida) {
        this.precioPartida = precioPartida;
    }
    public void setGeneroMaquina(String generoMaquina) {
        this.generoMaquina = generoMaquina;
    }
    public void setNombreMaquina(String nombreMaquina) {
        this.nombreMaquina = nombreMaquina;
    }
    public int[] getMejoresPuntuaciones() {
        return mejoresPuntuaciones;
    }

    /**
     * GETTERS
     * He escogido todos porque quiero mostrar por pantalla todos los atributos de MaquinaArcade
     */
    public String getNombreMaquina() { return nombreMaquina;
    }
    public int getPrecioPartida() {
        return precioPartida;
    }
    public String getGeneroMaquina() {
        return generoMaquina;
    }
    public boolean isEstaActiva() {
        return estaActiva;
    }
    public int getContadorPartidasJugadas() {
        return contadorPartidasJugadas;
    }
    public Jugador[] getMejoresJugadores() {
        return mejoresJugadores;
    }

    //MÉTODOS DE NUESTRA MAQUINAARCADE MÍNIMOS PARA HACER QUE FUNCIONE

    /**
     * ToString para mostrar la información de la máquina
     * @return
     */
    public String toString(){
        return "La máquina se llama: "+this.nombreMaquina+
                "\nEl genero de la máquina es: "+this.generoMaquina+
                "\nEl precio de cada partida es: "+this.precioPartida+"C"+
                "\nEstado: "+ComprobarActividad()+
                "\nSe han jugado "+this.contadorPartidasJugadas+
                mostrarRanking();
    }

    /**
     * Creamos el constructor para poder crear el jugador de forma más rápida en nuestro Main
     * @param nombreMaquina
     * @param generoMaquina
     * @param precioPartida
     */
    public MaquinaArcade (String nombreMaquina, String generoMaquina, int precioPartida){
        this.nombreMaquina = nombreMaquina;
        this.generoMaquina = generoMaquina;
        this.precioPartida = precioPartida;
        this.estaActiva=true;
        this.contadorPartidasJugadas=0;
        this.mejoresPuntuaciones =  new int[3];
        this.mejoresJugadores = new Jugador[3];
    }

    /**
     * Activar o desactivar la máquina, si la máquina esta activa la desactivo y viceversa
     */
    public void ActivarDesactivarMaquina (){
        if (estaActiva){
            estaActiva = false;
        } else if (!estaActiva){
            estaActiva = true;
        }
    }

    /**
     * Consulta actividad de la máquina
     */
    public String ComprobarActividad (){
        String actividad = "";
        if (estaActiva){
            actividad = "La máquina está activa";
        }else {
            actividad = "La máquina está desactiva";
        }
        return actividad;
    }

    /**
     * Método que actualiza todo mi ranking, pero no lo muestra
     * @param nuevaPuntuacion
     * @param jugador
     */
    private void actualizarRanking(int nuevaPuntuacion, Jugador jugador) {

        //COMPROBAR TOP 1
        if (nuevaPuntuacion > mejoresPuntuaciones[0]) {

            //Mover Top 2 al Top 3
            mejoresPuntuaciones[2] = mejoresPuntuaciones[1];
            mejoresJugadores[2] = mejoresJugadores[1];
            //Mover Top 1 al Top 2
            mejoresPuntuaciones[1] = mejoresPuntuaciones[0];
            mejoresJugadores[1] = mejoresJugadores[0];
            //Poner el Top 1
            mejoresPuntuaciones[0] = nuevaPuntuacion;
            mejoresJugadores[0] = jugador;
            System.out.println("¡NUEVO RÉCORD! " + jugador.getNombreJugador() + " ha entrado en el Top 1 con " + nuevaPuntuacion + " puntos.");

        //COMPROBAR TOP 2
        } else if (nuevaPuntuacion > mejoresPuntuaciones[1]) {

            //Ponemos el Top 2 en Top 3
            mejoresPuntuaciones[2] = mejoresPuntuaciones[1];
            mejoresJugadores[2] = mejoresJugadores[1];

            //Ponemos un nuevo Top 2
            mejoresPuntuaciones[1] = nuevaPuntuacion;
            mejoresJugadores[1] = jugador;
            System.out.println("¡NUEVO RÉCORD! " + jugador.getNombreJugador() + " ha entrado en el Top 2 con " + nuevaPuntuacion + " puntos.");

        //COMPROBAR TOP 3
        } else if (nuevaPuntuacion > mejoresPuntuaciones[2]) {

            //Ponemos un nuevo Top 3
            mejoresPuntuaciones[2] = nuevaPuntuacion;
            mejoresJugadores[2] = jugador;
            System.out.println("¡NUEVO RÉCORD! " + jugador.getNombreJugador() +  " ha entrado en el Top 3 con " + nuevaPuntuacion + " puntos.");
        }
    }

    /**
     * Comprobamos que la maquina se apague cada 100 partidas
     */
    private void comprobarMantenimiento(){
        if (this.contadorPartidasJugadas > 0 && this.contadorPartidasJugadas%100 == 0){
            estaActiva = false;
            System.out.println("La maquina "+this.nombreMaquina+" ha sido desactivada!");
        }
    }

    /**
     * Creamos el metodo para que el jugador pueda jugar una partida
     * @param jugadorVaJugar
     * @return
     */
    public int jugarPartida (Jugador jugadorVaJugar){
        int puntuacion = Utils.generarAleatorio(0,9999);
        this.contadorPartidasJugadas++;
        actualizarRanking(puntuacion,jugadorVaJugar);
        comprobarMantenimiento();
        return puntuacion;
    }

    /**
     * Mostramos el ranking en el toString de la maquina en el caso de que este completo
     * @return
     */
    public String mostrarRanking() {
        String ranking = "\n~~~~~~~~~~ R A N K I N G de " + this.nombreMaquina + " ~~~~~~~~~~\n";
        for (int i = 0; i < 3; i++) {
            String nombreJugador;

            //Si el puesto esta vacio hacemos una salida por pantalla de que esta vacio
            if (mejoresJugadores[i] != null) {
                nombreJugador = mejoresJugadores[i].getNombreJugador();
            } else {
                nombreJugador = "Vacío";
            }

            // Sino
            ranking += "Top " + (i + 1) + ": " + mejoresPuntuaciones[i] + " puntos, conseguidos por: " + nombreJugador;
            System.out.println("");
        }
        return ranking;
    }

}

