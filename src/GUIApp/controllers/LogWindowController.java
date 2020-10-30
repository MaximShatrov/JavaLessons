package GUIApp.controllers;

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
    private Label titleLabel;

    @FXML
    void initialize() {

    }

    /**
     * Записывает string в {@link LogWindowController#logText}
     * Используется для вывода лога
     * @param string входящая строка с логом
     */
    public void setLog(String string) {
        logText.setText(string);
    }

    /**
     * Записывает log в {@link LogWindowController#logText}
     * Используется для вывода состава отряда
     * @param log входящий StringBuilder
     */
    public void setLog(StringBuilder log) {
        logText.setText(log.toString());
    }

    /**
     * Закрывает окно
     */
    public void pressOk() {
        Stage stage = (Stage) okBtn.getScene().getWindow();
        stage.close();
    }

    /**
     * Устанавливает заголовок окна
     * @param string заголовок окна
     */
    public void setTitleLabel(String string) {
        titleLabel.setText(string);
    }
}
