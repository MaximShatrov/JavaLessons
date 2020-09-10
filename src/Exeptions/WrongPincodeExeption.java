package Exeptions;

public class WrongPincodeExeption extends CardExeption {
    public WrongPincodeExeption(int attempt) {
        if (attempt == 2) {
            System.err.println("Неверный пин-код! У вас осталось " + attempt + " попытки!");
        }
        if (attempt == 1) {
            System.err.println("Неверный пин-код! У вас осталась " + attempt + " попытка!");
        }
        else {
            System.err.println("Вы ввели неправильный пин-код 3 раза. Ваша карта заблокирована.");
        }
    }
}

