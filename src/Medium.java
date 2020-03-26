import java.io.IOException;
import java.io.*;
import java.util.Scanner;


public class Medium {
    public static void mediumTask() {
        System.out.println("\n" + "Medium task :)");
        Scanner lvlChoose = new Scanner(System.in);
        System.out.println("Введите число a");
        float A = lvlChoose.nextFloat();

        //добавить проверку на ввод чисел ??

        System.out.println("Введите число b");
        float B = lvlChoose.nextFloat();
        //добавить проверку на ввод чисел ??

        Math.summary(A,B);
        Math.difference(A,B);
        Math.composition(A,B);
        Math.ratio(A,B);
    }

    public static void main(String[] args){
        mediumTask();
    }
}
