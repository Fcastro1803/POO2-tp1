package org.unrn.tp1.ejer2;

//esat es clase hija de TarjetaCredito
public class TarjetaVisa extends TarjetaCredito {

    public TarjetaVisa(String numeroTarjeta, String titular, String fechaVencimiento) {
        super(numeroTarjeta, titular, fechaVencimiento);
    }

    @Override
    public double procesarPago(Pedido pedido) {
        //Los pagos con tarjeta de crédito Visa tienen un descuento del 3% sobre el costo total de las bebidas.
        double totalBebidas = 0;
        double totalPlatos = 0;
        totalBebidas = pedido.calcularTotalBebidas();
        totalPlatos = pedido.calcularTotalPlatos();
        double descuento = totalBebidas * 0.03;
        double totalPedido = (totalBebidas - descuento) + totalPlatos;
        double totalPagar = (totalPedido * pedido.mesa.propina) + totalPedido;
        return totalPagar;
    }
}
