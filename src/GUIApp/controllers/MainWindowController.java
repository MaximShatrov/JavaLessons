package GUIApp.controllers;

import java.io.IOException;

import BattleSim.Battle;
import BattleSim.Squad;
import GUIApp.animations.Shake;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainWindowController {
    private Parent p;
    private FXMLLoader extraSquadLoader;
    private Stage extraSquadStage;
    private ExtraSquadWindowController exSqWindowController;
    private FXMLLoader logLoader;
    private Stage logStage;
    private LogWindowController logWindowController;
    private FXMLLoader squadViewerLoader;
    private Stage squadViewerStage;
    LogWindowController squadViewerController;
    private Squad extraSquad1 = new Squad(0, "empty");
    private Squad extraSquad2 = new Squad(0, "empty");
    private Squad mainSquad1;
    private Squad mainSquad2;
    private Squad squad1Origin;
    private Squad squad2Origin;
    private StringBuilder log;

    @FXML
    private Button startSimulationButton;

    @FXML
    private Button openLogButton;

    @FXML
    private Label winLabel;

    @FXML
    private Button newBattleBtn;

    @FXML
    private TextField firstSquadnameField;

    @FXML
    private TextField firstSquadSizeField;

    @FXML
    private TextField secondSquadnameField;

    @FXML
    private TextField secondSquadSizeField;

    @FXML
    private Button addUnit_1_btn;
    @FXML
    private Button addUnit_2_btn;

    @FXML
    private Button showSquad1_btn;

    @FXML
    private Button showSquad2_btn;

    @FXML
    private Text extraUnitsSquad1;

    @FXML
    private Text extraUnitsSquad2;

    @FXML
    void initialize() throws IOException {
        extraSquadLoader = new FXMLLoader();
        extraSquadLoader.setLocation(getClass().getResource("/GUIApp/view/extraSquad_window.fxml"));
        try {
            extraSquadLoader.load();
        } catch (IOException e) {
            System.out.println("не смог загрузить extraSquad_window.fxml");
            e.printStackTrace();
        }
        p = extraSquadLoader.getRoot();
        extraSquadStage = new Stage();
        extraSquadStage.setScene(new Scene(p));
        extraSquadStage.setTitle("Добавление бойцов");
        extraSquadStage.initModality(Modality.APPLICATION_MODAL);
        extraSquadStage.setResizable(false);
        exSqWindowController = extraSquadLoader.getController();

        logLoader = new FXMLLoader();
        logLoader.setLocation(getClass().getResource("/GUIApp/view/log_window.fxml"));
        try {
            logLoader.load();
        } catch (IOException e) {
            System.out.println("не смог загрузить log_window.fxml");
            e.printStackTrace();
        }
        p = logLoader.getRoot();
        logStage = new Stage();
        logStage.setScene(new Scene(p));
        logStage.setTitle("Ход битвы");
        logStage.setResizable(false);
        logWindowController = logLoader.getController();

        squadViewerLoader = new FXMLLoader();
        squadViewerLoader.setLocation(getClass().getResource("/GUIApp/view/log_window.fxml"));
        try {
            squadViewerLoader.load();
        } catch (IOException e) {
            System.out.println("не смог загрузить log_window.fxml");
            e.printStackTrace();
        }
        p = squadViewerLoader.getRoot();
        squadViewerStage = new Stage();
        squadViewerStage.setScene(new Scene(p));
        squadViewerStage.setTitle("Список бойцов");
        squadViewerStage.setResizable(false);
        squadViewerController = squadViewerLoader.getController();
        initNodes();
    }


    @FXML
    void startBattle(ActionEvent event) {
        if (checkInputFields()) {
            mainSquad1 = new Squad(Integer.parseInt(firstSquadSizeField.getText()), firstSquadnameField.getText());
            mainSquad2 = new Squad(Integer.parseInt(secondSquadSizeField.getText()), secondSquadnameField.getText());
            Squad squad1;
            Squad squad2;
            if (extraSquad1.toString() == "empty") {
                squad1 = mainSquad1;
            } else {
                squad1 = new Squad(mainSquad1, extraSquad1, mainSquad1.toString());
            }
            if (extraSquad2.toString() == "empty") {
                squad2 = mainSquad2;
            } else {
                squad2 = new Squad(mainSquad2, extraSquad2, mainSquad2.toString());
            }
            try {
                squad1Origin = squad1.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            try {
                squad2Origin = squad2.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            Battle battle = new Battle(squad1, squad2);
            battle.startBattle();
            battle.getWinSquad();
            log = battle.getLog();
            firstSquadnameField.setDisable(true);
            secondSquadnameField.setDisable(true);
            firstSquadSizeField.setDisable(true);
            secondSquadSizeField.setDisable(true);
            addUnit_1_btn.setDisable(true);
            addUnit_2_btn.setDisable(true);
            openLogButton.setDisable(false);
            setWinLabel("Победил отряд " + battle.getWinSquad() + "!!!");
            winLabel.setVisible(true);
            startSimulationButton.setDisable(true);
            newBattleBtn.setDisable(false);
            showSquad1_btn.setDisable(false);
            showSquad2_btn.setDisable(false);
        }
    }

    @FXML
    void viewLog(ActionEvent event) {
        logWindowController.setLog(log.toString());
        logWindowController.setTitleLabel("Ход битвы");
        logStage.showAndWait();
    }

    @FXML
    void newBattle(ActionEvent event) {
        initNodes();
    }

    public void addUnit1(ActionEvent actionEvent) {
        exSqWindowController.clearAllValues();
        runStageExtraSquad();
        if (exSqWindowController.isSquadSet()) {
            extraSquad1 = new Squad(exSqWindowController.getWarriors(), "extraSquad1");
            extraUnitsSquad1.setText(exSqWindowController.getWarriors().size() + "");
        } else extraSquad1 = new Squad(0, "empty");
    }


    public void addUnit2(ActionEvent actionEvent) {
        exSqWindowController.clearAllValues();
        runStageExtraSquad();
        if (exSqWindowController.isSquadSet()) {
            extraSquad2 = new Squad(exSqWindowController.getWarriors(), "extraSquad2");
            extraUnitsSquad2.setText(exSqWindowController.getWarriors().size() + "");
        } else extraSquad2 = new Squad(0, "empty");
    }

    public void showSquad1(ActionEvent actionEvent) {
        squadViewerController.setLog(squad1Origin.squadList());
        squadViewerController.setTitleLabel("Состав отряда " + squad1Origin.toString());
        squadViewerStage.showAndWait();
    }

    public void showSquad2(ActionEvent actionEvent) {
        squadViewerController.setLog(squad2Origin.squadList());
        squadViewerController.setTitleLabel("Состав отряда " + squad2Origin.toString());
        squadViewerStage.showAndWait();
    }

    public void setWinLabel(String string) {
        winLabel.setText(string);
        winLabel.setVisible(true);
    }

    private void runStageExtraSquad() {
        exSqWindowController = extraSquadLoader.getController();
        extraSquadStage.showAndWait();
    }

    private void initNodes() {
        firstSquadSizeField.clear();
        secondSquadSizeField.clear();
        extraUnitsSquad1.setText("0");
        extraUnitsSquad2.setText("0");
        winLabel.setVisible(false);
        openLogButton.setDisable(true);
        newBattleBtn.setDisable(true);
        showSquad1_btn.setDisable(true);
        showSquad2_btn.setDisable(true);
        startSimulationButton.setDisable(false);
        firstSquadnameField.setDisable(false);
        secondSquadnameField.setDisable(false);
        firstSquadSizeField.setDisable(false);
        secondSquadSizeField.setDisable(false);
        addUnit_1_btn.setDisable(false);
        addUnit_2_btn.setDisable(false);
        extraSquad1 = new Squad(0, "empty");
        extraSquad2 = new Squad(0, "empty");
    }

    private boolean checkInputFields() {
        boolean state1;
        boolean state2;
        boolean state3;
        boolean state4;
        try {
            if (checkIntField(secondSquadSizeField)) {
                if (Integer.parseInt(secondSquadSizeField.getText()) <= 0 & extraSquad2.toString() == "empty") {
                    shakeField(secondSquadSizeField);
                    secondSquadSizeField.requestFocus();
                    state2 = false;
                } else state2 = true;
            } else {
                shakeField(secondSquadSizeField);
                secondSquadSizeField.requestFocus();
                state2 = false;
            }
        } catch (NumberFormatException e) {
            System.out.println("в поле не текст");
            shakeField(secondSquadSizeField);
            secondSquadSizeField.requestFocus();
            state2 = false;
        }
        try {
            if (checkIntField(firstSquadSizeField)) {
                if (Integer.parseInt(firstSquadSizeField.getText()) <= 0 & extraSquad1.toString() == "empty") {
                    shakeField(firstSquadSizeField);
                    firstSquadSizeField.requestFocus();
                    state1 = false;
                } else state1 = true;
            } else {
                shakeField(firstSquadSizeField);
                firstSquadSizeField.requestFocus();
                state1 = false;
            }
        } catch (NumberFormatException e) {
            System.out.println("в поле не текст");
            shakeField(firstSquadSizeField);
            firstSquadSizeField.requestFocus();
            state1 = false;
        }

        if (checkStringField(secondSquadnameField)) state4 = true;
        else {
            shakeField(secondSquadnameField);
            secondSquadnameField.requestFocus();
            state4 = false;
        }
        if (checkStringField(firstSquadnameField)) state3 = true;
        else {
            shakeField(firstSquadnameField);
            firstSquadnameField.requestFocus();
            state3 = false;
        }
        return (state1 && state2 && state3 && state4);
    }

    private boolean checkStringField(TextField textField) {
        if (textField.getText() == null || textField.getText().trim().isEmpty()) return false;
        else return true;
    }

    private boolean checkIntField(TextField textField) {
        if (textField.getText() == null || textField.getText().trim().isEmpty() || Integer.parseInt(textField.getText()) < 0)
            return false;
        else return true;
    }

    void shakeField(Node node) {
        Shake shakeNode = new Shake(node, 50, 5f);
        shakeNode.playAnim();
    }
}
