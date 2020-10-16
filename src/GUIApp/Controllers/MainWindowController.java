package GUIApp.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

public class MainWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField firstSquadnameField;

    @FXML
    private TextField firstSquadSizeField;

    @FXML
    private MenuButton firstSquadExtraUnit;

    @FXML
    private TextField secondSquadnameField;

    @FXML
    private TextField secondSquadSizeField;

    @FXML
    private MenuButton secondSquadExtraUnit;

    @FXML
    private Button startSimulation;

    @FXML
    void initialize() {
        assert firstSquadnameField != null : "fx:id=\"firstSquadnameField\" was not injected: check your FXML file 'main_window.fxml'.";
        assert firstSquadSizeField != null : "fx:id=\"firstSquadSizeField\" was not injected: check your FXML file 'main_window.fxml'.";
        assert firstSquadExtraUnit != null : "fx:id=\"firstSquadExtraUnit\" was not injected: check your FXML file 'main_window.fxml'.";
        assert secondSquadnameField != null : "fx:id=\"secondSquadnameField\" was not injected: check your FXML file 'main_window.fxml'.";
        assert secondSquadSizeField != null : "fx:id=\"secondSquadSizeField\" was not injected: check your FXML file 'main_window.fxml'.";
        assert secondSquadExtraUnit != null : "fx:id=\"secondSquadExtraUnit\" was not injected: check your FXML file 'main_window.fxml'.";
        assert startSimulation != null : "fx:id=\"startSimulation\" was not injected: check your FXML file 'main_window.fxml'.";

    }
}
