public class Drinks {/*

    public static final String[][] drinksList = new String[][]{{"Кола", "Пепси", "Лимонад", "Компот", "Липтон"}, {"45", "45", "35", "30", "50"}};

    public static void main(String[] args) {
        getDrinksList();
        chooseDrink();
    }

    public static void getDrinksList() {
        for (int i = 0; i < drinksList[0].length; i++) {
            System.out.println((i + 1) + ". " + drinksList[0][i] + ". Стоимость " + drinksList[1][i] + "руб.");
        }
    }


    public static String[][] chooseDrink() {
        System.out.println("Выберите напиток");
        getDrinksList();
        String[][] drinkSelected;
        drinkSelected = new String[2][1];
        boolean selectorCorrect = true;
        while (selectorCorrect) {
            int containerSelect = ConsoleApp.scanInputMenuSelect();
            switch (containerSelect) {
                case 1:
                    drinkSelected[0][0] = drinksList[0][0];
                    drinkSelected[1][0] = drinksList[1][0];
                    selectorCorrect = false;
                    break;
                case 2:
                    drinkSelected[0][0] = drinksList[0][1];
                    drinkSelected[1][0] = drinksList[1][1];
                    selectorCorrect = false;
                    break;
                case 3:
                    drinkSelected[0][0] = drinksList[0][2];
                    drinkSelected[1][0] = drinksList[1][2];
                    selectorCorrect = false;
                    break;
                case 4:
                    drinkSelected[0][0] = drinksList[0][3];
                    drinkSelected[1][0] = drinksList[1][3];
                    selectorCorrect = false;
                    break;
                case 5:
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
*/
}

