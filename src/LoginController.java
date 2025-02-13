
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    Label lbl_username;

    @FXML
    Label lbl_password;

    @FXML
    TextField tf_username;

    @FXML
    PasswordField pf_password;

    @FXML
    Button loginButton;

    private Stage stage;
    private Scene scene; 
    private Parent root;

    public void loginButtonHandler(ActionEvent event) throws IOException{

        String uname = tf_username.getText();
        String pword = pf_password.getText();

        System.out.println("Username entered: " + uname);

        if (DatabaseHandler.validateLogin(uname, pword)) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));

            root = loader.load();

            HomeController homeController = loader.getController();
            homeController.displayName(uname);

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            homeController.displayName(uname);
            

        } else {
            System.out.println("Login unsuccessful :(");
        }
    }
}