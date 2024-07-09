package Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerRegister {

    public class Cliente {
        private String idCustomer;
        private String name;
        private String address;
        private String email;
        private String phoneNumber;
        private String password;

        public Cliente(String idCustomer, String name, String address, String email, String phoneNumber, String password) {
            this.idCustomer = idCustomer;
            this.name = name;
            this.address = address;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.password = password;
        }

        public String getIdCustomer() {
            return idCustomer;
        }

        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }

        public String getEmail() {
            return email;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public String getPassword() {
            return password;
        }
    }

    private List<Cliente> clientes;

    public CustomerRegister() {
        this.clientes = new ArrayList<>();
    }

    public void addCustomer(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente findCustomerById(String idCustomer) {
        for (Cliente cliente : clientes) {
            if (cliente.getIdCustomer().equals(idCustomer)) {
                return cliente;
            }
        }
        return null;
    }

    public List<Cliente> getAllCustomers() {
        return new ArrayList<>(clientes);
    }

    public static void main(String[] args) {
        CustomerRegister register = new CustomerRegister();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al registro de clientes.");
        System.out.println("Por favor, ingrese sus datos:");

        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        System.out.print("Dirección: ");
        String address = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Número de teléfono: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Contraseña: ");
        String password = scanner.nextLine();

        CustomerRegister.Cliente cliente = register.new Cliente(id, name, address, email, phoneNumber, password);
        register.addCustomer(cliente);

        System.out.println("¡Registro completado con éxito!");

        System.out.println("Gracias por registrarse. Aquí están sus detalles:");
        System.out.println("ID: " + cliente.getIdCustomer());
        System.out.println("Nombre: " + cliente.getName());
        System.out.println("Dirección: " + cliente.getAddress());
        System.out.println("Email: " + cliente.getEmail());
        System.out.println("Número de teléfono: " + cliente.getPhoneNumber());
        System.out.println("Contraseña: " + cliente.getPassword());

        scanner.close();
    }
}