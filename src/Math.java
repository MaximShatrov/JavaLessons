import java.util.Scanner;

public class Math {

    public static void main(String[] args){

    }

    public static String scannerInput(){
        Scanner input = new Scanner(System.in);
        float nextFloat;
        try {
            nextFloat = input.nextFloat();
        }
        catch (Exception) {

        }

        //добавить проверку на ввод чисел ??

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
