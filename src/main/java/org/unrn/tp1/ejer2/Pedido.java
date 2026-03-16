package org.unrn.tp1.ejer2;

import java.util.List;

public class Pedido {
    List<Bebida> bebidas;
    List<Plato> platos;
    Mesa mesa;

    public Pedido(List<Bebida> bebidas, List<Plato> platos, Mesa mesa) {
        this.mesa = mesa;
        this.bebidas = bebidas;
        this.platos = platos;
    }

    //-------------BEBIDAS----------------
    //metodo para añadir bebida al pedido
    public void agregarBebida(Bebida bebida) {
        bebidas.add(bebida);
    }

    //metodo que devuelve el monto total de las bebidas
    public double calcularTotalBebidas() {
        double total = 0;
        for (Bebida bebida : bebidas) {
            total += bebida.getPrecio();
        }
        return total;
    }

    //-------------BEBIDAS----------------
    //metodo para añadir plato al pedido
    public void agregarPlato(Plato plato) {
        platos.add(plato);
    }

    //metodo que devuelve el monto total de los platos
    public double calcularTotalPlatos() {
        double total = 0;
        for (Plato plato : platos) {
            total += plato.getPrecio();
        }
        return total;
    }
}
