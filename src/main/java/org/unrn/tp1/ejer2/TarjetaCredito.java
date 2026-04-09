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

    public double procesarPago(Pedido pedido) {
        double totalBebidas = 0;
        double totalPlatos = 0;
        totalBebidas = pedido.calcularTotalBebidas();
        totalPlatos = pedido.calcularTotalPlatos();
        double totalPedido = totalBebidas + totalPlatos;
        double totalPagar = totalPedido + (totalPedido * pedido.mesa.propina);
        Files files = new Files();
        files.guardarCobroTxt(totalPagar, pedido.fechaPedido);
        return totalPagar;
    }
}
