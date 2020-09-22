package Data;

import java.io.IOException;

public interface ITerminal {

    String getAccountBalance();

    void getMoney();

    void addMoney();

    void makeNewClient() throws IOException;

    void deleteClient();

    void addCard();

    void removeCard();


}
