public class Easy {
    public static void easyTask() {
        float A = 60; //не смог без float, потому что в таком случае деление без остатка происходит :(
        float B = 9;
        System.out.println("Easy task :)");
        Main.summary(A,B);
        Main.difference(A,B);
        Main.composition(A,B);
        Main.ratio(A,B);

    }

    public static void main(String[] args){
    easyTask();
    }
}