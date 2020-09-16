package IO;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ScanData {

    public static int inputInt(Scanner input) {
        int nextInt = 0;
        boolean incorrectInputCheck = true;
        while(incorrectInputCheck){
            try {
                nextInt = input.nextInt();
                input.nextLine();
                incorrectInputCheck = false;
            } catch (InputMismatchException e) {
                System.err.println("Некорректное число! Повторите ввод:");
                input.nextLine();
            }
        }
        return nextInt;
    }
}
