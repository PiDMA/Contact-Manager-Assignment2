/**
 * Mikhail Yugay 101312178
 * David Pinto 101280540
 * Yagnik Patel 101324163
 */

package com.mycompany.assignment2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.util.Callback;

public class PrimaryController {
    //initialize members of class
    private ContactManager cm = new ContactManager();
    PrimaryController pc = this;

    @FXML
    private TextField txtCity;
    @FXML
    private TextField txtName;

    @FXML
    private void filter() {
        String city = (txtCity.getText().isEmpty()) ? "" : txtCity.getText();
        String name = (txtName.getText().isEmpty()) ? "" : txtName.getText();
        fillContacts(city, name);

    }

    public void init(ContactManager cm) {
        this.cm = cm;
        contacts.getItems().clear();
        fillContacts();

    }
    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
    private ListView contacts;

    @FXML
    private void switchToSecondary(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("secondary.fxml"));
        root = loader.load();
        SecondaryController secondaryController = loader.getController();
        secondaryController.init(cm);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void switchToView(ActionEvent event, Contact contact) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("view.fxml"));
        root = loader.load();
        ViewController viewController = loader.getController();
        viewController.displayContact(contact, cm);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void initialize() {

       // fillContacts();
    }

    public static class HBoxCell extends HBox {

        Label label = new Label();
        Button btnEdit = new Button("View");
        Button btnDelete = new Button("Delete");
        PrimaryController pc;

        HBoxCell(String labelText, String phone, PrimaryController pc, ContactManager cm) {
            super();
            this.pc = pc;
            label.setText(labelText);
            label.setMaxWidth(Double.MAX_VALUE);
            HBox.setHgrow(label, Priority.ALWAYS);
            btnEdit.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        pc.switchToView(event, cm.getContactByPhone(phone));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }

            });
            btnDelete.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    cm.deleteContact(phone);
                    pc.fillContacts();
                }
            });

            this.getChildren().addAll(label, btnEdit, btnDelete);
        }
    }

    public Parent fillContacts() {
        contacts.getItems().clear();
        BorderPane layout = new BorderPane();

        List<HBoxCell> list = new ArrayList<>();
        for (int i = 0; i < cm.getNumOfContacts(); i++) {
            list.add(new HBoxCell(cm.getContacts().get(i).getFirstName() + " " + cm.getContacts().get(i).getLastName(), cm.getContacts().get(i).getWorkPhone(), this, cm));
        }

        ObservableList<HBoxCell> myObservableList = FXCollections.observableList(list);
        contacts.setItems(myObservableList);

        return layout;
    }

    public Parent fillContacts(String city, String name) {

        contacts.getItems().clear();
        List<HBoxCell> list = new ArrayList<>();
        //Displaying contacts
        BorderPane layout = new BorderPane();
        if (!city.equals("") && !name.equals("")) {
            for (int i = 0; i < cm.getNumOfContacts(); i++) {
                if (cm.getContacts().get(i).getHomeAddress().getCity().equals(city) && cm.getContacts().get(i).getFirstName().equals(name)) {
                    list.add(new HBoxCell(cm.getContacts().get(i).getFirstName() + " " + cm.getContacts().get(i).getLastName(), cm.getContacts().get(i).getWorkPhone(), this, cm));
                }
            }
        } else if (!city.equals("")) {
            for (int i = 0; i < cm.getNumOfContacts(); i++) {
                if (cm.getContacts().get(i).getHomeAddress().getCity().equals(city)) {
                    list.add(new HBoxCell(cm.getContacts().get(i).getFirstName() + " " + cm.getContacts().get(i).getLastName(), cm.getContacts().get(i).getWorkPhone(), this, cm));
                }
            }
        } else if (!name.equals("")) {
            for (int i = 0; i < cm.getNumOfContacts(); i++) {
                if (cm.getContacts().get(i).getFirstName().equals(name) || cm.getContacts().get(i).getLastName().equals(name)) {
                    list.add(new HBoxCell(cm.getContacts().get(i).getFirstName() + " " + cm.getContacts().get(i).getLastName(), cm.getContacts().get(i).getWorkPhone(), this, cm));
                }
            }
        } else {

            for (int i = 0; i < cm.getNumOfContacts(); i++) {
                list.add(new HBoxCell(cm.getContacts().get(i).getFirstName() + " " + cm.getContacts().get(i).getLastName(), cm.getContacts().get(i).getWorkPhone(), this, cm));
            }

        }

        ListView<HBoxCell> listView = new ListView<HBoxCell>();
        ObservableList<HBoxCell> myObservableList = FXCollections.observableList(list);
        contacts.setItems(myObservableList);

        return layout;
    }
}
