package org.unrn.tp1.ejer1;

import java.time.LocalDate;

public interface RegistroInscripcion {
    void guardar(Participante p, LocalDate fecha, Concurso c);
}
