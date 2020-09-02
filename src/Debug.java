import java.util.Random;

public class Debug {
    static Random random = new Random();

    public static void main(String[] args) {
        Squad alphaSquad = new Squad(10, "Alpha");
        alphaSquad.squadList(alphaSquad);
    }

    private static int value() {

        int randomInt = random.nextInt(4);
        System.out.println(randomInt);
        randomInt = random.nextInt(4);
        System.out.println(randomInt);
        return randomInt;
    }
}
