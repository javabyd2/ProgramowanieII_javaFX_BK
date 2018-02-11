package javaFX;

import javaFX.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class Controller {

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



}
