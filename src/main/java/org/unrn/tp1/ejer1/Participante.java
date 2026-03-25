package org.unrn.tp1.ejer1;

public class Participante {
    private String name;
    private int points;
    private int id;

    public Participante(String name, int id) {
        this.name = name;
        this.points = 0;
        this.id = id;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
