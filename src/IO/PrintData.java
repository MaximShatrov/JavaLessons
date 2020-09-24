package IO;

public class PrintData {
    private final String RESET_COLOR = "\033[0m";
    private final String RED = "\033[0;31m";
    private final String GREEN = "\033[0;32m";
    private final String BLUE = "\033[0;34m";

    public void printString(String string) {
        System.out.println(string);
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
}
