package assignment3_jpacurrencyconverter.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "currency")
public class Currency {
    @Id
    private String abbreviation;
    private String name;
    private double rateToUsd;

    public Currency() {
    }

    public Currency(String abbreviation, String name, double rateToUsd) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.rateToUsd = rateToUsd;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getName() {
        return name;
    }

    public double getRateToUsd() {
        return rateToUsd;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRateToUsd(double rateToUsd) {
        this.rateToUsd = rateToUsd;
    }
}
