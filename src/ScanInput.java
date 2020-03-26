import java.util.InputMismatchException;
import java.util.Scanner;

public class ScanInput {
    public static float scanInputNumbers(){
        boolean inputFloatCheck = true;
        Scanner input = new Scanner(System.in);
        float nextFloat = 0;
        while (inputFloatCheck) {
            try {

                nextFloat = input.nextFloat();
                inputFloatCheck = false;
            }
            catch (InputMismatchException e) {
                //System.out.println("NumberFormatException: " + e.getMessage());
                System.out.println("Это не число... вводи по новой:");
                input.next();
            }
        }

        return nextFloat;
    }

    public static int scanInputMenuSelect(){
        boolean inputFloatCheck = true;
        Scanner input = new Scanner(System.in);
        int nextInt = 0;
        while (inputFloatCheck) {
            try {

                nextInt = input.nextInt();
                inputFloatCheck = false;
            }
            catch (InputMismatchException e) {
                //System.out.println("NumberFormatException: " + e.getMessage());
                System.out.println("Это не число. Пробуй еще:");
                input.next();
            }
        }

        return nextInt;
    }
}
