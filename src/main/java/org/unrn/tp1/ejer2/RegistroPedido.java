package org.unrn.tp1.ejer2;

import java.time.LocalDate;

public interface RegistroPedido {
    void guardarPedido(double totalPagar, LocalDate fecha);
}