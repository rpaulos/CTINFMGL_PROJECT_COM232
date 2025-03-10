import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ProfilePageController implements Initializable{

    @FXML
    private Button btn_home;

    @FXML
    private Button btn_profile;

    @FXML
    private Button btn_transactions;

    @FXML
    private Label lbl_addressCountry;

    @FXML
    private Label lbl_birthdate;

    @FXML
    private Label lbl_emailAddress;

    @FXML
    private Label lbl_initials;

    @FXML
    private Label lbl_name;

    @FXML
    private Label lbl_name1;

    @FXML
    private Label lbl_name11;

    @FXML
    private Label lbl_name111;

    @FXML
    private Label lbl_number;

    private Stage stage;
    private Scene scene; 
    private Parent root;

    public static String myNumber;

    public void initialize(URL url, ResourceBundle rb) {
        getName();
        getEmailAddress();
        getBirthdate();
        getLocation();
    }

    public void setProfilePage() {

    }

    public void getNumber() {
        lbl_number.setText(myNumber);
    }

    public void getName() {
        String myFirstName = DatabaseHandler.getFirstName(myNumber);
        String myLastName = DatabaseHandler.getLastName(myNumber);

        if (myFirstName != null && !myFirstName.isEmpty() && myLastName != null && !myLastName.isEmpty()) {
            String myInitials = myFirstName.substring(0, 1).toUpperCase() + myLastName.substring(0, 1).toUpperCase();
            
            lbl_initials.setText(myInitials);

            System.out.println(myFirstName);
            System.out.println(myLastName);

            System.out.println(myInitials);
        } else {
            lbl_initials.setText("Error");
        }


        String myName = (myFirstName + " " + myLastName);

        lbl_name.setText(myName);
    }

    public void getEmailAddress() {
        String myEmailAddress = DatabaseHandler.getEmailAddress(myNumber);

        lbl_emailAddress.setText(myEmailAddress);
    }

    public void getBirthdate() {
        Date myBirthdate = DatabaseHandler.getBirthdate(myNumber);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedBirthdate = sdf.format(myBirthdate);

        lbl_birthdate.setText(formattedBirthdate);
    }

    public void getLocation() {
        String myCountry = DatabaseHandler.getCountry(myNumber);
        String myAddress = DatabaseHandler.getAddress(myNumber);

        String myLocation = (myAddress + ", " + myCountry);

        lbl_addressCountry.setText(myLocation);
    }

    public void sendToEditProfilePage(ActionEvent event) throws IOException{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditProfilePage.fxml"));

        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void sendBackToHomeHandler(ActionEvent event) throws IOException{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));

        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void transactionPageHandler(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("TransactionHistoryPage.fxml"));

        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void sendBackToLoginHandler(ActionEvent event) throws IOException{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginPageNumber.fxml"));

        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void deleteAccountHandler(ActionEvent event) throws IOException{

        DatabaseHandler.deleteAccount(myNumber);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginPageNumber.fxml"));

        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SuccessPopUp.fxml"));
            Parent root = fxmlLoader.load();

            SuccessPopUpController controller = fxmlLoader.getController();
            controller.setSuccessMessage("Account has been deleted");

            Stage newStage = new Stage();
            newStage.setTitle("Success: Account Deleted");
            newStage.setScene(new Scene(root));
            newStage.centerOnScreen();
            newStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
