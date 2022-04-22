package com.mycompany.assignment2;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SecondaryController {

    private Parent root;
    private Stage stage;
    private Scene scene;

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
    ContactManager cm;

    public void init(ContactManager cm) {
        this.cm = cm;
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

    @FXML
    private void addContact() {
        boolean valid = true;
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
        } else if (txtDay.getText().isEmpty() || !cm.isInt(txtDay.getText())) {
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
            if (cm.addContact(fname, lname, hphone, wphone, email, notes, streetInfo, streetInfo2, city, postalCode, province, country, day, month, year)) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Contact Added");
                alert.showAndWait().ifPresent(rs -> {
                    if (rs == ButtonType.OK) {
                        System.out.println("Pressed OK.");
                    }
                });
                txtFirstName.setText("");
                txtLastName.setText("");
                txtHomePhone.setText("");
                txtWorkPhone.setText("");
                txtEmail.setText("");
                txtNotes.setText("");
                txtStreetInfo.setText("");
                txtStreetInfo2.setText("");
                txtStreetInfo.setText("");
                txtCity.setText("");
                txtPostalCode.setText("");
                txtProvince.setText("");
                txtCountry.setText("");
                txtDay.setText("");
                txtMonth.setText("");
                txtYear.setText("");
            } else {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Contact with this number is already Exists");
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
