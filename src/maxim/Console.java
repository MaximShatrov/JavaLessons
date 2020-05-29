package maxim;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Console {
    private static Scanner input = new Scanner(System.in);

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
        String nextString = null;
        while (nextString == null) {
            try {
                nextString = input.next();
                input.nextLine();
            } catch (NoSuchElementException e) {
                System.err.println("ERROR");
                input.nextLine();
            }
        }
        return nextString;
    }

    static StringBuilder scanInputSB() {
        StringBuilder sb = new StringBuilder(Console.scanInputString());
        return sb;
    }

    public static StringBuilder scanInputLogin() {
        boolean lenghtCheck = false;
        boolean nullCheck = false;
        String nextString = null;
        while (!lenghtCheck | !nullCheck) {
            try {
                nextString = input.next();
                input.nextLine();
                if (nextString.length() >= 6) {
                    lenghtCheck = true;
                }
                if (nextString != null) {
                    nullCheck = true;
                }
            } catch (NoSuchElementException e) {
                System.err.println("ERROR");
                input.nextLine();
            }
            if (!lenghtCheck | !nullCheck) {
                System.err.println("Логин не удовлетворяет условиям! Повторите ввод.");
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(nextString);
        return sb;
    }

    static StringBuilder scanInputFullName() {
        String[] numsAndmarks = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "!", "?", "=", "+", "@", "#", "$", "%", "^", "&", "*", ":", ";", "_", "~", "|", "/"};
        String nextString = null;
        boolean wordsCheck = false;
        boolean numAndMarksCheck = false;
        while (nextString == null | !wordsCheck | !numAndMarksCheck) {
            try {
                nextString = input.nextLine();
                int firstSpace = nextString.indexOf(" ");
                int secondSpace = nextString.indexOf(" ", firstSpace + 1);
                int thirdSpace = nextString.indexOf(" ", secondSpace + 1);
                if (secondSpace != -1 && thirdSpace == -1) {
                    wordsCheck = true;
                } else {
                    System.err.println("Поле ФИО должно содержать три слова через пробел!");
                }
                for (int i = 0; i < numsAndmarks.length; i++) {
                    if (nextString.contains(numsAndmarks[i])) {
                        System.err.println("ФИО не должны содержать недопустимые знаки!");
                        numAndMarksCheck = false;
                        break;
                    } else {
                        numAndMarksCheck = true;
                    }
                }
                if (!wordsCheck ^ !numAndMarksCheck) {
                    System.out.println("Повторите ввод:");
                }
                if (!wordsCheck && !numAndMarksCheck) {
                    System.out.println("Повторите ввод:");
                }

            } catch (NoSuchElementException e) {
                System.err.println("ERROR");
                input.nextLine();
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(nextString);
        return sb;
    }

    static StringBuilder scanInputBirthdate() {
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
        StringBuilder sb = new StringBuilder(10);
        sb.append(nextString);
        return sb;
    }


    public static String scanInputSerial() {
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

    public static StringBuilder scanInputPassportInfo() {
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
        StringBuilder sb = new StringBuilder();
        sb.append(nextString);
        return sb;
    }

    public static String scanInputMobileNumber() {
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

    public static String scanInputSite() {
    }
}
}