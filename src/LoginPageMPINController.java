import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class LoginPageMPINController {

    @FXML
    Button btn_LoginToHome;

    @FXML
    Button btn_PIN0;

    @FXML
    Button btn_PIN1;

    @FXML
    Button btn_PIN2;

    @FXML
    Button btn_PIN3;

    @FXML
    Button btn_PIN4;

    @FXML
    Button btn_PIN5;

    @FXML
    Button btn_PIN6;

    @FXML
    Button btn_PIN7;

    @FXML
    Button btn_PIN8;

    @FXML
    Button btn_PIN9;

    @FXML
    Button btn_PINDelete;

    @FXML
    Button btn_PINSpace;

    @FXML
    PasswordField pf_PIN;

    private Stage stage;
    private Scene scene; 
    private Parent root;

    public static String numberToValidate;
    public static String MPINToValidate;

    public void LoginToHomeHandler(ActionEvent event) throws IOException{

        MPINToValidate = pf_PIN.getText().trim().replaceAll("\\s+", "");

        if (DatabaseHandler.validateMobileNumberAndMPIN(numberToValidate, MPINToValidate)) {

            HomePageController.validNumber = numberToValidate;
            HomePageController.validPIN = MPINToValidate;

            FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));

            root = loader.load();

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } else {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ErrorPopUp.fxml"));
                Parent root = fxmlLoader.load();

                ErrorPopUpController controller = fxmlLoader.getController();
                controller.setErrorMessage("Incorrect number or MPIN. Make sure all fields are correct.");

                Stage newStage = new Stage();
                newStage.setTitle("Error");
                newStage.setScene(new Scene(root));
                newStage.centerOnScreen();
                newStage.show();

                backToLoginNumber();
                
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public void backToLoginNumber() {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginPageNumber.fxml"));

        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void PINButtonHandler(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        String digit = clickedButton.getText();

        pf_PIN.appendText(digit);
    }

    public void PINSpaceButtonHandler(ActionEvent event) {
        pf_PIN.appendText(" ");
    }

    public void PINDeleteButtonHandler(ActionEvent event) {
        String currentText = pf_PIN.getText();
        if (!currentText.isEmpty()) {
            pf_PIN.setText(currentText.substring(0, currentText.length() - 1));
        }
    }

}