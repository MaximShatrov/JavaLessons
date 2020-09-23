package Data;

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

        if (cardDBFile.length() == 0 || clientDBFile.length() == 0) {
            clientDB = new ArrayList<Client>();
            cardDB = new ArrayList<Card>();
            System.out.println("Файлы ДБ пусты. Созданы новые массивы.");   //debug msg
        } else {
            try {
                readDBfromFile();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                System.out.println("Class not found");
                e.printStackTrace();
            }
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
            printData.printString("Аккаунт с таким именем и паролем не найден.");
            return false;
        }
    }

    private void readDBfromFile() throws IOException, ClassNotFoundException {
        FileInputStream clientDB_FIS = new FileInputStream("./src/ClientDataBase");
        FileInputStream cardDBfile_FIS = new FileInputStream("./src/CardDataBase");
        ObjectInputStream readDB_OIS = new ObjectInputStream(clientDB_FIS);
        clientDB = (ArrayList<Client>) readDB_OIS.readObject();
        readDB_OIS = new ObjectInputStream(cardDBfile_FIS);
        cardDB = (ArrayList<Card>) readDB_OIS.readObject();
        System.out.println("Read db Ok.");      //debug msg
        clientDB_FIS.close();
        cardDBfile_FIS.close();
        readDB_OIS.close();
    }

    private void writeDBtoFile() throws IOException {
        FileOutputStream clientDB_FOS = new FileOutputStream("./src/ClientDataBase");
        FileOutputStream cardDB_FOS = new FileOutputStream("./src/CardDataBase");
        ObjectOutputStream writeDB_OOS = new ObjectOutputStream(clientDB_FOS);
        writeDB_OOS.writeObject(clientDB);
        writeDB_OOS = new ObjectOutputStream(cardDB_FOS);
        writeDB_OOS.writeObject(cardDB);
        System.out.println("write db ok");      //debug msg
        clientDB_FOS.close();
        cardDB_FOS.close();
        writeDB_OOS.close();
    }

    private boolean findClientName(String name) {
        Iterator<Client> iterator = clientDB.iterator();
        while (iterator.hasNext()) {
            Client client = iterator.next();
            if (client.getClientName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    private void updateClientDB() {
        clientDB.set(clientDB.indexOf(openedClient), openedClient);
        try {
            writeDBtoFile();
        } catch (IOException e) {
            System.err.println("Failed to write DB. Сontact software distributor.");
            e.printStackTrace();
        }
    }

    private void updateCardDB() {
        cardDB.set(cardDB.indexOf(openedCard), openedCard);
        try {
            writeDBtoFile();
        } catch (IOException e) {
            System.err.println("Failed to write DB. Сontact software distributor.");
            e.printStackTrace();
        }
    }

    private void addClientToDB(String id, String clientName, String pswrd) {
        Client tempClient = new Client(id, clientName, pswrd);
        clientDB.add(tempClient);
        try {
            writeDBtoFile();
        } catch (IOException e) {
            System.err.println("Failed to write DB. Сontact software distributor.");
            e.printStackTrace();
        }
    }

    @Override
    public void getAccountBalance() {
        printData.printString("На балансе вашего счета " + openedClient.getBalance() + "руб.");
    }

    @Override
    public void getMoney(Scanner input) {
        printData.printString("\nВведите сумму которую хотите снять. Выдаваемая сумма должна быть кратна 100руб!" +
                "\nСумма для снятия:");
        int wantedCash = scanData.inputInt(input);
        if (wantedCash % 100 == 0 && wantedCash > 0) {
            if (openedClient.getBalance() > wantedCash) {
                openedClient.editbalance(-wantedCash);
            } else {
                printData.printString("Недостаточно денег на счете.");
            }
        } else if (wantedCash < 0) {
            printData.printString("Вы не можете снять " + wantedCash + "руб.");
        } else if (wantedCash == 0) {
            printData.printString("Вы не можете снять 0руб. :)");
        } else {
            printData.printString("Сумма должна быть кратна 100!");
        }
        updateClientDB();
        printData.printString("Сумма в размере" + wantedCash + "руб. снята со счета" +
                "\n Оcтаток на счете: " + openedClient.getBalance() + "руб.");

    }

    @Override
    public void addMoney(Scanner input) {
        printData.printString("\nВведите сумму которую хотите внести. Принимаются только купюры кратные 100руб!" +
                "\nВносимая сумма:");
        int wantedCash = scanData.inputInt(input);
        if (wantedCash % 100 == 0) {
            if (wantedCash > 0) {
                openedClient.editbalance(wantedCash);
            } else if (wantedCash == 0) {
                printData.printString("Вы пытаетесь внести 0 руб.");
            } else {
                printData.printString("Нельзя внести отрицательную сумму :) ");
            }
        } else {
            printData.printString("Где вы взяли такие купюры? Попробуйте снова.");
        }
        updateClientDB();
        printData.printString("Сумма в размере" + wantedCash + "руб. успешно внесена на счет.");
    }

    @Override
    public void makeNewClient() {
        printData = new PrintData();
        scanData = new ScanData();
        printData.printString("Введите имя аккаунта:");
        String clientName = scanData.inputString();
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
    }

    @Override
    public boolean deleteClient(Scanner input) {
        printData.printStringError("Вы начали процедуру удаления аккаунта! " + openedClient.getClientName() + "!");
        boolean cycleRepeat = true;
        boolean deleteConfirm = false;
        while (cycleRepeat) {
            printData.printString("Введите пароль от аккаунта:");
            if (openedClient.passwordCheck(scanData.inputString())) {
                printData.printStringSuccess("Верный пароль.");
                printData.printString("Вы уверены, что хотите удалить аккаунт и заблокировать все приявязанные к нему карты?");
                printData.printStringError("Данное действие необратимо!");
                printData.printString("Введите 'УВЕРЕН' чтобы потвердить удаление аккаунта:");
                if (scanData.inputString() == "УВЕРЕН") {
                    //удаление клиента
                    clientDB.remove(clientDB.indexOf(openedClient));

                    //удаление карт
                    System.err.println("ЗДЕСТЬ ДОЛЖНО БЫТЬ УДАЛЕНИЕ КАРТ АККАУНТА.");       //debug msg

                    openedClient = null;
                    printData.printStringSuccess("Аккаунт успешно удален.");
                    deleteConfirm = true;
                    cycleRepeat = false;
                } else {
                    cycleRepeat = false;
                    printData.printStringError("Процедура удаления аккаунта отменена из-за неверного подтверждения.");
                    deleteConfirm = false;
                }
            } else {
                printData.printStringError("Неверный пароль!");
                printData.printString("Введите '1' чтобы повторить ввод пароля.");
                if (scanData.inputInt(input) == 1) {
                    cycleRepeat = true;
                } else {
                    cycleRepeat = false;
                    printData.printStringError("Процедура удаления аккаунта отменена.");
                    deleteConfirm = false;
                }
            }
        }
        return deleteConfirm;
    }

    @Override
    public void addCard() {

    }

    @Override
    public void removeCard() {

    }
}
