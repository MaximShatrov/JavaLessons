package Exeptions;

public class InsufficientFundsExeption extends CardExeption {

    public InsufficientFundsExeption(){
        //super("Недостаточно денег на балансе! Пополните счет.");
        System.err.println("Недостаточно денег на балансе! Пополните счет.");    }
}
