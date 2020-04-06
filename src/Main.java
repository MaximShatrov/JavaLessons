import java.util.Scanner;

public class Main {
    private static final int EASY_LEVEL = 1;
    private static final int MEDIUM_LEVEL = 2;
    private static final int HARD_LEVEL = 3;
    private static final int EXIT = 4;

    public static void main(String[] args) {
        boolean menuExit = true;
        Console.print("Выберите нужное задание:");
        Console.print("1. Изи");
        Console.print("2. Медиум");
        Console.print("3. Хард");
        Console.print("4. Выход");
        Console.print("\n" + "Ваш выбор:");
        while (menuExit) {
            Scanner lvlChoose = new Scanner(System.in);
            int lvlSet = lvlChoose.nextInt();
            switch (lvlSet) {
                case EASY_LEVEL:
                    Easy.easyTask();
                    menuExit = false;
                    break;
                case MEDIUM_LEVEL:
                    menuExit = false;
                    break;
                case HARD_LEVEL:
                    Hard.hardTask();
                    menuExit = false;
                    break;
                case EXIT:
                    menuExit = false;
                    break;
                default:
                    Console.print("Некорректный пункт! Повторите ввод:");
            }
        }

    }


}









