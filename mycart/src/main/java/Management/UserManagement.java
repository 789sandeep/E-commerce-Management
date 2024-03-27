package Management;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mycartt.User;

import Daoclasses.UserDAO;

class InvalidEmailException extends Exception {
    public InvalidEmailException(String email) {
        super("The email '" + email + "' is invalid.");
    }
}

class InvalidMobileNumberException extends Exception {
    public InvalidMobileNumberException(String number) {
        super("The mobile number '" + number + "' is invalid.");
    }
}

public class UserManagement {
	
	public static boolean isValidEmail(String email) {
        // Regular expression pattern for email validation
        String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
	
	
	
    private Daoclasses.UserDAO userDAO;

    public UserManagement() {
        this.userDAO = new UserDAO();
    }

    public void manageUsers() throws InvalidEmailException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add User");
            System.out.println("2. Get User by ID");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. Exit");
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
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addUser(Scanner scanner) throws InvalidEmailException {
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
        
        try {
            if (isValidEmail(email)) {
            	user.setUserEmail(email);
            } else {
                throw new InvalidEmailException(email);
            }
        } catch (InvalidEmailException e) {
            System.out.println(e.getMessage());
        }
        
        user.setUserPassword(password);
        user.setUserPhone(phone);
        user.setAddress(address);
        userDAO.addUser(user);
        System.out.println("User added successfully.");
    }

    private void getUserById(Scanner scanner) {
        System.out.print("Enter user ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); 

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
        scanner.nextLine(); 

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
            
            try {
                if (isValidEmail(newEmail)) {
                	user.setUserEmail(newEmail);
                } else {
                    throw new InvalidEmailException(newEmail);
                }
            } catch (InvalidEmailException e) {
                System.out.println(e.getMessage());
            }
            user.setUserName(newName);
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
}


