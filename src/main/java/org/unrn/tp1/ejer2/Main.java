package org.unrn.tp1.ejer2;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    //creamos 4 mesas
    public static void main(String[] args) {
        Mesa mesa1 = new Mesa(1, 0.02);
        Mesa mesa2 = new Mesa(2, 0.03);
        Mesa mesa3 = new Mesa(3, 0.02);
        Mesa mesa4 = new Mesa(4, 0.05);

        //creamos 4 platos
        Plato plato1 = new Plato("Pizza", 100);
        //Plato plato3 = new Plato("Ensalada", 60);
        //Plato plato4 = new Plato("Pasta", 120);
        //Plato plato2 = new Plato("Hamburguesa", 80);

        //creamos 4 bebidas
        Bebida bebida1 = new Bebida("Coca-Cola", 10);
        //Bebida bebida2 = new Bebida("Agua", 5);
        //Bebida bebida3 = new Bebida("Cerveza", 25);
        //Bebida bebida4 = new Bebida("Vino", 50);

        //creamos un pedido para la mesa1
        Pedido pedido1 = new Pedido(new ArrayList<>(), new ArrayList<>(), mesa1, LocalDate.of(2026, 5, 20));
        pedido1.agregarPlato(plato1);
        //pedido1.agregarPlato(plato2);
        pedido1.agregarBebida(bebida1);
        //pedido1.agregarBebida(bebida2);

        //creamos un pedido para la mesa2
        Pedido pedido2 = new Pedido(new ArrayList<>(), new ArrayList<>(), mesa2, LocalDate.of(2026, 2, 17));
        pedido2.agregarPlato(plato1);
        //pedido2.agregarPlato(plato4);
        //pedido2.agregarBebida(bebida3);
        pedido2.agregarBebida(bebida1);

        //creamos un pedido para la mesa3
        Pedido pedido3 = new Pedido(new ArrayList<>(), new ArrayList<>(), mesa3, LocalDate.of(2026, 4, 25));
        pedido3.agregarPlato(plato1);
        //pedido3.agregarPlato(plato4);
        pedido3.agregarBebida(bebida1);
        //pedido3.agregarBebida(bebida4);

        //creamos un pedido para la mesa4
        Pedido pedido4 = new Pedido(new ArrayList<>(), new ArrayList<>(), mesa4, LocalDate.now());
        pedido4.agregarPlato(plato1);
        //pedido4.agregarPlato(plato3);
        //pedido4.agregarBebida(bebida2);
        pedido4.agregarBebida(bebida1);

        //creamos 4 tarjetas de credito
        TarjetaVisa tarjetaVisa = new TarjetaVisa("1234567890123456", "Juan Perez", "12/28");
        TarjetaMastercard tarjetaMastercard = new TarjetaMastercard("9876543210987654", "Maria Gomez", "11/28");
        TarjetaComarcaPlus tarjetaComarcaPlus = new TarjetaComarcaPlus("5555555555554444", "Carlos Sanchez", "10/28");
        TarjetaCredito tarjetaCredito = new TarjetaCredito("1111222233334444", "Ana Rodriguez", "09/28");

        //calculamos el total del pedido
        tarjetaVisa.procesarPago(pedido1);
        tarjetaMastercard.procesarPago(pedido2);
        tarjetaComarcaPlus.procesarPago(pedido3);
        tarjetaCredito.procesarPago(pedido4);

    }
}
