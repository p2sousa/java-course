package application;

import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login extends Application implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button btnLogin;


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root, 400, 400);

        String css = getClass().getResource("application.css").toExternalForm();
        scene.getStylesheets().add(css);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
    }

    @FXML
    private void login(Event event) throws IOException {
        if (username.getText().length() > 0 && password.getText().length() > 0) {
            if (username.getText().equals("admin") && password.getText().equals("admin")) {

                System.out.println("loged");

                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
                Scene scene = new Scene(root, 400, 400);

                stage.setScene(scene);
                stage.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Opss!! user not found!");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Opss!! Something went wrong");
            alert.showAndWait();
        }
    }

}
