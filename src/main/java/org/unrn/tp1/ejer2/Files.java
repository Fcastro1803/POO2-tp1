package org.unrn.tp1.ejer2;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.nio.file.Files.exists;

public class Files implements RegistroPedido {

    private static void escribirTxt(FileWriter file, DateTimeFormatter formato, LocalDate fecha, double totalPagar) throws IOException {
        file.write(formato.format(fecha) + " || " + totalPagar + "\n");
        file.close();
        System.out.println("Se escribió en el archivo exitosamente.");
    }

    @Override
    public void guardarPedido(double totalPagar, LocalDate fechaCobro) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            if (exists(Path.of("cobros.txt"))) {
                FileWriter file = new FileWriter("cobros.txt", true);
                escribirTxt(file, formato, fechaCobro, totalPagar);
            } else {
                FileWriter file = new FileWriter("cobros.txt");
                escribirTxt(file, formato, fechaCobro, totalPagar);
            }
        } catch (IOException e) {
            System.out.println("Ocurrio un error: " + e.getMessage());
        }
    }
}

