package Data;

public class Client {
    private String clientID;
    private String clientName;
    private Card clientCard;
    private int balance;

    Client(String clientID, String clientName, Card clientCard){
        this.clientID = clientID;
        this.clientName = clientName;
        this.clientCard = clientCard;
        this.balance = 0;
    }
}
