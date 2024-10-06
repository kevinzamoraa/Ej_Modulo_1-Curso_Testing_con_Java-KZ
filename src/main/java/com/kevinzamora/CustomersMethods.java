package com.kevinzamora;

import java.util.ArrayList;

public class CustomersMethods {

    // 2. ArrayList de objetos Customer
    public ArrayList<Customer> customers = new ArrayList<>();

    public void inicializarBD() {
        Customer c1 = new Customer(1, "Kevin", "Zamora", "admin1@gmail.com", 27);
        Customer c2 = new Customer(2, "Alan", "Sastre", "admin2@gmail.com", 30);
        Customer c3 = new Customer(3, "Javi", "", "usuario1@gmail.com", 0);
        Customer c4 = new Customer(4, "Maria", "", "usuario2@gmail.com", 0);
        customers.add(c1); customers.add(c2); customers.add(c3); customers.add(c4);
    }

    public void imprimirListaClientes() {
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
        System.out.println("\n");
    }

    public void mostrarDatosCliente(int introducedId) {
        boolean encounteredCustomer = false;
        for (Customer customer : customers) {
            if (customer.getId() == introducedId) {
                System.out.println("Los datos del cliente buscado son los siguientes: \n" + customer.toString());
                encounteredCustomer = true;
            } else { encounteredCustomer = false; }
        }
        if (encounteredCustomer) {
            System.out.println("Se ha encontrado el cliente con éxito");
        } else {
            System.out.println("El cliente con el número de ID introducido NO éxiste en nuestra base de datos");
        }
    }

    public void crearNuevoCliente(String nombre, String apellido, String email, int edad) {
        int nuevoId = customers.size();
        Customer nuevoCliente = new Customer(nuevoId, nombre, apellido, email, edad);
        customers.add(nuevoCliente);
        if (customers.size() > nuevoId) {
            System.out.println("El nuevo cliente ha sido guardado con éxito.");
        } else {
            System.out.println("Ha ocurrido un error durante el guardado del nuevo cliente. Por favor, inténtelo más tarde.");
        }
    }

    public boolean existeElCliente(int id) {
        boolean existeCliente = false;
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                System.out.println("Se ha encontrado una coincidencia.");
                return existeCliente = true;
            } else {
                System.out.println("No existe ningún usuario con el número de ID introducido");
                return false;
            }
        }
        return false;
    }

    public void actualizarDatosCliente(int id, String nombre, String apellido, String email, int edad) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                customer.setNombre(nombre);
                customer.setApellido(apellido);
                customer.setEmail(email);
                customer.setEdad(edad);
                System.out.println("El cliente se ha actualizado con éxito.");
            } else {
                System.out.println("No existe ningún usuario con el número de ID introducido");
            }
        }
    }

    public void eliminarCliente(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                customers.remove(customer);
                System.out.println("El cliente ha sido borrado con éxito.");
            } else {
                System.out.println("El número de ID introducido no existe en nuestra base de datos");
            }
        }
    }

}
