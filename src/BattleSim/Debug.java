package BattleSim;

import java.util.Random;

public class Debug {
    static Random random = new Random();
    private int first = 100;

    public static void main(String[] args) {
        Debug debug = new Debug();
        int first = 100;
        debug.sample(first);
        System.out.println(first);
    }

    private static int value() {

        int randomInt = random.nextInt(4);
        System.out.println(randomInt);
        randomInt = random.nextInt(4);
        System.out.println(randomInt);
        return randomInt;
    }

    private int sample(int input){
        return input -=10;

    }
}
