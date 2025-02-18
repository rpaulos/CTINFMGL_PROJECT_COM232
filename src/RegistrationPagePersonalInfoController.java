
// import java.awt.Desktop;
// import java.awt.event.ActionEvent;
import java.io.IOError;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
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
    private PasswordField pf_registerMPIN;

    @FXML
    private TextField tf_registerMobileNumber;

    @FXML
    private TextField tf_registerAddress;

    @FXML
    private TextField tf_registerCountry;
    


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

    // public void registerAccountHandler(ActionEvent event) throws IOException{
        
    //     //Get the value of each text field
    //     String mobileNumber = tf_registerMobileNumber.getText();
    //     String mobilePersonalIdentificationNumber = pf_registerMPIN.getText();
    //     String emailAddress = tf_registerEmailAddress.getText();
    //     String firstName = tf_registerFirstName.getText();
    //     String lastName = tf_registerLastName.getText();
    //     String address = tf_registerAddress.getText();
    //     String country = tf_registerCountry.getText();

    //     //Get the value of the Date Picker
    //     LocalDate selectedDate = dp_registerBirthdate.getValue();
    //     if(selectedDate != null) {
    //         String dateString = selectedDate.toString();
    //         System.out.println(dateString);
    //     }

    //     System.out.print("This button works!");

    //     /*
    //      * This is the CREATE in CRUD
    //      * Conncet to the DatabaseHandler
    //      * This adds an account to the user table in the DB
    //      */


    //     //If all fields are not null (or empty), register them to the database

    //     FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginPageNumber.fxml"));

    //     root = loader.load();

    //     stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    //     scene = new Scene(root);
    //     stage.setScene(scene);
    //     stage.show();

    // }

    @FXML
    public void registerAccountHandler(ActionEvent event) throws IOException {
        if (isEmpty(tf_registerMobileNumber) || isEmpty(pf_registerMPIN) || isEmpty(tf_registerEmailAddress) ||
            isEmpty(tf_registerFirstName) || isEmpty(tf_registerLastName) || isEmpty(tf_registerCountry) ||
            isEmpty(tf_registerAddress) || dp_registerBirthdate.getValue() == null) {

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

                String mobileNumber = tf_registerMobileNumber.getText();
                String mobilePersonalIdentificationNumber = pf_registerMPIN.getText();
                String emailAddress = tf_registerEmailAddress.getText();
                String firstName = tf_registerFirstName.getText();
                String lastName = tf_registerLastName.getText();
                String address = tf_registerAddress.getText();
                String country = tf_registerCountry.getText();

                LocalDate selectedDate = dp_registerBirthdate.getValue();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                String birthDate = selectedDate.format(formatter);

                User user = new User(mobileNumber, firstName, lastName, emailAddress, mobilePersonalIdentificationNumber, birthDate, country, address);

                if (DatabaseHandler.addUser(user)) {
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SuccessPopUp.fxml"));
                        Parent root = fxmlLoader.load();

                        SuccessPopUpController controller = fxmlLoader.getController();
                        controller.setSuccessMessage("The account has been successfully created. The account is now active and ready for access.");

                        Stage newStage = new Stage();
                        newStage.setTitle("Success: Account Registered");
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

    }

    private static boolean isEmpty(TextField field) {
        return field == null || field.getText().trim().isEmpty();
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
