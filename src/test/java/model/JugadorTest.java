package model;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JugadorTest {

    @Test
    @DisplayName("Comprobar que al recargar créditos el saldo aumenta")
    public void recargarCreditosIncrementaSaldo() {
        Jugador jugador = new Jugador("Paco", "p72");
        assertEquals(100, jugador.getCreditosDisponibles());

        jugador.recargarCreditos(50);

        assertEquals(150, jugador.getCreditosDisponibles());
    }

    @Test
    @DisplayName("Jugador gasta créditos correctamente")
    public void gastarCreditosDisminuyeSaldo() {
        Jugador jugador = new Jugador("Ana", "an22");

        boolean resultado = jugador.gastarCreditos(30);

        assertTrue(resultado);
        assertEquals(70, jugador.getCreditosDisponibles());
    }

    @Test
    @DisplayName("No se pueden gastar más créditos de los que tiene")
    public void noGastarCreditosInsuficientes() {
        Jugador jugador = new Jugador("Luis", "l11");

        boolean resultado = jugador.gastarCreditos(200);

        assertFalse(resultado);
        assertEquals(100, jugador.getCreditosDisponibles());
    }

    @Test
    @DisplayName("Al jugar una partida se incrementa el número de partidas del jugador")
    public void incrementarNumeroPartidasJugadas() {
        Jugador jugador = new Jugador("Marta", "m44");

        assertEquals(0, jugador.getNumeroPartidasJugador());

        jugador.incrementarNumPartidas();

        assertEquals(1, jugador.getNumeroPartidasJugador());
    }
}