package org.unrn.tp1.ejer1;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConcursoTest {

    // Test que verifica que un participante se inscribe a un concurso
    @Test
    void testInscripcion() {
        Concurso avionesAEscalas = new Concurso("Concurso de Aviones a escalas",
                LocalDate.of(2026, 3, 13),
                LocalDate.of(2026, 3, 31), 1, new MockRegistroInscripcion(),
                new MockServicioEmail());
        Participante p1 = new Participante("eze", 1);
        avionesAEscalas.inscribir(p1, LocalDate.of(2026, 3, 20));
        assertTrue(avionesAEscalas.estaInscrito(p1), "El participante no se inscribio correctamente");
    }

    // Test que verifica inscripción el primer día
    @Test
    void testInscripcionPrimerDia() {
        Concurso avionesAEscalas = new Concurso("Concurso de Autos a escalas",
                LocalDate.of(2026, 3, 13),
                LocalDate.of(2026, 3, 31), 2, new MockRegistroInscripcion(),
                new MockServicioEmail());
        Participante p1 = new Participante("pepe", 2);
        avionesAEscalas.inscribir(p1, LocalDate.of(2026, 3, 13));
        assertTrue(p1.tienePointsDeprimerDia(10), "El participante no obtuvo los puntos correspondientes por inscribirse el primer dia");
    }

    // Test que verifica que no se inscribe fuera de rango
    @Test
    void testInscripcionFueraDeRango() {
        Concurso avionesAEscalas = new Concurso("Concurso de Aviones a escalas",
                LocalDate.of(2026, 3, 13),
                LocalDate.of(2026, 3, 31), 3, new MockRegistroInscripcion(),
                new MockServicioEmail());
        Participante p1 = new Participante("juan", 3);
        avionesAEscalas.inscribir(p1, LocalDate.of(2026, 4, 1));
        assertFalse(avionesAEscalas.estaInscrito(p1), "El participante se inscribio fuera del rango de fechas permitido");
    }

    private static class MockRegistroInscripcion implements RegistroInscripcion {
        @Override
        public void guardar(Participante p, LocalDate fecha, Concurso c) {
        }
    }

    private static class MockServicioEmail implements ServiceMail {
        @Override
        public void enviarEmailParticipante(Participante p, String nombreConcurso, LocalDate fechaFin) {
        }
    }
}