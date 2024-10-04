package com.kevinzamora;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    /* En la clase Principal definimos y construimos la estructura del menú de
    navegación de nuestra aplicación */
    /* A su vez, también instanciamos la clase Customer para poder hacer uso de las
    funciones/métodos, creados para gestionar los diferentes clientes/usuarios de nuestra
    aplicación */

    // 2. ArrayList de objetos Customer
    ArrayList<Customer> customers = new ArrayList<>();
    Customer c1 = new Customer(1, "Kevin", "Zamora", "admin1@gmail.com", 27);
    Customer c2 = new Customer(2, "Alan", "Sastre", "admin2@gmail.com", 30);
    Customer c3 = new Customer(3, "Javi", "", "usuario1@gmail.com", 0);
    Customer c4 = new Customer(4, "Maria", "", "usuario2@gmail.com", 0);

    // imprimir menu
    // Estructura de nuestro menú principal imprimido por pantalla
    public void loadMainMenu() {

        System.out.println("BIENVENID@S A NUESTRO BANCO: \n");
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
                System.out.println("INTRODUCIR DATOS DE UN NUEVO CLIENTE: \n");

                loadMainMenu();
                break;
            case 2:
                System.out.println("LISTA DE CLIENTES REGISTRADOS EN NUESTRA APLICACIÓN:");

                loadMainMenu();
                break;
            case 3:
                System.out.println("MOSTRAR DATOS DEL CLIENTE");

                loadMainMenu();
                break;
            case 4:
                System.out.println("ACTUALIZAR CLIENTE");

                loadMainMenu();
                break;
            case 5:
                System.out.println("ELIMINAR CLIENTE");

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
