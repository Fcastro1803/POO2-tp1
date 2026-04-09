package org.unrn.tp1.ejer1;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ConcursoTest {

    //este test verifica que un participante se inscribe a un concurso
    @Test
    void testInscripcion() {
        Concurso avionesAEscalas = new Concurso("Concurso de Aviones a escalas",
                LocalDate.of(2026, 3, 13),
                LocalDate.of(2026, 3, 31), 1, new MockRegistroInscripcion());
        Participante p1 = new Participante("eze", 1);
        avionesAEscalas.inscribir(p1, LocalDate.of(2026, 3, 20));
        assert avionesAEscalas.getInscriptos().contains(p1) : "El participante no se inscribio correctamente";
    }

    //este test verifica que un participante se incribe a un concurso el primer dia de inscripcion y obtiene los puntos correspondientes
    @Test
    void testInscripcionPrimerDia() {
        Concurso avionesAEscalas = new Concurso("Concurso de Autos a escalas",
                LocalDate.of(2026, 3, 13),
                LocalDate.of(2026, 3, 31), 2, new MockRegistroInscripcion());
        Participante p1 = new Participante("pepe", 2);
        avionesAEscalas.inscribir(p1, LocalDate.of(2026, 3, 13));
        assert p1.getPoints() == 10 : "El participante no obtuvo los puntos correspondientes por inscribirse el primer dia";
    }

    //este test verifica que un participante no se inscribe a un concurso fuera del rango de fechas permitido
    @Test
    void testInscripcionFueraDeRango() {
        Concurso avionesAEscalas = new Concurso("Concurso de Aviones a escalas",
                LocalDate.of(2026, 3, 13),
                LocalDate.of(2026, 3, 31), 3, new MockRegistroInscripcion());
        Participante p1 = new Participante("juan", 3);
        avionesAEscalas.inscribir(p1, LocalDate.of(2026, 4, 1));
        assert !avionesAEscalas.getInscriptos().contains(p1) : "El participante se inscribio fuera del rango de fechas permitido";
    }

    // Clase interna Mock para evitar conexión a BD en tests
    private static class MockRegistroInscripcion implements RegistroInscripcion {
        @Override
        public void guardar(Participante p, LocalDate fecha, Concurso c) {
        }
    }

    // Clase interna Mock para evitar el envío de mail|
    private static class MockEnviadorMail extends EmailService {
        @Override
        public void enviarEmailParticipante(Participante participante, String nombreConcurso, LocalDate fecha) {
        }
    }

}
