
// import java.awt.Button;
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

    ObservableList<SendTransactions> sendTransactionsList = FXCollections.observableArrayList();

    ObservableList<DepositTransactions> depositTransactionsList = FXCollections.observableArrayList();

    ObservableList<WithdrawTransactions> withdrawTransactionsList = FXCollections.observableArrayList();

    @FXML
    private TableView<User> mytable;

    @FXML
    private TableView<Wallet> myWalletTable;

    @FXML
    private TableView<Money> myMoneyTable;

    @FXML
    private TableView<TransactionTypes> myTransactionTypeTable;

    @FXML
    private TableView<SendTransactions> mySendTable;

    @FXML
    private TableView<DepositTransactions> myDepositTable;

    @FXML
    private TableView<WithdrawTransactions> myWithdrawTable;

    @FXML
    private TableColumn<User, String> phone_numbercol, first_namecol, last_namecol, 
                                email_addresscol, pincol, birthdatecol, countrycol, 
                                addresscol;
    
    @FXML
    private TableColumn<Wallet, String> phone_number_walletcol, first_name_walletcol, 
                                last_name_walletcol, balance_walletcol, currency_walletcol;

    @FXML
    private TableColumn<Money, String> currency_moneycol, conversion_ratemoneycol;

    @FXML
    private TableColumn<TransactionTypes, String> transaction_type_ID_transactiontypecol;

    @FXML
    private TableColumn<SendTransactions, String> send_transaction_ID_sendcol, sender_number_sendcol, 
                                sender_name_sendcol, receiver_name_sendcol, receiver_number_sendcol, 
                                amount_sendcol, transaction_date_sendcol;

    @FXML
    private TableColumn<DepositTransactions, String> deposit_transaction_ID_depositcol, depositor_number_depositcol, 
                                depositor_name_depositcol, amount_depositcol, transaction_date_depositcol;

    @FXML
    private TableColumn<WithdrawTransactions, String> withdraw_transaction_ID_withdrawcol, withdrawer_number_withdrawcol, 
                                withdrawer_name_withdrawcol, amount_withdrawcol, transaction_date_withdrawcol;

    @FXML
    private Button btn_Create;

    @FXML
    private Button btn_Delete;

    @FXML
    private Button btn_Update;

    @FXML
    private Button btn_adminWalletSubmit;

    @FXML
    private Button btn_adminCurrencySubmit;

    @FXML
    private Button btn_adminCurrencyUpdate;

    @FXML
    private Button btn_adminCurrencyDelete;

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
    private TextField tf_adminWalletNumber;

    @FXML
    private TextField tf_adminWalletAmount;

    @FXML
    private TextField tf_adminCurrency;

    @FXML
    private TextField tf_adminConversionRate;

    @FXML
    private DatePicker dp_Birthdate;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeCol();
        displayUser();
        displayWallet();
        displayMoney();
        displayTransactionTypes();
        displaySendTransactions();
        displayDepositTransactions();
        displayWithdrawTransactions();
        
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
        currency_walletcol.setCellValueFactory(new PropertyValueFactory<>("currency"));

        currency_moneycol.setCellValueFactory(new PropertyValueFactory<>("currency"));
        conversion_ratemoneycol.setCellValueFactory(new PropertyValueFactory<>("conversion_rate"));

        transaction_type_ID_transactiontypecol.setCellValueFactory(new PropertyValueFactory<>("transaction_type_ID"));

        send_transaction_ID_sendcol.setCellValueFactory(new PropertyValueFactory<>("send_transaction_id"));
        sender_number_sendcol.setCellValueFactory(new PropertyValueFactory<>("sender_number"));
        sender_name_sendcol.setCellValueFactory(new PropertyValueFactory<>("sender_name"));
        receiver_number_sendcol.setCellValueFactory(new PropertyValueFactory<>("receiver_number"));
        receiver_name_sendcol.setCellValueFactory(new PropertyValueFactory<>("receiver_name"));
        amount_sendcol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        transaction_date_sendcol.setCellValueFactory(new PropertyValueFactory<>("transaction_date"));

        deposit_transaction_ID_depositcol.setCellValueFactory(new PropertyValueFactory<>("deposit_transaction_id"));
        depositor_number_depositcol.setCellValueFactory(new PropertyValueFactory<>("depositor_number"));
        depositor_name_depositcol.setCellValueFactory(new PropertyValueFactory<>("depositor_name"));
        amount_depositcol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        transaction_date_depositcol.setCellValueFactory(new PropertyValueFactory<>("transaction_date"));

        withdraw_transaction_ID_withdrawcol.setCellValueFactory(new PropertyValueFactory<>("withdraw_transaction_id"));
        withdrawer_number_withdrawcol.setCellValueFactory(new PropertyValueFactory<>("withdrawer_number"));
        withdrawer_name_withdrawcol.setCellValueFactory(new PropertyValueFactory<>("withdrawer_name"));
        amount_withdrawcol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        transaction_date_withdrawcol.setCellValueFactory(new PropertyValueFactory<>("transaction_date"));
    }

    private static boolean isEmpty(TextField field) {
        return field == null || field.getText().trim().isEmpty();
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
                String currency = result.getString("currency");

                walletList.add(new Wallet(phone_number, first_name, last_name, balance, currency));
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
                String conversion_rate = result.getString("conversion_rate");

                moneyList.add(new Money(currency, conversion_rate));

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

    private void displaySendTransactions() {

        sendTransactionsList.clear();

        ResultSet result = DatabaseHandler.getSendTransactions();
        
        try {
            while (result.next()) {
                String send_transaction_ID = String.valueOf(result.getInt("send_transaction_ID"));                
                String sender_number = result.getString("sender_number");
                String sender_name = result.getString("sender_name");
                String receiver_number = result.getString("receiver_number");
                String receiver_name = result.getString("receiver_name");
                String amount = result.getString("amount");
                String transaction_date = result.getString("transaction_date");
                

                sendTransactionsList.add(new SendTransactions(send_transaction_ID, sender_number, sender_name, receiver_number, receiver_name, amount, transaction_date));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        mySendTable.setItems(sendTransactionsList); 

    }

    private void displayDepositTransactions() {

        depositTransactionsList.clear();

        ResultSet result = DatabaseHandler.getDepositTransactions();
        
        try {
            while (result.next()) {
                String deposit_transaction_ID = String.valueOf(result.getInt("deposit_transaction_ID"));
                String depositor_number = result.getString("depositor_number");
                String depositor_name = result.getString("depositor_name");
                String amount = result.getString("amount");
                String transaction_date = result.getString("transaction_date");

                depositTransactionsList.add(new DepositTransactions(deposit_transaction_ID,depositor_number, depositor_name, amount, transaction_date));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        myDepositTable.setItems(depositTransactionsList); 

    }

    private void displayWithdrawTransactions() {

        withdrawTransactionsList.clear();

        ResultSet result = DatabaseHandler.getWithdrawTransactions();
        
        try {
            while (result.next()) {
                String withdraw_transaction_ID = String.valueOf(result.getInt("withdraw_transaction_ID"));
                String withdrawer_number = result.getString("withdrawer_number");
                String withdrawer_name = result.getString("withdrawer_name");
                String amount = result.getString("amount");
                String transaction_date = result.getString("transaction_date");

                withdrawTransactionsList.add(new WithdrawTransactions(withdraw_transaction_ID, withdrawer_number, withdrawer_name, amount, transaction_date));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        myWithdrawTable.setItems(withdrawTransactionsList); 

    }

    @FXML
    private void adminBalance (ActionEvent event) {

        if (isEmpty(tf_adminWalletNumber) || isEmpty((tf_adminWalletAmount))) {
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
            String phone_number = tf_adminWalletNumber.getText();
            float amount = Float.parseFloat(tf_adminWalletAmount.getText());

            if (amount > 0) {
                //call deposit
                DatabaseHandler.deposit(amount, phone_number);

                //DatabaseHandler for recording transaction history for deposit by admin
                DatabaseHandler.adminDeposit(phone_number, amount);

                displayWallet();
                displayDepositTransactions();

                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SuccessPopUp.fxml"));
                    Parent root = fxmlLoader.load();

                    SuccessPopUpController controller = fxmlLoader.getController();
                    controller.setSuccessMessage("Action Complete");

                    Stage newStage = new Stage();
                    newStage.setTitle("Success");
                    newStage.setScene(new Scene(root));
                    newStage.centerOnScreen();
                    newStage.show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
  
            } else {
                //call withdraw
                DatabaseHandler.withdraw(Math.abs(amount), phone_number);

                //DatabaseHandler for recording transaction history for withdraw by admin
                DatabaseHandler.adminWithdraw(phone_number, amount);

                displayWallet();
                displayWithdrawTransactions();

                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SuccessPopUp.fxml"));
                    Parent root = fxmlLoader.load();

                    SuccessPopUpController controller = fxmlLoader.getController();
                    controller.setSuccessMessage("Action complete.");

                    Stage newStage = new Stage();
                    newStage.setTitle("Success");
                    newStage.setScene(new Scene(root));
                    newStage.centerOnScreen();
                    newStage.show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
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
                    newStage.setTitle("Success: Account updated");
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

    @FXML
    private void createMoney(ActionEvent event) {
        if (isEmpty(tf_adminCurrency) || isEmpty(tf_adminConversionRate)) {

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

            String currency = tf_adminCurrency.getText();
            String conversionRate = tf_adminConversionRate.getText();

            Money money = new Money(currency, conversionRate);

            if (DatabaseHandler.addMoney(money)) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SuccessPopUp.fxml"));
                    Parent root = fxmlLoader.load();

                    SuccessPopUpController controller = fxmlLoader.getController();
                    controller.setSuccessMessage("New currency and conversion rate has been added.");

                    Stage newStage = new Stage();
                    newStage.setTitle("Success");
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
        displayMoney();
    }

    @FXML
    private void deleteMoney(ActionEvent event) {
        Money money = myMoneyTable.getSelectionModel().getSelectedItem();

        String currency = money.getCurrency();

        if (DatabaseHandler.deleteMoney(money)) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SuccessPopUp.fxml"));
                Parent root = fxmlLoader.load();

                SuccessPopUpController controller = fxmlLoader.getController();
                controller.setSuccessMessage("Currency has been removed from the database.");

                Stage newStage = new Stage();
                newStage.setTitle("Success");
                newStage.setScene(new Scene(root));
                newStage.centerOnScreen();
                newStage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
            displayMoney();
        } else {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ErrorPopUp.fxml"));
                Parent root = fxmlLoader.load();

                ErrorPopUpController controller = fxmlLoader.getController();
                controller.setErrorMessage("An error has occurred while processing action.");

                Stage newStage = new Stage();
                newStage.setTitle("Error");
                newStage.setScene(new Scene(root));
                newStage.centerOnScreen();
                newStage.show();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    private void updateMoney(ActionEvent event) {
        if (isEmpty(tf_adminCurrency) || isEmpty(tf_adminConversionRate)) {

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

           String currency = tf_adminCurrency.getText();
            String conversionRate = tf_adminConversionRate.getText();

            Money money = new Money(currency, conversionRate);

            if (DatabaseHandler.updateMoney(money)) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SuccessPopUp.fxml"));
                    Parent root = fxmlLoader.load();

                    SuccessPopUpController controller = fxmlLoader.getController();
                    controller.setSuccessMessage("Currency has been updated.");

                    Stage newStage = new Stage();
                    newStage.setTitle("Success");
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
                    newStage.setTitle("Error");
                    newStage.setScene(new Scene(root));
                    newStage.centerOnScreen();
                    newStage.show();
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        displayMoney();
    }

}