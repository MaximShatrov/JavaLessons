package GUIApp.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import BattleSim.Battle;
import BattleSim.Squad;
import BattleSim.Units.Warrior;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
    private Parent p2;
    private FXMLLoader extraSquadLoader;
    private Stage extraSquadStage;
    private ExtraSquadWindowController exSqWindowController;
    private FXMLLoader logLoader;
    private Stage logStage;
    private LogWindowController logWindowController;
    private Squad extraSquad1 = new Squad(0, "empty");
    private Squad extraSquad2 = new Squad(0, "empty");
    private Squad mainSquad1;
    private Squad mainSquad2;
    private String squadName1;
    private String squadName2;
    private int mainSquadQnt1 = 0;
    private int mainSquadQnt2 = 0;
    private StringBuffer log;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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
    private Button addUnit_1_btn;

    @FXML
    private TextField secondSquadnameField;

    @FXML
    private TextField secondSquadSizeField;

    @FXML
    private Button addUnit_2_btn;

    @FXML
    private Text extraUnitsSquad1;

    @FXML

    private Text extraUnitsSquad2;


    @FXML
    void newBattle(ActionEvent event) {
        //firstSquadnameField.clear();
        //secondSquadnameField.clear();
        firstSquadSizeField.clear();
        secondSquadSizeField.clear();
        extraUnitsSquad1.setText("0");
        extraUnitsSquad2.setText("0");
        winLabel.setVisible(false);
        openLogButton.setDisable(true);
        newBattleBtn.setDisable(true);
        startSimulationButton.setDisable(false);
        extraSquad1 = new Squad(0, "empty");
        extraSquad2 = new Squad(0, "empty");
    }

    @FXML
    void startBattle(ActionEvent event) {
        mainSquad1 = new Squad(Integer.parseInt(firstSquadSizeField.getText()), firstSquadnameField.getText());
        mainSquad2 = new Squad(Integer.parseInt(secondSquadSizeField.getText()), secondSquadnameField.getText());
        Squad squad1;
        Squad squad2;
        if (extraSquad1.toString() == "empty"){
            squad1 = mainSquad1;
        } else {
            squad1 = new Squad(mainSquad1, extraSquad1, mainSquad1.toString());
        }
        if (extraSquad2.toString() == "empty"){
            squad2 = mainSquad2;
        } else {
            squad2 = new Squad(mainSquad2, extraSquad2, mainSquad2.toString());
        }


        Battle battle = new Battle(squad1, squad2);

        battle.startBattle();
        battle.getWinSquad();
        log = battle.getLog();
        openLogButton.setDisable(false);
        setWinLabel("Победил отряд " + battle.getWinSquad() + "!!!");


        winLabel.setVisible(true);
        startSimulationButton.setDisable(true);
        newBattleBtn.setDisable(false);
    }

    @FXML
    void viewLog(ActionEvent event) {
        logWindowController.setLog(log.toString());
        runLogStage();
    }

    @FXML
    void initialize() throws IOException {
        extraSquadLoader = new FXMLLoader();
        extraSquadLoader.setLocation(getClass().getResource("/GUIApp/View/extraSquad_window.fxml"));
        try {
            extraSquadLoader.load();
        } catch (IOException e) {
            System.out.println("не смог загрузить extraSquad_window.fxml");
            //e.printStackTrace();
        }
        p = extraSquadLoader.getRoot();
        extraSquadStage = new Stage();
        extraSquadStage.setScene(new Scene(p));
        extraSquadStage.setTitle("Добавление бойцов");
        extraSquadStage.initModality(Modality.APPLICATION_MODAL);
        extraSquadStage.setResizable(false);
        exSqWindowController = extraSquadLoader.getController();

        logLoader = new FXMLLoader();
        logLoader.setLocation(getClass().getResource("/GUIApp/View/log_window.fxml"));
        try {
            logLoader.load();
        } catch (IOException e) {
            System.out.println("не смог загрузить log_window.fxml");
            //e.printStackTrace();
        }
        p2 = logLoader.getRoot();
        logStage = new Stage();
        logStage.setScene(new Scene(p2));
        logStage.setTitle("Ход битвы");
        logStage.setResizable(false);
        logWindowController = logLoader.getController();


    }

    public void addUnit1(ActionEvent actionEvent) {
        exSqWindowController.clearAllValues();
        runStageExtraSquad();
        if (exSqWindowController.isSquadSet()) {
            extraSquad1 = new Squad(exSqWindowController.getWarriors(), "extraSquad1");
            extraUnitsSquad1.setText(exSqWindowController.getWarriors().length + "");
        } else   extraSquad1 = new Squad(0, "empty");
    }


    public void addUnit2(ActionEvent actionEvent) {
        exSqWindowController.clearAllValues();
        runStageExtraSquad();
        if (exSqWindowController.isSquadSet()) {
            extraSquad2 = new Squad(exSqWindowController.getWarriors(), "extraSquad2");
            extraUnitsSquad2.setText(exSqWindowController.getWarriors().length + "");
        } else extraSquad2 = new Squad(0, "empty");
    }

    public void setWinLabel(String string) {
        winLabel.setText(string);
        winLabel.setVisible(true);
    }

    private void runStageExtraSquad() {
        exSqWindowController = extraSquadLoader.getController();
        extraSquadStage.showAndWait();
    }

    private void runLogStage() {
        logWindowController = logLoader.getController();
        logStage.showAndWait();
    }
}
