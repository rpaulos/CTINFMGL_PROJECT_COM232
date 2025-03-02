import javafx.beans.property.SimpleStringProperty;

public class WithdrawTransactions {

    private final SimpleStringProperty withdraw_transaction_ID;
    private final SimpleStringProperty withdrawer_number;
    private final SimpleStringProperty withdrawer_name;
    private final SimpleStringProperty amount;
    private final SimpleStringProperty transaction_date;

    public WithdrawTransactions(String withdrawTransacId, String  wNumber, String wName, String amount, String transacDate) {
        this.withdraw_transaction_ID = new SimpleStringProperty(withdrawTransacId);
        this.withdrawer_number = new SimpleStringProperty(wNumber);
        this.withdrawer_name = new SimpleStringProperty(wName);
        this.amount = new SimpleStringProperty(amount);
        this.transaction_date = new SimpleStringProperty(transacDate);
    }

    public String getWithdraw_transaction_id() {
        return withdraw_transaction_ID.get();
    }

    public String getWithdrawer_number() {
        return withdrawer_number.get();
    }

    public String getWithdrawer_name() {
        return withdrawer_name.get();
    }

    public String getAmount() {
        return amount.get();
    }

    public String getTransaction_date() {
        return transaction_date.get();
    }
    
}
