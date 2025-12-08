package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalaRecreativaTest {

    @Test
    @DisplayName("Al jugar una partida al jugador se le resta el crédito")
    public void al_jugar_partida_el_jugador_pierde_creditos() {
        Jugador jugador = new Jugador("Paco", "paco72");
        MaquinaArcade maquina = new MaquinaArcade("Tetris", "Arcade",5);
        SalaRecreativa sala = new SalaRecreativa();
        sala.anhadirJugador(jugador);
        sala.anhadirMaquina(maquina);
        sala.gestionarPartida(jugador,maquina);
        assertEquals(95,jugador.getCreditosDisponibles());
    }

}