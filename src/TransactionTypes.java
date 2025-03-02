import javafx.beans.property.SimpleStringProperty;

public class TransactionTypes {
    
    private final SimpleStringProperty transaction_type_ID;

    public TransactionTypes(String atransaction_type_ID) {
        this.transaction_type_ID = new SimpleStringProperty(atransaction_type_ID);
            
    }

    public String getTransaction_type_ID() {
        return transaction_type_ID.get();
    }
}
