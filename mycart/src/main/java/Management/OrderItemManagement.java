package Management;


import java.util.List;
import java.util.Scanner;

import com.mycartt.OrderEntity;
import com.mycartt.OrderItem;
import com.mycartt.Product;

import Daoclasses.OrderEntityDAO;
import Daoclasses.OrderItemDAO;
import Daoclasses.ProductDAO;

public class OrderItemManagement {
    private OrderItemDAO orderItemDAO;
    private OrderEntityDAO orderEntityDAO;
    private ProductDAO productDAO;
    private Scanner scanner;

    public OrderItemManagement() {
        this.orderItemDAO = new OrderItemDAO();
        this.orderEntityDAO = new OrderEntityDAO();
        this.productDAO = new ProductDAO();
        this.scanner = new Scanner(System.in);
    }

    public void manageOrderItems() {
        try {
            while (true) {
                displayMenu();
                int choice = getUserChoice();
                switch (choice) {
                    case 1:
                        addOrderItem();
                        break;
                    case 2:
                        getOrderItemById();
                        break;
                    case 3:
                        updateOrderItem();
                        break;
                    case 4:
                        deleteOrderItem();
                        break;
                    case 5:
                        listAllOrderItems();
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } finally {
            scanner.close();
        }
    }

    private void displayMenu() {
        System.out.println("1. Add Order Item");
        System.out.println("2. Get Order Item by ID");
        System.out.println("3. Update Order Item");
        System.out.println("4. Delete Order Item");
        System.out.println("5. List All Order Items");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private int getUserChoice() {
        return scanner.nextInt();
    }

    private void addOrderItem() {
        System.out.print("Enter Order ID: ");
        int orderId = scanner.nextInt();
        System.out.print("Enter Product ID: ");
        int productId = scanner.nextInt();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        
        Product product = productDAO.getProductById(productId);
        if (product == null) {
            System.out.println("Product with ID " + productId + " does not exist.");
            return;
        }

        OrderEntity orderEntity = orderEntityDAO.getOrderEntityById(orderId);
        if (orderEntity == null) {
            System.out.println("Order with ID " + orderId + " does not exist.");
            return;
        }
        
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setOrder(orderEntity);
        orderItem.setQuantity(quantity);

        orderItemDAO.addOrderItem(orderItem);
        System.out.println("Order Item added successfully.");
    }

    private void getOrderItemById() {
        System.out.print("Enter Order Item ID: ");
        int itemId = scanner.nextInt();
        OrderItem orderItem = orderItemDAO.getOrderItemById(itemId);
        if (orderItem != null) {
            System.out.println("Order Item: " + orderItem);
        } else {
            System.out.println("Order Item not found.");
        }
    }

    private void updateOrderItem() {
        System.out.print("Enter Order Item ID: ");
        int itemId = scanner.nextInt();
        OrderItem orderItem = orderItemDAO.getOrderItemById(itemId);
        if (orderItem != null) {
            System.out.print("Enter new Quantity: ");
            int newQuantity = scanner.nextInt();
            orderItem.setQuantity(newQuantity);
            orderItemDAO.updateOrderItem(orderItem);
            System.out.println("Order Item updated successfully.");
        } else {
            System.out.println("Order Item not found.");
        }
    }

    private void deleteOrderItem() {
        System.out.print("Enter Order Item ID: ");
        int itemId = scanner.nextInt();
        orderItemDAO.deleteOrderItem(itemId);
        System.out.println("Order Item deleted successfully.");
    }

    private void listAllOrderItems() {
        List<OrderItem> orderItems = orderItemDAO.getAllOrderItems();
        if (orderItems.isEmpty()) {
            System.out.println("No order items found.");
        } else {
            System.out.println("List of Order Items:");
            for (OrderItem orderItem : orderItems) {
                System.out.println(orderItem);
            }
        }
    }
}

