import model.Jugador;
import model.MaquinaArcade;
import utils.utils;

public class Main {
    static void main(String[] args) {
        /**
        String dni = "12345678R";
        if (utils.validaDNI(dni)){
            System.out.println("Es valido");
        }else{
            System.out.println("No es valido");
        }
         */
        Jugador jugador1 = new Jugador("Manuel","001",100,0);
        System.out.println(jugador1.toString());
        System.out.println("");
        MaquinaArcade maquina1 = new MaquinaArcade("Comecocos","Arcade",10);
        System.out.println(maquina1.toString());

    }
}


