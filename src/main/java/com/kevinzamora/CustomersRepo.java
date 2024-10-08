package com.kevinzamora;

import java.util.ArrayList;
import java.util.Optional;

public class CustomersRepo {

    // 2. ArrayList de objetos Customer
    public ArrayList<Customer> customers = new ArrayList<>();

    public void initializeDB() {
        Customer c1 = new Customer(Long.valueOf(1), "Kevin", "Zamora", "admin1@gmail.com", 27);
        Customer c2 = new Customer(Long.valueOf(2), "Alan", "Sastre", "admin2@gmail.com", 30);
        Customer c3 = new Customer(Long.valueOf(3), "Javi", "", "usuario1@gmail.com", 0);
        Customer c4 = new Customer(Long.valueOf(4), "Maria", "", "usuario2@gmail.com", 0);
        customers.add(c1); customers.add(c2); customers.add(c3); customers.add(c4);
    }

    public void showCustomerList() {
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
        System.out.println("\n");
    }

    public void showCustomerData(Long introducedId) {
        boolean encounteredCustomer = false;
        Optional<Customer> cliente = customers.stream()
                .filter(customer -> customer.getId().equals(introducedId))
                .findFirst();
        if(cliente.isPresent())
            encounteredCustomer = true;
        if (encounteredCustomer) {
            System.out.println("Se ha encontrado el cliente con éxito");
        } else {
            System.out.println("El cliente con el número de ID introducido NO éxiste en nuestra base de datos");
        }
    }

    public void createNewCustomer(String nombre, String apellido, String email, int edad) {
        int ultimoId = customers.size() - 1;
        Long nuevoId = Long.valueOf(ultimoId + 1);
        Customer nuevoCliente = new Customer(nuevoId, nombre, apellido, email, edad);
        save(nuevoCliente);
        if (customers.size() > nuevoId) {
            System.out.println("El nuevo cliente ha sido guardado con éxito.");
        } else {
            System.out.println("Ha ocurrido un error durante el guardado del nuevo cliente. Por favor, inténtelo más tarde.");
        }
    }

    public boolean save(Customer customer) {
        try {
            return customers.add(customer);
        } catch (Exception e) {
            return false;
        }
    }

    public Optional<Customer> findCustomerById(Long id) {
        return customers.stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst();
    }

//    public void actualizarDatosCliente(Long id, String nombre, String apellido, String email, int edad) {
//        Customer cliente = encontrarClientePorId(id).orElse(null);
//        boolean nombreActualizado = false; boolean apellidoActualizado = false;
//        boolean edadActualizada = false; boolean emailActualizado = false;
//        if (cliente == null)
//            return;
//
//        if (nombre != null
//                && nombre.length() < 50) {
//            cliente.setNombre(nombre);
//            nombreActualizado = true;
//        }
//
//        if (apellido != null
//                && apellido.length() < 50) {
//            cliente.setApellido(apellido);
//            apellidoActualizado = true;
//        }
//
//        if (edad >= 18 && edad <= 110) {
//            cliente.setEdad(edad);
//            edadActualizada = true;
//        }
//
//        if (email != null
//                && email.contains("@")
//                && email.contains(".")) {
//            cliente.setEmail(email);
//            emailActualizado = true;
//        }
//
//        if (nombreActualizado && apellidoActualizado && edadActualizada && emailActualizado) {
//            System.out.println("El cliente se ha actualizado con éxito.");
//        } else {
//            System.out.println("No existe ningún usuario con el número de ID introducido");
//        }
//    }

    // update con RESTRICCIONES
    public void updateCustomer(Long id, Customer customer) {
        Customer cliente = findCustomerById(id).orElse(null);
        if (cliente == null)
            return;

        if (customer.getNombre() != null
                && customer.getNombre().length() < 50)
            cliente.setNombre(customer.getNombre());


        if (customer.getApellido() != null
                && customer.getApellido().length() < 50) {
            cliente.setApellido(customer.getApellido());
        }

        if (customer.getEdad() >= 18 && customer.getEdad() <= 110) {
            cliente.setEdad(customer.getEdad());
        }
        if (customer.getEmail() != null
                && customer.getEmail().contains("@")
                && customer.getEmail().contains(".")) {
            cliente.setEmail(customer.getEmail());
        }
    }

    public boolean removeCustomer(Long id) {
        return customers
                .removeIf(c -> c.getId().equals(id));
    }

    public void removeAllCustomers() {
        customers.clear();
    }

}
