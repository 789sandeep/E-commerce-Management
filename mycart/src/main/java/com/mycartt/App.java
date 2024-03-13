package com.mycartt;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class App 
{
    public static void main( String[] args )
    {
    	
    	System.out.println( "Hello World!" );
        // Initialize EntityManagerFactory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Ecommersemanagement");

        // Initialize EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Begin transaction
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        User user=new User();
        
        user.setUserName("akash");
        user.setUserEmail("akash@gmail.com");
        user.setUserPassword("aksh@19");
        user.setUserPhone("232994223");
        user.setAddress("indor");
        
        
        Customer cus=new Customer();
        cus.setName("jyant");
        
        OrderEntity ord=new OrderEntity();
        ord.setUser(user);
        
        
        Category ct=new Category();
        ct.setName("Dell");
        
        Product pr=new Product();
        pr.setCategory(ct);
        pr.setpDescription("i5 dell inspiron13 5000 laptop");
        pr.setpDiscount(10);
        pr.setpPrice(65000);
        pr.setpQuantity(1);
       
        OrderItem ordi=new OrderItem();
        ordi.setOrder(ord);
        ordi.setProduct(pr);
        ordi.setQuantity(1);
  
        
        entityManager.persist(user);
        entityManager.persist(cus);
        entityManager.persist(ord);
        entityManager.persist(ct);
        entityManager.persist(pr);
        entityManager.persist(ordi);
        
       
    
    
        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
        
        
     
    }
}
