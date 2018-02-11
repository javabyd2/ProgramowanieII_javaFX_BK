package javaFX;

import javaFX.model.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    private ObservableList<Person> personObservableList = FXCollections.observableArrayList();

    public Main(){
        personObservableList.add(new Person("Jan", "Kowalski"));
        personObservableList.add(new Person("Jan", "Kowalski"));
        personObservableList.add(new Person("Jan", "Kowalski"));
        personObservableList.add(new Person("Jan", "Kowalski"));
        personObservableList.add(new Person("Jan", "Kowalski"));
        personObservableList.add(new Person("Jan", "Kowalski"));
        personObservableList.add(new Person("Jan", "Kowalski"));
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane root = FXMLLoader.load(getClass().getClassLoader().getResource("RootLayout.fxml"));
        AnchorPane mainMenu = FXMLLoader.load(getClass().getClassLoader().getResource("PersonLayout.fxml"));


        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.setMinWidth(620);
        primaryStage.setMinHeight(485);


        primaryStage.show();
        root.setCenter(mainMenu);
        mainMenu.setMinSize(600,400);

    }



    public static void main(String[] args) {
        launch(args);
    }
}