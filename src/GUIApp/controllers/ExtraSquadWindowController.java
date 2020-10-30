package GUIApp.controllers;

import java.util.ArrayList;

import BattleSim.Units.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ExtraSquadWindowController {
    private int addField1;
    private int addField2;
    private int addField3;
    private int addField4;
    private boolean isSquadSet = false;
    private ArrayList<Warrior> warriors;
    private String squadName = "NullName";


    @FXML
    private Button okButton;


    @FXML
    private Text className1;

    @FXML
    private Text className2;

    @FXML
    private Text className3;

    @FXML
    private Text className4;

    @FXML
    private Text damage1;

    @FXML
    private Text damage2;

    @FXML
    private Text damage3;

    @FXML
    private Text damage4;

    @FXML
    private Text hp1;

    @FXML
    private Text hp2;

    @FXML
    private Text hp3;

    @FXML
    private Text hp4;

    @FXML
    private Text choosen1;

    @FXML
    private Text choosen2;

    @FXML
    private Text choosen3;

    @FXML
    private Text choosen4;

    @FXML
    void decrease1(ActionEvent event) {
        if (addField1 > 0) {
            addField1 -= 1;
            choosen1.setText(addField1 + "");
        }
    }

    @FXML
    void decrease2(ActionEvent event) {
        if (addField2 > 0) {
            addField2 -= 1;
            choosen2.setText(addField2 + "");
        }
    }

    @FXML
    void decrease3(ActionEvent event) {
        if (addField3 > 0) {
            addField3 -= 1;
            choosen3.setText(addField3 + "");
        }
    }

    public void decrease4(ActionEvent actionEvent) {
        if (addField4 > 0) {
            addField4 -= 1;
            choosen4.setText(addField4 + "");
        }
    }

    @FXML
    void increase1(ActionEvent event) {
        addField1 += 1;
        choosen1.setText(addField1 + "");
    }

    @FXML
    void increase2(ActionEvent event) {
        addField2 += 1;
        choosen2.setText(addField2 + "");
    }

    @FXML
    void increase3(ActionEvent event) {
        addField3 += 1;
        choosen3.setText(addField3 + "");
    }

    @FXML
    void increase4(ActionEvent event) {
        addField4 += 1;
        choosen4.setText(addField4 + "");
    }


    /**
     * Инициализация полей окна выбора классов.
     */
    @FXML
    void initialize() {
        Archer archer = new Archer(squadName);
        Knight knight = new Knight(squadName);
        Priest priest = new Priest(squadName);
        Viking viking = new Viking(squadName);
        className1.setText(archer.getUnitType());
        damage1.setText(archer.attack() + "");
        hp1.setText(archer.getHealth() + "");
        className2.setText(knight.getUnitType());
        damage2.setText(knight.attack() + "");
        hp2.setText(knight.getHealth() + "");
        className3.setText(priest.getUnitType());
        damage3.setText(priest.attack() + "");
        hp3.setText(priest.getHealth() + "");
        className4.setText(viking.getUnitType());
        damage4.setText(viking.attack() + "");
        hp4.setText(viking.getHealth() + "");
    }

    /**
     * Инициализирует ArrayList<Warrior> на основе выбранных пользователем данных
     */
    public void makeWarriorMassive() {
        warriors = new ArrayList<>();
        if (addField1 > 0) {
            for (int i = 0; i < addField1; i++) warriors.add(new Archer(squadName));
            setSquadSet(true);
        }
        if (addField2 > 0) {
            for (int i = 0; i < addField2; i++) warriors.add(new Knight(squadName));
            setSquadSet(true);
        }
        if (addField3 > 0) {
            for (int i = 0; i < addField3; i++) warriors.add(new Priest(squadName));
            setSquadSet(true);
        }
        if (addField4 > 0) {
            for (int i = 0; i < addField4; i++) warriors.add(new Viking(squadName));
            setSquadSet(true);
        }
    }

    /**
     * @return Возвращает ArrayList<Warrior> {@link ExtraSquadWindowController#warriors}
     */
    public ArrayList<Warrior> getWarriors() {
        return warriors;
    }

    /**
     * Закрывает окно и обнуляет значения полей.
     */
    public void cancel(ActionEvent actionEvent) {
        clearAllValues();
        closeStage();
    }

    /**
     * Приводит к нулю все значения полей addField#, устанавливает флаг isSquadSet в false
     */
    public void clearAllValues() {
        addField1 = 0;
        choosen1.setText(addField1 + "");
        addField2 = 0;
        choosen2.setText(addField2 + "");
        addField3 = 0;
        choosen3.setText(addField3 + "");
        addField4 = 0;
        choosen4.setText(addField4 + "");
        setSquadSet(false);
    }

    /**
     * Создает массив ArrayList<Warrior> {@link ExtraSquadWindowController#warriors}
     * Закрвает окно.
     */
    public void pressOk() {
        makeWarriorMassive();
        closeStage();
    }

    /**
     * Закрвает stage.
     */
    private void closeStage() {
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
    }

    /**
     * @param squadSet устанавливаемое значение флага {@link ExtraSquadWindowController#isSquadSet}
     */
    public void setSquadSet(boolean squadSet) {
        isSquadSet = squadSet;
    }

    /**
     * @return возвращает значение флага {@link ExtraSquadWindowController#isSquadSet}
     */
    public boolean getSquadStatus() {
        return isSquadSet;
    }
}
