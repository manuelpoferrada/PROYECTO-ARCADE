import jdk.jshell.execution.Util;
import model.Jugador;
import model.MaquinaArcade;
import model.SalaRecreativa;
import utils.Utils;

public class Main {
    public static void main(String[] args) {
        ejecucionDeResultado();

    }

    public static void ejecucionDeResultado (){
        SalaRecreativa sala = new SalaRecreativa();
        int opcion = 0;

        //----VALORES A INTRODUCIR DE JUGADOR-----
        String nombreJugador =" ";
        String id = " ";

        //----VALORES A INTRODUCIR DE LA MAQUINA
        String nombreMaquina = " ";
        String genero = " ";
        int precio = 0 ;

        do{
            opcion = Utils.menu();
            switch (opcion){
                case 1: //Añadimos un jugador
                    System.out.println("¡¡ VAMOS A REGISTRAR UN NUEVO JUGADOR !!");
                    System.out.println("");
                    nombreJugador = Utils.pideCadena("Introduzca un nombre para el jugador nuevo: ");
                    id = Utils.pideCadena("Introduzca un id para el jugador "+nombreJugador+" : ");
                    Jugador jugadorNuevo = new Jugador(nombreJugador,id);
                    if (sala.anhadirJugador(jugadorNuevo)){
                        System.out.println(jugadorNuevo.getNombreJugador()+" se ha añadido a la sala");
                    }else{
                        System.out.println(jugadorNuevo.getNombreJugador()+" no se ha incorporado en la sala");
                    }
                    break;
                case 2: //Añadimos una maquina
                    System.out.println("¡¡ VAMOS A REGISTRAR UNA MAQUINA !!");
                    System.out.println("");
                    nombreMaquina = Utils.pideCadena("Introduce el nombre de la maquina: ");
                    genero = Utils.pideCadena("Introduzca el genero de la maquina "+nombreMaquina+" ");
                    precio = Utils.pideNumero(0,100,"Introduce el precio de la máquina "+nombreMaquina+" ","Error, debe ser un numero entero entre 0 y 100 !!");
                    MaquinaArcade maquinaNueva = new MaquinaArcade(nombreMaquina,genero,precio);
                    if (sala.anhadirMaquina(maquinaNueva)){
                        System.out.println(maquinaNueva.getNombreMaquina()+" se ha añadido a la sala");
                    }else{
                        System.out.println(maquinaNueva.getNombreMaquina()+" no se ha incorporado en la sala !! ");
                    }
                    break;
                case 3: //Recargar créditos a un jugador
                    String idBuscarRecargar = "";
                    int creditosArecargar = 0;
                    idBuscarRecargar = Utils.pideCadena("Introduce el ID del jugador al que desee recargar creditos ");
                    Jugador jugadorARecargar = null;
                    jugadorARecargar=sala.buscarJugadorPorID(idBuscarRecargar);
                    if(jugadorARecargar != null){
                        creditosArecargar = Utils.pideNumero(10,100,"Introduce los creditos que desea recargar del jugador: ","Error, debe ser una cifra entera de (0-100)!!");
                        jugadorARecargar.recargarCreditos(creditosArecargar);
                        System.out.println("Se han ingresado los "+creditosArecargar+" correctamente.");
                    }else{
                        System.out.println(" Oh, losiento no hemos encontrado su jugador, ingrese bien su ID ");
                    }
                    break;
                case 4: //Listar jugadores
                    sala.listarJugadores();
                    break;
                case 5: //Listar maquinas
                    sala.listarMaquinas();
                    break;
                case 6: //Listar maquinas activas
                    sala.listarMaquinasActivas();
                    break;
                case 7: //Realizar el mantenimiento a una maquina (reactivarla)
                    String nombreMantenimiento = " ";
                    nombreMantenimiento = Utils.pideCadena("Introduce el nombre de la maquina de la que desea realizar mantenimiento: ");
                    MaquinaArcade maquinaARealizarMantenimiento = null;
                    maquinaARealizarMantenimiento=sala.buscarMaquinaPorNombre(nombreMantenimiento);
                    if (maquinaARealizarMantenimiento.ActivarMaquina()){
                        System.out.println("La maquina "+nombreMantenimiento+" se ha activado correctamente");
                    } else {
                        System.out.println("La maquina "+nombreMantenimiento+" ya estaba activa antes");
                    }
                    break;
                case 8: //Jugar una partida;
                    String jugadorJugarID = "";
                    String nombreMaquinaBuscarPartida = "";
                    jugadorJugarID = Utils.pideCadena("Selecciona el ID del jugador que quieras que juegue una partida: ");
                    nombreMaquinaBuscarPartida = Utils.pideCadena("Introduce el nombre de la maquina en la que el jugador quiere jugar la partida: ");
                    MaquinaArcade maquinaAJugar = sala.buscarMaquinaPorNombre(nombreMaquinaBuscarPartida);
                    Jugador jugadorBuscarCrearPartida = sala.buscarJugadorPorID(jugadorJugarID);
                    sala.gestionarPartida(jugadorBuscarCrearPartida,maquinaAJugar);
                    break;
                case 9: //Mostrar el jugador más activo;
                    if (sala.jugadorMasActivo() != null){
                        System.out.println("El jugador más activo es "+sala.jugadorMasActivo());
                    } else {
                        System.out.println("No hay jugador en la sala todavía o ninguna a participado");
                    }
                    break;
                case 10: //Mostrar la máquina mas usada;
                    System.out.println(sala.maquinaMasPartidas());
                    break;
                case 11: //Mostrar el ranking de una maquina
                    String nombreMaquinaBuscarRanking = "";
                    nombreMaquinaBuscarRanking = Utils.pideCadena("Busca la maquina por el nombre que desee ver el ranking: ");
                    MaquinaArcade mostrarRankingMaquina = sala.buscarMaquinaPorNombre(nombreMaquinaBuscarRanking);
                    System.out.println(mostrarRankingMaquina.mostrarRanking());
                    break;
                case 12: //Dar de baja una máquina;
                    String nombreDesactivarMaquina = "";
                    nombreDesactivarMaquina = Utils.pideCadena("Introduce el nombre de la maquina que quiera dar de baja: ");
                    MaquinaArcade maquinaDarDeBaja = null;
                    maquinaDarDeBaja = sala.buscarMaquinaPorNombre(nombreDesactivarMaquina);
                    if (maquinaDarDeBaja.DesactivarMaquina()){
                        System.out.println("La maquina "+nombreDesactivarMaquina+" se ha desactivado");
                    }else {
                        System.out.println("La maquina "+nombreDesactivarMaquina+" ya estaba dada de baja");
                    }
                    break;
                case 13: //Editar una maquina de arcade break;
                case 14: //Editar un jugador; break;
            }
        }while (opcion != 0);
    }
}


