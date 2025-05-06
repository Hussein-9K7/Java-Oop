package dbsetup;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaConnection {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("currencyPU");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
