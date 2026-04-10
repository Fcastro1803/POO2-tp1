package org.unrn.tp1.ejer1;

import java.time.LocalDate;

public interface ServiceMail {
    void enviarEmailParticipante(Participante p, String nombreConcurso, LocalDate fechaFin);
}
