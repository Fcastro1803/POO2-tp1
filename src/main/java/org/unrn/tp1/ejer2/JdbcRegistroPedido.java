package org.unrn.tp1.ejer2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class JdbcRegistroPedido implements RegistroPedido {
    private static final String URL = "jdbc:mysql://localhost:3306/restaurente_bd";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    @Override
    public void guardarPedido(double totalPagar, LocalDate fechaPedido) {
        String sql = "INSERT INTO pedido (fecha_pedido, total_pagar) VALUES (?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, fechaPedido.toString());
            statement.setDouble(2, totalPagar);

            statement.executeUpdate();
            System.out.println("Pedido guardado en la base de datos exitosamente.");

        } catch (SQLException e) {
            System.out.println("Error al guardar el pedido en la base de datos: " + e.getMessage());
        }
    }
}
