public class Hard {
    private static final int SUMMARY_SELECT = 1;
    private static final int DIFFERENCE_SELECT = 2;
    private static final int COMPOSITION_SELECT = 3;
    private static final int RATIO_SELECT = 4;
    public static void main(String[] args) {
        hardTask();
    }

    public static void hardTask() {
        System.out.println("Hard task :)" + "\n");
        System.out.println("Введите число a");
        float A = ScanInput.scanInputNumbers();
        System.out.println("\n" + "Введите число b");
        float B = ScanInput.scanInputNumbers();
        Hard.menuPrint();
        menuChoice(A, B);
    }


    public static void menuPrint() {
        System.out.println("\n" + "Выберите действие:");
        System.out.println("1. Сложить      a+b;");
        System.out.println("2. Вычесть      a-b;");
        System.out.println("3. Перемножить  a*b;");
        System.out.println("4. Поделить     a/b;");
        System.out.println("Ваш выбор:");
    }

    public static void menuChoice(float A, float B) {
        boolean menuChoiceCheck = true;
        while (menuChoiceCheck) {
            int numMenu = ScanInput.scanInputMenuSelect();
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
                    System.out.println("Ошибка! Выбери снова.");

            }
        }
    }
}
