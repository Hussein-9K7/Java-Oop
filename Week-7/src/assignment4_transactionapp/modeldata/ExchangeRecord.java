package modeldata;

import jakarta.persistence.*;

@Entity
@Table(name = "transaction")
public class ExchangeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;

    @ManyToOne
    @JoinColumn(name = "source_currency")
    private MoneyInfo source;

    @ManyToOne
    @JoinColumn(name = "destination_currency")
    private MoneyInfo destination;

    public ExchangeRecord() {}

    public ExchangeRecord(double amount, MoneyInfo source, MoneyInfo destination) {
        this.amount = amount;
        this.source = source;
        this.destination = destination;
    }

    public Long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public MoneyInfo getSource() {
        return source;
    }

    public void setSource(MoneyInfo source) {
        this.source = source;
    }

    public MoneyInfo getDestination() {
        return destination;
    }

    public void setDestination(MoneyInfo destination) {
        this.destination = destination;
    }
}
