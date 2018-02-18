package javaFX;

import javaFX.model.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    private ObservableList<Person> personObservableList = FXCollections.observableArrayList();

    public Main(){
        personObservableList.add(new Person("Jan", "Kowalski"));
        personObservableList.add(new Person("Adam", "abc"));
        personObservableList.add(new Person("Piotr", "sdfs"));
        personObservableList.add(new Person("Anna", "sfg"));
        personObservableList.add(new Person("Ola", "srthrth"));
        personObservableList.add(new Person("Zygmunt", "rthsth"));
        personObservableList.add(new Person("Tomasz", "srhtr"));
    }

    public ObservableList getPerson(){
        return personObservableList;
    }

    public void editPerson(String firstName, String lastName, int index){
        personObservableList.get(index).setFirstname(firstName);
        personObservableList.get(index).setLastname(lastName);
    }

    public void addPerson(String firstName, String lastName){
        personObservableList.add(new Person(firstName, lastName));
    }

    public void removePerson(int index){
        personObservableList.remove(index);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("PersonLayout.fxml"));

        BorderPane root = FXMLLoader.load(getClass().getClassLoader().getResource("RootLayout.fxml"));
        AnchorPane mainMenu = loader.load();

        Controller controller = loader.getController();
        controller.setMain(this);

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.setMinWidth(620);
        primaryStage.setMinHeight(485);


        primaryStage.show();
        root.setCenter(mainMenu);
        //root.setCenter(addPersonForm);

        mainMenu.setMinSize(600,400);

    }



    public static void main(String[] args) {
        launch(args);
    }
}
