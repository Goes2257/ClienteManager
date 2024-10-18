package com.clientemanager.insert;

import com.clientemanager.database.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertCliente {

    public void insertCliente(String nombre, String email, String contrasena) {
        String query = "INSERT INTO clientes (nombre, email, contrasena) VALUES (?, ?, ?)";
        
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, nombre);
            stmt.setString(2, email);
            stmt.setString(3, contrasena);
            stmt.executeUpdate();
            System.out.println("Cliente insertado correctamente.");
            
        } catch (SQLException e) {
            System.out.println("Error al insertar el cliente: " + e.getMessage());
        }
    }
}
