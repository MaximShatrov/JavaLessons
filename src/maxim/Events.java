package maxim;

public class Events {
    public static void deliveryClub(){
        System.out.println("Выполнена доставка еды");
    }

    public static void mailDelivery(){
        System.out.println("Выполнена доставка почты");
    }

    public static void goToJob(){

    }

    public static void goToHome(){

    }

    public static void demography(){
        System.out.println("Кто-то умер или родился");
    }

    public static void salary(){
        System.out.println("Получена зарплата ^^,");
    }

    public static void payment(){
        System.out.println("Платеж по ЖКХ совершен :(");
    }

    public static void doTheRandomEvent(){
        int switchSelect = RandomizeValues.getRandomInt(0,4);
        switch (switchSelect){
            case 0:
                Events.deliveryClub();
                break;
            case 1:
                Events.mailDelivery();
                break;
            case 2:
                Events.demography();
                break;
            case 3: case 4:
                System.out.println(Color.BLUE + "Ничего не произошло"+ Color.RESET);
                break;
            default:
                System.out.println(Color.RED + "Что-то пошло не так" + Color.RESET);
                break;
        }

    }
}
