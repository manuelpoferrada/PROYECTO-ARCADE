import model.Jugador;
import model.MaquinaArcade;
import model.SalaRecreativa;
import utils.utils;

public class Main {
    static void main(String[] args) {
        int opcion = 0;
        /**
        String dni = "12345678R";
        if (utils.validaDNI(dni)){
            System.out.println("Es valido");
        }else{
            System.out.println("No es valido");
        }
         */
        //do {
          //  opcion = utils.menu();
         //   utils.ejecucionDeResultado(opcion);
        //} while (opcion != 0);

        Jugador jugador1 = new Jugador("Manuel","001",100,0);
        System.out.println(jugador1.toString());
        System.out.println("");
        MaquinaArcade maquina1 = new MaquinaArcade("Comecocos","Arcade",10);
        System.out.println(maquina1.toString());

        SalaRecreativa sala1 = new SalaRecreativa();
    }
}


