package logic;

import modeldata.ExchangeRecord;
import modeldata.MoneyInfo;
import savehelper.TransactionSaver;

import jakarta.persistence.EntityManager;
import dbsetup.JpaConnection;

public class CurrencyLogic {

    public double convert(double amount, String fromAbbr, String toAbbr) {
        EntityManager em = JpaConnection.getEntityManager();

        try {
            MoneyInfo from = em.find(MoneyInfo.class, fromAbbr);
            MoneyInfo to = em.find(MoneyInfo.class, toAbbr);

            if (from == null || to == null) {
                return -1;
            }

            double amountInUsd = amount / from.getRate();
            double result = amountInUsd * to.getRate();

            ExchangeRecord record = new ExchangeRecord(amount, from, to);
            new TransactionSaver().saveTransaction(record);

            return result;
        } finally {
            em.close();
        }
    }
}
