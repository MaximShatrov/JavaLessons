package maxim;

import java.util.Random;

public class RandomizeValues {
    public static  Random randomInt = new Random();

    public static int getRandomInt(int min, int max){
        int value = randomInt.nextInt(max - min + 1);
        value += min;
        return value;
    }

    public static int getRandomInt4(int min, int max){      //Случайное количесво квартир (4 на этаж)
        int value = RandomizeValues.getRandomInt(min, max);
        value = ((min + value)*4)+1;
        return value;
    }
}
