public class Hard {
    private static final int SUMMARY_SELECT = 1;
    private static final int DIFFERENCE_SELECT = 2;
    private static final int COMPOSITION_SELECT = 3;
    private static final int RATIO_SELECT = 4;
    /*public static void main(String[] args) {
        hardTask();
    }*/

    public static void hardTask() {
        Console.print("Hard task :)" + "\n");
        Console.print("Введите число a");
        float A = Console.scanInputNumbers();
        Console.print("\n" + "Введите число b");
        float B = Console.scanInputNumbers();
        Hard.menuPrint();
        menuChoice(A, B);
    }


    public static void menuPrint() {
        Console.print("\n" + "Выберите действие:");
        Console.print("1. Сложить      a+b;");
        Console.print("2. Вычесть      a-b;");
        Console.print("3. Перемножить  a*b;");
        Console.print("4. Поделить     a/b;");
        Console.print("Ваш выбор:");
    }

    public static void menuChoice(float A, float B) {
        boolean menuChoiceCheck = true;
        while (menuChoiceCheck) {
            int numMenu = Console.scanInputMenuSelect();
            switch (numMenu) {
                case SUMMARY_SELECT:
                    Math.summary(A, B);
                    menuChoiceCheck = false;
                    break;
                case DIFFERENCE_SELECT:
                    Math.difference(A, B);
                    menuChoiceCheck = false;
                    break;
                case COMPOSITION_SELECT:
                    Math.composition(A, B);
                    menuChoiceCheck = false;
                    break;
                case RATIO_SELECT:
                    Math.ratio(A, B);
                    menuChoiceCheck = false;
                    break;
                default:
                    Console.print("Ошибка! Выбери снова.");

            }
        }
    }
}
