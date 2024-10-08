package com.kevinzamora;

import java.util.Optional;
import java.util.Scanner;

public class Principal {

    /* En la clase Principal definimos y construimos la estructura del menú de
    navegación de nuestra aplicación */
    /* A su vez, también instanciamos la clase Customer para poder hacer uso de las
    funciones/métodos, creados para gestionar los diferentes clientes/usuarios de nuestra
    aplicación */

    CustomersRepo customerMethodsObj = new CustomersRepo();

    // imprimir menu
    String menu = """
                ADMINISTRAR CLIENTES
                NUESTRAS OPCIONES SON:
                1. Registrar un nuevo cliente.
                2. Ver listado de clientes registrados.
                3. Obtener los datos de un cliente concreto.
                4. Actualizar cliente.
                5. Eliminar cliente.
                6. Salir
                """;
    // Estructura de nuestro menú principal imprimido por pantalla
    public void loadMainMenu() {

        System.out.println("BIENVENID@S A NUESTRO BANCO: \n");
        customerMethodsObj.inicializarBD();
        System.out.println(menu);

        // Método de entrada para seleccionar la opción deseada
        System.out.println("SELECCIONA UNA OPCIÓN (Introduce un nº entero):");
        Scanner scanner = new Scanner(System.in);
        int opcion = Integer.parseInt(scanner.nextLine());

        // Conmutador/Switch necesario para realizar la selección de la opción deseada
        // En cada opción se procede a llamar la función necesaria mediante 'bancoObj.' y nombre función + ()
        String nombreIntroducido = ""; String apellidoIntroducido = "";
        String emailIntroducido = ""; int edadIntroducida = 0;
        switch (opcion) {
            case 1:
                System.out.println("INTRODUCIR DATOS DE UN NUEVO CLIENTE: \n ");
                try {
                    System.out.println("Inserta su nombre (Texto): \n ");
                    nombreIntroducido = scanner.nextLine();
                    System.out.println("Inserta su apellido (Texto): \n ");
                    apellidoIntroducido = scanner.nextLine();
                    System.out.println("Introduce su 'email' (Texto): \n ");
                    emailIntroducido = scanner.nextLine();
                    System.out.println("Introduce su edad (Nº Entero): \n ");
                    edadIntroducida = Integer.parseInt(scanner.nextLine());
                } catch (Exception e) {
                    System.out.println("Se ha introducido algún dato erroneo.");
                }
                customerMethodsObj.crearNuevoCliente(nombreIntroducido, apellidoIntroducido, emailIntroducido, edadIntroducida);
                loadMainMenu();
                break;
            case 2:
                System.out.println("LISTA DE CLIENTES REGISTRADOS EN NUESTRA APLICACIÓN:");
                customerMethodsObj.encontrarListaClientes();
                loadMainMenu();
                break;
            case 3:
                System.out.println("MOSTRAR DATOS DEL CLIENTE");
                System.out.println("Introduce el número de ID del cliente a buscar: \n ");
                int idClienteIntroducido = Integer.parseInt(scanner.nextLine());
                customerMethodsObj.mostrarDatosCliente(idClienteIntroducido);
                loadMainMenu();
                break;
            case 4:
                System.out.println("ACTUALIZAR CLIENTE");
                System.out.println("Introduzca el número de ID del cliente a actualizar (Nº Entero): \n ");
                Long idClienteIntroducido1 = Long.valueOf(scanner.nextLine());
                Optional<Customer> cliente = customerMethodsObj.encontrarClientePorId(idClienteIntroducido1);
                if (cliente.isPresent()) {
                    System.out.println("Introduce su nuevo nombre: \n ");
                    String nombreIntroducido1 = scanner.nextLine();
                    System.out.println("Introduce su nuevo apellido: \n ");
                    String apellidoIntroducido1 = scanner.nextLine();
                    System.out.println("Introduce su nuevo 'email': \n ");
                    String emailIntroducido1 = scanner.nextLine();
                    System.out.println("Introduce su edad actual (Nº Entero): \n ");
                    int edadActual = Integer.parseInt(scanner.nextLine());

                    customerMethodsObj.actualizarDatosCliente(idClienteIntroducido1, nombreIntroducido1, apellidoIntroducido1,
                            emailIntroducido1, edadActual);
                }
                loadMainMenu();
                break;
            case 5:
                System.out.println("ELIMINAR CLIENTE");
                System.out.println("Introduce el número ID del cliente (Nº Entero): \n ");
                Long idClienteEliminar = Long.valueOf(scanner.nextLine());
                customerMethodsObj.eliminarCliente(idClienteEliminar);
                loadMainMenu();
                break;
            case 6:
                System.out.println("¡HASTA PRONTO!");
                break;
            default:
                System.out.println("LA OPCIÓN INTRODUCIDA NO ES VÁLIDA \n");
                break;
        }
    }
}
