import java.util.InputMismatchException;
import java.util.Scanner;

public class Math {

    /*public static void main(String[] args){

    }*/



    public static void summary(float a, float b) {
        Console.print("Сумма       a+b = " + (a + b));
    }

    public static void difference(float a, float b) {
        Console.print("Разность    a-b = " + (a - b));
    }

    public static void composition(float a, float b) {
        Console.print("Множество   a*b = " + a * b);
    }

    public static void ratio(float a, float b) {
        if (b == 0) {
            Console.print("Частное     a/b = Бесконечность");
        }
        else{
            Console.print("Частное     a/b = " + a / b);
        }
    }


}
