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

public class DepositPageController {

    @FXML
    private Button btn_depositBackToHome;

    @FXML
    private Button btn_submitDeposit;

    @FXML
    private TextField tf_amountToDeposit;

    private Stage stage;
    private Scene scene; 
    private Parent root;

        public void depositBackToHomeHandler(ActionEvent event) throws IOException{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));

        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
