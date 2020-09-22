package Exeptions;

public class DuplicatedAccountExeption extends CardExeption {
    public DuplicatedAccountExeption(){
        super("Данный аккаунт уже существует!");
    }
}
