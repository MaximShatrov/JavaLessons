import java.util.Scanner;


public class Hard {
    //float A;
    //float B;
    public static void main(String[] args) {

        inputAB();
        Hard.menuPrint();
        Scanner userInput = new Scanner(System.in);
        while (userInput.hasNext()) {
            menuChoice(userInput.nextInt());
            }

            System.out.println("\n" + "1 - посчитать с новыми числами?");
            System.out.println("2 - Вернуться в главное меню?");
            System.out.println("\n" + "Ваш выбор:");
            menuChoice2(userInput.nextInt());
        }


        public static void inputAB () {
            System.out.println("Hard task :)" + "\n");
            Scanner in3 = new Scanner(System.in);
            System.out.println("Введите число a");
            float A = in3.nextFloat(); //читаем float с клавиатуры
            System.out.println(A);
            //добавить проверку на ввод чисел ??

            System.out.println("\n" + "Введите число b");
            float B = in3.nextFloat(); //читаем float с клавиатуры
            System.out.println(A);
        }


        public static void menuPrint () {
            System.out.println("\n" + "Выберите действие:");
            System.out.println("1. Сложить      a+b;");
            System.out.println("2. Вычесть      a-b;");
            System.out.println("3. Перемножить  a*b;");
            System.out.println("4. Поделить     a/b;");
            System.out.println("Ваш выбор:");
        }

        public static menuChoice ( int numMenu){
            switch (numMenu) {
                case 1: {
                    Main.summary(A, B);
                }
                break;
                case 2: {
                    Main.difference(A, B);
                }
                break;
                case 3: {
                    Main.composition(A, B);
                }
                break;
                case 4: {
                    Main.ratio(A, B);
                }
                break;
                default:
                    System.out.println("Ошибка!");

            }

        }

        public static void menuChoice2 ( int numMenu2){
            switch (numMenu2) {
                case 1:
                    System.out.println("123"); //main();
                    break;
                case 2:
                    System.out.println("321"); //Main.main();
                    break;
                default:
                    System.out.println("Ошибка!");

            }

        }


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



/*
import java.util.Scanner;
 
public class InfoSys {
 
    public static void adresPrint() {
        System.out.println("Пушкина 9, кв. 8");
    }
 
    public static void telephPrint() {
        System.out.println("901-010-22-33");
    }
 
    public static void menuPrint() {
        System.out.println("1 - адрес;");
        System.out.println("2 - телефон;");
    }
 
    public static void menuChoice(int numMenu) {
        switch (numMenu) {
            case 1 : adresPrint();
            break;
            case 2 : telephPrint();
            break;
            default:
                System.out.println("Не понятно!");
        }
    }
 
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        menuPrint();
        while (userInput.hasNext()){
            menuChoice(userInput.nextInt());
        }
    }
}
*/