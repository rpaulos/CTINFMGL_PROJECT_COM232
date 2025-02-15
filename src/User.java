import javafx.beans.property.SimpleStringProperty;

public class User {

    private final SimpleStringProperty phone_Number;
    private final SimpleStringProperty first_Name;
    private final SimpleStringProperty last_Name;
    private final SimpleStringProperty email_Address;
    private final SimpleStringProperty PIN;
    private final SimpleStringProperty birthdate;
    private final SimpleStringProperty country;
    private final SimpleStringProperty address;

    public User(String pNumber, String fName, String lName, String eAddress, String MPIN, String bDate, String bansa, String location) {
        this.phone_Number = new SimpleStringProperty(pNumber);
        this.first_Name = new SimpleStringProperty(fName);
        this.last_Name = new SimpleStringProperty(lName);
        this.email_Address = new SimpleStringProperty(eAddress);
        this.PIN = new SimpleStringProperty(MPIN);
        this.birthdate = new SimpleStringProperty(bDate);
        this.country = new SimpleStringProperty(bansa);
        this.address = new SimpleStringProperty(location);
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

    public String getEmail_address() {
        return email_Address.get();
        
    }

    public String getPIN() {
        return PIN.get();
        
    }

    public String getBirthdate() {
        return birthdate.get();
        
    }

    public String getCountry() {
        return country.get();
        
    }

    public String getAddress() {
        return address.get();

    }


    
}
