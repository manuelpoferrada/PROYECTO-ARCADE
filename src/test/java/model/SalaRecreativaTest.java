package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalaRecreativaTest {

    @Test
    @DisplayName("No se permite jugar si el jugador no tiene créditos")
    public void noJugarSiJugadorNoTieneCreditos() {
        Jugador jugador = new Jugador("Paco", "p1");
        jugador.setCreditosDisponibles(0);

        MaquinaArcade maquina = new MaquinaArcade("Tetris", "Arcade", 5);
        SalaRecreativa sala = new SalaRecreativa();
        sala.anhadirJugador(jugador);
        sala.anhadirMaquina(maquina);

        boolean resultado = sala.gestionarPartida(jugador, maquina);

        assertTrue(resultado);
        assertEquals(0, jugador.getCreditosDisponibles());
    }

    @Test
    @DisplayName("No se permite jugar si la máquina está inactiva")
    public void noJugarSiMaquinaEstaInactiva() {
        Jugador jugador = new Jugador("Ana", "a1");
        MaquinaArcade maquina = new MaquinaArcade("Pacman", "Retro", 5);
        maquina.DesactivarMaquina();
        SalaRecreativa sala = new SalaRecreativa();
        sala.anhadirJugador(jugador);
        sala.anhadirMaquina(maquina);

        boolean resultado = sala.gestionarPartida(jugador, maquina);

        assertTrue(resultado);
        assertEquals(100, jugador.getCreditosDisponibles());
    }

    @Test
    @DisplayName("Al jugar una partida el crédito del jugador disminuye")
    public void jugarPartidaRestaCreditos() {
        Jugador jugador = new Jugador("Luis", "l1");
        MaquinaArcade maquina = new MaquinaArcade("Donkey Kong", "Arcade", 10);

        SalaRecreativa sala = new SalaRecreativa();
        sala.anhadirJugador(jugador);
        sala.anhadirMaquina(maquina);

        boolean resultado = sala.gestionarPartida(jugador, maquina);

        assertFalse(resultado);
        assertEquals(90, jugador.getCreditosDisponibles());
    }

    @Test
    @DisplayName("Al jugar una partida se incrementa el contador de partidas del jugador y de la máquina")
    public void jugarIncrementaPartidas() {
        Jugador jugador = new Jugador("Juan", "j1");
        MaquinaArcade maquina = new MaquinaArcade("Space Invaders", "Arcade", 5);

        SalaRecreativa sala = new SalaRecreativa();
        sala.anhadirJugador(jugador);
        sala.anhadirMaquina(maquina);

        assertEquals(0, jugador.getNumeroPartidasJugador());
        assertEquals(0, maquina.getContadorPartidasJugadas());

        sala.gestionarPartida(jugador, maquina);

        assertEquals(1, jugador.getNumeroPartidasJugador());
        assertEquals(1, maquina.getContadorPartidasJugadas());
    }
}
