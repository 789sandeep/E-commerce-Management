package Daoclasses;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.mycartt.OrderItem;
import com.mycartt.Product;

import utility.HibernateUtil;
import java.util.List;

public class OrderItemDAO {

    public void addOrderItem(OrderItem orderItem) {
        EntityManager entityManager = HibernateUtil.provideConnection();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(orderItem);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public OrderItem getOrderItemById(int itemId) {
        EntityManager entityManager = HibernateUtil.provideConnection();
        try {
            return entityManager.find(OrderItem.class, itemId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }

    public void updateOrderItem(OrderItem orderItem) {
        EntityManager entityManager = HibernateUtil.provideConnection();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(orderItem);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public void deleteOrderItem(int itemId) {
        EntityManager entityManager = HibernateUtil.provideConnection();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            OrderItem orderItem = entityManager.find(OrderItem.class, itemId);
            if (orderItem != null) {
                entityManager.remove(orderItem);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public List<OrderItem> getAllOrderItems() {
        EntityManager entityManager = HibernateUtil.provideConnection();
        try {
            Query query = entityManager.createQuery("SELECT oi FROM OrderItem oi");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }
    
    public Product getProductById(int itemId) {
        EntityManager entityManager = HibernateUtil.provideConnection();
        try {
            // Retrieve the OrderItem entity by its ID
            OrderItem orderItem = entityManager.find(OrderItem.class, itemId);
            
            // Check if the OrderItem exists
            if (orderItem != null) {
                // Access the associated Product entity
                return orderItem.getProduct();
            } else {
                System.out.println("OrderItem with ID " + itemId + " not found.");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }
}

