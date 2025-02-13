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

    public void LoginToHomeHandler(ActionEvent event) throws IOException{

        String MPIN = pf_PIN.getText().trim().replaceAll("\\s+", "");
        System.out.println("Entered PIN: " + MPIN);

        if (DatabaseHandler.validateMPIN(MPIN)) {
            System.out.println("SUCCESS");

            FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));

            root = loader.load();

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } else {
            System.out.println("UNSUCCESSFUL");

        }
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