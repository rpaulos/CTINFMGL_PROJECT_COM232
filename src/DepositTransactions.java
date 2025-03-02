import javafx.beans.property.SimpleStringProperty;

public class DepositTransactions {

    private final SimpleStringProperty deposit_transaction_ID;
    private final SimpleStringProperty depositor_number;
    private final SimpleStringProperty depositor_name;
    private final SimpleStringProperty amount;
    private final SimpleStringProperty transaction_date;

    public DepositTransactions(String depositTransacId, String  dNumber, String dName, String amount, String transacDate) {
        this.deposit_transaction_ID = new SimpleStringProperty(depositTransacId);
        this.depositor_number = new SimpleStringProperty(dNumber);
        this.depositor_name = new SimpleStringProperty(dName);
        this.amount = new SimpleStringProperty(amount);
        this.transaction_date = new SimpleStringProperty(transacDate);
    }

    public String getDeposit_transaction_id() {
        return deposit_transaction_ID.get();
    }

    public String getDepositor_number() {
        return depositor_number.get();
    }

    public String getDepositor_name() {
        return depositor_name.get();
    }

    public String getAmount() {
        return amount.get();
    }

    public String getTransaction_date() {
        return transaction_date.get();
    }
    
}
