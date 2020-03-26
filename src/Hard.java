import java.util.Scanner;
import java.util.InputMismatchException;

public class Hard {
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
        Scanner numMenuSelectScanner = new Scanner(System.in);
        while (menuChoiceCheck) {
            int numMenu = ScanInput.scanInputMenuSelect();
            //numMenuSelectScanner.next();
            switch (numMenu) {
                case 1:
                    Math.summary(A, B);
                    menuChoiceCheck = false;

                    break;
                case 2:
                    Math.difference(A, B);
                    menuChoiceCheck = false;

                    break;
                case 3:
                    Math.composition(A, B);
                    menuChoiceCheck = false;

                    break;
                case 4:
                    Math.ratio(A, B);
                    menuChoiceCheck = false;
                    break;
                default:
                    System.out.println("Ошибка! Выбери снова.");

            }
        }
    }
}
/*
        public static void summ () {
            System.out.println("\n" + "Выбрал Сложить");
        }

        public static void diff () {
            System.out.println("\n" + "Выбрал Вычесть");
        }

        public static void prod () {
            System.out.println("\n" + "Выбрал Перемножить");
        }

        public static void ratio () {
            System.out.println("\n" + "Выбрал Поделить");
        }
    }
*/