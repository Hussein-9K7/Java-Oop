package assignment3_jpacurrencyconverter.dao;

import assignment3_jpacurrencyconverter.datasource.JpaUtil;
import assignment3_jpacurrencyconverter.entity.Currency;
import jakarta.persistence.EntityManager;

public class CurrencyDao {
    public Currency findByAbbreviation(String abbreviation) {
        EntityManager em = JpaUtil.getEntityManager();
        Currency currency = null;

        try {
            currency = em.find(Currency.class, abbreviation);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            em.close();
        }

        return currency;
    }

    public void insertCurrency(Currency currency) {
        EntityManager em = JpaUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(currency);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Insert error: " + e.getMessage());
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
    }
}
