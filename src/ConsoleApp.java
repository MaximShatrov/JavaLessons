import java.util.Random;

public class ConsoleApp {
    //private static final int FIRST_ITEM = 1;
    //private final int THIRD_ITEM = 3;
    static Addons terminal = new Addons();
    //private Scanner input = new Scanner(System.in);
    private static String containerType;
    private static int cost = 0;
    private static Random randomValue = new Random();

    public static void main(String[] args) {
        //Addons terminal = new Addons();
        System.out.println("Добро пожаловать в конструктор мороженного IcecreamApp! \n");
        System.out.println("Какое мороженное вы хотите 'собрать'?");
        System.out.println("1. Обычное мороженное - рожок или стаканчик, до четырёх вкусов и до четырёх топпингов;");
        System.out.println("2. Мороженное-сюрприз - случайный выбор составляющих;");
        System.out.println("3. Мороженное-экстра  - обычное мороженное без топпинга и напиток на выбор;");
        boolean chooseMenu = true;
        while (chooseMenu) {
            int containerSelect = terminal.scanInputMenuSelect();
            switch (containerSelect) {
                case 1:
                    makeBaseIcecream();
                    chooseMenu = false;
                    break;
                case 2:
                    makeSurpriseIcecream();
                    chooseMenu = false;
                    break;
                case 3:
                    makeExtraIcecream();
                    chooseMenu = false;
                    break;
                default:
                    System.err.println("Выберите пункт меню!");
            }


        }
    }

    private static void makeBaseIcecream() {
        String[][] flavoursAndCost;
        String[][] toppingsAndCost;
        System.out.println("Определимся с выбором стаканчика или рожка:");
        chooseContainerType();
        System.out.println("\n" + "Пора выбирать вкусы:");
        flavoursAndCost = terminal.chooseFlavour(4);
        BaseIcecream baseIcecream = new BaseIcecream(containerType, extractAddon(flavoursAndCost), cost += extractCost(flavoursAndCost));
        System.out.println("\n" + "Осталось только выбрать топпинги:");
        toppingsAndCost = terminal.chooseToppings(4);
        baseIcecream.addToppings(extractAddon(toppingsAndCost), extractCost(toppingsAndCost));
        System.out.println("Ваше мороженное из конструктора:");
        baseIcecream.toString();
    }

    private static void makeSurpriseIcecream() {
        String[][] flavoursAndCost;
        String[][] toppingsAndCost;
        int value = 1 + randomValue.nextInt(2);
        if (value == 1) {
            containerType = "в стаканчике";
            cost = +5;
        } else {
            containerType = "в вафельном рожке";
            cost = +15;
        }
        flavoursAndCost = terminal.chooseRandomFlavour();
        toppingsAndCost = terminal.chooseRandomToppings();
        SurpriseIcecream surpriseIcecream = new SurpriseIcecream(containerType, extractAddon(flavoursAndCost), cost += extractCost(flavoursAndCost));
        surpriseIcecream.addToppings(extractAddon(toppingsAndCost), extractCost(toppingsAndCost));
        surpriseIcecream.toString();
    }

    private static void makeExtraIcecream() {
        String[][] flavoursAndCost;
        String[][] drinkAndCost;
        System.out.println("Определимся с выбором стаканчика или рожка:");
        chooseContainerType();
        System.out.println("\n" + "Пора выбирать вкусы:");
        flavoursAndCost = terminal.chooseFlavour(4);
        drinkAndCost = terminal.chooseDrink();
        ExtraIcecream extraIcecream = new ExtraIcecream(containerType, extractAddon(flavoursAndCost), extractAddon(drinkAndCost), cost += (extractCost(flavoursAndCost) + extractCost(drinkAndCost)));
        System.out.println("Ваше мороженное из конструктора:");
        extraIcecream.toString();
    }

    private static String[] extractAddon(String[][] inputMassive) {
        String[] flavours = new String[4];
        for (int i = 0; i < inputMassive[0].length; i++) {
            flavours[i] = inputMassive[0][i];
        }
        return flavours;
    }

    private static int extractCost(String[][] inputMassive) {
        int toppingsCost = 0;
        for (int i = 0; i < inputMassive[0].length; i++) {
            if (inputMassive[1][i] != null) {
                toppingsCost = toppingsCost + Integer.parseInt(inputMassive[1][i]);
            }
        }
        return toppingsCost;
    }

    private static void chooseContainerType() {
        System.out.println("1.Стаканчик     5 руб. \n" +
                "2.Рожок        15 руб.");
        while (containerType == null) {
            int containerSelect = terminal.scanInputMenuSelect();
            switch (containerSelect) {
                case 1:
                    containerType = "в стаканчике";
                    cost = +5;
                    break;
                case 2:
                    containerType = "в вафельном рожке";
                    cost = +15;
                    break;
                default:
                    System.err.println("Выберите стаканчик или рожок!");
            }
        }
    }

    /*static int scanInputMenuSelect() {
        int nextInt = 0;
        try {
            nextInt = input.nextInt();
            input.nextLine();
        } catch (InputMismatchException e) {
            input.nextLine();
        }
        return nextInt;
    }*/
}
