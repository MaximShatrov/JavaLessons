package maxim;

class RunProgram {
    static Account[] dataBase;
    private static StringBuilder id;

    {
        dataBase = new Account[100];
        for (int i = 0; i < dataBase.length; i++) {
            dataBase[i] = new Account();
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println("Введите свой ID:");
        id = Console.scanInputSB();
        for (Account account : dataBase) {
            if (account.getLogin() == id) {
                loginAccount();
            } else {
                System.err.println("Идентификатора не найден в списке существующих, хотите создать аккаунт?");
                System.out.println("1. Да");
                System.out.println("2. Нет");
                int menuSelect = Console.scanInputMenuSelect();
                switch (menuSelect) {
                    case 1:
                        createAccount();
                        break;
                    case 2:
                        System.out.println("До свидания!");
                        break;
                    default:
                        System.err.println("Что-то пошло не так, обратитесь к администратору.");
                }

            }
        }
    }

    private static void createAccount() {
        for (int i = 0; i < dataBase.length; i++) {
            if (!dataBase[i].isExistsFlag()) {
                //создание аккаунта00
                System.out.println("Введите логин (минимум 6 знаков):");
                dataBase[i].setLogin(Console.scanInputLogin());
                System.out.println("Введите свои Фамилию Имя и Отчество (через пробел):");
                dataBase[i].setFullName(Console.scanInputFullName());
                System.out.println("Введите свою дату рождения в формате ДД.ММ.ГГГГ :");
                dataBase[i].setBirthDate(Console.scanInputBirthdate());
                System.out.println("Укажите город проживания:");
                dataBase[i].setCity(Console.scanInputString());
                System.out.println("Введите паспортные данные; \n Серию и номер в формате ХХХХ ХХХХХХ:");
                dataBase[i].setPassportSerial(Console.scanInputSerial());
                System.out.println("Кем и когда выдан:");
                dataBase[i].setPassportInfo(Console.scanInputPassportInfo());
                System.out.println("Укажите номер телефона в формате +79ХХХХХХХХХ:");
                dataBase[i].setMobileNumber(Console.scanInputMobileNumber());
                System.out.println("Укажите адрес сайта:");
                dataBase[i].setSite(Console.scanInputSite());
                System.out.println("Укажите место работы и должность:");
                dataBase[i].setWorkInfo(Console.scanInputString());
                System.out.println("Напишите немного о себе:");
                dataBase[i].setInfo(Console.scanInputString());
                System.out.println("Выберите аватар:");
                dataBase[i].setInfo(Console.scanInputString());
                dataBase[i].setExistsFlag(true);                    //аккаунт создан

            }
        }
    }

    private static void loginAccount() {
        for (int i = 0; i < dataBase.length; i++) {
            if (dataBase[i].isExistsFlag()) {

            }
        }
    }
}