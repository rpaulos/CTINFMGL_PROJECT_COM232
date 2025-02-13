import java.awt.TextField;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class HomeController {

    @FXML
    Label lbl_homeLabel; 
    
    @FXML
    PasswordField pf_newPassword;

    @FXML
    Button btn_submitNewPassword;

    public void displayName(String username) {
        lbl_homeLabel.setText(username);
    }

    public void changePasswordHandler(ActionEvent event) throws IOException{

        String pword = pf_newPassword.getText();
        String uname = lbl_homeLabel.getText();

        if (DatabaseHandler.changePassword(uname, pword)) {
            
            System.out.println("Password change successful :)");
        } else {
            
            System.out.println("Password change successful :(");
        }
    }
    
}
