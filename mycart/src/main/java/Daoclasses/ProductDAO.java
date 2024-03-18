package Daoclasses;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.mycartt.Product;

import utility.HibernateUtil;

import javax.persistence.Query;
import java.util.List;

public class ProductDAO {

    public void addProduct(Product product) {
        EntityManager entityManager = HibernateUtil.provideConnection();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(product);
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

    public Product getProductById(int productId) {
        EntityManager entityManager = HibernateUtil.provideConnection();
        try {
            return entityManager.find(Product.class, productId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }

    public void updateProduct(Product product) {
        EntityManager entityManager = HibernateUtil.provideConnection();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(product);
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

    public void deleteProduct(int productId) {
        EntityManager entityManager = HibernateUtil.provideConnection();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            Product product = entityManager.find(Product.class, productId);
            if (product != null) {
                entityManager.remove(product);
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

    public List<Product> getAllProducts() {
        EntityManager entityManager = HibernateUtil.provideConnection();
        try {
            Query query = entityManager.createQuery("SELECT p FROM Product p");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }
}


