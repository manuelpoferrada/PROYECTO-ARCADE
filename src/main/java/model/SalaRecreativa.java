package model;

public class SalaRecreativa {
    private MaquinaArcade [] maquinasArcade;
    private Jugador [] jugadores;

    /**
     * GETTERS
     * He escogido los dos porque quiero poder mostrar todo el array jugddores y MaquinasArcade
     */
    public Jugador[] getJugadores() {
        return jugadores;
    }

    public MaquinaArcade[] getMaquinasArcade() {
        return maquinasArcade;
    }

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

}
