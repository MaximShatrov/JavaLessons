package maxim;

import java.util.Random;

public class RandomizeValues {
    public static  Random randomValue = new Random();

    public static int getRandInt(int min, int max){
        int value = randomValue.nextInt(max - min + 1);
        value += min;
        return value;
    }

    public static int getRandInt4(int min, int max){      //Случайное количесво квартир (4 на этаж)
        int value = RandomizeValues.getRandInt(min, max);
        value = ((min + value)*4);
        return value;
    }

    public static boolean getRandBoolean(){
        boolean value = randomValue.nextBoolean();
        return value;
    }
}
