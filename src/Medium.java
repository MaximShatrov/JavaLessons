public class Medium {
    public static void mediumTask() {
        System.out.println("\n" + "Medium task :)");
        System.out.println("Введите число a");
        float A = ScanInput.scanInputNumbers();
        System.out.println("Введите число b");
        float B = ScanInput.scanInputNumbers();
        Math.summary(A,B);
        Math.difference(A,B);
        Math.composition(A,B);
        Math.ratio(A,B);
    }

    public static void main(String[] args){
        mediumTask();
    }
}
