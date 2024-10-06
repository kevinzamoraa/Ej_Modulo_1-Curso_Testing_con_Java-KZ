package com.kevinzamora;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    /* En la clase Principal definimos y construimos la estructura del menú de
    navegación de nuestra aplicación */
    /* A su vez, también instanciamos la clase Customer para poder hacer uso de las
    funciones/métodos, creados para gestionar los diferentes clientes/usuarios de nuestra
    aplicación */

    CustomersMethods customerMethodsObj = new CustomersMethods();

    // imprimir menu
    // Estructura de nuestro menú principal imprimido por pantalla
    public void loadMainMenu() {

        System.out.println("BIENVENID@S A NUESTRO BANCO: \n");
        customerMethodsObj.inicializarBD();
        System.out.println("ADMINISTRAR CLIENTES \n NUESTRAS OPCIONES SON: \n "
                + "1. Registrar un nuevo cliente. \n "
                + "2. Ver listado de clientes registrados. \n "
                + "3. Obtener los datos de un cliente concreto. \n "
                + "4. Actualizar cliente. \n "
                + "5. Eliminar cliente. \n "
                + "6. Salir \n");

        // Método de entrada para seleccionar la opción deseada
        System.out.println("SELECCIONA UNA OPCIÓN (Introduce un nº entero):");
        Scanner scanner = new Scanner(System.in);
        int opcion = Integer.parseInt(scanner.nextLine());

        // Conmutador/Switch necesario para realizar la selección de la opción deseada
        // En cada opción se procede a llamar la función necesaria mediante 'bancoObj.' y nombre función + ()
        switch (opcion) {
            case 1:
                System.out.println("INTRODUCIR DATOS DE UN NUEVO CLIENTE: \n ");
                System.out.println("Inserta su nombre (Texto): \n ");
                String nombreIntroducido = scanner.nextLine();
                System.out.println("Inserta su apellido (Texto): \n ");
                String apellidoIntroducido = scanner.nextLine();
                System.out.println("Introduce su 'email' (Texto): \n ");
                String emailIntroducido = scanner.nextLine();
                System.out.println("Introduce su edad (Nº Entero): \n ");
                int edadIntroducida = scanner.nextInt();
                customerMethodsObj.crearNuevoCliente(nombreIntroducido, apellidoIntroducido, emailIntroducido, edadIntroducida);
                loadMainMenu();
                break;
            case 2:
                System.out.println("LISTA DE CLIENTES REGISTRADOS EN NUESTRA APLICACIÓN:");
                customerMethodsObj.imprimirListaClientes();
                loadMainMenu();
                break;
            case 3:
                System.out.println("MOSTRAR DATOS DEL CLIENTE");
                System.out.println("Introduce el número de ID del cliente a buscar: \n ");
                int idClienteIntroducido = scanner.nextInt();
                customerMethodsObj.mostrarDatosCliente(idClienteIntroducido);
                loadMainMenu();
                break;
            case 4:
                System.out.println("ACTUALIZAR CLIENTE");
                System.out.println("Introduzca el número de ID del cliente a actualizar (Nº Entero): \n ");
                int idClienteIntroducido1 = scanner.nextInt();
                if (customerMethodsObj.existeElCliente(idClienteIntroducido1)) {
                    System.out.println("Introduce su nuevo nombre: \n ");
                    String nombreIntroducido1 = scanner.nextLine();
                    System.out.println("Introduce su nuevo apellido: \n ");
                    String apellidoIntroducido1 = scanner.nextLine();
                    System.out.println("Introduce su nuevo 'email': \n ");
                    String emailIntroducido1 = scanner.nextLine();
                    System.out.println("Introduce su edad actual (Nº Entero): \n ");
                    int edadActual = scanner.nextInt();

                    customerMethodsObj.actualizarDatosCliente(idClienteIntroducido1, nombreIntroducido1, apellidoIntroducido1,
                            emailIntroducido1, edadActual);
                }
                loadMainMenu();
                break;
            case 5:
                System.out.println("ELIMINAR CLIENTE");
                System.out.println("Introduce el número ID del cliente (Nº Entero): \n ");
                int idClienteEliminar = scanner.nextInt();
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
