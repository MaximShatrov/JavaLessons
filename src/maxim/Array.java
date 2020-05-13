package maxim;

public class Array {
    private static final int MIN_HOUSES = 5;
    private static final int MAX_HOUSES = 10;
    private static final int QUANTITY_OF_HOUSES = RandomizeValues.getRandInt(MIN_HOUSES,MAX_HOUSES);
    private static final int MIN_FLOOR = 3;
    private static final int MAX_FLOOR = 5;
    public static Family[][] unnamedStreet;

    public static void streetCreation(){
        //unnamedStreet = new Family[3][3];      //Постоянные параметры для упрощения отладки
        unnamedStreet = new Family[QUANTITY_OF_HOUSES][];
        for (int i = 0; i < unnamedStreet.length; i++) {
            unnamedStreet[i] = new Family[RandomizeValues.getRandInt4(MIN_FLOOR,MAX_FLOOR)];
        }

    }

    public static void streetFilling(){
        for (int i = 0; i < unnamedStreet.length; i++) {                       //Дома от 0 до unnamedStreet.length
            for (int j = 0; j < unnamedStreet[i].length; j++){                 //Квартиры от 0 до unnamedStreet[i].length
                unnamedStreet[i][j] = new Family();
            }
            }
        }

    public static void main(String[] args){ }
}




