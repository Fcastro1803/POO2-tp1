package org.unrn.tp1.ejer1;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.nio.file.Files.exists;

public class Files implements RegistroInscripcion {

    private static void escribirTxt(Participante p, LocalDate fecha, Concurso concurso, FileWriter file, DateTimeFormatter formato) throws IOException {
        file.write(formato.format(fecha) + ", " + p.getId() + ", " + concurso.getId() + "\n");
        file.close();
        System.out.println("Se escribió en el archivo exitosamente.");
    }

    @Override
    public void guardar(Participante p, LocalDate fecha, Concurso concurso) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            if (exists(Path.of("concursantes.txt"))) {
                System.out.println("El archivo ya existe. Se agregara los participantes al archivo existente.");
                FileWriter file = new FileWriter("concursantes.txt", true);
                escribirTxt(p, fecha, concurso, file, formato);
                return;
            }
            FileWriter file = new FileWriter("concursantes.txt");
            escribirTxt(p, fecha, concurso, file, formato);
        } catch (IOException e) {
            System.out.println("Ocurrio un error: " + e.getMessage());
        }
    }
}
