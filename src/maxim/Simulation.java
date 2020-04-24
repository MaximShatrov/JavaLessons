package maxim;

public class Simulation {
    public static void main(int days) {
        System.out.println("На Безымянной улице " + (Array.unnamedStreet.length+1) + " домов");
        for (int i = 0; i < days; i++) {
            TimeAndDate.printDate();
            int today = TimeAndDate.getDay();
            if (today == 25) {
                Events.salary();
            } else { }
            if (today == 10){
               Events.payment();
            } else  { }
            Events.doTheRandomEvent();
            TimeAndDate.incrementDate();
        }
        System.out.println("\n"+ "Симуляция закончена.");
    }
}
