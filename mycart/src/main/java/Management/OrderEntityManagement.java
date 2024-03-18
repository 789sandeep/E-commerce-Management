package Management;


import java.util.List;
import java.util.Scanner;

import com.mycartt.Customer;
import com.mycartt.OrderEntity;
import com.mycartt.User;

import Daoclasses.CustomerDAO;
import Daoclasses.OrderEntityDAO;
import Daoclasses.UserDAO;

public class OrderEntityManagement {
    private OrderEntityDAO orderEntityDAO;
    private UserDAO userDAO;
    private CustomerDAO customerDAO;

    public OrderEntityManagement() {
        this.orderEntityDAO = new OrderEntityDAO();
        this.userDAO = new UserDAO();
        this.customerDAO = new CustomerDAO();
    }

    public void manageOrders() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Order");
            System.out.println("2. Get Order by ID");
            System.out.println("3. Update Order");
            System.out.println("4. Delete Order");
            System.out.println("5. List All Orders");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addOrder(scanner);
                    break;
                case 2:
                    getOrderById(scanner);
                    break;
                case 3:
                    updateOrder(scanner);
                    break;
                case 4:
                    deleteOrder(scanner);
                    break;
                case 5:
                    listAllOrders();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addOrder(Scanner scanner) {
        System.out.println("Enter user ID for the order: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.println("Enter customer ID for the order: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Retrieve user and customer entities
        User user = userDAO.getUserById(userId);
        if (user == null) {
            System.out.println("User with ID " + userId + " does not exist.");
            return;
        }

        Customer customer = customerDAO.getCustomerById(customerId);
        if (customer == null) {
            System.out.println("Customer with ID " + customerId + " does not exist.");
            return;
        }

        // Create the order entity
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setUser(user);
        orderEntity.setCustomer(customer);
        // Add logic to set other attributes of the order entity
        
        // Persist the order entity
        orderEntityDAO.addOrderEntity(orderEntity);
        System.out.println("Order added successfully.");
    }

    private void getOrderById(Scanner scanner) {
        System.out.print("Enter order ID: ");
        int orderId = scanner.nextInt();
        scanner.nextLine(); // consume newline

        OrderEntity orderEntity = orderEntityDAO.getOrderEntityById(orderId);
        if (orderEntity != null) {
            displayOrderDetails(orderEntity);
        } else {
            System.out.println("Order not found.");
        }
    }

    private void updateOrder(Scanner scanner) {
        System.out.print("Enter order ID: ");
        int orderId = scanner.nextInt();
        scanner.nextLine(); // consume newline

        OrderEntity orderEntity = orderEntityDAO.getOrderEntityById(orderId);
        if (orderEntity != null) {
            // Add logic to update attributes of the order entity
            orderEntityDAO.updateOrderEntity(orderEntity);
            System.out.println("Order updated successfully.");
        } else {
            System.out.println("Order not found.");
        }
    }

    private void deleteOrder(Scanner scanner) {
        System.out.print("Enter order ID: ");
        int orderId = scanner.nextInt();
        scanner.nextLine(); // consume newline

        orderEntityDAO.deleteOrderEntity(orderId);
        System.out.println("Order deleted successfully.");
    }

    private void listAllOrders() {
        List<OrderEntity> orders = orderEntityDAO.getAllOrderEntities();
        if (orders != null) {
            for (OrderEntity orderEntity : orders) {
                displayOrderDetails(orderEntity);
            }
        } else {
            System.out.println("No orders found.");
        }
    }

    private void displayOrderDetails(OrderEntity orderEntity) {
        System.out.println("Order ID: " + orderEntity.getOrderId());
        System.out.println("User ID: " + orderEntity.getUser().getUserId());
        System.out.println("Customer ID: " + orderEntity.getCustomer().getCustomerId());
        // Add logic to display other attributes of the order entity
    }
}
