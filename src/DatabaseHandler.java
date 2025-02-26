import java.lang.classfile.instruction.StackInstruction;
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

    public int execUpdateQuery(String query) {
        int affectedRows = 0;
        try {
            stmt = getDBConnection().createStatement();
            affectedRows = stmt.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println("Not working");
        }
        return affectedRows;
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

    //validateMobileNumberAndMPIN handles the validation of the account
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

    //getFirstName and getUserBalance is used to display the name and balance of the user in the HomePage
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

    //expressSend and subtractFromBalance handles the amound to send to other users
    //Need a way to negate the amountToSend from the phone_number of the user who sent the money
    //Plus a way to check the balance first  before sending the money. 
    //If balance < amountToSend, show a pop up message
    public static float expressSend(String numberToSendTo, float amountToSend) {
        String query = "UPDATE wallet SET balance = balance + ? WHERE phone_number = ?";
        float balance = 0.0f;
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getDBConnection();
            stmt = conn.prepareStatement(query);
            stmt.setFloat(1, amountToSend);
            stmt.setString(2, numberToSendTo);
            
            int affectedRows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return balance;
    }

    public static void negateBalance(Float negateFromBalance, String myNumber) {
        String query = "UPDATE wallet SET balance = balance - ? WHERE phone_number = ?";
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getDBConnection();
            stmt = conn.prepareStatement(query);
            stmt.setFloat(1, negateFromBalance); 
            stmt.setString(2, myNumber);

            int affectedRows = stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
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