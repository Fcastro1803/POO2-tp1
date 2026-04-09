package org.unrn.tp1.ejer2;

import java.time.LocalDate;

public class TarjetaMastercard extends TarjetaCredito {
    private LocalDate fechaCobro;

    public TarjetaMastercard(String numeroTarjeta, String titular, String fechaVencimiento) {
        super(numeroTarjeta, titular, fechaVencimiento);
    }

    @Override
    public double procesarPago(Pedido pedido) {
        //Los pagos con tarjeta de crédito Mastercard tienen un 2% de descuento sobre el costo total de los platos principales.
        double totalBebidas = 0;
        double totalPlatos = 0;
        totalBebidas = pedido.calcularTotalBebidas();
        totalPlatos = pedido.calcularTotalPlatos();
        double descuento = totalPlatos * 0.02;
        double totalPedido = (totalPlatos - descuento) + totalBebidas;
        double totalPagar = (totalPedido * pedido.mesa.propina) + totalPedido;
        Files files = new Files();
        files.guardarCobroTxt(totalPagar, pedido.fechaPedido);
        return totalPagar;
    }
}
