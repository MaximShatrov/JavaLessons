package Data;

import java.io.Serializable;

public class Card implements Serializable {
    private String number;
    private String clientID;

    public Card(String number, String clientID) {
        this.number = number;
        this.clientID = clientID;
    }
}
