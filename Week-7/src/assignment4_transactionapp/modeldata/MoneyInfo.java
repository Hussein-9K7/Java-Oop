package modeldata;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "currency")
public class MoneyInfo {
    @Id
    private String abbreviation;

    private String name;
    private double rate;

    public MoneyInfo() {}

    public MoneyInfo(String abbreviation, String name, double rate) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.rate = rate;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
