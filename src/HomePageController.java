
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Node;

public class HomePageController implements Initializable {
// public class HomePageController{

    @FXML
    private Button btn_cashIn;

    @FXML
    private Button btn_deposit;

    @FXML
    private Button btn_help;

    @FXML
    private Button btn_home;

    @FXML
    private Button btn_load;

    @FXML
    private Button btn_profile;

    @FXML
    private Button btn_ad;

    @FXML
    private Button btn_toExpressSend;

    @FXML
    private Button btn_transactions;

    @FXML
    private Button btn_withdraw;

    @FXML
    private Label lbl_balance;
    
    @FXML
    private Label lbl_name;

    private String first_name;

    private Stage stage;
    private Scene scene; 
    private Parent root;

    public static String validNumber;
    public static String validPIN;
    public static float balance;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ProfilePageController.myNumber = validNumber;
        ReceiptPageController.myNumber = validNumber;
        EditProfilePageController.myNumber = validNumber;
        getName();
        getBalance();
    }

    public void sendHandler(ActionEvent event) throws IOException {

        ExpressSendPageController.number = validNumber;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ExpressSendPage.fxml"));

        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    // public void loadHandler(ActionEvent event) throws IOException {

    //     ExpressSendPageController.number = validNumber;

    //     FXMLLoader loader = new FXMLLoader(getClass().getResource("LoadPage.fxml"));

    //     root = loader.load();

    //     stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    //     scene = new Scene(root);
    //     stage.setScene(scene);
    //     stage.show();

    // }


    public void depositHandler(ActionEvent event) throws IOException {

        DepositPageController.number = validNumber;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("DepositPage.fxml"));

        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void WithdrawHandler(ActionEvent event) throws IOException {

        WithdrawPageController.number = validNumber;
        WithdrawPageController.myBalance = balance;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("WithdrawPage.fxml"));

        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void getName() {
        first_name = DatabaseHandler.getFirstName(validNumber);

        if (first_name != null) {
            lbl_name.setText(first_name);
        } else {
            lbl_name.setText("ERROR");
        }
    }

    public void getBalance() {
        balance = DatabaseHandler.getUserBalance(validNumber);
        String formatBalance = String.format("%,.2f", balance);
        lbl_balance.setText(formatBalance);
        ExpressSendPageController.myBalance = balance;
        System.out.println(balance);
    }

    public void profilePageHandler(ActionEvent event) throws IOException {

        ProfilePageController.myNumber = validNumber;


        FXMLLoader loader = new FXMLLoader(getClass().getResource("ProfilePage.fxml"));

        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void transactionPageHandler(ActionEvent event) throws IOException {

        TransactionHistoryController.myNumber = validNumber;


        FXMLLoader loader = new FXMLLoader(getClass().getResource("TransactionHistoryPage.fxml"));

        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void heartAd(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://web.facebook.com/share/p/18Lj4exq5U/"));
    }

}
