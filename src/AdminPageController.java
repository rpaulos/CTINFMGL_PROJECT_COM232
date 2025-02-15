
import java.io.IOException;
import java.sql.ResultSet;
import java.util.Observable;
import javax.swing.Action;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.DialogPane;
import javax.naming.spi.DirStateFactory;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;


public class AdminPageController implements Initializable {

    ObservableList<User> userlist = FXCollections.observableArrayList();

    @FXML
    private TableView<User> mytable;

    @FXML
    private TableColumn<User, String> phone_numbercol;

    @FXML
    private TableColumn<User, String> first_namecol;

    @FXML
    private TableColumn<User, String> last_namecol;

    @FXML
    private TableColumn<User, String> email_addresscol;

    @FXML
    private TableColumn<User, String> pincol;

    @FXML
    private TableColumn<User, String> birthdatecol;

    @FXML
    private TableColumn<User, String> countrycol;

    @FXML
    private TableColumn<User, String> addresscol;

    @FXML
    private Button btn_Create;

    @FXML
    private Button btn_Delete;

    @FXML
    private Button btn_Update;

    @FXML
    private TextField tf_Address;

    @FXML
    private TextField tf_Country;

    @FXML
    private TextField tf_EmailAddress;

    @FXML
    private TextField tf_FirstName;

    @FXML
    private TextField tf_LastName;

    @FXML
    private TextField tf_PIN;

    @FXML
    private TextField tf_PhoneNumber;

    @FXML
    private DatePicker dp_Birthdate;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeCol();
        displayUser();
        
    }

    private void initializeCol() {
        phone_numbercol.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
        first_namecol.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        last_namecol.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        email_addresscol.setCellValueFactory(new PropertyValueFactory<>("email_address"));
        pincol.setCellValueFactory(new PropertyValueFactory<>("PIN"));
        birthdatecol.setCellValueFactory(new PropertyValueFactory<>("birthdate"));
        countrycol.setCellValueFactory(new PropertyValueFactory<>("country"));
        addresscol.setCellValueFactory(new PropertyValueFactory<>("address"));
    }

    private void displayUser() {

        userlist.clear();

        ResultSet result = DatabaseHandler.getUsers();
        
        try {
            while (result.next()) {
                String phone_number = result.getString("phone_number");
                String first_name = result.getString("first_name");
                String last_name = result.getString("last_name");
                String email_address = result.getString("email_address");
                String PIN = result.getString("PIN");
                String birthdate = result.getString("birthdate");
                String country = result.getString("country");
                String address = result.getString("address");

                userlist.add(new User(phone_number, first_name, last_name, email_address, PIN, birthdate, country, address));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        mytable.setItems(userlist);

    }

    @FXML
    private void createUser(ActionEvent event) {
        if (isEmpty(tf_PhoneNumber) || isEmpty(tf_FirstName) || isEmpty(tf_LastName) ||
            isEmpty(tf_EmailAddress) || isEmpty(tf_PIN) || isEmpty(tf_Country) ||
            isEmpty(tf_Address) || dp_Birthdate.getValue() == null) {

                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ErrorEmptyField.fxml"));
                    Parent root = fxmlLoader.load();

                    ErrorEmptyFieldController controller = fxmlLoader.getController();
                    controller.setErrorMessage("An error has occured while processing action. Make sure to answer all fields before submitting.");

                    Stage newStage = new Stage();
                    newStage.setTitle("Error: Empty field");
                    newStage.setScene(new Scene(root));
                    newStage.centerOnScreen();
                    newStage.show();
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
        
        } else {

            String phoneNumber = tf_PhoneNumber.getText();
            String firstName = tf_FirstName.getText();
            String lastName = tf_LastName.getText();
            String emailAddress = tf_EmailAddress.getText();
            String MPIN = tf_PIN.getText();
            String country = tf_Country.getText();
            String address = tf_Address.getText();

            LocalDate selectedDate = dp_Birthdate.getValue();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            String birthDate = selectedDate.format(formatter);

            User user = new User(phoneNumber, firstName, lastName, emailAddress, MPIN, birthDate, country, address);

            if (DatabaseHandler.addUser(user)) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SuccessAccountCreated.fxml"));
                    Parent root = fxmlLoader.load();
                    Stage newStage = new Stage();
                    newStage.setTitle("Success: Account created");
                    newStage.setScene(new Scene(root));
                    newStage.centerOnScreen();
                    newStage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setContentText("Account Registration Failed");
                alert.showAndWait();
            }

        }
        displayUser();
    }

    private static boolean isEmpty(TextField field) {
        return field == null || field.getText().trim().isEmpty();
    }

    @FXML
    private void deleteUser(ActionEvent event) {
        User user = mytable.getSelectionModel().getSelectedItem();

        String phoneNumber = user.getPhone_number();

        if (DatabaseHandler.deleteUser(user)) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setContentText("Account Deleted");
            alert.showAndWait();
            displayUser();
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setContentText("Account Registered");
            alert.showAndWait();
        }

    }

    @FXML
    private void updateUser(ActionEvent event) {
        if (isEmpty(tf_PhoneNumber) || isEmpty(tf_FirstName) || isEmpty(tf_LastName) ||
            isEmpty(tf_EmailAddress) || isEmpty(tf_PIN) || isEmpty(tf_Country) ||
            isEmpty(tf_Address) || dp_Birthdate.getValue() == null) {

                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ErrorEmptyField.fxml"));
                    Parent root = fxmlLoader.load();
                    Stage newStage = new Stage();
                    newStage.setTitle("Error: Empty field");
                    newStage.setScene(new Scene(root));
                    newStage.centerOnScreen();
                    newStage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        
        } else {

            String phoneNumber = tf_PhoneNumber.getText();
            String firstName = tf_FirstName.getText();
            String lastName = tf_LastName.getText();
            String emailAddress = tf_EmailAddress.getText();
            String MPIN = tf_PIN.getText();
            String country = tf_Country.getText();
            String address = tf_Address.getText();

            LocalDate selectedDate = dp_Birthdate.getValue();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            String birthDate = selectedDate.format(formatter);

            User user = new User(phoneNumber, firstName, lastName, emailAddress, MPIN, birthDate, country, address);

            if (DatabaseHandler.updateUser(user)) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setContentText("User updated");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setContentText("Update cannot go through");
                alert.showAndWait();
            }

        }
        displayUser();
    }

}