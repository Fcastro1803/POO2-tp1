package org.unrn.tp1.ejer1;

import java.time.LocalDate;

public class Main {
    static void main() {
        //creamos un concurso
        Concurso avionesAEscalas = new Concurso("Concurso de Aviones a escalas",
                LocalDate.of(2026, 3, 13),
                LocalDate.of(2026, 3, 31), 1);
        //creamos 3 participantes
        Participante p1 = new Participante("pepe", 1);
        Participante p2 = new Participante("eze", 2);
        Participante p3 = new Participante("juan", 3);

        //inscripcion el primer dia
        avionesAEscalas.inscribir(p1, LocalDate.of(2026, 3, 13));

        //inscripcion dentro del rango
        avionesAEscalas.inscribir(p2, LocalDate.of(2026, 3, 20));

        //inscripcion fuera de rango
        avionesAEscalas.inscribir(p3, LocalDate.of(2026, 4, 1));

        //verificamos puntos usando el arreglo de inscriptos del concurso usando el metodo obtenerResultados
        avionesAEscalas.obtenerResultados();
    }
}
