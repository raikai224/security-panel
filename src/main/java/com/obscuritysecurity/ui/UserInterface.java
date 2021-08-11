package main.java.com.obscuritysecurity.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.com.obscuritysecurity.business.utils.Timer;

public class UserInterface extends Application {

    /**
     * The entry point of application.
     * <p>
     * Creates and instance of the timer to tick every second
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Timer.instance();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("obscuritysecurity.fxml"));
        primaryStage.setTitle("Obscurity Security");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
