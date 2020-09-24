package Data;

import java.io.IOException;
import java.util.Scanner;

public interface ITerminal {

    void getAccountBalance();

    void getMoney(Scanner input);

    void addMoney(Scanner input);

    void makeNewClient();

    boolean deleteClient(Scanner input);

    void addCard(Scanner input);

    void removeCard(Scanner input);

    boolean clientAuthorization();
}
