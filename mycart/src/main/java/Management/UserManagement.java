package Management;

import java.util.List;
import java.util.Scanner;

import com.mycartt.User;

import Daoclasses.UserDAO;


public class UserManagement {

    private Daoclasses.UserDAO userDAO;

    public UserManagement() {
        this.userDAO = new UserDAO();
    }

    public void manageUsers() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add User");
            System.out.println("2. Get User by ID");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. List All Users");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addUser(scanner);
                    break;
                case 2:
                    getUserById(scanner);
                    break;
                case 3:
                    updateUser(scanner);
                    break;
                case 4:
                    deleteUser(scanner);
                    break;
                case 5:
                    listAllUsers();
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

    private void addUser(Scanner scanner) {
        System.out.print("Enter user name: ");
        String name = scanner.nextLine();
        System.out.print("Enter user email: ");
        String email = scanner.nextLine();
        System.out.print("Enter user password: ");
        String password = scanner.nextLine();
        System.out.print("Enter user phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter user address:");
        String address = scanner.nextLine();

        User user = new User();
        user.setUserName(name);
        user.setUserEmail(email);
        user.setUserPassword(password);
        user.setUserPhone(phone);
        user.setAddress(address);
        userDAO.addUser(user);
        System.out.println("User added successfully.");
    }

    private void getUserById(Scanner scanner) {
        System.out.print("Enter user ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // consume newline

        User user = userDAO.getUserById(userId);
        if (user != null) {
            System.out.println("User: " + user);
        } else {
            System.out.println("User not found.");
        }
    }

    private void updateUser(Scanner scanner) {
        System.out.print("Enter user ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // consume newline

        User user = userDAO.getUserById(userId);
        if (user != null) {
            System.out.print("Enter new user name: ");
            String newName = scanner.nextLine();
            System.out.print("Enter new user email: ");
            String newEmail = scanner.nextLine();
            System.out.print("Enter new user password: ");
            String newPassword = scanner.nextLine();
            System.out.print("Enter new user phone: ");
            String newPhone = scanner.nextLine();
            System.out.print("Enter new user address: ");
            String newAddress = scanner.nextLine();

            user.setUserName(newName);
            user.setUserEmail(newEmail);
            user.setUserPassword(newPassword);
            user.setUserPhone(newPhone);
            user.setAddress(newAddress);

            userDAO.updateUser(user);
            System.out.println("User updated successfully.");
        } else {
            System.out.println("User not found.");
        }
    }

    private void deleteUser(Scanner scanner) {
        System.out.print("Enter user ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // consume newline

        userDAO.deleteUser(userId);
        System.out.println("User deleted successfully.");
    }

    private void listAllUsers() {
        List<User> users = userDAO.getAllUsers();
        if (users.isEmpty()) {
            System.out.println("No users found.");
        } else {
            System.out.println("List of Users:");
            for (User user : users) {
                System.out.println(user);
            }
        }
    }
}


