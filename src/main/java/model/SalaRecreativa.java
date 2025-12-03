package model;

import utils.Utils;

public class SalaRecreativa {
    private MaquinaArcade [] maquinasArcade;
    private Jugador [] jugadores;

    /**
     * Funcionalidades mínimas:
     *      --> Registrar nuevos jugadores
     *      --> Registrar nuevas máquinas
     *      --> Buscar un jugador por ID
     *      --> Buscar una máquina por nombre
     *      --> Listar jugadores
     *      --> Listar máquinas
     *      --> Listar únicamente máquinas activas
     *      --> Obtener el jugador más activo
     *      --> Obtener la máquina con más partidas jugadas
     *      --> Gestionar una partida:
     *          >> Comprobar que la máquina está activa
     *          >> Comprobar que el jugador tiene créditos suficientes
     *          >> Descontar créditos al jugador
     *          >> Hacer que el jugador juegue en la máquina.
     *          >> Mostrar un mensaje que indique la puntuación obtenida por el jugador en la máquina.
     *          >> Devolverá true si se ha jugado
     */

    /**
     * Listamos los jugadores
     * @return
     */
    public Jugador[] getJugadores() {
        return jugadores;
    }

    /**
     * Listamos las maquinas
     * @return
     */
    public MaquinaArcade[] getMaquinasArcade() {
        return maquinasArcade;
    }

    /**
     * Estamos listando las maquinas que estan activas y dando un aviso si no hay ninguna activa
     */
    public void listarMaquinasActivas() {
        boolean HayAlgunaActiva = false;
        for (int i = 0; i < maquinasArcade.length; i++){
            if (maquinasArcade[i] != null && maquinasArcade[i].isEstaActiva()){
                System.out.println(maquinasArcade[i].toString());
                System.out.println("--------------------------");
                HayAlgunaActiva = true;
            }
        }
        if (!HayAlgunaActiva){
            System.out.println("No hay ninguna máquina activa en este momento.");
        }
    }

    /**
     * Buscamos al jugador por su ID
     * @param identificadorJugador
     * @return
     */
    public Jugador buscarJugadorPorID (String identificadorJugador){
        Jugador jugadorAux = null;
        boolean jugadorEncontrado = false;
        for (int i = 0; i < jugadores.length; i++){
            if (this.jugadores[i] != null && this.jugadores[i].getIdentificadorJugador().equals(identificadorJugador)){
                jugadorAux = this.jugadores[i];
                jugadorEncontrado = true;
            }
        }
        return jugadorAux;
    }

    /**
     * Busco la maquina por su nombre y devuelvo dicha maquina
     * @param nombreMaquina
     * @return
     */
    public MaquinaArcade buscarMaquinaPorNombre (String nombreMaquina){
        MaquinaArcade maquinaAux = null;
        boolean maquinaEncontrada = false;
        for (int i = 0; i < maquinasArcade.length; i++){
            if (this.maquinasArcade[i] != null && this.maquinasArcade[i].getNombreMaquina().equals(nombreMaquina)){
                maquinaAux = this.maquinasArcade[i];
                maquinaEncontrada = true;
            }
        }
        return maquinaAux;
    }

    /**
     * Añadimos a un jugador
     * @param jugador
     * @return
     */
    public boolean anhadirJugador (Jugador jugador){
        boolean jugadoranhadido = false;
            if (jugador != null) {
                for (int i = 0; i < jugadores.length && !jugadoranhadido; i++) {
                    this.jugadores[i] = jugador;
                    jugadoranhadido = true;
                }
            }
        return jugadoranhadido;
    }

    public boolean anhadirMaquina (MaquinaArcade maquinaArcade){
        boolean maquinaAnhadida = false;
        if (maquinaArcade != null) {
            for (int i = 0; i < maquinasArcade.length && !maquinaAnhadida; i++) {
                this.maquinasArcade[i] = maquinaArcade;
                maquinaAnhadida = true;
            }
        }
        return maquinaAnhadida;
    }



}
