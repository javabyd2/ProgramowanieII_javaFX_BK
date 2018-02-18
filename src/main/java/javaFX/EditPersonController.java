package javaFX;

import javaFX.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EditPersonController {

    //referencja klasy main
    private Main main;

    private int selectedRecordIndex;

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
                main.editPerson(firstNameField.getCharacters().toString(),lastNameField.getCharacters().toString(),selectedRecordIndex);

            }
        });
    }

    public void setSelectedRecordIndex(int selectedRecordIndex) {
        this.selectedRecordIndex = selectedRecordIndex;
    }


    public void setMain(Main main){
        this.main = main;
    }
}
