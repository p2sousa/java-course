package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Hello World From JavaFX");

        Label lbl = new Label("Hello World From JavaFX <Pablo>");
        Scene scene = new Scene(lbl, 400, 200);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
