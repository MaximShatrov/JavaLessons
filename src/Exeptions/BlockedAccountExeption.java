package Exeptions;

public class BlockedAccountExeption extends CardExeption {
    public BlockedAccountExeption(){
        System.err.println("Данный аккаунт заблокирован!");
    }
}
