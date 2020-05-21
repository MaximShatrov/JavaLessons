package maxim;

class RunProgram {
    static Account[] dataBase;
    private static String id;

    {
        dataBase = new Account[100];
        for (int i = 0; i < dataBase.length; i++) {
            dataBase[i] = new Account();
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println("Введите свой ID:");
        id = Console.scanInputString();
        for (Account account : dataBase) {
            if (account.geteMail() == id) {

            } else {
                System.out.println("Идентификатора не найден в списке существующих, хотите создать аккаунт?");

            }
        }
    }

    private static void createAccount() {
        for (int i = 0; i < dataBase.length; i++) {
            if (!dataBase[i].isExistsFlag()) {
            }
        }
    }

    private static void loginAccount() {
        for (int i = 0; i < dataBase.length; i++) {
            if (!dataBase[i].isExistsFlag()) {

            }
        }
    }
}