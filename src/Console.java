import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
    private static Scanner input = new Scanner(System.in);
    public static float scanInputNumbers(){
        boolean inputFloatCheck = true;
        float nextFloat = 0;
        while (inputFloatCheck) {
            try {
                nextFloat = input.nextFloat();
                input.nextLine();
                inputFloatCheck = false;
            }
            catch (InputMismatchException e) {
                //System.out.println("NumberFormatException: " + e.getMessage());
                Console.print("Это не число... вводи по новой:");
                input.nextLine();

            }
        }
        return nextFloat;
    }

    public static int scanInputMenuSelect(){
        int nextInt = 0;
        try {
                nextInt = input.nextInt();
                input.nextLine();
            }
            catch (InputMismatchException e) {
                input.nextLine();
            }
        return nextInt;
    }

    public static void print(String text){
        System.out.println(text);
    }

    public static void printMainMenu() {
        Console.print("Выберите нужный уровень:");
        Console.print("1. Изи");
        Console.print("2. Медиум");
        Console.print("3. Хард");
        Console.print("4. Выход");
        Console.print("\n" + "Ваш выбор:");
    }
}
