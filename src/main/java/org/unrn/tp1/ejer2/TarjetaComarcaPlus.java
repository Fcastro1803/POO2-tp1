package org.unrn.tp1.ejer2;

import java.time.LocalDate;

public class TarjetaComarcaPlus extends TarjetaCredito {

    private LocalDate fechaCobro;

    public TarjetaComarcaPlus(String numeroTarjeta, String titular, String fechaVencimiento) {
        super(numeroTarjeta, titular, fechaVencimiento);
    }

    @Override
    public double procesarPago(Pedido pedido) {
        CalcularTotales totales = getCalcularTotales(pedido);
        double totalPedido = (totales.totalPlatos() + totales.totalBebidas());
        double descuento = totalPedido * 0.02;
        double totalPedidoConDescuento = totalPedido - descuento;
        double totalPagar = (totalPedidoConDescuento * pedido.mesa.propina) + totalPedidoConDescuento;
        String tarjeta = "Comarca Plus";
        registrarPedido(pedido, totalPagar, tarjeta);
        return totalPagar;
    }
}