package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class EventApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Event handler");

        Label lbl = new Label("Input your name: ");
        Label lblGreeting = new Label();
        lblGreeting.setVisible(false);
        TextField txtName = new TextField();
        txtName.setTooltip(new Tooltip("Input your name here"));
        Button btnClick = new Button("Say hello");
        btnClick.setTooltip(new Tooltip("Click to greeting"));

        btnClick.setOnAction(event -> {
            if (txtName.getText().length() > 0) {
                lblGreeting.setText("Hello " + txtName.getText() + " this is my event");
                lblGreeting.setVisible(true);
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Opss!! Something went wrong");
                alert.showAndWait();
            }

        });

        GridPane gridPane = new GridPane();
        gridPane.setHgap(15);
        gridPane.setVgap(20);
        gridPane.autosize();
        gridPane.setPadding(new Insets(5, 5, 5, 5));

        gridPane.add(lbl, 0, 0);
        gridPane.add(txtName, 1, 0);
        gridPane.add(btnClick, 0, 1);
        gridPane.add(lblGreeting, 0, 2);

        Group groupItens = new Group();

        groupItens.getChildren().add(gridPane);
        Scene scene = new Scene(groupItens, 500, 200);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
