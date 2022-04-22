/**
 * Mikhail Yugay 101312178
 * David Pinto 101280540
 * Yagnik Patel 101324163
 */
package com.mycompany.assignment2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ViewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtHomePhone;
    @FXML
    private TextField txtWorkPhone;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtNotes;
    @FXML
    private TextField txtStreetInfo;
    @FXML
    private TextField txtStreetInfo2;
    @FXML
    private TextField txtCity;
    @FXML
    private TextField txtPostalCode;
    @FXML
    private TextField txtProvince;
    @FXML
    private TextField txtCountry;
    @FXML
    private TextField txtDay;
    @FXML
    private TextField txtMonth;
    @FXML
    private TextField txtYear;
    Contact contact;

    public void displayContact(Contact contact, ContactManager cm) {
        this.cm = cm;
        this.contact = contact;
        txtFirstName.setText(contact.getFirstName());
        txtLastName.setText(contact.getLastName());
        txtHomePhone.setText(contact.getHomePhone());
        txtWorkPhone.setText(contact.getWorkPhone());
        txtEmail.setText(contact.getEmail());
        txtNotes.setText(contact.getNotes());
        txtStreetInfo.setText(contact.getHomeAddress().getStreetInfo1());
        txtStreetInfo2.setText(contact.getHomeAddress().getStreetInfo2());
        txtStreetInfo.setText(contact.getHomeAddress().getStreetInfo1());
        txtCity.setText(contact.getHomeAddress().getCity());
        txtPostalCode.setText(contact.getHomeAddress().getPostalCode());
        txtProvince.setText(contact.getHomeAddress().getProvince());
        txtCountry.setText(contact.getHomeAddress().getCountry());
        txtDay.setText(contact.getBirthday().getDay() + "");
        txtMonth.setText(contact.getBirthday().getMonth() + "");
        txtYear.setText(contact.getBirthday().getYear() + "");
    }

    private Parent root;
    private Stage stage;
    private Scene scene;
    private ContactManager cm;

    @FXML
    private void switchToPrimary(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("primary.fxml"));
        root = loader.load();
        PrimaryController primaryController = loader.getController();
        primaryController.init(cm);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void edit() {
        boolean valid = true;
        //Large check to prevent empty values
        if (txtFirstName.getText().isEmpty()) {
            valid = false;
        } else if (txtLastName.getText().isEmpty()) {
            valid = false;
        } else if (txtHomePhone.getText().isEmpty()) {
            valid = false;
        } else if (txtWorkPhone.getText().isEmpty()) {
            valid = false;
        } else if (txtEmail.getText().isEmpty()) {
            valid = false;
        } else if (txtNotes.getText().isEmpty()) {
            valid = false;
        } else if (txtStreetInfo.getText().isEmpty()) {
            valid = false;
        } else if (txtStreetInfo2.getText().isEmpty()) {
            valid = false;
        } else if (txtCity.getText().isEmpty()) {
            valid = false;
        } else if (txtPostalCode.getText().isEmpty()) {
            valid = false;
        } else if (txtProvince.getText().isEmpty()) {
            valid = false;
        } else if (txtCountry.getText().isEmpty()) {
            valid = false;
        } else if (txtDay.getText().isEmpty() || !cm.isInt(txtDay.getText())) { //Double check that the date provided is an int for the constructor
            txtDay.setText("");
            txtDay.setPromptText("Please enter a number");
            txtMonth.setText("");
            txtMonth.setPromptText("Please enter a number");
            txtYear.setText("");
            txtYear.setPromptText("Please enter a number");
            valid = false;
        } else if (txtMonth.getText().isEmpty() || !cm.isInt(txtMonth.getText())) {
            txtDay.setText("");
            txtDay.setPromptText("Please enter a number");
            txtMonth.setText("");
            txtMonth.setPromptText("Please enter a number");
            txtYear.setText("");
            txtYear.setPromptText("Please enter a number");
            valid = false;
        } else if (txtYear.getText().isEmpty() || !cm.isInt(txtYear.getText())) {
            txtDay.setText("");
            txtDay.setPromptText("Please enter a number");
            txtMonth.setText("");
            txtMonth.setPromptText("Please enter a number");
            txtYear.setText("");
            txtYear.setPromptText("Please enter a number");
            valid = false;
        }

        if (valid) { 
            //If valid we organize the input data then create a new contact
            String fname = txtFirstName.getText();
            String lname = txtLastName.getText();
            String hphone = txtHomePhone.getText();
            String wphone = txtWorkPhone.getText();
            String email = txtEmail.getText();
            String notes = txtNotes.getText();
            String streetInfo = txtStreetInfo.getText();
            String streetInfo2 = txtStreetInfo2.getText();
            String city = txtCity.getText();
            String postalCode = txtPostalCode.getText();
            String province = txtProvince.getText();
            String country = txtCountry.getText();
            int day = Integer.parseInt(txtDay.getText());
            int month = Integer.parseInt(txtMonth.getText());
            int year = Integer.parseInt(txtYear.getText());
            contact.setWorkPhone("not available");//
            System.out.println(cm.getContactByPhone(wphone));
            if (cm.getContactByPhone(wphone) == null) {
                contact.setFirstName(fname);
                contact.setLastName(lname);
                contact.setHomePhone(hphone);
                contact.setWorkPhone(wphone);
                contact.setEmail(email);
                contact.setNotes(notes);
                contact.getHomeAddress().setStreetInfo1(streetInfo);
                contact.getHomeAddress().setStreetInfo2(streetInfo2);
                contact.getHomeAddress().setCity(city);
                contact.getHomeAddress().setPostalCode(postalCode);
                contact.getHomeAddress().setProvince(province);
                contact.getHomeAddress().setCountry(country);
                contact.getBirthday().setDay(day);
                contact.getBirthday().setMonth(month);
                contact.getBirthday().setYear(year);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Contact Updated");
                alert.showAndWait().ifPresent(rs -> {
                    if (rs == ButtonType.OK) {
                        System.out.println("Pressed OK.");
                    }
                });

            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Contact with this number is already Exists");
                //alert.setContentText("I have a great message for you!");
                alert.showAndWait().ifPresent(rs -> {
                    if (rs == ButtonType.OK) {
                        System.out.println("Pressed OK.");
                    }
                });
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Values");
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });
        }
    }

}
