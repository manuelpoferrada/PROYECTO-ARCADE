package model;

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
    public String getNombreMaquina() {
        return nombreMaquina;
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

    public String toString(){
        return "La máquina se llama: "+this.nombreMaquina+
                "\nEl genero de la máquina es: "+this.generoMaquina+
                "\nEl precio de cada partida es: "+this.precioPartida+"C"+
                "\nEstado: "+ComprobarActividad()+
                "\nSe han jugado "+this.contadorPartidasJugadas+
                "\n~~~~~~~~~~ R A N K I N G ~~~~~~~~~~"+
                "\nTop 1: "+mejoresPuntuaciones[0]+" con el jugador "+mejoresJugadores[0]+
                "\nTop 2: "+mejoresPuntuaciones[1]+" con el jugador "+mejoresJugadores[1]+
                "\nTap 3: "+mejoresPuntuaciones[2]+" con el jugador "+mejoresJugadores[2];
    }

    /**
     * Funcionalidades mínimas:
     *      --> Activas y Desactivar la maquina
     *      --> Consultar si está activa
     *      --> Permitir a un jugador jugar una partida
     *          >> Puntuacion aleatoria en cada partida (0-9999) y sumar 1 a la cantidad de partidas
     *          >> Cuando sea la partida 100/200/300... la maquina se desactiva
     *          >> Hacer y mostrar el Ranking
     *          >> Devolver la puntuación de cada partida
     *      --> Mostrar información del jugador
     *          >> Patidas Jugadas
     *          >> Estado
     *          >> Ranking
     *          >> Más...
     */

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
        boolean activa = false;
        String actividad = "";
        if (estaActiva){
            actividad = "La máquina está activa";
            activa = true;
        }else {
            actividad = "La máquina está desactiva";
            activa = false;
        }
        return actividad;
    }

}

