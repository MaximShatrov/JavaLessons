package GUIApp;

import GUIApp.Controllers.ExtraSquadWindowController;
import GUIApp.Controllers.MainWindowController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("View/main_window.fxml"));
        primaryStage.setTitle("Симулятор битвы v.0.1_alpha");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void extraSquadWindow() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("View/extraSquad_window.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Симулятор битвы v.0.1_alpha");
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
