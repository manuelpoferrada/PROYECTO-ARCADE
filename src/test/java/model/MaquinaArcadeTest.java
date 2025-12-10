package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaquinaArcadeTest {

    @Test
    @DisplayName("Al jugar una partida se incrementa el contador de partidas")
    public void contadorPartidasIncrementa() {
        Jugador jugador = new Jugador("Paco", "p1");
        MaquinaArcade maquina = new MaquinaArcade("Tetris", "Arcade", 5);

        assertEquals(0, maquina.getContadorPartidasJugadas());

        maquina.jugarPartida(jugador);

        assertEquals(1, maquina.getContadorPartidasJugadas());
    }

    @Test
    @DisplayName("Si se juegan varias partidas la mayor puntuación queda en el top 1")
    public void mayorPuntuacionEsTop1() {
        Jugador jugador = new Jugador("Ana", "a1");
        MaquinaArcade maquina = new MaquinaArcade("Pacman", "Arcade", 5);

        // Simulamos puntuaciones manualmente
        maquina.actualizarRanking(200, jugador);
        maquina.actualizarRanking(800, jugador);
        maquina.actualizarRanking(500, jugador);
        maquina.actualizarRanking(1000, jugador);

        int[] ranking = maquina.getMejoresPuntuaciones();

        assertEquals(1000, ranking[0]); // mayor está arriba
    }

    @Test
    @DisplayName("La peor puntuación no aparece en el top 3")
    public void peorPuntuacionNoEnTop3() {
        Jugador jugador = new Jugador("Luis", "l1");
        MaquinaArcade maquina = new MaquinaArcade("Donkey Kong", "Arcade", 5);

        maquina.actualizarRanking(900, jugador);
        maquina.actualizarRanking(700, jugador);
        maquina.actualizarRanking(400, jugador);

        // Intento meter puntuación peor que todas
        maquina.actualizarRanking(50, jugador);

        int[] ranking = maquina.getMejoresPuntuaciones();

        assertNotEquals(50, ranking[2]);
    }

    @Test
    @DisplayName("Cuando se alcanzan 100 partidas la máquina se desactiva")
    public void maquinaSeDesactivaAlLlegar100Partidas() {
        Jugador jugador = new Jugador("Marta", "m1");
        MaquinaArcade maquina = new MaquinaArcade("Space Invaders", "Arcade", 5);

        // Simulamos 99 partidas ya jugadas
        maquina.setContadorPartidasJugadas(99);

        // La número 100
        maquina.jugarPartida(jugador);

        assertFalse(maquina.isEstaActiva());
    }
}