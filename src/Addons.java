import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Addons {

    private final String[][] flavorsList = new String[][]{{"Шоколадный", "Клубничный", "Банановый", "Вишнёвый", "Фисташковый"}, {"30", "30", "35", "40", "30"}};
    private final String[][] toppingsList = new String[][]{{"Орехи", "Шоколад", "Фрукты", "Сироп", "Сгущёнка", "Ликер"}, {"30", "20", "15", "20", "25", "45"}};
    private final String[][] drinksList = new String[][]{{"Кола", "Пепси", "Лимонад", "Компот", "Липтон"}, {"45", "45", "35", "30", "50"}};
    private Scanner input = new Scanner(System.in);
    private final int FIRST_CASE_SELECT = 1;
    private final int SECOND_CASE_SELECT = 2;
    private final int THIRD_CASE_SELECT = 3;
    private final int FOURTH_CASE_SELECT = 4;
    private final int FIFTH_CASE_SELECT = 5;
    private final int SIX_CASE_SELECT = 6;
    private final int SEVEN_CASE_SELECT = 7;

    public void getFlavourList() {
        for (int i = 0; i < flavorsList[0].length; i++) {
            System.out.println((i + 1) + ". " + flavorsList[0][i] + " вкус. Стоимость " + flavorsList[1][i] + "руб.");
        }
        System.out.println((flavorsList[0].length + 1) + ". " + "Закончить выбор вкусов. \n");
    }


    public String[][] chooseFlavour() {  //flavoursCount - максимальное кол-во вкусов в мороженном
        getFlavourList();
        String[][] flavourSelected;
        flavourSelected = new String[2][4];
        boolean endSelection = true;
        for (int i = 0; i < flavourSelected[0].length; i++) {
            boolean selectorCorrect = true;
            while (selectorCorrect && endSelection) {
                System.out.println("Выберите " + (i + 1) + "й вкус");
                int containerSelect = scanInputMenuSelect();
                switch (containerSelect) {
                    case FIRST_CASE_SELECT:
                        flavourSelected[0][i] = flavorsList[0][0];
                        flavourSelected[1][i] = flavorsList[1][0];
                        selectorCorrect = false;
                        break;
                    case SECOND_CASE_SELECT:
                        flavourSelected[0][i] = flavorsList[0][1];
                        flavourSelected[1][i] = flavorsList[1][1];
                        selectorCorrect = false;
                        break;
                    case THIRD_CASE_SELECT:
                        flavourSelected[0][i] = flavorsList[0][2];
                        flavourSelected[1][i] = flavorsList[1][2];
                        selectorCorrect = false;
                        break;
                    case FOURTH_CASE_SELECT:
                        flavourSelected[0][i] = flavorsList[0][3];
                        flavourSelected[1][i] = flavorsList[1][3];
                        selectorCorrect = false;
                        break;
                    case FIFTH_CASE_SELECT:
                        flavourSelected[0][i] = flavorsList[0][4];
                        flavourSelected[1][i] = flavorsList[1][4];
                        selectorCorrect = false;
                        break;
                    case SIX_CASE_SELECT:
                        System.out.println("Выбор вкусов завершён. \n");
                        endSelection = false;
                        break;
                    default:
                        System.err.println("Выберите вкус!");
                }
            }

        }
        return flavourSelected;
    }

    public String[][] chooseRandomFlavour() {
        Random randomValue = new Random();
        int pos = randomValue.nextInt(flavorsList[0].length);
        String[][] flavourSelected;
        flavourSelected = new String[2][1];
        flavourSelected[0][0] = flavorsList[0][pos];
        flavourSelected[1][0] = flavorsList[1][pos];
        return flavourSelected;
    }

    public void getToppingsList() {
        for (int i = 0; i < toppingsList[0].length; i++) {
            System.out.println((i + 1) + ". " + toppingsList[0][i] + ". Стоимость " + toppingsList[1][i] + "руб.");
        }
        System.out.println((toppingsList[0].length + 1) + ". " + "Закончить выбор топпингов. \n");
    }

    public String[][] chooseToppings() {
        getToppingsList();
        String[][] toppingsSelected;
        toppingsSelected = new String[2][4];
        boolean endSelection = true;
        for (int i = 0; i < toppingsSelected[0].length; i++) {
            boolean selectorCorrect = true;
            while (selectorCorrect && endSelection) {
                System.out.println("Выберите " + (i + 1) + "й топпинг:");
                int containerSelect = scanInputMenuSelect();
                switch (containerSelect) {
                    case FIRST_CASE_SELECT:
                        toppingsSelected[0][i] = toppingsList[0][0];
                        toppingsSelected[1][i] = toppingsList[1][0];
                        selectorCorrect = false;
                        break;
                    case SECOND_CASE_SELECT:
                        toppingsSelected[0][i] = toppingsList[0][1];
                        toppingsSelected[1][i] = toppingsList[1][1];
                        selectorCorrect = false;
                        break;
                    case THIRD_CASE_SELECT:
                        toppingsSelected[0][i] = toppingsList[0][2];
                        toppingsSelected[1][i] = toppingsList[1][2];
                        selectorCorrect = false;
                        break;
                    case FOURTH_CASE_SELECT:
                        toppingsSelected[0][i] = toppingsList[0][3];
                        toppingsSelected[1][i] = toppingsList[1][3];
                        selectorCorrect = false;
                        break;
                    case FIFTH_CASE_SELECT:
                        toppingsSelected[0][i] = toppingsList[0][4];
                        toppingsSelected[1][i] = toppingsList[1][4];
                        selectorCorrect = false;
                        break;
                    case SIX_CASE_SELECT:
                        toppingsSelected[0][i] = toppingsList[0][5];
                        toppingsSelected[1][i] = toppingsList[1][5];
                        selectorCorrect = false;
                        break;
                    case SEVEN_CASE_SELECT:
                        System.out.println("Выбор топпингов завершён. \n");
                        endSelection = false;
                        break;
                    default:
                        System.err.println("Выберите топпинг!");
                }
            }

        }
        return toppingsSelected;
    }

    public String[][] chooseRandomToppings() {
        Random randomValue = new Random();
        int pos = randomValue.nextInt(toppingsList[0].length);
        String[][] toppingsSelected;
        toppingsSelected = new String[2][2];
        toppingsSelected[0][0] = toppingsList[0][pos];
        toppingsSelected[1][0] = toppingsList[1][pos];
        pos = randomValue.nextInt(toppingsList[0].length);
        toppingsSelected[0][1] = toppingsList[0][pos];
        toppingsSelected[1][1] = toppingsList[1][pos];
        return toppingsSelected;
    }

    public void getDrinksList() {
        for (int i = 0; i < drinksList[0].length; i++) {
            System.out.println((i + 1) + ". " + drinksList[0][i] + ". Стоимость " + drinksList[1][i] + "руб.");
        }
    }

    public String[][] chooseDrink() {
        System.out.println("Выберите напиток");
        getDrinksList();
        String[][] drinkSelected;
        drinkSelected = new String[2][1];
        boolean selectorCorrect = true;
        while (selectorCorrect) {
            int containerSelect = scanInputMenuSelect();
            switch (containerSelect) {
                case FIRST_CASE_SELECT:
                    drinkSelected[0][0] = drinksList[0][0];
                    drinkSelected[1][0] = drinksList[1][0];
                    selectorCorrect = false;
                    break;
                case SECOND_CASE_SELECT:
                    drinkSelected[0][0] = drinksList[0][1];
                    drinkSelected[1][0] = drinksList[1][1];
                    selectorCorrect = false;
                    break;
                case THIRD_CASE_SELECT:
                    drinkSelected[0][0] = drinksList[0][2];
                    drinkSelected[1][0] = drinksList[1][2];
                    selectorCorrect = false;
                    break;
                case FOURTH_CASE_SELECT:
                    drinkSelected[0][0] = drinksList[0][3];
                    drinkSelected[1][0] = drinksList[1][3];
                    selectorCorrect = false;
                    break;
                case FIFTH_CASE_SELECT:
                    drinkSelected[0][0] = drinksList[0][4];
                    drinkSelected[1][0] = drinksList[1][4];
                    selectorCorrect = false;
                    break;
                default:
                    System.err.println("Выберите напиток!");
            }
        }
        return drinkSelected;
    }

    int scanInputMenuSelect() {
        int nextInt = 0;
        try {
            nextInt = input.nextInt();
            input.nextLine();
        } catch (InputMismatchException e) {
            input.nextLine();
        }
        return nextInt;
    }
}
