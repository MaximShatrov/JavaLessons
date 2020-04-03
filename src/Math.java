import java.util.InputMismatchException;
import java.util.Scanner;

public class Math {

    public static void main(String[] args){

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
        if (b == 0) {
            System.out.println("Частное     a/b = Бесконечность");
        }
        else{
            System.out.println("Частное     a/b = " + a / b);
        }
    }


}
