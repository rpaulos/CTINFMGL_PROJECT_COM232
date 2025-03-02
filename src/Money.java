import javafx.beans.property.SimpleStringProperty;

public class Money {
    
    private final SimpleStringProperty currency;

    public Money(String acurrency) {
        this.currency = new SimpleStringProperty(acurrency);
            
    }

    public String getCurrency() {
        return currency.get();
    }
}
