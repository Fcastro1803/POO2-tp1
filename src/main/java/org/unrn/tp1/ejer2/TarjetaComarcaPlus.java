package org.unrn.tp1.ejer2;

import java.time.LocalDate;

public class TarjetaComarcaPlus extends TarjetaCredito {

    private LocalDate fechaCobro;

    public TarjetaComarcaPlus(String numeroTarjeta, String titular, String fechaVencimiento) {
        super(numeroTarjeta, titular, fechaVencimiento);
    }

    @Override
    public double procesarPago(Pedido pedido) {
        //Los pagos con tarjeta de crédito Comarca Plus tienen un,
        // descuento del 2% sobre el costo total (bebidas + platos principales).
        double totalBebidas = 0;
        double totalPlatos = 0;
        totalBebidas = pedido.calcularTotalBebidas();
        totalPlatos = pedido.calcularTotalPlatos();
        double totalPedido = (totalPlatos + totalBebidas);
        double descuento = totalPedido * 0.02;
        double totalPedidoConDescuento = totalPedido - descuento;
        double totalPagar = (totalPedidoConDescuento * pedido.mesa.propina) + totalPedidoConDescuento;
        Files files = new Files();
        files.guardarCobroTxt(totalPagar, pedido.fechaPedido);
        return totalPagar;
    }
}