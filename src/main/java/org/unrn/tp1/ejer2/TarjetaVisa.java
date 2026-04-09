package org.unrn.tp1.ejer2;

import java.time.LocalDate;

//esat es clase hija de TarjetaCredito
public class TarjetaVisa extends TarjetaCredito {
    private LocalDate fechaCobro;

    public TarjetaVisa(String numeroTarjeta, String titular, String fechaVencimiento) {
        super(numeroTarjeta, titular, fechaVencimiento);
    }

    @Override
    public double procesarPago(Pedido pedido) {
        CalcularTotales totales = getCalcularTotales(pedido);
        double descuento = totales.totalBebidas() * 0.03;
        double totalPedido = (totales.totalBebidas() - descuento) + totales.totalPlatos();
        double totalPagar = (totalPedido * pedido.mesa.propina) + totalPedido;
        String tarjeta = "Visa";
        registrarPedido(pedido, totalPagar, tarjeta);
        return totalPagar;
    }
}