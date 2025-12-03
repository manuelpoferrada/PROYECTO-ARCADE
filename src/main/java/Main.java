import model.Jugador;
import model.MaquinaArcade;
import model.SalaRecreativa;
import utils.Utils;

import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        int opcion = 0;

        Jugador jugador1 = new Jugador("Manuel","001");
        System.out.println(jugador1.toString());
        System.out.println("");
        MaquinaArcade maquina1 = new MaquinaArcade("Comecocos","Arcade",10);
        System.out.println(maquina1.toString());

        SalaRecreativa sala1 = new SalaRecreativa();
        sala1.anhadirJugador(jugador1);
        sala1.anhadirMaquina(maquina1);
        jugador1.creditosRestados(40);

//        String nombre = "";
//        System.out.print("Introduzca el nombre del jugador: ");
//        Scanner sc = new Scanner(System.in);
//        nombre = sc.nextLine();
//        Jugador nuevoJugador = new Jugador(nombre, );
            //return


        //Jugador nuevoJugador = pedirJugador();
        //sala1.anhadirJugador(nuevoJugador);
    }

    public static void ejecucionDeResultado (int opcion){
        switch (opcion){
            case 1: //registrar nuevo jugador break;
            case 2: //Registrar una nueva máquina de arcade; break;
            case 3: //Recargar créditos a un jugador; break;
            case 4: //Listar jugadores; break;
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


