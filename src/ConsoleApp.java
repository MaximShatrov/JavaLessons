import java.util.Random;

public class ConsoleApp {
    private static final int FIRST_ITEM = 1;
    private static final int SECOND_ITEM = 2;
    private static final int THIRD_ITEM = 3;
    private static int cost = 0;
    private static Random randomValue = new Random();
    private String containerType = null;

    public static void main(String[] args) {
        Addons terminal = new Addons();
        ConsoleApp console = new ConsoleApp();
        System.out.println("Добро пожаловать в конструктор мороженного IcecreamApp! \n" +
                "Какое мороженное вы хотите 'собрать'? \n");
        boolean chooseMenu = true;
        while (chooseMenu) {
            System.out.println("1. Обычное мороженное - рожок или стаканчик, до четырёх вкусов и до четырёх топпингов; \n" +
                    "2. Мороженное-сюрприз - случайный выбор составляющих; \n" + "3. Мороженное-экстра  - обычное мороженное без топпинга и напиток на выбор;");
            int containerSelect = terminal.scanInputMenuSelect();
            switch (containerSelect) {
                case FIRST_ITEM:
                    console.makeBaseIcecream(terminal);
                    break;
                case SECOND_ITEM:
                    console.makeSurpriseIcecream(terminal);
                    break;
                case THIRD_ITEM:
                    console.makeExtraIcecream(terminal);
                    break;
                default:
                    System.err.println("Выберите пункт меню!");
            }
            System.out.println("\nХотите собрать еще одно мороженное?" +
                            "\n1.Да \n2.Нет");
            containerSelect = terminal.scanInputMenuSelect();
            switch (containerSelect) {
                case FIRST_ITEM:
                    System.out.println("Какое мороженное вы хотите 'собрать' cейчас? \n");
                    break;
                case SECOND_ITEM:
                    chooseMenu = false;
                    System.out.println("Завершение сеанса IcecreamApp.");
                    break;
            }
        }
    }

    private void makeBaseIcecream(Addons terminal) {
        containerType = null;
        String[][] flavoursAndCost;
        String[][] toppingsAndCost;
        System.out.println("Определимся с выбором стаканчика или рожка:");
        chooseContainerType(terminal);
        System.out.println("\n" + "Пора выбирать вкусы:");
        flavoursAndCost = terminal.chooseFlavour();
        BaseIcecream baseIcecream = new BaseIcecream(containerType, extractAddon(flavoursAndCost), cost += extractCost(flavoursAndCost));
        System.out.println("\n" + "Осталось только выбрать топпинги:");
        toppingsAndCost = terminal.chooseToppings();
        baseIcecream.addToppings(extractAddon(toppingsAndCost), extractCost(toppingsAndCost));
        System.out.println("Ваше мороженное из конструктора:\n" + baseIcecream.toString());
    }

    private void makeSurpriseIcecream(Addons terminal) {
        containerType = null;
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
        System.out.println("Ваше мороженное из конструктора:\n" + surpriseIcecream.toString());

    }

    private void makeExtraIcecream(Addons terminal) {
        containerType = null;
        String[][] flavoursAndCost;
        String[][] drinkAndCost;
        System.out.println("Определимся с выбором стаканчика или рожка:");
        chooseContainerType(terminal);
        System.out.println("\n" + "Пора выбирать вкусы:");
        flavoursAndCost = terminal.chooseFlavour();
        drinkAndCost = terminal.chooseDrink();
        ExtraIcecream extraIcecream = new ExtraIcecream(containerType, extractAddon(flavoursAndCost), extractAddon(drinkAndCost), cost += (extractCost(flavoursAndCost) + extractCost(drinkAndCost)));
        System.out.println("Ваше мороженное из конструктора:\n" + extraIcecream.toString());
    }

    private String[] extractAddon(String[][] inputMassive) {
        String[] flavours = new String[4];
        for (int i = 0; i < inputMassive[0].length; i++) {
            flavours[i] = inputMassive[0][i];
        }
        return flavours;
    }

    private int extractCost(String[][] inputMassive) {
        int toppingsCost = 0;
        for (int i = 0; i < inputMassive[0].length; i++) {
            if (inputMassive[1][i] != null) {
                toppingsCost = toppingsCost + Integer.parseInt(inputMassive[1][i]);
            }
        }
        return toppingsCost;
    }

    private void chooseContainerType(Addons terminal) {
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
}
