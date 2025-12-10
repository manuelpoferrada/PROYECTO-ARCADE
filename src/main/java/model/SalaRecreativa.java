package model;

public class SalaRecreativa {
    private MaquinaArcade [] maquinasArcade;
    private Jugador [] jugadores;
    private int numeroJugadores = 0;
    private int numeroMaquinas = 0;

    /**
     * Conctructor que inicia los arrays a 50 y 20
     */
    public SalaRecreativa() {
        this.jugadores = new Jugador[50];
        this.maquinasArcade = new MaquinaArcade[20];
    }

    //GETTERS

    public Jugador[] getJugadores() {
        return jugadores;
    }
    public MaquinaArcade[] getMaquinasArcade() {
        return maquinasArcade;
    }

    //METODOS MINIMOS PARA QUE NUESTRA SALA RECREATIVA SEA FUNCIONAL

    /**
     * Metodo que muestra por pantalla todos los jugadores de nuestra sala
     */
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

    /**
     * Metodo que muestra todas las maquinas de nuestra sala
     */
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
            System.out.println("Ninguna máquina esta activa");
        }
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
            //EN EL NUMERO DE JUGADORES NUEVO QUE AHI INTRODUCIMOS EL NUEVO JUGADOR
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
        String nombreJugadorMasPartidas = "ninguno, no hay jugadores en sala.";
        int numeroMaxPartidas = -1;
        for (int i = 0 ; i < jugadores.length && jugadores[i] != null; i++){
           if (jugadores[i].getNumeroPartidasJugador() >= numeroMaxPartidas){
               numeroMaxPartidas = jugadores[i].getNumeroPartidasJugador();
               nombreJugadorMasPartidas = jugadores[i].getNombreJugador();
           }
        }
        return nombreJugadorMasPartidas;
    }

    /**
     * Comprobamos si hay jugadores en la sala para poder hacer algo
     * @return
     */
    public boolean hayJugadores (){
        boolean hayJugadoreEnSala = false;
        for (int i = 0; i < jugadores.length && jugadores[i]!=null;i++ ){
            if (jugadores[i]!=null){
                hayJugadoreEnSala = true;
            }
        }
        return hayJugadoreEnSala;
    }

    /**
     * Comprobamos si hay jugadores en la sala para poder hacer algo
     * @return
     */
    public boolean hayMaquinas (){
        boolean hayMaquinasEnSala = false;
        for (int i = 0; i < maquinasArcade.length && maquinasArcade[i]!=null;i++ ){
            if (maquinasArcade[i]!=null){
                hayMaquinasEnSala = true;
            }
        }
        return hayMaquinasEnSala;
    }


    /**
     * Devolvemos una cadena que contiende el nombre de la maquina con mas partidas jugadas
     * @return
     */
    public String maquinaMasPartidas(){
        String maquinaMasPartidasJugadas = "ninguna, no hay jugadores en sala.";
        int numeroMaxPartidas = 0;
        for (int i = 0 ; i < maquinasArcade.length && maquinasArcade[i] != null; i++){
            if (maquinasArcade[i].getContadorPartidasJugadas() > numeroMaxPartidas){
                numeroMaxPartidas = maquinasArcade[i].getContadorPartidasJugadas();
                maquinaMasPartidasJugadas = maquinasArcade[i].getNombreMaquina();
            }
        }
        return maquinaMasPartidasJugadas;
    }


    /**
     * Nos encargamos de jugar la partida si de cumplen los requisitos de poder jugarla, poder gastar creditos y que la maquina este activa
     * @param jugadorAJugar
     * @param maquinaAJugar
     * @return
     */
    public boolean gestionarPartida(Jugador jugadorAJugar, MaquinaArcade maquinaAJugar) {
        boolean partidaNoGestionada = true;
        if (maquinaAJugar.isEstaActiva() && jugadorAJugar.gastarCreditos(maquinaAJugar.getPrecioPartida())){
            partidaNoGestionada = false;
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
        return partidaNoGestionada;
    }
}
