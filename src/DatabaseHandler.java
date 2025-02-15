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

    // public static boolean validateMPIN(String PIN){

    //     getInstance();
    //     String query = "SELECT * FROM users WHERE PIN = '" + PIN + "'";
        
    //     System.out.println(query);

    //     ResultSet result = handler.execQuery(query);
    //     try {
    //         if (result.next()) {
    //             return true;
    //         }
    //     }
    //     catch (SQLException e){
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