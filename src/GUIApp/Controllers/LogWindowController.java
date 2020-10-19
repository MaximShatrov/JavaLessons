package GUIApp.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class LogWindowController {

    public Text logText;

    private String log;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label logScrollPane;

    @FXML
    private TextFlow logTextWlow;

    @FXML
    private Button okBtn;

    @FXML
    void logOkBtn(ActionEvent event) {
        Stage stage = (Stage) okBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {

    }

    public void setLog(String string){
        logText.setText(string);
    }
}
