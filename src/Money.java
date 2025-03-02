import javafx.beans.property.SimpleStringProperty;

public class Money {
    
    private final SimpleStringProperty currency;
    private final SimpleStringProperty conversion_rate;

    public Money(String acurrency, String aconversion_rate) {
        this.currency = new SimpleStringProperty(acurrency);
        this.conversion_rate = new SimpleStringProperty(aconversion_rate);
            
    }

    public String getCurrency() {
        return currency.get();
    }

    public String getConversion_rate() {
        return conversion_rate.get();
    }
}
