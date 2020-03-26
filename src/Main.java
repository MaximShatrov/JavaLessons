import java.util.Scanner;

public class Main {
    private static final int EASY_LEVEL = 1;
    private static final int MEDIUM_LEVEL = 2;
    private static final int HARD_LEVEL = 3;
    private static final int EXIT = 4;

    public static void main(String[] args) {
        boolean menuExit = true;
        System.out.println("Выберите нужное задание:");
        System.out.println("1. Изи");
        System.out.println("2. Медиум");
        System.out.println("3. Хард");
        System.out.println("4. Выход");
        System.out.println("\n" + "Ваш выбор:");
        while (menuExit) {
            Scanner lvlChoose = new Scanner(System.in);
            int lvlSet = lvlChoose.nextInt();
            switch (lvlSet) {
                case EASY_LEVEL:
                    Easy.easyTask();
                    menuExit = false;
                    break;
                case MEDIUM_LEVEL:
                    Medium.mediumTask();
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
                    System.out.println("Некорректный пункт! Повторите ввод:");
            }
        }

    }


}









