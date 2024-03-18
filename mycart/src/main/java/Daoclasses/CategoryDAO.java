package Daoclasses;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.mycartt.Category;

import utility.HibernateUtil;

public class CategoryDAO {

    public void addCategory(Category category) {
        EntityManager entityManager = HibernateUtil.provideConnection();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(category);
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

    public Category getCategoryById(long categoryId) {
        EntityManager entityManager = HibernateUtil.provideConnection();
        try {
            return entityManager.find(Category.class, categoryId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }

    public void updateCategory(Category category) {
        EntityManager entityManager = HibernateUtil.provideConnection();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(category);
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

    public void deleteCategory(Long categoryId) {
        EntityManager entityManager = HibernateUtil.provideConnection();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            Category category = entityManager.find(Category.class, categoryId);
            if (category != null) {
                entityManager.remove(category);
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
}
