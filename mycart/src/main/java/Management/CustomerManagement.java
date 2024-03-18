package Management;

import java.util.Scanner;

import com.mycartt.Customer;
import com.mycartt.User;

import Daoclasses.CustomerDAO;


import java.util.Scanner;

public class CustomerManagement {
    private CustomerDAO customerDAO;

    public CustomerManagement() {
        this.customerDAO = new CustomerDAO();
    }

    public void manageCustomers() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Customer");
            System.out.println("2. Get Customer by ID");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addCustomer(scanner);
                    break;
                case 2:
                    getCustomerById(scanner);
                    break;
                case 3:
                    updateCustomer(scanner);
                    break;
                case 4:
                    deleteCustomer(scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addCustomer(Scanner scanner) {
        System.out.print("Enter customer name: ");
        String firstName = scanner.nextLine();

        Customer customer = new Customer();
        customer.setName(firstName);

        customerDAO.addCustomer(customer);
        System.out.println("Customer added successfully.");
    }

    private void getCustomerById(Scanner scanner) {
        System.out.print("Enter customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Customer customer = customerDAO.getCustomerById(customerId);
        if (customer != null) {
            System.out.println("Customer: " + customer.getName());
        } else {
            System.out.println("Customer not found.");
        }
    }

    private void updateCustomer(Scanner scanner) {
        System.out.print("Enter customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Customer customer = customerDAO.getCustomerById(customerId);
        if (customer != null) {
            System.out.print("Enter new first name: ");
            String newFirstName = scanner.nextLine();
            System.out.print("Enter new last name: ");
            String newLastName = scanner.nextLine();

            customer.setName(newFirstName);

            customerDAO.updateCustomer(customer);
            System.out.println("Customer updated successfully.");
        } else {
            System.out.println("Customer not found.");
        }
    }

    private void deleteCustomer(Scanner scanner) {
        System.out.print("Enter customer ID: ");
        long customerId = scanner.nextLong();
        scanner.nextLine(); // consume newline

        customerDAO.deleteCustomer(customerId);
        System.out.println("Customer deleted successfully.");
    }
}
