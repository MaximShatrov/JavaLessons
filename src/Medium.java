import java.io.IOException;
import java.io.*;
import java.util.Scanner;


public class Medium {
    public static void mediumTask() {
        System.out.println("\n" + "Medium task :)");
        System.out.println("Введите число a");
        float A = Math.scanInput();
        System.out.println("Введите число b");
        float B = Math.scanInput();
        Math.summary(A,B);
        Math.difference(A,B);
        Math.composition(A,B);
        Math.ratio(A,B);
    }

    public static void main(String[] args){
        mediumTask();
    }
}
