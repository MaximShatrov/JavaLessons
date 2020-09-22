package Data;

import IO.PrintData;
import IO.ScanData;

import java.io.*;
import java.util.ArrayList;
import java.util.UUID;

public class Service implements ITerminal {
    private ArrayList<Client> clientDB;
    private ArrayList<Card> cardDB;

    public Service() {  //первичная инициализация массивов
        File cardDBFile = new File("./src/CardDataBase");
        File clientDBFile = new File("./src/ClientDataBase");

        if (cardDBFile.length() == 0 || clientDBFile.length() == 0) {
            clientDB = new ArrayList<Client>();
            cardDB = new ArrayList<Card>();
            System.out.println("Файлы ДБ пусты. Созданы новые массивы.");
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

    private void readDBfromFile() throws IOException, ClassNotFoundException {
        FileInputStream clientDB_FIS = new FileInputStream("./src/ClientDataBase");
        FileInputStream cardDBfile_FIS = new FileInputStream("./src/CardDataBase");
        ObjectInputStream readDB_OIS = new ObjectInputStream(clientDB_FIS);
        clientDB = (ArrayList<Client>) readDB_OIS.readObject();
        readDB_OIS = new ObjectInputStream(cardDBfile_FIS);
        cardDB = (ArrayList<Card>) readDB_OIS.readObject();
        System.out.println("Read db Ok.");
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
        System.out.println("write db ok");
        clientDB_FOS.close();
        cardDB_FOS.close();
        writeDB_OOS.close();
    }


    @Override
    public String getAccountBalance() {
        return null;
    }

    @Override
    public void getMoney() {

    }

    @Override
    public void addMoney() {

    }

    @Override
    public void makeNewClient() throws IOException {
        PrintData printData = new PrintData();
        ScanData scanData = new ScanData();
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
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        Client tempClient = new Client(id, clientName, pswrd);
        clientDB.add(tempClient);
        writeDBtoFile();
    }

    @Override
    public void deleteClient() {

    }

    @Override
    public void addCard() {

    }

    @Override
    public void removeCard() {

    }
}
