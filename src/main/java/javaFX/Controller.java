package javaFX;

import javaFX.model.Person;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;


public class Controller {

    //referencja klasy main
    private Main main;

    @FXML
    private Button addButton;

    @FXML
    private Button removeButton;

    @FXML
    private Button editButton;

    @FXML
    private TableView<Person> personTableView;

    @FXML
    private TableColumn<Person, String> firstnameColumn;

    @FXML
    private TableColumn<Person, String> lastnameColumn;

    @FXML
    private Label firstnameLabel;

    @FXML
    private Label lastnameLabel;

    @FXML
    private Label streetLabel;

    @FXML
    private Label cityLabel;

    @FXML
    private Label postalCodeLabel;

    @FXML
    private Label birthdayLabel;

    @FXML
    private void initialize(){
        firstnameColumn.setCellValueFactory(data -> data.getValue().firstnameProperty());
        lastnameColumn.setCellValueFactory(data -> data.getValue().lastnameProperty());
        personTableView.getSelectionModel().selectedItemProperty().addListener((observable, x ,y) -> showPerson(y));
        addButton.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                addPerson();

            }
        });
        removeButton.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                removePerson();
            }
        });
        editButton.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                editPerson();
                firstnameColumn.setStyle("-fx-base: #55a2c6;");

            }
        });

    }


    public void showPerson(Person person){
        firstnameLabel.setText(person.getFirstname());
        lastnameLabel.setText(person.getLastname());
        streetLabel.setText(person.getStreet());
        cityLabel.setText(person.getCity());
        postalCodeLabel.setText(person.getPostalCode());
        birthdayLabel.setText(person.getBirthday());
    }

    public void addPerson(){
        try {
            FXMLLoader formLoader = new FXMLLoader(getClass().getClassLoader().getResource("FormLayout.fxml"));
            Parent root1 = formLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Adding a new person");
            stage.setScene(new Scene(root1));
            stage.show();

            AddControler controler = formLoader.getController();
            controler.setMain(this.main);

        } catch (IOException e) {
            e.printStackTrace();
        }
//
//        acceptFormButton.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
//            @Override
//            public void handle(javafx.event.ActionEvent event) {
//                main.addPerson();
//            }
//        });

    }

    public void removePerson(){
        int index = personTableView.getSelectionModel().getSelectedIndex();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Deleted");
        Person deleted = personTableView.getItems().get(index);
        alert.setHeaderText("UWAGA!!!!");
        alert.setContentText("Usunales " + deleted.getFirstname() + " " + deleted.getLastname());
        alert.showAndWait();
        this.main.removePerson(index);
    }

    public void editPerson(){
        this.main.editPerson();
    }

    public void setMain(Main main){
        this.main = main;
        personTableView.setItems(main.getPerson());
    }



}
