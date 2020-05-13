package maxim;

public class Simulation {
    public static void main(int days) {
        System.out.println("На Безымянной улице " + (Array.unnamedStreet.length) + " дома(ов)");
        for (int d = 0; d < days; d++) {
            TimeAndDate.printDate();
            for (int i = 0; i < Array.unnamedStreet.length; i++) {
                for (int j = 0; j < Array.unnamedStreet[i].length; j++) {
                    Array.unnamedStreet[i][j].setOnWork(RandomizeValues.getRandBoolean());
                }
            }
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
