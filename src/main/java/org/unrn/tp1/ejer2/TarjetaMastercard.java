package org.unrn.tp1.ejer2;

import java.time.LocalDate;

public class TarjetaMastercard extends TarjetaCredito {
    private LocalDate fechaCobro;

    public TarjetaMastercard(String numeroTarjeta, String titular, String fechaVencimiento) {
        super(numeroTarjeta, titular, fechaVencimiento);
    }

    @Override
    public double procesarPago(Pedido pedido) {
        CalcularTotales totales = getCalcularTotales(pedido);
        double descuento = totales.totalPlatos() * 0.02;
        double totalPedido = (totales.totalPlatos() - descuento) + totales.totalBebidas();
        double totalPagar = (totalPedido * pedido.mesa.propina) + totalPedido;
        String tarjeta = "Mastercard";
        registrarPedido(pedido, totalPagar, tarjeta);
        return totalPagar;
    }
}