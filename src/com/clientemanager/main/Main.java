package com.clientemanager.main;

import com.clientemanager.insert.InsertCliente;
import com.clientemanager.delete.DeleteCliente;
import com.clientemanager.update.UpdateCliente;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InsertCliente insertCliente = new InsertCliente();
        DeleteCliente deleteCliente = new DeleteCliente();
        UpdateCliente updateCliente = new UpdateCliente();

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Insertar cliente");
            System.out.println("2. Eliminar cliente");
            System.out.println("3. Actualizar cliente");
            System.out.println("4. Consultar clientes");
            System.out.println("5. Salir");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    scanner.nextLine(); // Limpiar buffer
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el email del cliente: ");
                    String email = scanner.nextLine();
                    System.out.print("Ingrese la contraseña del cliente: ");
                    String contrasena = scanner.nextLine();
                    insertCliente.insertCliente(nombre, email, contrasena);
                    break;
                case 2:
                    System.out.print("Ingrese el ID del cliente a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    deleteCliente.deleteCliente(idEliminar);
                    break;
                case 3:
                    System.out.print("Ingrese el ID del cliente a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer
                    System.out.print("Ingrese el nuevo nombre del cliente: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("Ingrese el nuevo email del cliente: ");
                    String nuevoEmail = scanner.nextLine();
                    System.out.print("Ingrese la nueva contraseña del cliente: ");
                    String nuevaContrasena = scanner.nextLine();
                    updateCliente.updateCliente(idActualizar, nuevoNombre, nuevoEmail, nuevaContrasena);
                    break;
                case 4:
                    updateCliente.consultarClientes();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
