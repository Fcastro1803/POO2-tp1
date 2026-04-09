package org.unrn.tp1.ejer2;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PedidosTest {

    @Test
    void testCalculoCostoConTarjetaVisa() {
        Mesa mesa1 = new Mesa(1, 0.05);
        Pedido pedido1 = new Pedido(new ArrayList<>(), new ArrayList<>(), mesa1, LocalDate.of(2026, 5, 20));
        pedido1.agregarPlato(new Plato("Pizza", 100));
        pedido1.agregarBebida(new Bebida("Coca-Cola", 50));
        TarjetaVisa tarjetaVisa = new TarjetaVisa("1234567890123456", "Juan Perez", "12/28");
        assertEquals(155.92, tarjetaVisa.procesarPago(pedido1), 0.01);
    }

    @Test
    void testCalculoCostoConTarjetaMastercard() {
        Mesa mesa1 = new Mesa(1, 0.03);
        Pedido pedido1 = new Pedido(new ArrayList<>(), new ArrayList<>(), mesa1, LocalDate.of(2026, 5, 20));
        pedido1.agregarPlato(new Plato("Pizza", 100));
        pedido1.agregarBebida(new Bebida("Coca-Cola", 50));
        TarjetaMastercard tarjetaMastercard = new TarjetaMastercard("1234567890123456", "Juan Perez", "12/28");
        assertEquals(152.44, tarjetaMastercard.procesarPago(pedido1), 0.01);
    }

    @Test
    void testCalculoCostoConTarjetaComarcaPlus() {
        Mesa mesa1 = new Mesa(1, 0.02);
        Pedido pedido1 = new Pedido(new ArrayList<>(), new ArrayList<>(), mesa1, LocalDate.of(2026, 5, 20));
        pedido1.agregarPlato(new Plato("Pizza", 100));
        pedido1.agregarBebida(new Bebida("Coca-Cola", 50));
        TarjetaComarcaPlus tarjetaComarcaPlus = new TarjetaComarcaPlus("1234567890123456", "Juan Perez", "12/28");
        assertEquals(149.94, tarjetaComarcaPlus.procesarPago(pedido1), 0.01);
    }

    @Test
    void testCalculoCostoConTarjetaViedma() {
        Mesa mesa1 = new Mesa(1, 0.05);
        Pedido pedido1 = new Pedido(new ArrayList<>(), new ArrayList<>(), mesa1, LocalDate.of(2026, 5, 20));
        pedido1.agregarPlato(new Plato("Pizza", 100));
        pedido1.agregarBebida(new Bebida("Coca-Cola", 50));
        TarjetaCredito tarjetaViedma = new TarjetaCredito("1234567890123456", "Juan Perez", "12/28");
        assertEquals(157.50, tarjetaViedma.procesarPago(pedido1), 0.01);
    }
}