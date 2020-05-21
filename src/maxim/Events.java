package maxim;

import static maxim.Array.unnamedStreet;

class Events {
/*
    private static Family selectedRoom(){
        int randHouse = RandomizeValues.getRandInt(1, Array.unnamedStreet.length)-1;
        int randRoom = RandomizeValues.getRandInt(1, Array.unnamedStreet[randHouse].length)-1;
        return Array.unnamedStreet[randHouse][randRoom];
    }
*/

    private static void deliveryClub() {
        int selectHouse = RandomizeValues.getRandInt(1, unnamedStreet.length) - 1;
        int selectRoom = RandomizeValues.getRandInt(1, unnamedStreet[selectHouse].length) - 1;
        if (unnamedStreet[selectHouse][selectRoom].getHumans() > 0) {
            if (!unnamedStreet[selectHouse][selectRoom].getOnWork()) {
                int budget = unnamedStreet[selectHouse][selectRoom].getBudget();
                int foodPrice = RandomizeValues.getRandInt(1, 10) * 100;
                if (budget > foodPrice) {
                    unnamedStreet[selectHouse][selectRoom].decreaseBudget(foodPrice);
                    System.out.println("Заказ на сумму " + foodPrice + "руб. доставлен по адресу ул.Безымянная " + (selectHouse + 1) + " ,кв " + (selectRoom + 1));
                }
            }
        }
    }

    private static void mailDelivery() {
        int selectHouse = RandomizeValues.getRandInt(1, unnamedStreet.length) - 1;
        int selectRoom = RandomizeValues.getRandInt(1, unnamedStreet[selectHouse].length) - 1;
        if (unnamedStreet[selectHouse][selectRoom].getHumans() > 0) {
            if (!unnamedStreet[selectHouse][selectRoom].getOnWork()) {
                System.out.println("Посылка доставлена по адресу ул.Безымянная " + (selectHouse + 1) + " ,кв " + (selectRoom + 1));
            }
        }
    }

    private static void demographyDeath() {
        int selectHouse = RandomizeValues.getRandInt(1, unnamedStreet.length) - 1;
        int selectRoom = RandomizeValues.getRandInt(1, unnamedStreet[selectHouse].length) - 1;
        if (unnamedStreet[selectHouse][selectRoom].getHumans() > 0) {
            unnamedStreet[selectHouse][selectRoom].killHuman();
            System.out.println("Сегодня не стало прекрасного человека %USERNAME%, жившего на ул.Безымянной " + (selectHouse + 1) + " ,кв " + (selectRoom + 1));
        }
    }

    private static void demographyBirth() {
        int selectHouse = RandomizeValues.getRandInt(1, unnamedStreet.length) - 1;
        int selectRoom = RandomizeValues.getRandInt(1, unnamedStreet[selectHouse].length) - 1;
        if (unnamedStreet[selectHouse][selectRoom].getHumans() >= 2) {
            unnamedStreet[selectHouse][selectRoom].birthHuman();
            System.out.println("В семье %USERNAME%, проживающих на ул.Безымянной " + (selectHouse + 1) + " ,кв " + (selectRoom + 1) + ", пополнение :)");
        }
    }

    static void salary() {
        int selectHouse = RandomizeValues.getRandInt(1, unnamedStreet.length) - 1;
        int selectRoom = RandomizeValues.getRandInt(1, unnamedStreet[selectHouse].length) - 1;
        if (unnamedStreet[selectHouse][selectRoom].getHumans() > 0) {
            unnamedStreet[selectHouse][selectRoom].salaryDay();
        }
        System.out.println("Получена зарплата ^^,");
    }

    static void payment() {
        int selectHouse = RandomizeValues.getRandInt(1, unnamedStreet.length) - 1;
        int selectRoom = RandomizeValues.getRandInt(1, unnamedStreet[selectHouse].length) - 1;
        if (unnamedStreet[selectHouse][selectRoom].getHumans() > 0) {
            if (unnamedStreet[selectHouse][selectRoom].getBudget() > unnamedStreet[selectHouse][selectRoom].getBills()) {
                unnamedStreet[selectHouse][selectRoom].payday();
            }
        }
        System.out.println("Платеж по ЖКХ совершен :(");
    }

    static void doTheRandomEvent() {
        int switchSelect = RandomizeValues.getRandInt(0, 9);
        switch (switchSelect) {
            case 0:
            case 1:
            case 2:
                Events.deliveryClub();
                break;
            case 3:
            case 4:
                Events.mailDelivery();
                break;
            case 6:
                Events.demographyDeath();
                break;
            case 8:
                Events.demographyBirth();
                break;
            default:
                System.out.println(Color.BLUE + "Ничего не произошло" + Color.RESET);
                break;
        }
    }
}
