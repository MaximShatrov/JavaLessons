import java.util.Random;

public class Flavors {
    public static final String[][] flavorsList = new String[][]{{"Шоколадный", "Клубничный", "Банановый", "Вишнёвый", "Фисташковый"}, {"30", "30", "35", "40", "30"}};

    public static void main(String[] args) {
        getFlavourList();
        chooseFlavour(4);
    }

    public static void getFlavourList() {
        for (int i = 0; i < flavorsList[0].length; i++) {
            System.out.println((i + 1) + ". " + flavorsList[0][i] + " вкус. Стоимость " + flavorsList[1][i] + "руб.");
        }
        System.out.println((flavorsList[0].length + 1) + ". " + "Закончить выбор вкусов. \n");
    }


    public static String[][] chooseFlavour(int flavoursCount) {  //flavoursCount - максимальное кол-во вкусов в мороженном
        getFlavourList();
        String[][] flavourSelected;
        flavourSelected = new String[2][flavoursCount];
        boolean endSelection = true;
        for (int i = 0; i < flavourSelected[0].length; i++) {
            boolean selectorCorrect = true;
            while (selectorCorrect && endSelection) {
                System.out.println("Выберите " + (i + 1) + "й вкус");
                int containerSelect = ConsoleApp.scanInputMenuSelect();
                switch (containerSelect) {
                    case 1:
                        flavourSelected[0][i] = flavorsList[0][0];
                        flavourSelected[1][i] = flavorsList[1][0];
                        selectorCorrect = false;
                        break;
                    case 2:
                        flavourSelected[0][i] = flavorsList[0][1];
                        flavourSelected[1][i] = flavorsList[1][1];
                        selectorCorrect = false;
                        break;
                    case 3:
                        flavourSelected[0][i] = flavorsList[0][2];
                        flavourSelected[1][i] = flavorsList[1][2];
                        selectorCorrect = false;
                        break;
                    case 4:
                        flavourSelected[0][i] = flavorsList[0][3];
                        flavourSelected[1][i] = flavorsList[1][3];
                        selectorCorrect = false;
                        break;
                    case 5:
                        flavourSelected[0][i] = flavorsList[0][4];
                        flavourSelected[1][i] = flavorsList[1][4];
                        selectorCorrect = false;
                        break;
                    case 6:
                        System.out.println("Выбор вкусов завершён. \n");
                        endSelection = false;
                        break;
                    default:
                        System.err.println("Выберите вкус!");
                }
            }

        }
        /*for (int i = 0; i < flavourSelected[0].length; i++) {
            if (flavourSelected[0][i] != null)
                System.out.println((i + 1) + ". " + flavourSelected[0][i] + " вкус. Стоимость " + flavourSelected[1][i] + "руб.");
        }*/
        return flavourSelected;
    }

    public static String[][] chooseRandomFlavour(){
        Random randomValue = new Random();
        int pos = randomValue.nextInt(flavorsList[0].length);
        String[][] flavourSelected;
        flavourSelected = new String[2][1];
        flavourSelected[0][0] = flavorsList[0][pos];
        flavourSelected[1][0] = flavorsList[1][pos];
        return flavourSelected;
    }
}

