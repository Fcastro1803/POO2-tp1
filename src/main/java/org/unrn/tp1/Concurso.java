package org.unrn.tp1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Concurso {
    private String name;
    private List<Participante> inscriptos;
    private LocalDate fechaInicioInscripcion;
    private LocalDate fechaFinInscripcion;

    public Concurso(String name, LocalDate inicio, LocalDate fin) {
        this.name = name;
        this.fechaInicioInscripcion = inicio;
        this.fechaFinInscripcion = fin;
        this.inscriptos = new ArrayList<>();
    }

    public void inscribir(Participante p, LocalDate fechaInscripcion) {
        if (fechaInscripcion.isBefore(fechaInicioInscripcion) || fechaInscripcion.isAfter(fechaFinInscripcion)) {
            System.out.println("El participante " + p.getName() + " no puede participar, fecha de inscripción fuera del período permitido");
            return;
        }
        inscriptos.add(p);
        System.out.println("Participante " + p.getName() + " inscripto exitosamente.");
        //se le asigna 10 puntos si es el primer dia de inscripcion
        if (fechaInscripcion.equals(fechaInicioInscripcion)) {
            p.addPoints(10);
            System.out.println("Participante " + p.getName() + " gano 10 puntos por inscribirse el primer dia.");
        }
    }

    public void obtenerResultados() {
        for (Participante p : inscriptos) {
            System.out.println("Participante: " + p.getName() + ", Puntos: " + p.getPoints());
        }
    }

    public List<Participante> getInscriptos() {
        return inscriptos;
    }
}
