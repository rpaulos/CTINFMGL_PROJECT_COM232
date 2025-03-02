import javafx.beans.property.SimpleStringProperty;

public class SendTransactions {

    private final SimpleStringProperty send_transaction_ID;
    private final SimpleStringProperty sender_number;
    private final SimpleStringProperty sender_name;
    private final SimpleStringProperty receiver_number;
    private final SimpleStringProperty receiver_name;
    private final SimpleStringProperty amount;
    private final SimpleStringProperty transaction_date;

    public SendTransactions(String sendTransacId, String  sNumber, String sName, String rNumber, String rName, String amount, String transacDate) {
        this.send_transaction_ID = new SimpleStringProperty(sendTransacId);
        this.sender_number = new SimpleStringProperty(sNumber);
        this.sender_name = new SimpleStringProperty(sName);
        this.receiver_number = new SimpleStringProperty(rNumber);
        this.receiver_name = new SimpleStringProperty(rName);
        this.amount = new SimpleStringProperty(amount);
        this.transaction_date = new SimpleStringProperty(transacDate);
    }

    public String getSend_transaction_id() {
        return send_transaction_ID.get();
    }

    public String getSender_number() {
        return sender_number.get();
    }

    public String getSender_name() {
        return sender_name.get();
    }

    public String getReceiver_number() {
        return receiver_number.get();
    }

    public String getReceiver_name() {
        return receiver_name.get();
    }

    public String getAmount() {
        return amount.get();
    }

    public String getTransaction_date() {
        return transaction_date.get();
    }
    
}
