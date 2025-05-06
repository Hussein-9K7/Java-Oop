package assignment3_jpacurrencyconverter.controller;

import assignment3_jpacurrencyconverter.dao.CurrencyDao;
import assignment3_jpacurrencyconverter.entity.Currency;

public class CurrencyController {
    private CurrencyDao dao;

    public CurrencyController() {
        dao = new CurrencyDao();
    }

    public double convert(double amount, String fromAbbr, String toAbbr) {
        Currency from = dao.findByAbbreviation(fromAbbr);
        Currency to = dao.findByAbbreviation(toAbbr);

        if (from == null || to == null) {
            return -1;
        }

        double amountInUSD = amount / from.getRateToUsd();
        return amountInUSD * to.getRateToUsd();
    }

    public boolean addCurrency(String abbr, String name, double rate) {
        if (abbr == null || name == null || rate <= 0) {
            return false;
        }

        Currency newCurrency = new Currency(abbr, name, rate);
        dao.insertCurrency(newCurrency);
        return true;
    }
}
