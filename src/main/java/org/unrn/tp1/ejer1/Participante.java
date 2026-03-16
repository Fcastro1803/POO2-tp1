package org.unrn.tp1.ejer1;

public class Participante {
    private String name;
    private int points;

    public Participante(String name) {
        this.name = name;
        this.points = 0;
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
}
