package org.unrn.tp1.ejer2;

import java.time.LocalDate;

//clase abtracta, no se puede instanciar, solo se puede heredar
public class TarjetaCredito {
    private String numeroTarjeta;
    private String titular;
    private String fechaVencimiento;
    private LocalDate fechaCobro;

    public TarjetaCredito(String numeroTarjeta, String titular, String fechaVencimiento) {
        this.numeroTarjeta = numeroTarjeta;
        this.titular = titular;
        this.fechaVencimiento = fechaVencimiento;
    }

    public static void registrarPedido(Pedido pedido, double totalPagar) {
        pedido.registro.guardarPedido(totalPagar, pedido.fechaPedido);
    }

    public static CalcularTotales getCalcularTotales(Pedido pedido) {
        double totalBebidas = 0;
        double totalPlatos = 0;
        totalBebidas = pedido.calcularTotalBebidas();
        totalPlatos = pedido.calcularTotalPlatos();
        CalcularTotales totales = new CalcularTotales(totalBebidas, totalPlatos);
        return totales;
    }

    public double procesarPago(Pedido pedido) {
        CalcularTotales totales = getCalcularTotales(pedido);
        double totalPedido = totales.totalBebidas() + totales.totalPlatos();
        double totalPagar = totalPedido + (totalPedido * pedido.mesa.propina);
        registrarPedido(pedido, totalPagar);
        return totalPagar;
    }

    public record CalcularTotales(double totalBebidas, double totalPlatos) {
    }

}
