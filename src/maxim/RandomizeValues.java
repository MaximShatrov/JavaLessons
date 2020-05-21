package maxim;

import java.util.Random;

class RandomizeValues {
    private static Random randomValue = new Random();

    static int getRandInt(int min, int max) {
        int value = randomValue.nextInt(max - min + 1);
        value += min;
        return value;
    }

    static int getRandInt4(int min, int max) {      //Случайное количесво квартир (4 на этаж)
        int value = RandomizeValues.getRandInt(min, max);
        value = ((min + value) * 4);
        return value;
    }

    static boolean getRandBoolean() {
        return randomValue.nextBoolean();
    }
}
