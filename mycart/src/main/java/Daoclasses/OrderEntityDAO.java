package Daoclasses;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.mycartt.OrderEntity;

import utility.HibernateUtil;

public class OrderEntityDAO {

    public void addOrderEntity(OrderEntity orderEntity) {
        EntityManager entityManager = HibernateUtil.provideConnection();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(orderEntity);
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

    public OrderEntity getOrderEntityById(int orderId) {
        EntityManager entityManager = HibernateUtil.provideConnection();
        try {
            return entityManager.find(OrderEntity.class, orderId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }

    public void updateOrderEntity(OrderEntity orderEntity) {
        EntityManager entityManager = HibernateUtil.provideConnection();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(orderEntity);
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

    public void deleteOrderEntity(int orderId) {
        EntityManager entityManager = HibernateUtil.provideConnection();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            OrderEntity orderEntity = entityManager.find(OrderEntity.class, orderId);
            if (orderEntity != null) {
                entityManager.remove(orderEntity);
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

    public List<OrderEntity> getAllOrderEntities() {
        EntityManager entityManager = HibernateUtil.provideConnection();
        try {
            Query query = entityManager.createQuery("SELECT o FROM OrderEntity o");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }
}

