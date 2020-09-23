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

    Client(String clientName, String password) {
        this.clientName = clientName;
        this.password = password;
    }

    public String getClientID() {
        return clientID;
    }

    public int getBalance() {
        return balance;
    }

    public void editbalance(int diff) {
        this.balance += diff;
    }

    public boolean passwordCheck(String tempPassword) {
        return password.equals(tempPassword);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (clientName != null ? !clientName.equals(client.clientName) : client.clientName != null) return false;
        return password != null ? password.equals(client.password) : client.password == null;
    }

    @Override
    public int hashCode() {
        int result = clientName != null ? clientName.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    public String getClientName() {
        return clientName;
    }

}
