//import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;

public class Wallet {

    private final SimpleStringProperty phone_Number;
    private final SimpleStringProperty first_Name;
    private final SimpleStringProperty last_Name;
    private final SimpleStringProperty balance;
    private final SimpleStringProperty currency;
    

    public Wallet(String pNumber, String fName, String lName, String abalance, String acurrency) {
    //public Wallet(String pNumber, String fName, String lName) {
        this.phone_Number = new SimpleStringProperty(pNumber);
        this.first_Name = new SimpleStringProperty(fName);
        this.last_Name = new SimpleStringProperty(lName);
        this.balance = new SimpleStringProperty(String.valueOf(abalance));
        this.currency = new SimpleStringProperty(acurrency);
        
    }

    public String getPhone_number() {
        return phone_Number.get();
    }

    public String getFirst_name() {
        return first_Name.get();
        
    }

    public String getLast_name() {
        return last_Name.get();
        
    }

    public String getBalance() {
        return balance.get();
        
    }

    public String getCurrency() {
        return currency.get();
        
    }
}
