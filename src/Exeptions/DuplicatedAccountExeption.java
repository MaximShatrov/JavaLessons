package Exeptions;

public class DuplicatedAccountExeption extends CardExeption {
    public DuplicatedAccountExeption(){
        System.err.println("Данный аккаунт уже существует!");
    }
}
