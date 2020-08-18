import java.util.Random;

public class Toppings {
    public static final String[][] toppingsList = new String[][]{{"Орехи", "Шоколад", "Фрукты", "Сироп", "Сгущёнка", "Ликер"}, {"30", "20", "15", "20", "25", "45"}};

    public static void main(String[] args) {
        //getToppingsList();
        chooseToppings(4);
    }

    public static void getToppingsList() {
        for (int i = 0; i < toppingsList[0].length; i++) {
            System.out.println((i + 1) + ". " + toppingsList[0][i] + ". Стоимость " + toppingsList[1][i] + "руб.");
        }
        System.out.println((toppingsList[0].length + 1) + ". " + "Закончить выбор топпингов. \n");
    }


    public static String[][] chooseToppings(int toppingsCount) {  //toppingsCount - максимальное кол-во топпингов в мороженном
        getToppingsList();
        String[][] toppingsSelected;
        toppingsSelected = new String[2][toppingsCount];
        boolean endSelection = true;
        for (int i = 0; i < toppingsSelected[0].length; i++) {
            boolean selectorCorrect = true;
            while (selectorCorrect && endSelection) {
                System.out.println("Выберите " + (i + 1) + "й топпинг:");
                int containerSelect = ConsoleApp.scanInputMenuSelect();
                switch (containerSelect) {
                    case 1:
                        toppingsSelected[0][i] = toppingsList[0][0];
                        toppingsSelected[1][i] = toppingsList[1][0];
                        selectorCorrect = false;
                        break;
                    case 2:
                        toppingsSelected[0][i] = toppingsList[0][1];
                        toppingsSelected[1][i] = toppingsList[1][1];
                        selectorCorrect = false;
                        break;
                    case 3:
                        toppingsSelected[0][i] = toppingsList[0][2];
                        toppingsSelected[1][i] = toppingsList[1][2];
                        selectorCorrect = false;
                        break;
                    case 4:
                        toppingsSelected[0][i] = toppingsList[0][3];
                        toppingsSelected[1][i] = toppingsList[1][3];
                        selectorCorrect = false;
                        break;
                    case 5:
                        toppingsSelected[0][i] = toppingsList[0][4];
                        toppingsSelected[1][i] = toppingsList[1][4];
                        selectorCorrect = false;
                        break;
                    case 6:
                        toppingsSelected[0][i] = toppingsList[0][5];
                        toppingsSelected[1][i] = toppingsList[1][5];
                        selectorCorrect = false;
                        break;
                    case 7:
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

    public static String[][] chooseRandomToppings(){
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
}
