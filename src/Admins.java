import javafx.beans.property.SimpleStringProperty;

public class Admins {
    
    private final SimpleStringProperty admin_ID;
    private final SimpleStringProperty admin_full_name;
    private final SimpleStringProperty admin_email_address;
    private final SimpleStringProperty admin_PIN;

    public Admins(String adminUser_ID, String adminUser_full_name, String adminUser_email_address, String adminUser_PIN) {
        this.admin_ID = new SimpleStringProperty(adminUser_ID);
        this.admin_full_name = new SimpleStringProperty(adminUser_full_name);
        this.admin_email_address = new SimpleStringProperty(adminUser_email_address);
        this.admin_PIN = new SimpleStringProperty(adminUser_PIN);
            
    }

    public String getAdmin_ID() {
        return admin_ID.get();
    }

    public String getAdmin_full_name() {
        return admin_full_name.get();
    }
    
    public String getAdmin_email_address() {
        return admin_email_address.get();
    }

    public String getAdmin_PIN() {
        return admin_PIN.get();
    }
}
