package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JugadorTest {

    @Test
    @DisplayName("Jugador gasta créditos correctamente")
    public void test_jugador_gasta_creditos_correctamente() {
        Jugador jugador = new Jugador("Paco", "paco72");
        assertEquals(100, jugador.getCreditosDisponibles());
        jugador.gastarCreditos(20);
        assertEquals(80, jugador.getCreditosDisponibles());
    }

}