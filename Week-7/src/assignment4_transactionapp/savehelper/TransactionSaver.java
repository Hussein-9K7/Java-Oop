package savehelper;

import dbsetup.JpaConnection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import modeldata.ExchangeRecord;

public class TransactionSaver {

    public void saveTransaction(ExchangeRecord record) {
        EntityManager em = JpaConnection.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(record);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
        } finally {
            em.close();
        }
    }
}
