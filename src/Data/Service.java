package Data;

import Exceptions.DuplicateCardException;
import Exceptions.DuplicatedAccountException;
import Exceptions.WrongPincodeException;
import IO.PrintData;
import IO.ScanData;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.UUID;

public class Service implements ITerminal {
    private ArrayList<Client> clientDB;
    private ArrayList<Card> cardDB;
    private Client openedClient;
    private Card openedCard;
    private PrintData printData = new PrintData();
    private ScanData scanData = new ScanData();

    public Service() {  //первичная инициализация массивов
        File cardDBFile = new File("./src/CardDataBase");
        File clientDBFile = new File("./src/ClientDataBase");
        if (cardDBFile.length() == 0) {
            cardDB = new ArrayList<Card>();
            //System.out.println("Файлы кардДБ пусты. Созданы новые массивы.");   //debug msg
        } else {
            readCardDBfromFile();
        }
        if (clientDBFile.length() == 0) {
            clientDB = new ArrayList<Client>();
            //System.out.println("Файлы клиентДБ пусты. Созданы новые массивы.");   //debug msg
        } else {
            readClientDBfromFile();
        }
    }

    public boolean clientAuthorization() {
        printData.printString("Введите имя акаунта:");
        String tempClientname = scanData.inputString();
        printData.printString("Введите пароль:");
        String tempPswrd = scanData.inputString();
        Client tempClient = new Client(tempClientname, tempPswrd);
        if (clientDB.contains(tempClient)) {
            openedClient = clientDB.get(clientDB.indexOf(tempClient));
            return true;
        } else {
            printData.printStringError("Аккаунт с таким именем и паролем не найден." +
                    "\nВозвращаем Вас в главное меню.");
            printData.printDelay(3, "Возврат в главное меню через");

            return false;
        }
    }

    private void readCardDBfromFile() {
        try (FileInputStream cardDBfile_FIS = new FileInputStream("./src/CardDataBase");
             ObjectInputStream readDB_OIS = new ObjectInputStream(cardDBfile_FIS)) {
            cardDB = (ArrayList<Card>) readDB_OIS.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
            e.printStackTrace();
        }
    }

    private void readClientDBfromFile() {
        try (FileInputStream clientDB_FIS = new FileInputStream("./src/ClientDataBase");
             ObjectInputStream readDB_OIS = new ObjectInputStream(clientDB_FIS)) {
            clientDB = (ArrayList<Client>) readDB_OIS.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
            e.printStackTrace();
        }
    }

    private void writeDBtoFile() {

        try (FileOutputStream clientDB_FOS = new FileOutputStream("./src/ClientDataBase");
             FileOutputStream cardDB_FOS = new FileOutputStream("./src/CardDataBase");
             ObjectOutputStream writeDB_OOS = new ObjectOutputStream(clientDB_FOS)) {
            writeDB_OOS.writeObject(clientDB);
        } catch (IOException e) {
            System.err.println("Failed to write clientDB. Сontact software distributor.");
            e.printStackTrace();
        }
        try (FileOutputStream clientDB_FOS = new FileOutputStream("./src/ClientDataBase");
             FileOutputStream cardDB_FOS = new FileOutputStream("./src/CardDataBase");
             ObjectOutputStream writeDB_OOS = new ObjectOutputStream(cardDB_FOS)) {
            writeDB_OOS.writeObject(cardDB);
        } catch (IOException e) {
            System.err.println("Failed to write cardDB. Сontact software distributor.");
            e.printStackTrace();
        }

    }

    private boolean isClientExists(String name) throws DuplicatedAccountException {
        Iterator<Client> iterator = clientDB.iterator();
        while (iterator.hasNext()) {
            Client client = iterator.next();
            if (client.getClientName().equals(name)) {
                throw new DuplicatedAccountException("Аккаунт с таким логином уже зарегестрирован в системе!" +
                        "\nПридумайте новый логин.");
            }
        }
        return false;
    }

    private boolean isCardExists(StringBuffer number) throws DuplicateCardException {
        Iterator<Card> iterator = cardDB.iterator();
        while (iterator.hasNext()) {
            Card card = iterator.next();
            if (card.getNumber().toString().equals(number.toString())) {
                throw new DuplicateCardException("Карта с таким номером уже зарегестрирована в системе!");
            }
        }
        return false;

    }

    private void updateClientDB() {
        clientDB.set(clientDB.indexOf(openedClient), openedClient);
        writeDBtoFile();
    }

    /**
     * private void updateCardDB() {
     * cardDB.set(cardDB.indexOf(openedCard), openedCard);
     * try {
     * writeDBtoFile();
     * } catch (IOException e) {
     * System.err.println("Failed to write DB. Сontact software distributor.");
     * e.printStackTrace();
     * }
     * }
     **/

    private void addClientToDB(String id, String clientName, String pswrd) {
        Client tempClient = new Client(id, clientName, pswrd);
        clientDB.add(tempClient);
        writeDBtoFile();
    }

    @Override
    public void getAccountBalance() {
        printData.printStringSuccess("На балансе вашего счета " + openedClient.getBalance() + "руб.");
    }

    @Override
    public void getMoney(Scanner input) {
        printData.printString("\nВведите сумму которую хотите снять. Выдаваемая сумма должна быть кратна 100руб!" +
                "\nВнесите 0 для отмены." +
                "\nСумма для снятия:");
        int wantedCash = 0;
        boolean getFlag = false;
        while (true) {
            wantedCash = scanData.inputInt(input);
            if (wantedCash % 100 == 0 && wantedCash > 0) {
                if (openedClient.getBalance() > wantedCash) {
                    openedClient.editbalance(-wantedCash);
                    getFlag = true;
                    break;
                } else {
                    try {
                        throw new InstantiationException("Недостаточно денег на счете. Уменьшите сумму.");
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            } else if (wantedCash < 0) {
                printData.printStringError("Вы не можете снять " + wantedCash + "руб. Попробуйте снова.");
                continue;
            } else if (wantedCash == 0) {
                break;
            } else {
                printData.printStringError("Сумма должна быть кратна 100! Мы не выдаем мелочь.");
                continue;
            }
        }
        if (getFlag) {
            updateClientDB();
            printData.printStringSuccess("Сумма в размере " + wantedCash + "руб. снята со счета." +
                    "\nОcтаток на счете: " + openedClient.getBalance() + "руб.");
        }


    }

    @Override
    public void addMoney(Scanner input) {
        printData.printString("\nВведите сумму которую хотите внести. Принимаются только купюры кратные 100руб!" +
                "\nВнесите 0 для отмены." +
                "\nВносимая сумма:");
        int wantedCash = 0;
        boolean addFlag = false;
        while (true) {
            wantedCash = scanData.inputInt(input);
            if (wantedCash % 100 == 0) {
                if (wantedCash > 0) {
                    openedClient.editbalance(wantedCash);
                    addFlag = true;
                    break;
                } else if (wantedCash == 0) {
                    break;
                } else {
                    printData.printStringError("Нельзя внести отрицательную сумму :) Попробуйте снова.");
                    continue;
                }
            } else {
                printData.printStringError("Мы не принимаем мелочь! Попробуйте снова.");
                continue;
            }
        }
        if (addFlag) {
            updateClientDB();
            printData.printStringSuccess("Сумма в размере " + wantedCash + "руб. успешно внесена на счет.");
        }
    }

    @Override
    public void makeNewClient() {
        String clientName = null;
        boolean newClientChecker = true;
        while (newClientChecker) {
            printData.printString("Введите имя аккаунта:");
            clientName = scanData.inputString();
            if (clientName == null) {
                printData.printStringError("Поле не может быть пустым!");
                continue;
            }
            try {
                if (!isClientExists(clientName)) {
                    newClientChecker = false;
                }
            } catch (DuplicatedAccountException e) {
                e.printStackTrace();
            }
        }

        String pswrd = null;
        boolean pswrdIdentityCheck = false;
        while (!pswrdIdentityCheck) {
            printData.printString("Придумайте пароль:");
            String pswrdTemp1 = scanData.inputString();
            printData.printString("Повторите пароль:");
            String pswrdTemp2 = scanData.inputString();
            if (pswrdTemp1.equals(pswrdTemp2)) {
                pswrd = pswrdTemp2;
                pswrdIdentityCheck = true;
            } else {
                printData.printString("Пароли не совпадают! Попробуйте снова.");
            }
        }
        //генерация уникального ID
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();

        addClientToDB(id, clientName, pswrd);
        printData.printStringSuccess("Аккаунт " + clientName + " успешно зарегестрирован в системе.");
        printData.printDelay(3, "Возврат в главное меню через");
    }

    @Override
    public boolean deleteClient(Scanner input) {
        printData.printStringError("Вы начали процедуру удаления аккаунта! " + openedClient.getClientName() + "!");
        boolean isDeleted = false;
        while (true) {
            printData.printString("Введите пароль от аккаунта:");
            if (openedClient.passwordCheck(scanData.inputString())) {
                printData.printStringSuccess("Верный пароль.");
                printData.printString("Вы уверены, что хотите удалить аккаунт и заблокировать все приявязанные к нему карты?");
                printData.printStringError("Данное действие необратимо!");
                printData.printString("Введите 'УВЕРЕН' чтобы потвердить удаление аккаунта:");
                if (scanData.inputString().equals("УВЕРЕН")) {
                    //удаление клиента
                    clientDB.remove(clientDB.indexOf(openedClient));
                    //удаление карт
                    Iterator<Card> iterator = cardDB.iterator();
                    while (iterator.hasNext()) {
                        Card card = iterator.next();
                        if (card.getClientID().equals(openedClient.getClientID())) {
                            cardDB.remove(card);
                            iterator = cardDB.iterator();
                        }
                    }
                    openedClient = null;
                    writeDBtoFile();
                    printData.printStringSuccess("Аккаунт успешно удален.");
                    isDeleted = true;
                    break;
                } else {
                    printData.printStringError("Процедура удаления аккаунта отменена из-за неверного подтверждения.");
                    break;
                }
            } else {
                printData.printStringError("Неверный пароль!");
                printData.printString("Введите \"1\" чтобы повторить ввод пароля.\n\t\t\"0\" для отмены.");
                if (scanData.inputInt(input) == 1) {
                    continue;
                } else {
                    printData.printStringError("Процедура удаления аккаунта отменена.");
                    break;

                }
            }
        }
        return isDeleted;
    }

    @Override
    public void addCard(Scanner input) {
        StringBuffer newCardNumber = new StringBuffer();
        boolean newCardNumberChecker = true;
        while (true) {
            printData.printString("Введите номер карты состоящий из 16 цифр, без пробелов.");
            newCardNumber.append(scanData.inputLong(input));
            System.out.println(1);
            for (int j = 4; j <= 14; j = j + 5) {                              //форматируем номер к виду  5321 23** **** ****
                newCardNumber.insert(j, " ");
            }
            System.out.println(2);
            if (newCardNumber.length() == 19) {
                try {
                    if (!isCardExists(newCardNumber)) {
                        break;
                    }
                } catch (DuplicateCardException e) {
                    e.printStackTrace();
                    printData.printStringError("Введите другие данные.");
                    newCardNumber.delete(0, newCardNumber.length());
                    continue;
                }
            } else {
                printData.printStringError("Вы ввели некоректный номер. Повторите ввод.");
                newCardNumber.delete(0, newCardNumber.length());
                continue;

            }
        }
        printData.printStringSuccess("Карта №" + newCardNumber);
        boolean newPinChecker = true;
        int newPin = 0;
        printData.printString("Придумайте четырехзначный пинкод:");
        while (newPinChecker) {
            int tempPin1 = scanData.inputInt(input);
            String checkLenght = new String(tempPin1 + "");
            if (checkLenght.length() != 4) {
                printData.printStringError("Пинкод должен состоять из 4 цифр! Повторите ввод:");
                continue;
            }
            printData.printString("Повторите ввод пикода:");
            int tempPin2 = scanData.inputInt(input);
            if (tempPin1 == tempPin2) {
                newPin = tempPin2;
                printData.printStringSuccess("Пинкод успешно сохранен.");
                newPinChecker = false;
            } else {
                printData.printStringError("Пинкод не совпадает с введенным ранее! Повторите заново.");
            }
        }
        cardDB.add(new Card(newCardNumber, openedClient.getClientID(), newPin));
        printData.printStringSuccess("Карта " + newCardNumber + " успешно привязана к аккаунту.");
        writeDBtoFile();
    }

    @Override
    public void removeCard(Scanner input) {
        printData.printString("Вы собираетесь удалить карту с данного аккаунта.");
        ArrayList<Card> cardListOfClient = getCardListOfClient();
        if (cardListOfClient.isEmpty()) {
            printData.printStringError("К данному аккаунту не привязана ни одна карта.");
        } else {

            while (true) {
                cardListOfClient = getCardListOfClient();
                printListOfcards(cardListOfClient);
                boolean isBlocked = true;
                printData.printStringMenu("0. Выйти");
                printData.printString("Введите порядковый номер карты, которую желаете удалить:");
                int selectCard = scanData.inputInt(input);

                if (selectCard < 0 | selectCard > cardListOfClient.size()) {
                    printData.printStringError("Выберите нужный пункт меню!");
                    continue;
                } else if (selectCard == 0) {
                    printData.printStringSuccess("Выход в ЛК. ");
                    break;
                } else {
                    Card removedCard = cardListOfClient.get(selectCard - 1);
                    printData.printString("Для удаления карты введите пинкод:");
                    for (int i = 0; i < 3; i++) {
                        if (removedCard.pinCodeCheck(scanData.inputInt(input))) {
                            cardDB.remove(removedCard);
                            isBlocked = false;
                            writeDBtoFile();
                            break;
                        } else {
                            try {
                                throw new WrongPincodeException("Неверный пинкод! У вас осталось " + (2 - i) + " попыток ввода.");
                            } catch (WrongPincodeException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                if (isBlocked) {
                    printData.printDelay(30, "Три неудычные попытки ввода пинкода! Доступк к консоли заблокирован на ");
                }
            }

        }

    }

    private ArrayList<Card> getCardListOfClient() {
        ArrayList<Card> cardListOfClient = new ArrayList<>();
        Iterator<Card> iterator = cardDB.iterator();
        while (iterator.hasNext()) {
            Card currentCard = iterator.next();
            if (currentCard.getClientID().equals(openedClient.getClientID())) {
                cardListOfClient.add(currentCard);
            }
        }
        return cardListOfClient;
    }

    private void printListOfcards(ArrayList<Card> cardlist) {
        for (int i = 0; i < cardlist.size(); i++) {
            Card card = cardlist.get(i);
            printData.printStringMenu((i + 1) + ". Карта " + card.getNumber());
        }
    }

    private StringBuffer generateNewCard() {
        printData.printString("Производим выпуск новой карты.");
        StringBuffer newCardNumber = new StringBuffer("532123");
        for (int i = 0; i < 10; i++) {                                  //генерируем номер вида     532123**********
            char addnum = (char) (Math.random() * 9);
            newCardNumber.append(addnum);
        }
        for (int j = 4; j <= 14; j = +5) {                              //форматируем номер к виду  5321 23** **** ****
            newCardNumber.insert(j, " ");
        }
        return newCardNumber;
    }
}
