package org.unrn.tp1.ejer1;

import java.sql.*;
import java.time.LocalDate;

public class JdbcRegistroInscripcion implements RegistroInscripcion {
    private String url = "jdbc:mysql://localhost:3306/concursos_db";
    private String user = "root";
    private String password = "root";

    public JdbcRegistroInscripcion() {
    }

    @Override
    public void guardar(Participante p, LocalDate fecha, Concurso c) {
        String sql = "INSERT INTO inscripciones (id_participante, id_concurso, fecha_inscripcion) VALUES (?, ?, ?)";

        //
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setInt(1, p.getId());
            statement.setInt(2, c.getId());
            statement.setDate(3, Date.valueOf(fecha));

            statement.executeUpdate();
            System.out.println("Inscripción guardada en BD para: " + p.getName());

        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar con la base de datos", e);
        }
    }
}
