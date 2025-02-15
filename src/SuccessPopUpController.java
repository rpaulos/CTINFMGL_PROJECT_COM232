import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.text.Text;

public class SuccessPopUpController {

    @FXML
    private Button btn_closeSuccess;

    @FXML
    private Text txt_successMessage;

    @FXML
    void closeSuccessHandler(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();

    }

    @FXML
    public void setSuccessMessage(String message) {
        txt_successMessage.setText(message);
    }

}
