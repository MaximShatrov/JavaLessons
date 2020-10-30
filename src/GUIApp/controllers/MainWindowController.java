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
    private final int SHAKE_DURATION= 50;
    private final float SHAKE_Xdf = 5f;

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


    /**
     * Инициализация окон и элементов окна.
     */
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


    /**
     * Метод вызываемый по нажатию кнопки "В бой!"
     * Формирует {@link MainWindowController#mainSquad1} и {@link MainWindowController#mainSquad2} на основе введенных пользователем данных.
     * Создает новые отряды (squad1 и squad2) из {@link MainWindowController#mainSquad1} {@link MainWindowController#extraSquad1} и {@link MainWindowController#mainSquad2} {@link MainWindowController#extraSquad2}.
     * Создает новую битву {@link Battle()}, передает в нее (squad1, squad2).
     * Получает из битвы лог.
     * Устанавливает активность полей и кнопок.
     * Выводит строку с именем победившего отряда.
     */
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

    /**
     * Открытие окна с логом битвы
     */
    @FXML
    void viewLog(ActionEvent event) {
        logWindowController.setLog(log.toString());
        logWindowController.setTitleLabel("Ход битвы");
        logStage.showAndWait();
    }

    /**
     * Метод вызываемый по нажатию кнопки "Новая битва"
     */
    @FXML
    void newBattle(ActionEvent event) {
        initNodes();
    }

    /**
     * Метод вызываемый по нажатию кнопки "Добавить" у первого отряда.
     * Открывает окно Добавления бойцов, ждет ввода данных.
     * Проверяет создался ли экстра-отряд. Если да - копирует его под именем "extraSquad1".
     */
    public void addUnit1(ActionEvent actionEvent) {
        exSqWindowController.clearAllValues();
        runStageExtraSquad();
        if (exSqWindowController.getSquadStatus()) {
            extraSquad1 = new Squad(exSqWindowController.getWarriors(), "extraSquad1");
            extraUnitsSquad1.setText(exSqWindowController.getWarriors().size() + "");
        }
    }

    /**
     * Метод вызываемый по нажатию кнопки "Добавить" у первого отряда.
     * Открывает окно Добавления бойцов, ждет ввода данных.
     * Проверяет создался ли экстра-отряд. Если да - копирует его под именем "extraSquad2".
     */
    public void addUnit2(ActionEvent actionEvent) {
        exSqWindowController.clearAllValues();
        runStageExtraSquad();
        if (exSqWindowController.getSquadStatus()) {
            extraSquad2 = new Squad(exSqWindowController.getWarriors(), "extraSquad2");
            extraUnitsSquad2.setText(exSqWindowController.getWarriors().size() + "");
        }
    }

    /**
     * Показывает состав {@link MainWindowController#extraSquad1} в новом окне.
     */
    public void showSquad1(ActionEvent actionEvent) {
        squadViewerController.setLog(squad1Origin.squadList());
        squadViewerController.setTitleLabel("Состав отряда " + squad1Origin.toString());
        squadViewerStage.showAndWait();
    }

    /**
     * Показывает состав {@link MainWindowController#extraSquad2} в новом окне.
     */
    public void showSquad2(ActionEvent actionEvent) {
        squadViewerController.setLog(squad2Origin.squadList());
        squadViewerController.setTitleLabel("Состав отряда " + squad2Origin.toString());
        squadViewerStage.showAndWait();
    }

    /**
     * Устанавливает TextField {@link MainWindowController#winLabel} и отображает его.
     */
    public void setWinLabel(String string) {
        winLabel.setText(string);
        winLabel.setVisible(true);
    }

    /**
     * Запускает окно добавления бойцов.
     */
    private void runStageExtraSquad() {
        exSqWindowController = extraSquadLoader.getController();
        extraSquadStage.showAndWait();
    }

    /**
     * Приводит поля и кнопки к начальному состоянию (состоянию ввода входящих параметров) и инициализирует экстра-отряды пустышки.
     */
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


    /**
     * Проверяет текстовые поля программы на корректность введеных/не введенных данных и их соответствие между собой:
     * 1) Поля не должны быть пустыми
     * 2) Поля не должны состоять из одних пробелов
     * 3) Поля численности отряда не должны содержать строк и быть отрицательными
     * 4) Экстра-отряды и случайно формируемые отряды не должны в сумме давать "ноль".
     * Указывает пользователю на некорректное поле.
     * @return Возвращает true если все условия соблюдены.
     */
    private boolean checkInputFields() {
        boolean squadSize1FieldIsOk;
        boolean squadSize2FieldIsOk;
        boolean squadname1isOk;
        boolean squadname2isOk;
        try {
            if (checkIntField(secondSquadSizeField)) {
                squadSize2FieldIsOk = !isSquadEmpty(secondSquadSizeField, extraSquad2);
            } else {
                focusField(secondSquadSizeField);
                squadSize2FieldIsOk = false;
            }
        } catch (NumberFormatException e) {
            System.out.println("В поле не текст");
            focusField(secondSquadSizeField);
            squadSize2FieldIsOk = false;
        }

        try {
            if (checkIntField(firstSquadSizeField)) {
                squadSize1FieldIsOk = !isSquadEmpty(firstSquadSizeField, extraSquad1);
            } else {
                focusField(firstSquadSizeField);
                squadSize1FieldIsOk = false;
            }
        } catch (NumberFormatException e) {
            System.out.println("В поле не текст");
            focusField(firstSquadSizeField);
            squadSize1FieldIsOk = false;
        }

        if (checkStringField(secondSquadnameField)) squadname2isOk = true;
        else {
            focusField(secondSquadnameField);
            squadname2isOk = false;
        }
        if (checkStringField(firstSquadnameField)) squadname1isOk = true;
        else {
            focusField(firstSquadnameField);
            squadname1isOk = false;
        }
        return (squadSize1FieldIsOk && squadSize2FieldIsOk && squadname1isOk && squadname2isOk);
    }

    /**
     * Проверяет текстовое поле чтобы оно
     * 1) Не было пустым
     * 2) Не состояло из одних пробелов
     * @return Возвращает true если все условия соблюдены.
     */
    private boolean checkStringField(TextField textField) {
        if (textField.getText() == null || textField.getText().trim().isEmpty()) return false;
        else return true;
    }

    /**
     * Проверяет текстовое поле чтобы оно
     * 1) Не было пустым
     * 2) Не состояло из одних пробелов
     * 3) Значение в поле было больше нуля
     * @return Возвращает true если все условия соблюдены.
     */
    private boolean checkIntField(TextField textField) {
        if (textField.getText() == null || textField.getText().trim().isEmpty() || Integer.parseInt(textField.getText()) < 0)
            return false;
        else return true;
    }

    /**
     * Проверяет необходимость введения численности отряда в textField.
     * @param textField поле задающее численностьо формируемого отряда со случаными бойцами
     * @param squad формируемый вручную отряд 1{@link MainWindowController#extraSquad1} или 2{@link MainWindowController#extraSquad2}. Если он имеет имя "empty" - значит он не создан и не имеет бойцов.
     * @return Возвращает true если формируемый вручную отряд не создан, а в TextField с численностью отряда введено число меньше нуля.
     * на {@link MainWindowController#SHAKE_Xdf} пикселей по оси X влево-вправо
     */
    boolean isSquadEmpty(TextField textField, Squad squad){
        if (squad.toString().equals("empty") && Integer.parseInt(textField.getText()) <= 0) {
            focusField(textField);
            return true;
        } else {return false;}
    }

    /**
     * "Трясет" переданный в метод node в течение {@link MainWindowController#SHAKE_DURATION} миллисикунд
     * на {@link MainWindowController#SHAKE_Xdf} пикселей по оси X влево-вправо
     */
    void shakeNode(Node node) {
        Shake shakeNode = new Shake(node, SHAKE_DURATION, SHAKE_Xdf);
        shakeNode.playAnim();
    }

    /**
     * Воспроизводит анимацию "тряски" у переданного в метода node и перемещает на него фокус.
     */
    void focusField(TextField  textField){
        shakeNode(textField);
        textField.requestFocus();
    }


}
