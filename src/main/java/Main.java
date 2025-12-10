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
                    //SALIDA POR PANTALLA
                    System.out.println("¡¡ VAMOS A REGISTRAR UN NUEVO JUGADOR !!");
                    System.out.println("");
                    //PEDIMOS UN NOMBRE AL JUGADOR Y ID PARA ASI CREAR UN NUEVO JUGADOR CON DICHOS VALORES
                    nombreJugador = Utils.pideCadena("Introduzca un nombre para el jugador nuevo: ");
                    id = Utils.pideCadena("Introduzca un id para el jugador "+nombreJugador+" : ");
                    //CREAMOS UN JUGADOR PARA PASARLO SIEMPRE EN AÑADIR JUGADOR Y ASÍ CREAR UN NUEVO
                    Jugador jugadorNuevo = new Jugador(nombreJugador,id);
                    //ESTE METODO DEVUELVE UN BOOLEAN Y INDICA SI SE HA AÑADIDO A LA SALA O NO
                    if (sala.anhadirJugador(jugadorNuevo)){
                        System.out.println(jugadorNuevo.getNombreJugador()+" se ha añadido a la sala");
                    }else{
                        System.out.println(jugadorNuevo.getNombreJugador()+" no se ha incorporado en la sala !!");
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
                    if (sala.hayJugadores()) {
                        String idBuscarRecargar = "";
                        int creditosArecargar = 0;
                        idBuscarRecargar = Utils.pideCadena("Introduce el ID del jugador al que desee recargar creditos: ");
                        Jugador jugadorARecargar = null;
                        jugadorARecargar = sala.buscarJugadorPorID(idBuscarRecargar);
                        if (jugadorARecargar != null) {
                            creditosArecargar = Utils.pideNumero(10, 100, "Introduce los creditos que desea recargar del jugador: ", "Error, debe ser una cifra entera de (0-100)!!");
                            jugadorARecargar.recargarCreditos(creditosArecargar);
                            System.out.println("Se han ingresado los " + creditosArecargar + " correctamente.");
                        } else {
                            System.out.println(" Oh, losiento no hemos encontrado su jugador ("+idBuscarRecargar+") ingrese bien su ID ");
                        }
                    } else {
                        System.out.println("No hay ningún jugador en la sala para poder recargar creditos.");
                    }
                    break;
                case 4: //Listar jugadores
                    sala.listarJugadores();
                    break;
                case 5: //Listar maquinas
                    sala.listarMaquinas();
                    break;
                case 6: //Listar maquinas activas
                    if (sala.hayMaquinas()) {
                        sala.listarMaquinasActivas();
                    } else {
                        System.out.println("Ni si quiera hay maquinas en la sala ¿Cómo van a haber maquinas activas?");
                    }
                    break;
                case 7: //Realizar el mantenimiento a una maquina (reactivarla)
                    if (sala.hayMaquinas()) {
                        String nombreMantenimiento = " ";
                        nombreMantenimiento = Utils.pideCadena("Introduce el nombre de la maquina de la que desea realizar mantenimiento: ");
                        MaquinaArcade maquinaARealizarMantenimiento = null;
                        maquinaARealizarMantenimiento = sala.buscarMaquinaPorNombre(nombreMantenimiento);
                        if (sala.buscarMaquinaPorNombre(nombreMantenimiento) != null) {
                            if (maquinaARealizarMantenimiento.ActivarMaquina()) {
                                System.out.println("La maquina " + nombreMantenimiento + " se ha activado correctamente");
                            } else {
                                System.out.println("La maquina " + nombreMantenimiento + " ya estaba activa antes");
                            }
                        } else {
                            System.out.println("No se ha encontrado el nombre de la maquina ("+nombreMantenimiento+")");
                        }
                    } else {
                        System.out.println("No hay maquinas en sala ¿Cómo vamos a reactivar una?");
                    }
                    break;
                case 8: //Jugar una partida;
                    if (sala.hayJugadores() && sala.hayMaquinas()){
                        String jugadorJugarID = "";
                        String nombreMaquinaBuscarPartida = "";
                        jugadorJugarID = Utils.pideCadena("Selecciona el ID del jugador que quieras que juegue una partida: ");
                        Jugador jugadorBuscarCrearPartida = sala.buscarJugadorPorID(jugadorJugarID);
                        if (sala.buscarJugadorPorID(jugadorJugarID) != null){
                            nombreMaquinaBuscarPartida = Utils.pideCadena("Introduce el nombre de la maquina en la que "+jugadorJugarID+" quiere jugar la partida: ");
                            MaquinaArcade maquinaAJugar = sala.buscarMaquinaPorNombre(nombreMaquinaBuscarPartida);
                            if (sala.buscarMaquinaPorNombre(nombreMaquinaBuscarPartida) != null) {
                                sala.gestionarPartida(jugadorBuscarCrearPartida, maquinaAJugar);
                            } else {
                                System.out.println("No se ha encontrado el nombre de la maquina ("+nombreMaquinaBuscarPartida+")");
                            }
                        } else {
                            System.out.println("No se ha encontrado el jugador con ID ("+jugadorJugarID+")");
                        }
                    } else {
                        System.out.println("No hay jugadores en la sala/maquinas, no puedes hacerlo");
                    }

                    break;
                case 9: //Mostrar el jugador más activo;
                    if (sala.jugadorMasActivo() != null){
                        System.out.println("El jugador más activo es "+sala.jugadorMasActivo());
                    }
                    break;
                case 10: //Mostrar la máquina mas usada;
                    if (sala.maquinaMasPartidas() != null){
                        System.out.println("La maquina con más partidas es "+sala.maquinaMasPartidas());
                    }
                    break;
                case 11: //Mostrar el ranking de una maquina
                    if (sala.hayMaquinas()) {
                        String nombreMaquinaBuscarRanking = "";
                        nombreMaquinaBuscarRanking = Utils.pideCadena("Busca la maquina por el nombre que desee ver el ranking: ");
                        MaquinaArcade mostrarRankingMaquina = sala.buscarMaquinaPorNombre(nombreMaquinaBuscarRanking);
                        if (sala.buscarMaquinaPorNombre(nombreMaquinaBuscarRanking) != null) {
                            System.out.println(mostrarRankingMaquina.mostrarRanking());
                        } else {
                            System.out.println("No se ha encontrado el nombre de la maquina ("+nombreMaquinaBuscarRanking+")");
                        }
                    } else {
                        System.out.println("No hay maquinas en sala ¿Cómo vamos a mostrar el ranking?");
                    }
                    break;
                case 12: //Dar de baja una máquina;
                    if (sala.hayMaquinas()) {
                        String nombreDesactivarMaquina = "";
                        nombreDesactivarMaquina = Utils.pideCadena("Introduce el nombre de la maquina que quiera dar de baja: ");
                        MaquinaArcade maquinaDarDeBaja = null;
                        maquinaDarDeBaja = sala.buscarMaquinaPorNombre(nombreDesactivarMaquina);
                        if (sala.buscarMaquinaPorNombre(nombreDesactivarMaquina) != null) {
                            if (maquinaDarDeBaja.DesactivarMaquina()) {
                                System.out.println("La maquina " + nombreDesactivarMaquina + " se ha desactivado");
                            } else {
                                System.out.println("La maquina " + nombreDesactivarMaquina + " ya estaba dada de baja");
                            }
                        } else {
                            System.out.println("No se ha encontrado el nombre de la maquina ("+nombreDesactivarMaquina+")");
                        }
                    } else {
                        System.out.println("No hay ninguna máquina en sala ¿Cómo vamos a dar de baja una máquina?");
                    }
                    break;
                case 13: //Editar una maquina de arcade
                    if ( sala.hayMaquinas()) {
                        String nombreBuscarMaquinaEditar = "";
                        String nombreMaquinaEditar = "";
                        String generoMaquinaEditar = "";
                        int precioMaquinaEditar = 0;
                        nombreBuscarMaquinaEditar = Utils.pideCadena("Introduce el nombre de la máquina que desea editar: ");
                        MaquinaArcade maquinaNuevaParaEditar = null;
                        maquinaNuevaParaEditar = sala.buscarMaquinaPorNombre(nombreBuscarMaquinaEditar);
                        if (sala.buscarMaquinaPorNombre(nombreBuscarMaquinaEditar) != null) {
                            nombreMaquinaEditar = Utils.pideCadena("Ingrese el nuevo nombre que desea poner a " + nombreBuscarMaquinaEditar + ": ");
                            maquinaNuevaParaEditar.setNombreMaquina(nombreMaquinaEditar);
                            generoMaquinaEditar = Utils.pideCadena("Ingrese un nuevo genero para la maquina " + nombreMaquinaEditar + ": ");
                            maquinaNuevaParaEditar.setGeneroMaquina(generoMaquinaEditar);
                            precioMaquinaEditar = Utils.pideNumero(1, 100, "Ingresa un precio (1-100): ", "Error, debe ser un numero entero entre 1 y 100.");
                            maquinaNuevaParaEditar.setPrecioPartida(precioMaquinaEditar);
                        } else {
                            System.out.println("No se ha encontrado el nombre de la maquina ("+nombreBuscarMaquinaEditar+")");
                        }
                    } else {
                        System.out.println("No hay maquinas en la sala ¿Cómo vas a modificar algúna?");
                    }
                    break;
                case 14: //Editar un jugador;
                    if (sala.hayJugadores()) {
                        String idBuscarJugadorEditar = "";
                        String nombreCambiarJugador = "";
                        String idCambiarJugador = "";
                        idBuscarJugadorEditar = Utils.pideCadena("Introduce el ID del jugador que desea cambiar los datos: ");
                        Jugador jugadorParaEditar = null;
                        jugadorParaEditar = sala.buscarJugadorPorID(idBuscarJugadorEditar);
                        if (sala.buscarJugadorPorID(idBuscarJugadorEditar) != null) {
                            nombreCambiarJugador = Utils.pideCadena("Introduce el nuevo nombre del jugador: ");
                            jugadorParaEditar.setNombreJugador(nombreCambiarJugador);
                            idCambiarJugador = Utils.pideCadena("Introdce un ID para el jugador " + nombreCambiarJugador + " :");
                            jugadorParaEditar.setIdentificadorJugador(idCambiarJugador);
                        } else {
                            System.out.println(" Oh, losiento no hemos encontrado su jugador ("+idBuscarJugadorEditar+") ingrese bien su ID ");
                        }
                    } else {
                        System.out.println("No hay jugadores en la sala ¿Cómo vas a modificar alguno?");
                    }
                    break;
            }
        }while (opcion != 0);
    }
}


