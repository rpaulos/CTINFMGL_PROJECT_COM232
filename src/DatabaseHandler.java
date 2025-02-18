import java.sql.*;

public class DatabaseHandler {

    private static DatabaseHandler handler = null;
    private static Statement stmt = null;
    private static PreparedStatement pstatement = null;

    public static DatabaseHandler getInstance() {
        if (handler == null) {
            handler = new DatabaseHandler();
        }
        return handler;
    }

    public static Connection getDBConnection()
    {
        Connection connection = null;
        String dburl = "jdbc:mysql://localhost:3306/gcash";
        String userName = "root";
        String password = "123";

        try
        {
            connection = DriverManager.getConnection(dburl, userName, password);

        } catch (Exception e){
            e.printStackTrace();
        }

        return connection;
    }

    public ResultSet execQuery(String query) {
        ResultSet result;
        try {
            stmt = getDBConnection().createStatement();
            result = stmt.executeQuery(query);
        }
        catch (SQLException ex) {
            System.out.println("Exception at execQuery:dataHandler" + ex.getLocalizedMessage());
            return null;
        }
        finally {
        }
        return result;
    }

    public static boolean validateMobileNumber(String phone_number){

        getInstance();
        String query = "SELECT * FROM users WHERE phone_number = '" + phone_number + "'";
        
        System.out.println(query);

        ResultSet result = handler.execQuery(query);
        try {
            if (result.next()) {
                return true;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    //GET THE FIRST NAME FOR THE lbl_name in the HomePage.fxml
    // public static String getFirstName(String phone_number, String PIN) {
    //     String query = "SELECT first_name FROM users WHERE phone_number = '" + phone_number + "AND PIN = '" + PIN + "'"; 
    // }

    /* GET THE BALANCE FOR lbl_balance AND DISPLAY IT ON THE HomePage.fxml
    public static float getBalance(String phone_number, String PIN){
        getInstance();
        String query = "SELECT * FROM wallet WHERE phone_number = '" + phone_number + "' AND PIN = '" + PIN + "'";

        System.out.println(query);
        
    }
    */

    public static String getFirstName(String phone_number, String PIN) {
        String query = "SELECT first_name FROM users WHERE phone_number = ? AND PIN = ?";
        String first_name = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet result = null;

        try {
            conn = getDBConnection();
            stmt = conn.prepareStatement(query);
            stmt.setString(1, phone_number);
            stmt.setString(2, PIN);
            result = stmt.executeQuery();

            if(result.next()) {
                first_name = result.getString("first_name");
            } 
            
        } catch (SQLException e) {
                e.printStackTrace();
            }
        return first_name;
    }

    public static float getUserBalance(String phone_number) {
        String query = "SELECT balance FROM wallet WHERE phone_number = ?";
        float balance = 0.0f;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet result = null;

        try {
            conn = getDBConnection();
            stmt = conn.prepareStatement(query);
            stmt.setString(1, phone_number);
            result = stmt.executeQuery();

            if(result.next()) {
                balance = result.getFloat("balance");
            } 
            
        } catch (SQLException e) {
                e.printStackTrace();
            }
        return balance;
    }

    // public static boolean expressSend(String numberString, float amount, String phone_number){
    //     getInstance();
    //     String query = "UPDATE wallet SET balance = balance + " + amount + " WHERE phone_number = '" + numberString + "'"; 

    //     ResultSet result = handler.execQuery(query);
    //     try {
    //         if (result.next()) {
    //             subtractFromBalance(phone_number, amount); //calls subtractFromBalance() or find a way to execute two querries
    //             return true; //expressSend can't reach this because of the line above is calling a diff method
    //         }
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    //     return false;

    // }

    // public static boolean subtractFromBalance(String phone_number, float amount) {
    //     getInstance();
    //     String query = "UPDATE wallet SET balance = balance - " + amount + " WHERE phone_number = '" + phone_number + "'";

    //     ResultSet result = handler.execQuery(query);
    //     try {
    //         if (result.next()) {
    //             return true;
    //         }
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    //     return false;
    // }

    public static boolean validateMobileNumberAndMPIN(String phone_number, String PIN){
        getInstance();
        String query = "SELECT * FROM users WHERE phone_number = '" + phone_number + "' AND PIN = '" + PIN + "'";
        
        System.out.println(query);

        ResultSet result = handler.execQuery(query);
        try {
            if (result.next()) {
                return true;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public static ResultSet getUsers(){
        ResultSet result = null;
        
        try {
            String query = "SELECT * FROM users";
            result = handler.execQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean addUser(User user) {
        try {
            pstatement = getDBConnection().prepareStatement("INSERT INTO users (phone_number, first_name, last_name, email_address, PIN, birthdate, country, address) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            pstatement.setString(1, user.getPhone_number());
            pstatement.setString(2, user.getFirst_name());
            pstatement.setString(3, user.getLast_name());
            pstatement.setString(4, user.getEmail_address());
            pstatement.setString(5, user.getPIN());
            pstatement.setString(6, user.getBirthdate());
            pstatement.setString(7, user.getCountry());
            pstatement.setString(8, user.getAddress());

            return pstatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deleteUser(User user) {
        try {
            pstatement = getDBConnection().prepareStatement("DELETE FROM users WHERE phone_number = ?");
            pstatement.setString(1, user.getPhone_number());
            
            int res = pstatement.executeUpdate();
            if (res > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean updateUser(User user) {

        try {
            pstatement = getDBConnection().prepareStatement("UPDATE users SET phone_number = ?, first_name = ?, last_name = ?, email_address = ?, PIN = ?, birthdate = ?, country = ?, address = ? WHERE phone_number = ?");
            pstatement.setString(1, user.getPhone_number());
            pstatement.setString(2, user.getFirst_name());
            pstatement.setString(3, user.getLast_name());
            pstatement.setString(4, user.getEmail_address());
            pstatement.setString(5, user.getPIN());
            pstatement.setString(6, user.getBirthdate());
            pstatement.setString(7, user.getCountry());
            pstatement.setString(8, user.getAddress());
            pstatement.setString(9, user.getPhone_number());

            int res = pstatement.executeUpdate();

            if (res > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}