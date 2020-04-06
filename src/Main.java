public class Main {
    private static final int EASY_LEVEL = 1;
    private static final int MEDIUM_LEVEL = 2;
    private static final int HARD_LEVEL = 3;
    private static final int EXIT = 4;

    public static void main(String[] args) {
        boolean menuExit = true;
        Console.printMainMenu();
        while (menuExit) {
            int lvlSet = Console.scanInputMenuSelect();
            switch (lvlSet) {
                case EASY_LEVEL:
                    Easy.easyTask();
                    Console.print("Уровень Easy выполнен." + "\n");
                    Console.printMainMenu();
                    break;
                case MEDIUM_LEVEL:
                    Medium.mediumTask();
                    Console.print("Уровень Medium выполнен." + "\n");
                    Console.printMainMenu();
                    break;
                case HARD_LEVEL:
                    Hard.hardTask();
                    Console.print("Уровень Hard выполнен." + "\n");
                    Console.printMainMenu();
                    break;
                case EXIT:
                    Console.print("\n" + "Завершение работы.");
                    menuExit = false;
                    break;
                default:
                    Console.print("Некорректный пункт! Повторите ввод:");
            }
        }
    }
}









