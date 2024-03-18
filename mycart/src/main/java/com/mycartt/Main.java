package com.mycartt;


import java.util.Scanner;

import Management.CategoryManagement;
import Management.CustomerManagement;
import Management.OrderEntityManagement;
import Management.OrderItemManagement;
import Management.ProductManagement;
import Management.UserManagement;

public class Main {

    public static void main(String[] args) {
    	
    	Scanner sc= new Scanner(System.in);
    	 try {
             while (true) {
                 displayMenu();
                 
                 int choice = sc.nextInt();
                 switch (choice) {
                 case 1:
                	 
                	 UserManagement userManagement = new UserManagement();
                     userManagement.manageUsers();
                	 
                 case 2:
                	  CustomerManagement customerManagement=new CustomerManagement();
           	          customerManagement.manageCustomers();
                	  
                 case 3:
                	 
                	 ProductManagement productmanagement=new ProductManagement();
                     productmanagement.manageProducts();
                	 
                 case 4:
                	 
                	 OrderItemManagement orderitemmanagement=new OrderItemManagement();
          	         orderitemmanagement.manageOrderItems();
                	 
                 case 5:
                	 
                	  OrderEntityManagement orderentitymanagement =new OrderEntityManagement();
           	          orderentitymanagement.manageOrders();
                	  
                 case 6:
                	 CategoryManagement categorymanagement=new CategoryManagement();
                     categorymanagement.manageCategories(); 
                	 
                 default:
                     System.out.println("Invalid choice. Please try again.");
                 }
             }
         } finally {
             sc.close();
         }
     }

  private static void displayMenu() {
    	        System.out.println("1. Add use details");
    	        System.out.println("2. Add customer details");
    	        System.out.println("3. Add product details");
    	        System.out.println("4. Add orderitem details");
    	        System.out.println("5. Add order details");
    	        System.out.println("6. Add category details");  
    	        System.out.println("Ente your choise :");
    }
}

