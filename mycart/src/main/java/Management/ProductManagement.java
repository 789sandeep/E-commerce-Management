package Management;

import java.util.List;
import java.util.Scanner;

import com.mycartt.Product;

import Daoclasses.ProductDAO;

public class ProductManagement {
    private ProductDAO productDAO;

    public ProductManagement() {
        this.productDAO = new ProductDAO();
    }

    public void manageProducts() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Product");
            System.out.println("2. Get Product by ID");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. List All Products");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addProduct(scanner);
                    break;
                case 2:
                    getProductById(scanner);
                    break;
                case 3:
                    updateProduct(scanner);
                    break;
                case 4:
                    deleteProduct(scanner);
                    break;
                case 5:
                    listAllProducts();
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

    private void addProduct(Scanner scanner) {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter product discount: ");
        double discount = scanner.nextDouble();

        Product product = new Product();
        product.setPname(name);
        product.setPprice(price);
        product.setPdiscount(discount);
        productDAO.addProduct(product);
        System.out.println("Product added successfully.");
    }

    private void getProductById(Scanner scanner) {
        System.out.print("Enter product ID: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Product product = productDAO.getProductById(productId);
        if (product != null) {
            System.out.println("Product: " + product);
        } else {
            System.out.println("Product not found.");
        }
    }

    private void updateProduct(Scanner scanner) {
        System.out.print("Enter product ID: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Product product = productDAO.getProductById(productId);
        if (product != null) {
            System.out.print("Enter new product name: ");
            String newName = scanner.nextLine();
            System.out.print("Enter new product price: ");
            double newPrice = scanner.nextDouble();
            System.out.print("Enter new product discount: ");
            double newDiscount = scanner.nextDouble();

            product.setPname(newName);
            product.setPprice(newPrice);
            product.setPdiscount(newDiscount);

            productDAO.updateProduct(product);
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    private void deleteProduct(Scanner scanner) {
        System.out.print("Enter product ID: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // consume newline

        productDAO.deleteProduct(productId);
        System.out.println("Product deleted successfully.");
    }

    private void listAllProducts() {
        List<Product> products = productDAO.getAllProducts();
        if (products.isEmpty()) {
            System.out.println("No products found.");
        } else {
            System.out.println("List of Products:");
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }
}

