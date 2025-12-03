import model.Jugador;
import model.MaquinaArcade;
import model.SalaRecreativa;
import utils.Utils;

import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        int opcion = 0;
    }

    public static void ejecucionDeResultado (int opcion){
        SalaRecreativa sala = new SalaRecreativa();
        //----VALORES A INTRODUCIR DE JUGADOR-----
        String nombreJugador =" ";
        String id = " ";

        //----VALORES A INTRODUCIR DE LA MAQUINA
        String nombreMaquina = " ";
        String genero = " ";
        int precio = 0 ;

        //CREAMOS UN JUGADOR AUX PARA PODER CREAR JUGADORES
        Jugador jugadorAux = new Jugador(nombreJugador,id);
        MaquinaArcade maquinaAux = new MaquinaArcade(nombreMaquina,genero,precio);
        switch (opcion){
            case 1: //Añadimos un jugador
                nombreJugador = Utils.pideCadena("Introduzca un nombreJugador para el jugador nuevo ");
                jugadorAux.setNombreJugador(nombreJugador);
                id = Utils.pideCadena("Introduzca un id para el jugador"+jugadorAux.getNombreJugador());
                jugadorAux.setIdentificadorJugador(id);
                break;
            case 2: //Añadimos una maquina
                nombreMaquina = Utils.pideCadena("Introduce el nombre de la maquina ");
                maquinaAux.setNombreMaquina(nombreMaquina);
                genero = Utils.pideCadena("Introduzca el genero de la maquina "+maquinaAux.getNombreMaquina());
                maquinaAux.setGeneroMaquina(genero);
                precio = Utils.pideNumero(0,100,"Introduce el precio de la máquina"+maquinaAux.getNombreMaquina(),"Error, debe ser un numero entero entre 0 y 100 !!");
                break;
            case 3: //Recargar créditos a un jugador
                String idBuscarRecargar = "";
                idBuscarRecargar = Utils.pideCadena("Introduce el ID del jugador al que desee recargar creditos ");
                Jugador jugadorARecargar = null;
                jugadorARecargar=sala.buscarJugadorPorID(idBuscarRecargar);
                if(jugadorARecargar != null){
                    jugadorARecargar.recargarCreditos();
                }else{
                    System.out.println(" Oh, losiento no hemos encontrado su jugador, ingrese bien su ID ");
                }
                break;
            case 4: //Listar jugadores

                break;
            case 5: //Listar maquinas; break;
            case 6: //Listar maquinas activas; break;
            case 7: //Realizar el mantenimiento a una maquina (reactivarla); break;
            case 8: //Jugar una partida; break;
            case 9: //Mostrar el jugador más activo; break;
            case 10: //Mostrar la máquina mas usada; break;
            case 11: //Mostrar el ranking de una maquina; break;
            case 12: //Dar de baja una máquina; break;
            case 13: //Editar una maquina de arcade; break;
            case 14: //Editar un jugador; break;
        }
    }
}


