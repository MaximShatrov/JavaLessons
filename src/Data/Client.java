package Data;

import java.io.Serializable;

public class Client implements Serializable {
    private String clientID;
    private String clientName;
    private Card clientCard0;
    private Card clientCard1;
    private String password;
    private int balance;

    Client(String clientID, String clientName, String password) {
        this.clientID = clientID;
        this.clientName = clientName;
        this.password = password;
        this.balance = 0;
    }

    public String getClientID() {
        return clientID;
    }

    public boolean authorization(String tempPass) {
        return password.equals(tempPass);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (balance != client.balance) return false;
        if (clientID != null ? !clientID.equals(client.clientID) : client.clientID != null) return false;
        if (clientName != null ? !clientName.equals(client.clientName) : client.clientName != null) return false;
        if (clientCard0 != null ? !clientCard0.equals(client.clientCard0) : client.clientCard0 != null) return false;
        return clientCard1 != null ? clientCard1.equals(client.clientCard1) : client.clientCard1 == null;
    }

    @Override
    public int hashCode() {
        int result = clientID != null ? clientID.hashCode() : 0;
        result = 31 * result + (clientName != null ? clientName.hashCode() : 0);
        result = 31 * result + (clientCard0 != null ? clientCard0.hashCode() : 0);
        result = 31 * result + (clientCard1 != null ? clientCard1.hashCode() : 0);
        result = 31 * result + balance;
        return result;
    }
}
