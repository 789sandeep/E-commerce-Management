package utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
    private static EntityManagerFactory emf = null;

    static {
        emf = Persistence.createEntityManagerFactory("Ecommersemanagement");
    }

    public static EntityManager provideConnection() {
        return emf.createEntityManager();
    }
}

