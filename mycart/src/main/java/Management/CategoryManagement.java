package Management;

import java.util.Scanner;

import com.mycartt.Category;

import Daoclasses.CategoryDAO;

public class CategoryManagement {
    private CategoryDAO categoryDAO;

    public CategoryManagement() {
        this.categoryDAO = new CategoryDAO();
    }

    public void manageCategories() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Category");
            System.out.println("2. Get Category by ID");
            System.out.println("3. Update Category");
            System.out.println("4. Delete Category");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addCategory(scanner);
                    break;
                case 2:
                    getCategoryById(scanner);
                    break;
                case 3:
                    updateCategory(scanner);
                    break;
                case 4:
                    deleteCategory(scanner);
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

    private void addCategory(Scanner scanner) {
        System.out.print("Enter category name: ");
        String name = scanner.nextLine();

        Category category = new Category();
        category.setName(name);

        categoryDAO.addCategory(category);
        System.out.println("Category added successfully.");
    }

    private void getCategoryById(Scanner scanner) {
        System.out.print("Enter category ID: ");
        long categoryId = scanner.nextLong();
        scanner.nextLine(); // consume newline

        Category category = categoryDAO.getCategoryById(categoryId);
        if (category != null) {
            System.out.println("Category: " + category.getName());
        } else {
            System.out.println("Category not found.");
        }
    }

    private void updateCategory(Scanner scanner) {
        System.out.print("Enter category ID: ");
        long categoryId = scanner.nextLong();
        scanner.nextLine(); // consume newline

        Category category = categoryDAO.getCategoryById(categoryId);
        if (category != null) {
            System.out.print("Enter new category name: ");
            String newName = scanner.nextLine();
            category.setName(newName);
            categoryDAO.updateCategory(category);
            System.out.println("Category updated successfully.");
        } else {
            System.out.println("Category not found.");
        }
    }

    private void deleteCategory(Scanner scanner) {
        System.out.print("Enter category ID: ");
        long categoryId = scanner.nextLong();
        scanner.nextLine(); // consume newline

        categoryDAO.deleteCategory(categoryId);
        System.out.println("Category deleted successfully.");
    }
}
