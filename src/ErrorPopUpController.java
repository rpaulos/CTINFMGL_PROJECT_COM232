
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.text.Text;

public class ErrorPopUpController {

    @FXML
    private Button btn_closeError;

    @FXML
    private Text txt_errorMessage;

    @FXML
    void closeErrorHandler(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();

    }

    @FXML
    public void setErrorMessage(String message) {
        txt_errorMessage.setText(message);
    }

}
