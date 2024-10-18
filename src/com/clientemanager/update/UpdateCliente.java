package com.clientemanager.update;

import com.clientemanager.database.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateCliente {

    public void updateCliente(int id, String nombre, String email, String contrasena) {
        String query = "UPDATE clientes SET nombre = ?, email = ?, contrasena = ? WHERE id = ?";
        
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, nombre);
            stmt.setString(2, email);
            stmt.setString(3, contrasena);
            stmt.setInt(4, id);
            stmt.executeUpdate();
            System.out.println("Cliente actualizado correctamente.");
            
        } catch (SQLException e) {
            System.out.println("Error al actualizar el cliente: " + e.getMessage());
        }
    }

    public void consultarClientes() {
        String query = "SELECT * FROM clientes";
        
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Contraseña: " + rs.getString("contrasena"));
                System.out.println("----");
            }
            
        } catch (SQLException e) {
            System.out.println("Error al consultar los clientes: " + e.getMessage());
        }
    }
}

