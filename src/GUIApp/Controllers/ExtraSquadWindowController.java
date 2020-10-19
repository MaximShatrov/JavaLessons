package GUIApp.Controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import BattleSim.Units.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ExtraSquadWindowController {
    private int addField1;
    private int addField2;
    private int addField3;
    private int addField4;
    private String testString;
    private boolean isSquadSet = false;
    private Warrior[] warriors;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label winLabel;

    @FXML
    private Button okButton;

    @FXML
    private Button cancelButton;

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
    private Button increase1;

    @FXML
    private Button increase2;

    @FXML
    private Button increase3;

    @FXML
    private Button increase4;

    @FXML
    private Button decrease1;

    @FXML
    private Button decrease2;

    @FXML
    private Button decrease3;

    @FXML
    private Button decrease4;

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



    private String squadName = "NullName";

    public void makeWarriorMassive() {
        List<Warrior> arrayList = new ArrayList<>();
        if (addField1 > 0) {
            for (int i = 0; i < addField1; i++) arrayList.add(new Archer(squadName));
            setSquadSet(true);
        }
        if (addField2 > 0) {
            for (int i = 0; i < addField2; i++) arrayList.add(new Knight(squadName));
            setSquadSet(true);
        }
        if (addField3 > 0) {
            for (int i = 0; i < addField3; i++) arrayList.add(new Priest(squadName));
            setSquadSet(true);
        }
        if (addField4 > 0) {
            for (int i = 0; i < addField4; i++) arrayList.add(new Viking(squadName));
            setSquadSet(true);
        }
        warriors = arrayList.toArray(new Warrior[0]);
    }

    public Warrior[] getWarriors(){
        return warriors;
    }

    public void cancel(ActionEvent actionEvent) {
        clearAllValues();
        closeStage();
    }


    public void clearAllValues() {
        addField1 = 0;
        choosen1.setText(addField1+"");
        addField2 = 0;
        choosen2.setText(addField2+"");
        addField3 = 0;
        choosen3.setText(addField3+"");
        addField4 = 0;
        choosen4.setText(addField4+"");
        setSquadSet(false);
    }

    public void pressOk() {
        makeWarriorMassive();
        closeStage();
    }

    private void closeStage() {
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
    }

    public boolean isSquadSet() {
        return isSquadSet;
    }

    public void setSquadSet(boolean squadSet) {
        isSquadSet = squadSet;
    }
}
