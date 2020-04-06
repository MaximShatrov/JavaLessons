public class Medium {
    public static void mediumTask() {
        Console.print("\n" + "Medium task :)");
        Console.print("Введите число a");
        float A = Console.scanInputNumbers();
        Console.print("Введите число b");
        float B = Console.scanInputNumbers();
        Math.summary(A,B);
        Math.difference(A,B);
        Math.composition(A,B);
        Math.ratio(A,B);
    }

    public static void main(String[] args){
        mediumTask();
    }
}
