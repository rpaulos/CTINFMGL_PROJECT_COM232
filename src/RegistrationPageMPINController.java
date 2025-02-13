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

public class RegistrationPageMPINController {

    @FXML
    private Button btn_backToRegistrationPersonalInfo;

    @FXML
    private Button btn_registrationSubmit;

    @FXML
    private TextField tf_registerMPIN;

    @FXML
    void numberToPINHandler(ActionEvent event) {

    }

    private Stage stage;
    private Scene scene; 
    private Parent root;

    public void backToRegistrationPersonalInfo(ActionEvent event) throws IOException{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("RegistrationPagePersonalInfo.fxml"));

        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void registrationSubmitHandler(ActionEvent event) throws IOException{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginPageNumber.fxml"));

        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
