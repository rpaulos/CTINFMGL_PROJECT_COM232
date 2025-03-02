
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginPageNumberController {

    @FXML
    TextField tf_LoginNumber;

    @FXML
    Button btn_0;

    @FXML
    Button btn_1;

    @FXML
    Button btn_2;

    @FXML
    Button btn_3;

    @FXML
    Button btn_4;

    @FXML
    Button btn_5;

    @FXML
    Button btn_6;

    @FXML
    Button btn_7;

    @FXML
    Button btn_8;

    @FXML
    Button btn_9;

    @FXML
    Button btn_Next;

    @FXML
    Button btn_Space;

    @FXML
    Button btn_Delete;

    @FXML
    Button btn_signUp;

    private Stage stage;
    private Scene scene; 
    private Parent root;

    public void numberToMPINHandler(ActionEvent event) throws IOException{

        String usernumber = tf_LoginNumber.getText().trim().replaceAll("\\s+", "");

        if (DatabaseHandler.validateMobileNumber(usernumber)) {
            
            LoginPageMPINController.numberToValidate = usernumber;

            FXMLLoader loader;
    
            if (usernumber.equalsIgnoreCase("Admin")) {
                loader = new FXMLLoader(getClass().getResource("TESTPAGE.fxml"));
            } else {
                loader = new FXMLLoader(getClass().getResource("LoginPageMPIN.fxml"));
            }

            root = loader.load();
    
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
            
        } else {

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ErrorPopUp.fxml"));
                Parent root = fxmlLoader.load();

                ErrorPopUpController controller = fxmlLoader.getController();
                controller.setErrorMessage("Account does not exists. Sign up or input a valid number.");

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

    public void numberButtonHandler(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        String digit = clickedButton.getText();

        tf_LoginNumber.appendText(digit);
    }

    public void spaceButtonHandler(ActionEvent event) {
        tf_LoginNumber.appendText(" ");
    }

    public void deleteButtonHandler(ActionEvent event) {
        String currentText = tf_LoginNumber.getText();
        if (!currentText.isEmpty()) {
            tf_LoginNumber.setText(currentText.substring(0, currentText.length() - 1));
        }
    }

    public void signUpHandler(ActionEvent event) throws IOException{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("RegistrationPagePersonalInfo.fxml"));

        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
