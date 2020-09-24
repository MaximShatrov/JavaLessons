package Data;

import java.io.Serializable;

public class Card implements Serializable {
    private StringBuffer number;
    private String clientID;
    private int pinCode;

    public Card(StringBuffer number, String clientID, int pinCode) {
        this.number = number;
        this.clientID = clientID;
        this.pinCode = pinCode;
    }

    public StringBuffer getNumber() {
        return number;
    }

    public String getClientID() {
        return clientID;
    }

    public boolean pinCodeCheck(int pinCode) {
        boolean check;
        if (this.pinCode == pinCode) {
            check = true;
        } else {
            check = false;
        }
        return check;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (pinCode != card.pinCode) return false;
        if (number != null ? !number.equals(card.number) : card.number != null) return false;
        return clientID != null ? clientID.equals(card.clientID) : card.clientID == null;
    }

    @Override
    public int hashCode() {
        int result = number != null ? number.hashCode() : 0;
        result = 31 * result + (clientID != null ? clientID.hashCode() : 0);
        result = 31 * result + pinCode;
        return result;
    }
}
