import java.util.Scanner;

public class Main {
    private static final int EASY_LEVEL = 1;
    private static final int MEDIUM_LEVEL = 2;
    private static final int HARD_LEVEL = 3;

    public static void main(String[] args) {
        System.out.println("Выберите нужное задание:");
        System.out.println("1. Изи");
        System.out.println("2. Медиум");
        System.out.println("3. Хард");
        System.out.println("\n" + "Ваш выбор:");
        while (true) {                                      //бесконечный цикл. Что-то мне кажется что это не очень хорошо. Рекурсия получается.
            Scanner lvlChoose = new Scanner(System.in);
            int lvlSet = lvlChoose.nextInt();
            //проверка lvlSet
            switch (lvlSet) {
                case EASY_LEVEL: {
                    Easy.main(null);
                }
                break;
                case MEDIUM_LEVEL: {
                    Medium.main(null);
                }
                break;
                case HARD_LEVEL: {
                    Hard.main(null);
                }
                break;
                default:{
                    System.out.println("Некорректный пункт! Повторите ввод:");
                    // отсюда бы как-нибудь вернуться к int lvlSet = lvlChoose.nextInt(); чтобы убрать while
                    /*System.out.println("пук пук пук я человек паук");*/
                }
            }
        }

    }


    public static void summary(float a, float b) {
        System.out.println("Сумма       a+b = " + (a + b));
    }

    public static void difference(float a, float b) {
        System.out.println("Разность    a-b = " + (a - b));
    }

    public static void composition(float a, float b) {
        System.out.println("Множество   a*b = " + a * b);
    }

    public static void ratio(float a, float b) {
        System.out.println("Частное     a/b = " + a / b);
    }
}









