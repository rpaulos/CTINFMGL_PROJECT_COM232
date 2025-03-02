
import java.io.IOException;
import java.sql.ResultSet;
import java.util.Observable;
// import javax.swing.Action;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.DialogPane;
import javax.naming.spi.DirStateFactory;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
// import javax.swing.table.TableColumn;


public class AdminPageController implements Initializable {

    ObservableList<User> userlist = FXCollections.observableArrayList();

    ObservableList<Wallet> walletList = FXCollections.observableArrayList();

    ObservableList<Money> moneyList = FXCollections.observableArrayList();

    ObservableList<TransactionTypes> transactionTypesList = FXCollections.observableArrayList();

    @FXML
    private TableView<User> mytable;

    @FXML
    private TableView<Wallet> myWalletTable;

    @FXML
    private TableView<Money> myMoneyTable;

    @FXML
    private TableView<TransactionTypes> myTransactionTypeTable;

    @FXML
    private TableColumn<User, String> phone_numbercol;

    @FXML
    private TableColumn<User, String> first_namecol;

    @FXML
    private TableColumn<User, String> last_namecol;

    @FXML
    private TableColumn<User, String> email_addresscol;

    @FXML
    private TableColumn<User, String> pincol;

    @FXML
    private TableColumn<User, String> birthdatecol;

    @FXML
    private TableColumn<User, String> countrycol;

    @FXML
    private TableColumn<User, String> addresscol;

    @FXML
    private TableColumn<?, ?> phone_number_walletcol;

    @FXML
    private TableColumn<?, ?> first_name_walletcol;

    @FXML
    private TableColumn<?, ?> last_name_walletcol;

    @FXML
    private TableColumn<?, ?> balance_walletcol;

    @FXML
    private TableColumn<?, ?> currency_moneycol;

    @FXML
    private TableColumn<?, ?> transaction_type_ID_transactiontypecol;

    @FXML
    private Button btn_Create;

    @FXML
    private Button btn_Delete;

    @FXML
    private Button btn_Update;

    @FXML
    private TextField tf_Address;

    @FXML
    private TextField tf_Country;

    @FXML
    private TextField tf_EmailAddress;

    @FXML
    private TextField tf_FirstName;

    @FXML
    private TextField tf_LastName;

    @FXML
    private TextField tf_PIN;

    @FXML
    private TextField tf_PhoneNumber;

    @FXML
    private DatePicker dp_Birthdate;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeCol();
        displayUser();
        displayWallet();
        displayMoney();
        displayTransactionTypes();
        
    }

    private void initializeCol() {
        phone_numbercol.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
        first_namecol.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        last_namecol.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        email_addresscol.setCellValueFactory(new PropertyValueFactory<>("email_address"));
        pincol.setCellValueFactory(new PropertyValueFactory<>("PIN"));
        birthdatecol.setCellValueFactory(new PropertyValueFactory<>("birthdate"));
        countrycol.setCellValueFactory(new PropertyValueFactory<>("country"));
        addresscol.setCellValueFactory(new PropertyValueFactory<>("address"));

        phone_number_walletcol.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
        first_name_walletcol.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        last_name_walletcol.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        balance_walletcol.setCellValueFactory(new PropertyValueFactory<>("balance"));

        currency_moneycol.setCellValueFactory(new PropertyValueFactory<>("currency"));

        transaction_type_ID_transactiontypecol.setCellValueFactory(new PropertyValueFactory<>("transaction_type_ID"));
    }

    private void displayUser() {

        userlist.clear();

        ResultSet result = DatabaseHandler.getUsers();
        
        try {
            while (result.next()) {
                String phone_number = result.getString("phone_number");
                String first_name = result.getString("first_name");
                String last_name = result.getString("last_name");
                String email_address = result.getString("email_address");
                String PIN = result.getString("PIN");
                String birthdate = result.getString("birthdate");
                String country = result.getString("country");
                String address = result.getString("address");

                userlist.add(new User(phone_number, first_name, last_name, email_address, PIN, birthdate, country, address));
                
                displayWallet();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        mytable.setItems(userlist);

    }

    private void displayWallet() {

        walletList.clear();

        ResultSet result = DatabaseHandler.getWallet();
        
        try {
            while (result.next()) {
                String phone_number = result.getString("phone_number");
                String first_name = result.getString("first_name");
                String last_name = result.getString("last_name");
                String balance = result.getString("balance");

                walletList.add(new Wallet(phone_number, first_name, last_name, balance));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        myWalletTable.setItems(walletList);

    }

    private void displayMoney() {

        moneyList.clear();

        ResultSet result = DatabaseHandler.getMoney();
        
        try {
            while (result.next()) {
                String currency = result.getString("currency");

                moneyList.add(new Money(currency));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        myMoneyTable.setItems(moneyList);

    }

    private void displayTransactionTypes() {

        transactionTypesList.clear();

        ResultSet result = DatabaseHandler.getTransactionTypes();
        
        try {
            while (result.next()) {
                String transaction_type_ID = result.getString("transaction_type_ID");

                transactionTypesList.add(new TransactionTypes(transaction_type_ID));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        myTransactionTypeTable.setItems(transactionTypesList); 

    }

    @FXML
    private void createUser(ActionEvent event) {
        if (isEmpty(tf_PhoneNumber) || isEmpty(tf_FirstName) || isEmpty(tf_LastName) ||
            isEmpty(tf_EmailAddress) || isEmpty(tf_PIN) || isEmpty(tf_Country) ||
            isEmpty(tf_Address) || dp_Birthdate.getValue() == null) {

                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ErrorPopUp.fxml"));
                    Parent root = fxmlLoader.load();

                    ErrorPopUpController controller = fxmlLoader.getController();
                    controller.setErrorMessage("An error has occurred while processing action. Make sure to answer all fields before submitting.");

                    Stage newStage = new Stage();
                    newStage.setTitle("Error: Empty field");
                    newStage.setScene(new Scene(root));
                    newStage.centerOnScreen();
                    newStage.show();
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
        
        } else {

            String phoneNumber = tf_PhoneNumber.getText();
            String firstName = tf_FirstName.getText();
            String lastName = tf_LastName.getText();
            String emailAddress = tf_EmailAddress.getText();
            String MPIN = tf_PIN.getText();
            String country = tf_Country.getText();
            String address = tf_Address.getText();

            LocalDate selectedDate = dp_Birthdate.getValue();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            String birthDate = selectedDate.format(formatter);

            User user = new User(phoneNumber, firstName, lastName, emailAddress, MPIN, birthDate, country, address);

            if (DatabaseHandler.addUser(user)) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SuccessPopUp.fxml"));
                    Parent root = fxmlLoader.load();

                    SuccessPopUpController controller = fxmlLoader.getController();
                    controller.setSuccessMessage("User registration complete. The account is now active and ready for access.");

                    Stage newStage = new Stage();
                    newStage.setTitle("Success: Account created");
                    newStage.setScene(new Scene(root));
                    newStage.centerOnScreen();
                    newStage.show();

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ErrorPopUp.fxml"));
                    Parent root = fxmlLoader.load();

                    ErrorPopUpController controller = fxmlLoader.getController();
                    controller.setErrorMessage("An error has occurred while processing action. Make sure to answer all fields before submitting.");

                    Stage newStage = new Stage();
                    newStage.setTitle("Error: Empty field");
                    newStage.setScene(new Scene(root));
                    newStage.centerOnScreen();
                    newStage.show();
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        displayUser();
    }

    private static boolean isEmpty(TextField field) {
        return field == null || field.getText().trim().isEmpty();
    }

    @FXML
    private void deleteUser(ActionEvent event) {
        User user = mytable.getSelectionModel().getSelectedItem();

        String phoneNumber = user.getPhone_number();

        if (DatabaseHandler.deleteUser(user)) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SuccessPopUp.fxml"));
                Parent root = fxmlLoader.load();

                SuccessPopUpController controller = fxmlLoader.getController();
                controller.setSuccessMessage("The account has been successfully deleted. All related data has been removed.");

                Stage newStage = new Stage();
                newStage.setTitle("Success: Account deleted");
                newStage.setScene(new Scene(root));
                newStage.centerOnScreen();
                newStage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
            displayUser();
        } else {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ErrorPopUp.fxml"));
                Parent root = fxmlLoader.load();

                ErrorPopUpController controller = fxmlLoader.getController();
                controller.setErrorMessage("An error has occurred while processing action.");

                Stage newStage = new Stage();
                newStage.setTitle("Error: Account not deleted");
                newStage.setScene(new Scene(root));
                newStage.centerOnScreen();
                newStage.show();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    private void updateUser(ActionEvent event) {
        if (isEmpty(tf_PhoneNumber) || isEmpty(tf_FirstName) || isEmpty(tf_LastName) ||
            isEmpty(tf_EmailAddress) || isEmpty(tf_PIN) || isEmpty(tf_Country) ||
            isEmpty(tf_Address) || dp_Birthdate.getValue() == null) {

                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ErrorPopUp.fxml"));
                    Parent root = fxmlLoader.load();

                    ErrorPopUpController controller = fxmlLoader.getController();
                    controller.setErrorMessage("An error has occurred while processing action. Make sure to answer all fields before submitting.");

                    Stage newStage = new Stage();
                    newStage.setTitle("Error: Empty field");
                    newStage.setScene(new Scene(root));
                    newStage.centerOnScreen();
                    newStage.show();
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
        
        } else {

            String phoneNumber = tf_PhoneNumber.getText();
            String firstName = tf_FirstName.getText();
            String lastName = tf_LastName.getText();
            String emailAddress = tf_EmailAddress.getText();
            String MPIN = tf_PIN.getText();
            String country = tf_Country.getText();
            String address = tf_Address.getText();

            LocalDate selectedDate = dp_Birthdate.getValue();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            String birthDate = selectedDate.format(formatter);

            User user = new User(phoneNumber, firstName, lastName, emailAddress, MPIN, birthDate, country, address);

            if (DatabaseHandler.updateUser(user)) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SuccessPopUp.fxml"));
                    Parent root = fxmlLoader.load();

                    SuccessPopUpController controller = fxmlLoader.getController();
                    controller.setSuccessMessage("The account has been successfully updated.");

                    Stage newStage = new Stage();
                    newStage.setTitle("Success: Account deleted");
                    newStage.setScene(new Scene(root));
                    newStage.centerOnScreen();
                    newStage.show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ErrorPopUp.fxml"));
                    Parent root = fxmlLoader.load();

                    ErrorPopUpController controller = fxmlLoader.getController();
                    controller.setErrorMessage("An error has occurred while processing action. Update can't go through.");

                    Stage newStage = new Stage();
                    newStage.setTitle("Error: Empty field");
                    newStage.setScene(new Scene(root));
                    newStage.centerOnScreen();
                    newStage.show();
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        displayUser();
    }

}