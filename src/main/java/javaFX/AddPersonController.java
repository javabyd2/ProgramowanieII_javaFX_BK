package javaFX;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddPersonController {

    //referencja klasy main
    private Main main;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private Button acceptFormButton;

    @FXML
    private void initialize(){
        acceptFormButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                main.addPerson(firstNameField.getCharacters().toString(),lastNameField.getCharacters().toString());

            }
        });
    }


    public void setMain(Main main){
        this.main = main;
    }

}
