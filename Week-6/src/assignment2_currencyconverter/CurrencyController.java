package assignment2_currencyconverter;

import java.util.List;

public class CurrencyController {
    private CurrencyModel model;

    public CurrencyController() {
        model = new CurrencyModel();
    }

    public List<Currency> getCurrencies() {
        return model.getCurrencies();
    }

    public double convert(double amount, Currency from, Currency to) {
        return model.convert(amount, from, to);
    }
}
