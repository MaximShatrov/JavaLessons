package maxim;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Console {
    private static Scanner input = new Scanner(System.in);

    static float scanInputNumbers() {
        boolean inputFloatCheck = true;
        float nextFloat = 0;
        while (inputFloatCheck) {
            try {
                nextFloat = input.nextFloat();
                input.nextLine();
                inputFloatCheck = false;
            } catch (InputMismatchException e) {
                //System.out.println("NumberFormatException: " + e.getMessage());
                System.out.println("Это не число... вводи по новой:");
                input.nextLine();
            }
        }
        return nextFloat;
    }

    static String scanInputString() {
        boolean inputCheck = true;
        String nextString = null;
        while (inputCheck) {
            try {
                nextString = input.next();
                input.nextLine();
                inputCheck = false;
            } catch (NoSuchElementException e) {
                System.err.println("ERROR");
                input.nextLine();
            }
        }
        return nextString;
    }


    static int scanInputMenuSelect() {
        int nextInt = 0;
        try {
            nextInt = input.nextInt();
            input.nextLine();
        } catch (InputMismatchException e) {
            input.nextLine();
        }
        return nextInt;
    }

}