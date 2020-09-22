package IO;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ScanData {

    public int inputInt(Scanner input) {
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

    public String inputString(){
        Scanner input = new Scanner(System.in);
        String nextString = null;
        boolean incorrectInputCheck = true;
        while(incorrectInputCheck){
            try {
                nextString = input.next();
                input.nextLine();
                if (nextString != null){
                    incorrectInputCheck = false;
                }
            } catch (InputMismatchException e) {
                System.err.println("Что-то пошло не так...");
                input.nextLine();
            }
        }
        return nextString;
    }
}
