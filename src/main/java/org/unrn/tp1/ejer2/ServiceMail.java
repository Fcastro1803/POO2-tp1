package org.unrn.tp1.ejer2;

import java.time.LocalDate;

public interface ServiceMail {
    void enviarEmailPedido(LocalDate fecha, double totalPagar, String tarjeta);
}
