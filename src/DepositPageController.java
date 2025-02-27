
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

    public static String number;
    public static int feature = 3;
    
    private static boolean isEmpty(TextField field) {
        return field == null || field.getText().trim().isEmpty();
    }

    public void depositHandler(ActionEvent event) throws IOException {

        //Checks if the user inputs an amount to deposit
        if (isEmpty(tf_amountToDeposit)) {
            try {
                //Load error pop up
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ErrorPopUp.fxml"));
                Parent root = fxmlLoader.load();

                ErrorPopUpController controller = fxmlLoader.getController();
                //Set new message for incomplete field
                controller.setErrorMessage("An error has occurred while processing action. Make sure to answer all fields before submitting.");
                
                Stage newStage = new Stage();
                newStage.setTitle("Error: Empty field");
                newStage.setScene(new Scene(root));
                newStage.centerOnScreen();
                newStage.show();
                            
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Float amountToDeposit = Float.parseFloat(tf_amountToDeposit.getText());
            DatabaseHandler.deposit(amountToDeposit, number);

            //Call the receipt page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ReceiptPage.fxml"));

                root = loader.load();

                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            
            
        }
    }

    public void depositBackToHomeHandler(ActionEvent event) throws IOException{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));

        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
