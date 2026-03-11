package com.restaurante.comidasrapidas;

import com.restaurante.comidasrapidas.Service.ClienteService;
import com.restaurante.comidasrapidas.Service.ProductoService;
import com.restaurante.comidasrapidas.Model.Cliente;
import com.restaurante.comidasrapidas.Model.Producto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MenuConsola implements CommandLineRunner {

    private final ClienteService clienteService;
    private final ProductoService productoService;

    public MenuConsola(ClienteService clienteService, ProductoService productoService) {
        this.clienteService = clienteService;
        this.productoService = productoService;
    }

    @Override
    public void run(String... args) {

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {

            System.out.println("\n==== SISTEMA COMIDAS RAPIDAS ====");
            System.out.println("1. Gestionar Clientes");
            System.out.println("2. Gestionar Productos");
            System.out.println("0. Salir");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1 -> menuClientes(scanner);
                case 2 -> menuProductos(scanner);

            }

        } while (opcion != 0);

    }

    private void menuClientes(Scanner scanner) {

        int opcion;

        do {

            System.out.println("\n--- CLIENTES ---");
            System.out.println("1. Crear cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Actualizar cliente");
            System.out.println("4. Eliminar cliente");
            System.out.println("0. Volver");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1 -> {

                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Telefono: ");
                    String telefono = scanner.nextLine();

                    System.out.print("Direccion: ");
                    String direccion = scanner.nextLine();

                    Cliente cliente = new Cliente(nombre, telefono, direccion);
                    clienteService.crearCliente(cliente);

                    System.out.println("Cliente creado.");
                }

                case 2 -> clienteService.obtenerClientes()
                        .forEach(c ->
                                System.out.println(c.getId() + " - " + c.getNombre())
                        );

                case 3 -> {

                    System.out.print("ID cliente a actualizar: ");
                    Long id = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print("Nuevo nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Nuevo telefono: ");
                    String telefono = scanner.nextLine();

                    System.out.print("Nueva direccion: ");
                    String direccion = scanner.nextLine();

                    Cliente cliente = new Cliente(nombre, telefono, direccion);

                    clienteService.actualizarCliente(id, cliente);

                    System.out.println("Cliente actualizado.");
                }

                case 4 -> {

                    System.out.print("ID cliente a eliminar: ");
                    Long id = scanner.nextLong();

                    clienteService.eliminarCliente(id);

                    System.out.println("Cliente eliminado.");
                }

            }

        } while (opcion != 0);
    }

    private void menuProductos(Scanner scanner) {

        int opcion;

        do {

            System.out.println("\n--- PRODUCTOS ---");
            System.out.println("1. Crear producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Actualizar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("0. Volver");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1 -> {

                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Precio: ");
                    double precio = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Descripcion: ");
                    String descripcion = scanner.nextLine();

                    Producto producto = new Producto(nombre, precio, descripcion);
                    productoService.crearProducto(producto);

                    System.out.println("Producto creado.");
                }

                case 2 -> productoService.obtenerProductos()
                        .forEach(p ->
                                System.out.println(p.getId() + " - " + p.getNombre())
                        );

                case 3 -> {

                    System.out.print("ID producto a actualizar: ");
                    Long id = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print("Nuevo nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Nuevo precio: ");
                    double precio = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Nueva descripcion: ");
                    String descripcion = scanner.nextLine();

                    Producto producto = new Producto(nombre, precio, descripcion);

                    productoService.actualizarProducto(id, producto);

                    System.out.println("Producto actualizado.");
                }

                case 4 -> {

                    System.out.print("ID producto a eliminar: ");
                    Long id = scanner.nextLong();

                    productoService.eliminarProducto(id);

                    System.out.println("Producto eliminado.");
                }

            }

        } while (opcion != 0);
    }
}