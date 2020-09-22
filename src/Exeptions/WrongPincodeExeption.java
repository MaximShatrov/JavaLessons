package Exeptions;

public class WrongPincodeExeption extends CardExeption {
    public WrongPincodeExeption(int attempt) {
        super("Неверный пин-код! У вас осталось " + attempt + " попытки!");
    }
}

