
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditProfilePageController {

    @FXML
    private Button btn_home;

    @FXML
    private Button btn_profile;

    @FXML
    private Button btn_submit;

    @FXML
    private Button btn_transactions;

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

    private Stage stage;
    private Scene scene; 
    private Parent root;

    public static String myNumber;

    private static boolean isEmpty(TextField field) {
        return field == null || field.getText().trim().isEmpty();
    }

    public void submitEditProfileHandler(ActionEvent event) throws IOException {

        if (isEmpty(tf_Address) || isEmpty(tf_Country) || isEmpty(tf_EmailAddress) || 
        isEmpty(tf_FirstName) || isEmpty(tf_LastName) || isEmpty(tf_PIN)) {

            try {
                //Load the error pop up
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ErrorPopUp.fxml"));
                Parent root = fxmlLoader.load();

                ErrorPopUpController controller = fxmlLoader.getController();
                //Set new message for incomplete field
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
            String address = tf_Address.getText();
            String country = tf_Country.getText();
            String email_address = tf_EmailAddress.getText();
            String firstName = tf_FirstName.getText();
            String lastName = tf_LastName.getText();
            int pin = Integer.parseInt(tf_PIN.getText());
    
            DatabaseHandler.updateAccount(myNumber, firstName, lastName, email_address, address, country, pin);

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SuccessPopUp.fxml"));
                Parent root = fxmlLoader.load();

                SuccessPopUpController controller = fxmlLoader.getController();
                controller.setSuccessMessage("The account has been updated.");

                Stage newStage = new Stage();
                newStage.setTitle("Success: Account Updated");
                newStage.setScene(new Scene(root));
                newStage.centerOnScreen();
                newStage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

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
