package assignment2_dbcurrencyconverter.controller;

import assignment2_dbcurrencyconverter.dao.CurrencyDao;

public class CurrencyController {
    private CurrencyDao dao;

    public CurrencyController() {
        dao = new CurrencyDao();
    }

    public double convert(double amount, String fromAbbr, String toAbbr) {
        double fromRate = dao.getRateByAbbreviation(fromAbbr);
        double toRate = dao.getRateByAbbreviation(toAbbr);

        if (fromRate <= 0 || toRate <= 0) {
            return -1;
        }

        double amountInUSD = amount / fromRate;
        return amountInUSD * toRate;
    }
}
