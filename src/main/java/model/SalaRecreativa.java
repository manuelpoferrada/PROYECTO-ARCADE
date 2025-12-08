package model;

public class SalaRecreativa {
    private MaquinaArcade [] maquinasArcade;
    private Jugador [] jugadores;
    private int numeroJugadores = 0;
    private int numeroMaquinas = 0;

    public SalaRecreativa() {
        this.jugadores = new Jugador[50];
        this.maquinasArcade = new MaquinaArcade[20];
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

    public void listarJugadores() {
        boolean hayJugadores = false;
        for (int i = 0; i < jugadores.length ; i++) {
            if (jugadores[i] != null) {
                System.out.println(jugadores[i].toString());
                System.out.println("----------------------------");
                hayJugadores = true;
            }
        }
        if (!hayJugadores){
            System.out.println("No hay jugadores en la sala !!");
        }
    }

    public void listarMaquinas(){
        boolean hayAglunaMaquina = false;
        for (int i = 0; i < maquinasArcade.length; i++){
            if (maquinasArcade[i] != null){
                System.out.println(maquinasArcade[i].toString());
                System.out.println("----------------------------");
                hayAglunaMaquina = true;
            }
        }
        if (!hayAglunaMaquina){
            System.out.println("No hay ninguna maquina en la Sala !! ");
        }
    }

    /**
     * Estamos listando las maquinas que estan activas y dando un aviso si no hay ninguna activa
     */
    public void listarMaquinasActivas() {
        boolean HayAlgunaActiva = false;
        for (int i = 0; i < maquinasArcade.length; i++){
            if (maquinasArcade[i] != null && maquinasArcade[i].isEstaActiva()){
                System.out.println(maquinasArcade[i].toString());
                System.out.println("");
                System.out.println("--------------------------");
                HayAlgunaActiva = true;
            }
        }
        if (!HayAlgunaActiva){
            System.out.println("No hay ninguna máquina activa en este momento.");
        }
    }

    public void  SalaRecreativa (){
        this.maquinasArcade = new MaquinaArcade[50];
        this.jugadores = new Jugador[50];
    }

    /**
     * Buscamos al jugador por su ID
     * @param identificadorJugador
     * @return
     */
    public Jugador buscarJugadorPorID (String identificadorJugador){
        Jugador jugadorAux = null;

        for (int i = 0; i < jugadores.length; i++){
            if (this.jugadores[i] != null && this.jugadores[i].getIdentificadorJugador().equals(identificadorJugador)){
                jugadorAux = this.jugadores[i];
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
     * @param jugadorNuevo
     * @return
     */
    public boolean anhadirJugador(Jugador jugadorNuevo) {
        boolean estaAnhadidoJugador = false;
        if (numeroJugadores < jugadores.length) {
            this.jugadores[numeroJugadores] = jugadorNuevo;
            numeroJugadores++;
            estaAnhadidoJugador = true;
        }
        return estaAnhadidoJugador;
    }

    /**
     * Anñadimos una maquina
     * @param maquinaArcade
     * @return
     */
    public boolean anhadirMaquina(MaquinaArcade maquinaArcade) {
        boolean estaAnhadida = false;
        if (numeroMaquinas < maquinasArcade.length) {
            this.maquinasArcade[numeroMaquinas] = maquinaArcade;
            numeroMaquinas++;
            estaAnhadida = true;
        }
        return estaAnhadida;
    }

    /**
     * Obtenemos el jugador que haya jugado mas partidas ya que es el mas activo
     * @return nombreJugadorMasPartidas
     */
    public String jugadorMasActivo(){
        String nombreJugadorMasPartidas = "No hay jugadores en la sala";
        int numeroMaxPartidas = -1;
        for (int i = 0 ; i < jugadores.length; i++){
           if (jugadores[i].getNumeroPartidasJugador() >= numeroMaxPartidas){
               numeroMaxPartidas = jugadores[i].getNumeroPartidasJugador();
               nombreJugadorMasPartidas = jugadores[i].getNombreJugador();
           }
        }
        return nombreJugadorMasPartidas;
    }

    /**
     * Devolvemos una cadena que contiende el nombre de la maquina con mas partidas jugadas
     * @return
     */
    public String maquinaMasPartidas(){
        String maquinaMasPartidasJugadas = "";
        int numeroMaxPartidas = 0;
        for (int i = 0 ; i < maquinasArcade.length; i++){
            if (maquinasArcade[i].getContadorPartidasJugadas() > numeroMaxPartidas){
                numeroMaxPartidas = maquinasArcade[i].getContadorPartidasJugadas();
                maquinaMasPartidasJugadas = maquinasArcade[i].getNombreMaquina();
            }
        }
        return maquinaMasPartidasJugadas;
    }


    public boolean gestionarPartida(Jugador jugadorAJugar, MaquinaArcade maquinaAJugar) {
        boolean partidaGestionada = false;
        if (maquinaAJugar.isEstaActiva() && jugadorAJugar.gastarCreditos(maquinaAJugar.getPrecioPartida())){
            maquinaAJugar.jugarPartida(jugadorAJugar);
            if (maquinaAJugar.getPuntuacioncadaPartida() >= 0 && maquinaAJugar.getPuntuacioncadaPartida() < 2000){
                System.out.println(" ¡¡ OOHH !! Solo has sacado "+maquinaAJugar.getPuntuacioncadaPartida()+" puntos.");
            }else if (maquinaAJugar.getPuntuacioncadaPartida() >= 2000 && maquinaAJugar.getPuntuacioncadaPartida() < 4000) {
                System.out.println(" ¡¡ UUHH !! Bueno no está mal  " + maquinaAJugar.getPuntuacioncadaPartida() + " puntos.");
            }else if (maquinaAJugar.getPuntuacioncadaPartida() >= 4000 && maquinaAJugar.getPuntuacioncadaPartida() < 6000) {
                System.out.println(" ¡¡ EEHH OJO !! Has sacado una buena puntuación  " + maquinaAJugar.getPuntuacioncadaPartida() + " puntos.");
            }else if (maquinaAJugar.getPuntuacioncadaPartida() >= 6000 && maquinaAJugar.getPuntuacioncadaPartida() < 8000) {
                System.out.println(" ¡¡ EEHH OJO !! Has sacado una buena puntuación  " + maquinaAJugar.getPuntuacioncadaPartida() + " puntos.");
            }else if (maquinaAJugar.getPuntuacioncadaPartida() >= 8000 && maquinaAJugar.getPuntuacioncadaPartida() < 9999) {
                System.out.println(" ¡¡ OLEEE !! Has sacado una puntuación alta  " + maquinaAJugar.getPuntuacioncadaPartida() + " puntos.");
            }
        }
        return partidaGestionada;
    }
}
