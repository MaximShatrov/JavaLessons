package maxim;

public class Array {
    private static final int MIN_HOUSES = 5;
    private static final int MAX_HOUSES = 10;
    private static final int QUANTITY_OF_HOUSES = RandomizeValues.getRandomInt(MIN_HOUSES,MAX_HOUSES);
    private static final int MIN_FLOOR = 3;
    private static final int MAX_FLOOR = 5;
    public static int[][][] unnamedStreet;

    public static void streetCreation(){
        //unnamedStreet = new int[10][8][3];      //Постоянные параметры для упрощения отладки
        unnamedStreet = new int[QUANTITY_OF_HOUSES][][];
        for (int i = 0; i < unnamedStreet.length; i++) {
            unnamedStreet[i] = new int [RandomizeValues.getRandomInt4(MIN_FLOOR,MAX_FLOOR)][3];
        }
    }

    public static void streetFilling(){
        for (int i = 0; i < unnamedStreet.length; i++) {                    //Дома от 0 до unnamedStreet.length
            //System.out.println("House #" +i +":");
            for (int j = 1; j < unnamedStreet[i].length; j++) {             //Квартиры 1 до unnamedStreet[i].length
                for (int k = 0; k < unnamedStreet[i][j].length; k++) {
                    switch (k){
                        case 0:
                            unnamedStreet[i][j][k] = RandomizeValues.getRandomInt(1,4); //Количество людей в квартире
                            break;
                        case 1:
                            unnamedStreet[i][j][k] = 1000*RandomizeValues.getRandomInt(10,40); //Деньги в семье
                            break;
                        case 2:
                            unnamedStreet[i][j][k] = RandomizeValues.getRandomInt(0,5000);        //Долги по ЖКХ
                            break;
                        default:
                            System.out.println("\033[0;31m" + "Что-то пошло не так :|" + "\u001B[0m");
                    }
                }
            }
        }
    }

    public static void changeFamilyParams(int house, int room, int param, int diff){
        //some code
    }

    public static void main(String[] args){
            }
}




