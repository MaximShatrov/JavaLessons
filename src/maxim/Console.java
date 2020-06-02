package maxim;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    /*static float scanInputNumbers() {
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
    }*/

    static String scanInputString() {
        String nextString = null;
        while (nextString == null) {
            try {
                nextString = input.nextLine();
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
        String nextString = null;
        while (!lenghtCheck | nextString == null) {
            try {
                nextString = input.next();
                input.nextLine();
                if (nextString.length() >= 6) {
                    lenghtCheck = true;
                }
            } catch (NoSuchElementException e) {
                System.err.println("ERROR");
                input.nextLine();
            }
            if (!lenghtCheck | nextString == null) {
                System.err.println("Логин не удовлетворяет условиям! Повторите ввод.");
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(nextString);
        return sb;
    }

    private static String firstUpperCase(String word) {
        if (word == null || word.isEmpty()) return "";
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

    static StringBuilder scanInputFullName() {
        String[] numsAndmarks = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "!", "?", "=", "+", "@", "#", "$", "%", "^", "&", "*", ":", ";", "_", "~", "|", "/"};
        String nextString = null;
        boolean wordsCheck = false;
        boolean numAndMarksCheck = false;
        int firstSpace = 0;
        int secondSpace = 0;
        int thirdSpace = 0;
        while (nextString == null | !wordsCheck | !numAndMarksCheck) {
            try {
                nextString = input.nextLine();
                firstSpace = nextString.indexOf(" ");
                secondSpace = nextString.indexOf(" ", firstSpace + 1);
                thirdSpace = nextString.indexOf(" ", secondSpace + 1);
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
        String lastName = firstUpperCase(nextString.substring(0, firstSpace).toLowerCase());
        String firstName = firstUpperCase(nextString.substring(firstSpace + 1, secondSpace).toLowerCase());
        String fatherName = firstUpperCase(nextString.substring(secondSpace + 1).toLowerCase());
        StringBuilder sb = new StringBuilder(lastName + " " + firstName + " " + fatherName);
        return sb;
    }

    static Date scanInputBirthdate() {
        String nextString = null;
        boolean contentCheck = false;
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd.MM.yyyy");
        format.setLenient(false);
        Date bDate = null;
        while (nextString == null | !contentCheck) {
            try {
                nextString = input.nextLine();
                //nextString = "04.05.1994";
                bDate = format.parse(nextString);
                contentCheck = true;
            } catch (ParseException e) {
                contentCheck = false;
                System.err.println("Неправильная дата! Повторите ввод:");
                //e.printStackTrace();
            }
        }
        return bDate;
    }

    static StringBuilder scanInputCity() {
        String[] numsAndmarks = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "!", "?", "=", "+", "@", "#", "$", "%", "^", "&", "*", ":", ";", "~", "|", "/"};
        String nextString = null;
        boolean numAndMarksCheck = false;
        while (nextString == null | !numAndMarksCheck) {
            try {
                nextString = input.nextLine();
                for (int i = 0; i < numsAndmarks.length; i++) {
                    if (nextString.contains(numsAndmarks[i])) {
                        System.err.println("Поле ГОРОД не должно содержать недопустимые знаки! Повторите ввод:");
                        numAndMarksCheck = false;
                        break;
                    } else {
                        numAndMarksCheck = true;
                    }
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

    static String scanInputSerial() {
        String nums = "0123456789 ";
        String nextString = null;
        boolean contentCheck = false;
        boolean formatCheck = false;
        while (nextString == null | !contentCheck | !formatCheck) {
            try {
                nextString = input.nextLine();
                int firstDot = nextString.indexOf(" ");
                int secondDot = nextString.indexOf(" ", firstDot + 1);
                if (firstDot == 4 && secondDot == -1 && nextString.length() == 11) {
                    formatCheck = true;
                } else {
                    System.err.println("Серия и номер паспорта имеют формат отличный от XXXX XXXXXXX! Повторите ввод:");
                    continue;
                }
                char[] stringtoChar = nextString.toCharArray();
                for (int i = 0; i < stringtoChar.length; i++) {
                    if (nums.contains("" + stringtoChar[i])) {
                        contentCheck = true;
                    } else {
                        contentCheck = false;
                        System.err.println("Поле содержит недопустимые знаки! Повторите ввод:");
                        break;
                    }
                }
            } catch (NoSuchElementException e) {
                System.err.println("ERROR");
                input.nextLine();
            }
        }
        return nextString;
    }

    private static StringBuilder findAndReplace(StringBuilder sb, String filter) {
        if (sb.indexOf(filter) != -1) {
            sb.replace(sb.indexOf(filter), (sb.indexOf(filter) + filter.length()), filter.toUpperCase());
        }
        return sb;
    }

    public static StringBuilder scanInputPassportInfo() {
        boolean inputCheck = false;
        String nextString = null;
        while (nextString == null | !inputCheck) {
            try {
                nextString = input.nextLine();
                if (!nextString.isEmpty()) {
                    inputCheck = true;
                } else {
                    System.err.println("Поле не должно быть пустым!  Повторите ввод:");
                }
            } catch (NoSuchElementException e) {
                System.err.println("ERROR");
                input.nextLine();
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(nextString);
        sb = findAndReplace(sb, " ровд ");
        sb = findAndReplace(sb, " увд ");
        sb = findAndReplace(sb, " гровд ");
        sb = findAndReplace(sb, " уфмс ");
        sb = findAndReplace(sb, " оуфмс ");
        return sb;
    }

    public static StringBuilder scanInputMobileNumber() {
        String nums = "0123456789 ";
        boolean inputCheck = true;
        boolean contentCheck = false;
        String nextString = null;
        while (nextString == null | !inputCheck | !contentCheck) {
            try {
                nextString = input.next();
                if (!nextString.isEmpty()) {
                    inputCheck = true;
                } else {
                    System.err.println("Поле не должно быть пустым!  Повторите ввод:");
                }
            } catch (NoSuchElementException e) {
                System.err.println("ERROR");
                input.nextLine();
            }
            System.out.print("Ваш номер: +7" + nextString);
            if (nextString.length() != 10) {
                inputCheck = false;
                System.out.println(" имеет неверный формат! Повторите вод:");
                continue;
            }
            char[] stringtoChar = nextString.toCharArray();
            for (int i = 0; i < stringtoChar.length; i++) {
                if (nums.contains("" + stringtoChar[i])) {
                    contentCheck = true;
                } else {
                    contentCheck = false;
                    System.out.println(" содержит недопустимые знаки! Повторите ввод:");
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder("+7");
        sb.append(nextString);
        return sb;
    }

}
