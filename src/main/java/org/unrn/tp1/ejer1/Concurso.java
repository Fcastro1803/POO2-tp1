package org.unrn.tp1.ejer1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Concurso {
    private String name;
    private int id;
    private List<Participante> inscriptos;
    private LocalDate fechaInicioInscripcion;
    private LocalDate fechaFinInscripcion;
    private RegistroInscripcion registro;
    private ServiceMail servicioEmail;

    public Concurso(String name, LocalDate inicio, LocalDate fin, int id, RegistroInscripcion registro, ServiceMail servicioEmail) {
        this.name = name;
        this.fechaInicioInscripcion = inicio;
        this.fechaFinInscripcion = fin;
        this.inscriptos = new ArrayList<>();
        this.id = id;
        this.registro = registro;
        this.servicioEmail = servicioEmail;
    }

    public void inscribir(Participante p, LocalDate fechaInscripcion) {
        if (fechaInscripcion.isBefore(fechaInicioInscripcion) || fechaInscripcion.isAfter(fechaFinInscripcion)) {
            System.out.println("El participante " + p.getName() + " no puede participar, fecha de inscripción fuera del período permitido");
            return;
        }
        inscriptos.add(p);
        this.registro.guardar(p, fechaInscripcion, this);
        this.servicioEmail.enviarEmailParticipante(p, this.name, this.fechaFinInscripcion);
        if (fechaInscripcion.equals(fechaInicioInscripcion)) {
            p.addPoints(10);
            System.out.println("Participante " + p.getName() + " gano 10 puntos por inscribirse el primer dia.");
        }
    }

    public boolean estaInscrito(Participante p) {
        return inscriptos.contains(p);
    }

    public void obtenerResultados() {
        for (Participante p : inscriptos) {
            System.out.println("Participante: " + p.getName() + ", Puntos: " + p.getPoints());
        }
    }

    public List<Participante> getInscriptos() {
        return inscriptos;
    }

    public int getId() {
        return id;
    }
}
