import Data.ITerminal;
import IO.PrintData;
import IO.ScanData;

import java.util.Scanner;

public class BankApp {
    private final int MENU_ITEM_1 = 1;
    private final int MENU_ITEM_2 = 2;
    private final int MENU_ITEM_3 = 3;
    private final int MENU_ITEM_4 = 4;

    public static void main(String[] args) {
        BankApp bankApp = new BankApp();
        ITerminal iTerminal = new Console();
        Scanner sourceScanner = new Scanner(System.in);
        PrintData printData = new PrintData();
        ScanData scanData = new ScanData();

        printData.printString("Добро пожаловать в приложение DrinkoffBank." +
                "\nВыберите нужный пункт меню:" +
                "\n1. Узнать баланс счета" +
                "\n2. Снять/внести деньги на счет" +
                "\n3. Создать/удалить клиентский аккаунт" +
                "\n4. Привязать/удалить карту с аккаунта" +
                "\n\nВаш выбор: ");
        int menuItem1Level = scanData.inputInt(sourceScanner);
        int menuItem2Level;
        if (menuItem1Level == bankApp.MENU_ITEM_1) {
            iTerminal.getAccountBalance();
        } else if (menuItem1Level == bankApp.MENU_ITEM_2) {
            printData.printString("\nВыберите нужный пункт меню:" +
                    "\n1. Снять деньги со счета" +
                    "\n2. Внести деньги на счет" +
                    "\n\nВаш выбор: ");
            menuItem2Level = scanData.inputInt(sourceScanner);
            if (menuItem2Level == bankApp.MENU_ITEM_1) {
                iTerminal.getMoney();
            } else if (menuItem2Level == bankApp.MENU_ITEM_2) {
                iTerminal.addMoney();
            } else {
                printData.printString("Выберите корректный пункт меню.");
            }
        } else if (menuItem1Level == bankApp.MENU_ITEM_3) {
            printData.printString("\nВыберите нужный пункт меню:" +
                    "\n1. Создать клиентский аккаунт" +
                    "\n2. Удалить клиентский аккаунт" +
                    "\n\nВаш выбор: ");
            menuItem2Level = scanData.inputInt(sourceScanner);
            if (menuItem2Level == bankApp.MENU_ITEM_1) {

            } else if (menuItem2Level == bankApp.MENU_ITEM_2) {

            } else {
                printData.printString("Выберите корректный пункт меню.");
            }
        } else if (menuItem1Level == bankApp.MENU_ITEM_4) {
            printData.printString("\nВыберите нужный пункт меню:" +
                    "\n1. Привязать карту к аккаунту" +
                    "\n2. Удалить карту с аккаунта" +
                    "\n\nВаш выбор: ");
            menuItem2Level = scanData.inputInt(sourceScanner);
            if (menuItem2Level == bankApp.MENU_ITEM_1) {
                iTerminal.addCard();
            } else if (menuItem2Level == bankApp.MENU_ITEM_2) {
                iTerminal.removeCard();
            } else {
                printData.printString("Выберите корректный пункт меню.");
            }
        } else {
            printData.printString("Выберите корректный пункт меню.");
        }


    }
}

