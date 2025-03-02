import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ReceiptPageController implements Initializable{


    @FXML
    private Button btn_close;

    @FXML
    private Text txt_refNo; 

    @FXML
    private Text txt_totalAmountLabel;

    @FXML
    private Text txt_SentViaLabel;

    @FXML
    private Text txt_transacDate;

    @FXML
    private Text txt_amount;

    @FXML
    private Text txt_initials;

    @FXML
    private Text txt_myNumber;

    @FXML
    private Text txt_totalAmount;

    @FXML
    private Text txt_title;

    private Stage stage;
    private Scene scene; 
    private Parent root;

    public static String myNumber;
    public static float amountSent;
    public static float amountDeposited;
    public static float amountWithdrawn;
    public static String numberSentTo;
    public static int mode;
    
    public void initialize(URL url, ResourceBundle rb) {

        switch (mode) {
            case 1:
                setExpressSendReceipt();
                break;
            
            // case 2:
            //     setLoadReceipt();
            //     break;
            
            case 3:
                setDepositReceipt();
                break;
            
            case 4:
                setWithdrawReceipt();
                break;
            
        }
    }

    public void setExpressSendReceipt() {

        //Ommits the first character of the number and set the text
        String modifiedNumber = numberSentTo.substring(1);
        txt_myNumber.setText(modifiedNumber);

        //Casts the float to a string and set the text for the amount sent
        txt_amount.setText(Float.toString(amountSent));
        txt_totalAmount.setText(Float.toString(amountSent));

        //Call the DB handler to get the first and last name and set the initials
        String initials = DatabaseHandler.getFirstLastName(numberSentTo);

        if (initials != null && !initials.isEmpty()) {
            txt_initials.setText(initials);
        } else {
            txt_initials.setText("Error");
        }

        //Set the date of transaction
        LocalDateTime transacDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDate = transacDateTime.format(formatter);
        txt_transacDate.setText(formattedDate);

    }

    public void setDepositReceipt() {
        //Ommits the first character of the number and set the text
        String modifiedNumber = myNumber.substring(1);
        txt_myNumber.setText(modifiedNumber);

        //Casts the float to a string and set the text for the amount sent
        txt_amount.setText(Float.toString(amountDeposited));
        txt_totalAmount.setText(Float.toString(amountDeposited));

        txt_title.setText("Deposit");
        txt_SentViaLabel.setText("Deposited via GCash");
        txt_totalAmountLabel.setText("Total Amount Deposited");

        String initials = DatabaseHandler.getFirstLastName(myNumber);

        if (initials != null && !initials.isEmpty()) {
            txt_initials.setText(initials);
        } else {
            txt_initials.setText("Error");
        }

        //Set the date of transaction
        LocalDateTime transacDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDate = transacDateTime.format(formatter);
        txt_transacDate.setText(formattedDate);
    }

    public void setWithdrawReceipt() {
        //Ommits the first character of the number and set the text
        String modifiedNumber = myNumber.substring(1);
        txt_myNumber.setText(modifiedNumber);

        //Casts the float to a string and set the text for the amount sent
        txt_amount.setText(Float.toString(amountWithdrawn));
        txt_totalAmount.setText(Float.toString(amountWithdrawn));

        txt_title.setText("Withdraw");
        txt_SentViaLabel.setText("Withdraw via GCash");
        txt_totalAmountLabel.setText("Total Amount Withdrawn");

        String initials = DatabaseHandler.getFirstLastName(myNumber);

        if (initials != null && !initials.isEmpty()) {
            txt_initials.setText(initials);
        } else {
            txt_initials.setText("Error");
        }

        //Set the date of transaction
        LocalDateTime transacDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDate = transacDateTime.format(formatter);
        txt_transacDate.setText(formattedDate);
    }

    public void sendBackToHomeHandler(ActionEvent event) throws IOException{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));

        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
