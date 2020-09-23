import Data.ITerminal;
import Data.Service;
import IO.PrintData;
import IO.ScanData;

import java.util.Scanner;

public class BankApp {
    private final int MENU_ITEM_1 = 1;
    private final int MENU_ITEM_2 = 2;
    private final int MENU_ITEM_3 = 3;
    private final int MENU_ITEM_4 = 4;
    private final int MENU_ITEM_5 = 5;
    private final int MENU_ITEM_6 = 6;
    private final int MENU_ITEM_7 = 7;

    public static void main(String[] args) {
        BankApp bankApp = new BankApp();
        ITerminal iTerminal = new Service();
        Scanner sourceScanner = new Scanner(System.in);
        PrintData printData = new PrintData();
        ScanData scanData = new ScanData();
        printData.printString("Добро пожаловать в приложение DrinkoffBank." +
                "\nВыберите нужный пункт меню:" +
                "\n1. Войти в аккаунт" +
                "\n2. Создать аккаунт" +
                "\n\nВаш выбор: ");
        int menuItem1Level = scanData.inputInt(sourceScanner);
        int menuItem2Level;
        if (menuItem1Level == bankApp.MENU_ITEM_1) {                        //Войти в аккаунт
            if (iTerminal.clientAuthorization()) {                          //авторизация
                printData.printString("\nВыберите нужный пункт меню:" +
                        "\n\n1. Узнать баланс" +
                        "\n2. Снять деньги со счета" +
                        "\n3. Внести деньги на счет" +
                        "\n4. Выпустить карту" +
                        "\n5. Удалить карту с аккаунта" +
                        "\n6. Удалить аккаунт(!)" +
                        "\n7. Выйти из ЛК" +
                        "\n\nВаш выбор: ");
                menuItem2Level = scanData.inputInt(sourceScanner);
                if (menuItem2Level == bankApp.MENU_ITEM_1) {            //баланс
                    iTerminal.getAccountBalance();
                } else if (menuItem2Level == bankApp.MENU_ITEM_2) {     //снять кэш
                    iTerminal.getMoney(sourceScanner);
                } else if (menuItem2Level == bankApp.MENU_ITEM_3) {     //внести кэш
                    iTerminal.addMoney(sourceScanner);
                } else if (menuItem2Level == bankApp.MENU_ITEM_4) {     //выпустить карту
                    iTerminal.addCard();
                } else if (menuItem2Level == bankApp.MENU_ITEM_5) {     //закрыть карту
                    iTerminal.removeCard();
                } else if (menuItem2Level == bankApp.MENU_ITEM_6) {     //удалить аккаунт клиента
                    iTerminal.deleteClient();
                } else if (menuItem2Level == bankApp.MENU_ITEM_7) {     //Выход
                    //флаг выхода??
                } else {
                    printData.printString("Выберите корректный пункт меню!");
                }
            }


        } else if (menuItem1Level == bankApp.MENU_ITEM_2) {
            iTerminal.makeNewClient();

        } else {
            printData.printString("Выберите корректный пункт меню.");
        }
    }

}

