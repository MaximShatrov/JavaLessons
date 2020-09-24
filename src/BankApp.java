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
        printData.printString("Добро пожаловать в приложение DrinkoffBank.");
        while (true) {
            printData.printString("\nВыберите нужный пункт меню:");
            printData.printStringMenu("1. Войти в аккаунт" +
                    "\n2. Создать аккаунт" +
                    "\n3. Выйти из приложения");
            printData.printString("\nВаш выбор: ");
            int menuItem1Level = scanData.inputInt(sourceScanner);
            int menuItem2Level;
            if (menuItem1Level == bankApp.MENU_ITEM_1) {                        //Войти в аккаунт

                if (iTerminal.clientAuthorization()) {                          //авторизация
                    printData.printStringSuccess("Успешная авторизация.");
                    while (true) {
                        printData.printString("\nВыберите нужный пункт меню:");
                        printData.printStringMenu("1. Узнать баланс" +
                                "\n2. Снять деньги со счета" +
                                "\n3. Внести деньги на счет" +
                                "\n4. Привязать карту" +
                                "\n5. Удалить карту с аккаунта" +
                                "\n6. Удалить аккаунт(!)" +
                                "\n7. Выйти из ЛК");
                        printData.printString("Ваш выбор: ");
                        menuItem2Level = scanData.inputInt(sourceScanner);
                        if (menuItem2Level == bankApp.MENU_ITEM_1) {            //баланс
                            iTerminal.getAccountBalance();
                            //bankApp.menuDelay(2,printData);
                        } else if (menuItem2Level == bankApp.MENU_ITEM_2) {     //снять кэш
                            iTerminal.getMoney(sourceScanner);
                            //bankApp.menuDelay(2,printData);
                        } else if (menuItem2Level == bankApp.MENU_ITEM_3) {     //внести кэш
                            iTerminal.addMoney(sourceScanner);
                            //bankApp.menuDelay(2,printData);
                        } else if (menuItem2Level == bankApp.MENU_ITEM_4) {     //выпустить карту
                            iTerminal.addCard(sourceScanner);
                            //bankApp.menuDelay(2,printData);
                        } else if (menuItem2Level == bankApp.MENU_ITEM_5) {     //закрыть карту
                            iTerminal.removeCard(sourceScanner);
                            //bankApp.menuDelay(2,printData);
                        } else if (menuItem2Level == bankApp.MENU_ITEM_6) {     //удалить аккаунт клиента
                            if (iTerminal.deleteClient(sourceScanner)) {
                                break;
                            } else {
                                printData.printDelay(3, "Неудачная попвтка удаления аккаунта. Выход из ЛК через");
                                break;
                            }
                        } else if (menuItem2Level == bankApp.MENU_ITEM_7) {     //Выход
                            break;
                        } else {
                            printData.printStringError("Выберите корректный пункт меню!");
                        }
                    }
                } //else { printData.printStringError("Неудачная");}
            } else if (menuItem1Level == bankApp.MENU_ITEM_2) {
                iTerminal.makeNewClient();
                continue;

            } else if (menuItem1Level == bankApp.MENU_ITEM_3) {
                break;
            } else {
                printData.printString("Выберите корректный пункт меню.");
                continue;
            }
        }

    }

    private void menuDelay(int delay, PrintData printData){
        printData.printString("                                     "); //чтобы у printData.printStringSuccess() на предыдущей строке не "уходил" цвет.
                                                                        // При debug'е такое не наблюдается.
        printData.printDelay(delay, "Возврат в меню через");
    }

}

