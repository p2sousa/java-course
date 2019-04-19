package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Hello world from JavaFX");

        Label lbl = new Label("Hello World from JavaFX <SON>");
        Button button = new Button("First button");
        TextField txt = new TextField();
        String[] arr = new String[]{"hello", "hi", "hi there"};
        ChoiceBox<String> choiceBox = new ChoiceBox<>(FXCollections.observableArrayList(arr));
        choiceBox.setTooltip(new Tooltip("Select your greeting"));
        CheckBox checkBox = new CheckBox("Caption");

        GridPane gridPane = new GridPane();
        BorderPane borderPane = new BorderPane();
        borderPane.setBottom(gridPane);

        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("File");
        menu.getItems().add(new MenuItem("New"));
        menu.getItems().add(new MenuItem("Save"));

        menuBar.getMenus().add(menu);
        menuBar.prefWidthProperty().bind(stage.widthProperty());
        borderPane.setTop(menuBar);

        gridPane.setPadding(new Insets(5));
        gridPane.setHgap(15);
        gridPane.setVgap(15);
        gridPane.autosize();

        Group group = new Group();
        Scene scene = new Scene(group, 400, 200);

        gridPane.add(lbl, 0, 0);
        gridPane.add(button, 0, 1);
        gridPane.add(txt, 0, 2);
        gridPane.add(choiceBox, 0, 3);
        gridPane.add(checkBox, 0, 4);

        group.getChildren().add(borderPane);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
