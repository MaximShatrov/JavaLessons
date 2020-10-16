package IO;

import FLMUnits.SockerPlayer;

public class PrintData {
    private final String RESET_COLOR = "\033[0m";
    private final String RED = "\033[0;31m";
    private final String GREEN = "\033[0;32m";
    private final String BLUE = "\033[0;34m";

    public void printString(String string) {
        System.out.println(string);
    }

    public void printArrayToTable(SockerPlayer[] array, String title){
        System.out.println(title);
        System.out.printf("%-4s","№");
        System.out.printf("%-40s", "Имя");
        System.out.printf("%-16s", "Страна");
        System.out.printf("%-32s", "Лига");
        System.out.printf("%7s", "Рейтинг");
        System.out.print("\n");
        System.out.printf("%100s", tabSeparator(100)+"\n");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%-4s",(i + 1) + ".");
            System.out.printf("%-40s", array[i].getNickName());
            System.out.printf("%-16s", array[i].getCountry());
            System.out.printf("%-32s", array[i].getLeague());
            System.out.printf("%3d", array[i].getPoints());
            System.out.print("\n");
        }
        System.out.println();
    }
    public void printStringError(String string) {
        printString(RED + string + RESET_COLOR);
    }

    public void printStringMenu(String string) {
        printString(BLUE + string + RESET_COLOR);
    }

    public void printStringSuccess(String string) {
        printString(GREEN + string + RESET_COLOR);
    }

    public void clearConsole() {
        for (int i = 0; i < 1000; i++) {
            System.out.print("\b\b\b\b\b");
        }
    }
    public void printDelay(int delay, String message){
        for (int i = 0; i < delay; i++) {
            String string = new String(message + " " + (delay - i) + " cек.");
            System.out.print(string);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int j = 0; j < string.length(); j++) {
                System.out.print("\b");
            }
        }
        System.out.println();
    }
    private String tabSeparator(int lenght){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < lenght; i++) {
            stringBuffer.append("-");
        }
        return stringBuffer.toString();
    }
}