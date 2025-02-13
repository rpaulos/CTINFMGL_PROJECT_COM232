import java.io.IOException;

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
    private Button btn_registrationToMPINRegister;

    @FXML
    private DatePicker dp_registerBirthdate;

    @FXML
    private TextField tf_registerAddress;

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

    public void registrationToMPINRegisterHandler(ActionEvent event) throws IOException{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("RegistrationPageMPIN.fxml"));

        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
