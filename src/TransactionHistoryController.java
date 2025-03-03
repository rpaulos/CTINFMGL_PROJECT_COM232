import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TransactionHistoryController implements Initializable {

    @FXML
    private TableView<SendTransactions> mySendTable;

    @FXML
    private TableView<DepositTransactions> myDepositTable;

    @FXML
    private TableView<WithdrawTransactions> myWithdrawTable;

    ObservableList<SendTransactions> sendTransactionsList = FXCollections.observableArrayList();

    ObservableList<DepositTransactions> depositTransactionsList = FXCollections.observableArrayList();

    ObservableList<WithdrawTransactions> withdrawTransactionsList = FXCollections.observableArrayList();

    @FXML
    private TableColumn<SendTransactions, String> receiver_name_sendcol, amount_sendcol, transaction_date_sendcol;

    @FXML
    private TableColumn<DepositTransactions, String> amount_depositcol, transaction_date_depositcol;

    @FXML
    private TableColumn<WithdrawTransactions, String> amount_withdrawcol, transaction_date_withdrawcol;
    
    @FXML
    private Button btn_home;

    @FXML
    private Button btn_profile;

    @FXML
    private Button btn_transactions;

    @FXML
    private Label lbl_name;

    private Stage stage;
    private Scene scene; 
    private Parent root;

    public static String myNumber;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeCol();
        displaySendTransactions();
        displayDepositTransactions();
        displayWithdrawTransactions();
    }

    private void initializeCol() {
        receiver_name_sendcol.setCellValueFactory(new PropertyValueFactory<>("receiver_name"));
        amount_sendcol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        transaction_date_sendcol.setCellValueFactory(new PropertyValueFactory<>("transaction_date"));

        amount_depositcol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        transaction_date_depositcol.setCellValueFactory(new PropertyValueFactory<>("transaction_date"));

        amount_withdrawcol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        transaction_date_withdrawcol.setCellValueFactory(new PropertyValueFactory<>("transaction_date"));
    }

    private void displaySendTransactions() {

        sendTransactionsList.clear();

        ResultSet result = DatabaseHandler.getUserSendTransactions(myNumber);
        
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

        ResultSet result = DatabaseHandler.getUserDepositTransactions(myNumber);
        
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

        ResultSet result = DatabaseHandler.getUserWithdrawTransactions(myNumber);
        
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
    public void profilePageHandler(ActionEvent event) throws IOException{

        // ProfilePageController.myNumber = myNumber;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ProfilePage.fxml"));

        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void sendBackToHomeHandler(ActionEvent event) throws IOException{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));

        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
