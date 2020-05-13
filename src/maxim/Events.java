package maxim;

public class Events {
/*
    private static Family selectedRoom(){
        int randHouse = RandomizeValues.getRandInt(1, Array.unnamedStreet.length)-1;
        int randRoom = RandomizeValues.getRandInt(1, Array.unnamedStreet[randHouse].length)-1;
        return Array.unnamedStreet[randHouse][randRoom];
    }
*/

    public static void deliveryClub() {
        int selectHouse = RandomizeValues.getRandInt(1, Array.unnamedStreet.length)-1;
        int selectRoom = RandomizeValues.getRandInt(1, Array.unnamedStreet[selectHouse].length)-1;
        if (Array.unnamedStreet[selectHouse][selectRoom].getHumans() > 0) {
            if (Array.unnamedStreet[selectHouse][selectRoom].getOnWork() != true) {
                int budget = Array.unnamedStreet[selectHouse][selectRoom].getBudget();
                int foodPrice = RandomizeValues.getRandInt(1, 10) * 100;
                if (budget > foodPrice) {
                    Array.unnamedStreet[selectHouse][selectRoom].decreaseBudget(foodPrice);
                    System.out.println("Заказ на сумму " + foodPrice + "руб. доставлен по адресу ул.Безымянная " + (selectHouse + 1) + " ,кв " + (selectRoom + 1));
                }
            }
        }
    }

    public static void mailDelivery() {
        int selectHouse = RandomizeValues.getRandInt(1, Array.unnamedStreet.length)-1;
        int selectRoom = RandomizeValues.getRandInt(1, Array.unnamedStreet[selectHouse].length)-1;
        if (Array.unnamedStreet[selectHouse][selectRoom].getHumans() > 0) {
            if (Array.unnamedStreet[selectHouse][selectRoom].getOnWork() != true) {
                System.out.println("Посылка доставлена по адресу ул.Безымянная " + (selectHouse + 1) + " ,кв " + (selectRoom + 1));
            }
        }
    }

    public static void demographyDeath(){
        int selectHouse = RandomizeValues.getRandInt(1,Array.unnamedStreet.length)-1;
        int selectRoom = RandomizeValues.getRandInt(1, Array.unnamedStreet[selectHouse].length)-1;
        if (Array.unnamedStreet[selectHouse][selectRoom].getHumans()>0){
            Array.unnamedStreet[selectHouse][selectRoom].killHuman();
            System.out.println("Сегодня не стало прекрасного человека %USERNAME%, жившего на ул.Безымянной " +(selectHouse+1) + " ,кв " +(selectRoom+1));
        }
    }

    public static void demographyBirth(){
        int selectHouse = RandomizeValues.getRandInt(1,Array.unnamedStreet.length)-1;
        int selectRoom = RandomizeValues.getRandInt(1, Array.unnamedStreet[selectHouse].length)-1;
        if (Array.unnamedStreet[selectHouse][selectRoom].getHumans()>=2){
            Array.unnamedStreet[selectHouse][selectRoom].birthHuman();
            System.out.println("В семье %USERNAME%, проживающих на ул.Безымянной " +(selectHouse+1) + " ,кв " +(selectRoom+1) + ", пополнение :)");
        }
    }

    public static void salary(){
        int selectHouse = RandomizeValues.getRandInt(1,Array.unnamedStreet.length)-1;
        int selectRoom = RandomizeValues.getRandInt(1, Array.unnamedStreet[selectHouse].length)-1;
        if (Array.unnamedStreet[selectHouse][selectRoom].getHumans() > 0) {
            Array.unnamedStreet[selectHouse][selectRoom].salaryDay();
        }
        System.out.println("Получена зарплата ^^,");
    }

    public static void payment(){
        int selectHouse = RandomizeValues.getRandInt(1,Array.unnamedStreet.length)-1;
        int selectRoom = RandomizeValues.getRandInt(1, Array.unnamedStreet[selectHouse].length)-1;
        if (Array.unnamedStreet[selectHouse][selectRoom].getHumans() > 0) {
            if (Array.unnamedStreet[selectHouse][selectRoom].getBudget()>Array.unnamedStreet[selectHouse][selectRoom].getBills()){
                Array.unnamedStreet[selectHouse][selectRoom].payday();
            }
        }
        System.out.println("Платеж по ЖКХ совершен :(");
    }

    public static void doTheRandomEvent(){
        int switchSelect = RandomizeValues.getRandInt(0,9);
        switch (switchSelect){
            case 0: case 1: case 2:
                Events.deliveryClub();
                break;
            case 3: case 4:
                Events.mailDelivery();
                break;
            case 6:
                Events.demographyDeath();
                break;
            case 8:
                Events.demographyBirth();
                break;
            default:
                System.out.println(Color.BLUE + "Ничего не произошло"+ Color.RESET);
                break;
        }
    }
}
