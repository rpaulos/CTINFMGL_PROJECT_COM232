import java.io.IOException;
import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistrationPagePersonalInfoController {

    @FXML
    private Button btn_backToLogin;

    @FXML
    private Button btn_registerSubmit;

    @FXML
    private DatePicker dp_registerBirthdate;

    @FXML
    private TextField tf_registerMPIN;

    @FXML
    private TextField tf_registerEmailAddress;

    @FXML
    private TextField tf_registerFirstName;

    @FXML
    private TextField tf_registerLastName;

    @FXML
    private TextField tf_registerMobileNumber;

    @FXML
    private TextField tf_registerNationality;

    @FXML
    void numberToPINHandler(ActionEvent event) {

    }

    private Stage stage;
    private Scene scene; 
    private Parent root;

    public void backToLoginHandler(ActionEvent event) throws IOException{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginPageNumber.fxml"));

        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void registerAccountHandler(ActionEvent event) throws IOException{
        
        //Get the value of each text field
        String mobileNumber = tf_registerMobileNumber.getText();
        String mobilePersonalIdentificationNumber = tf_registerMPIN.getText();
        String emailAddress = tf_registerEmailAddress.getText();
        String firstName = tf_registerFirstName.getText();
        String lastName = tf_registerLastName.getText();
        String nationality = tf_registerNationality.getText();

        //Get the value of the Date Picker
        LocalDate selectedDate = dp_registerBirthdate.getValue();
        if(selectedDate != null) {
            String dateString = selectedDate.toString();
            System.out.println(dateString);
        }

        System.out.print("This button works!");

        /*
         * TODO:
         * This is the CREATE in CRUD
         * Conncet to the DatabaseHandler
         * This adds an account to the user table in the DB
         */


        //If all fields are not null (or empty), register them to the database

        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginPageNumber.fxml"));

        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


    // public void registrationToMPINRegisterHandler(ActionEvent event) throws IOException{

    //     FXMLLoader loader = new FXMLLoader(getClass().getResource("RegistrationPageMPIN.fxml"));

    //     root = loader.load();

    //     stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    //     scene = new Scene(root);
    //     stage.setScene(scene);
    //     stage.show();

    // }
}
