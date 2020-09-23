package Exceptions;

public class BlockedAccountExeption extends CardExeption {
    public BlockedAccountExeption(){
        super("Данный аккаунт заблокирован!");
    }
}
