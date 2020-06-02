package maxim;

class RunProgram {
    static Account[] dataBase;
    private static StringBuilder id;


    public static void main(String[] args) {
        System.out.println("Добро пожаловать!");
        {
            dataBase = new Account[100];
            for (int i = 0; i < dataBase.length; i++) {
                dataBase[i] = new Account();
            }
        }
        while (true) {
            System.out.println("Что вы хотите сделать?\n" +
                    "1.Войти в аккаунт \n" +
                    "2.Создать аккаунт");
            int lvlSet = Console.scanInputMenuSelect();
            switch (lvlSet) {
                case 1:
                    loginAccount();
                    break;
                case 2:
                    createAccount();
                    break;
                default:
                    System.out.println("Некорректный пункт! Повторите ввод:");
            }
        }
    }

    private static void createAccount() {
        boolean loginAlreadyTaken = true;
        int i = 0;
        System.out.println("Придумайте логин (минимум 6 знаков):");
        for (i = 0; i < dataBase.length; i++) {
            while (loginAlreadyTaken) {
                id = Console.scanInputLogin();
                for (int j = 0; j < dataBase.length; j++) {
                    if (dataBase[j].getLogin() == id) {
                        System.err.println("Данный логин уже занят! Введите новый");
                        loginAlreadyTaken = true;
                        continue;
                    } else {
                        loginAlreadyTaken = false;
                    }
                }
            }
            if (!dataBase[i].isExistsFlag()) {
                dataBase[i].setLogin(id);
                System.out.println("Введите свои Фамилию Имя и Отчество (через пробел):");
                dataBase[i].setFullName(Console.scanInputFullName());
                System.out.println("Введите свою дату рождения в формате ДД.ММ.ГГГГ :");
                dataBase[i].setBirthDate(Console.scanInputBirthdate());
                System.out.println("Укажите город проживания:");
                dataBase[i].setCity(Console.scanInputCity());
                System.out.println("Введите паспортные данные; \nСерию и номер в формате ХХХХ ХХХХХХ:");
                dataBase[i].setPassportSerial(Console.scanInputSerial());
                System.out.println("Кем и когда выдан:");
                dataBase[i].setPassportInfo(Console.scanInputPassportInfo());
                System.out.println("Укажите номер телефона в формате +7ХХХХХХХХХХ:");
                dataBase[i].setMobileNumber(Console.scanInputMobileNumber());
                System.out.println("Укажите адрес сайта:");
                dataBase[i].setSite(Console.scanInputString());
                System.out.println("Укажите место работы и должность:");
                dataBase[i].setWorkInfo(Console.scanInputString());
                System.out.println("Напишите немного о себе:");
                dataBase[i].setInfo(Console.scanInputString());
                //System.out.println("Выберите аватар:");
                dataBase[i].setAvatar();
                System.out.println("Поздравляем! Ваш аккаунт успешно создан.");
                dataBase[i].setExistsFlag(true);                    //аккаунт создан
                break;
            }
        }
    }


    private static void loginAccount() {
        boolean findAccount = false;
        System.out.println("Введите логин:");
        id = Console.scanInputSB();
        for (int i = 0; i < dataBase.length; i++) {
            if (dataBase[i].isExistsFlag() & dataBase[i].getLogin().toString().equals(id.toString())) {
                System.out.println("Аккаунт с таким логином найден \n");
                findAccount = true;
                System.out.println(dataBase[i].toString());
                System.out.println("\n");
                break;
            }
        }
        if (!findAccount) {
            System.err.println("Аккаунт с таким логином не найден!");
        }
    }
}
