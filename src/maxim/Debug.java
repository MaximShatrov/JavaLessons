// Класс только для отладки!
package maxim;

@Deprecated
public class Debug {
    public static void main(String[] args){
        Debug.printStreet();
    }

    public static void printStreet(){
        Array.streetCreation();
        Array.streetFilling();
        for (int i = 1; i < Array.unnamedStreet.length; i++) {
            System.out.println(Color.BLUE_BOLD + "Дом #" +i +":" + Color.RESET);
            for (int j = 1; j < Array.unnamedStreet[i].length; j++) {
                System.out.print(Color.YELLOW + "Квартира #" +j +": " + Color.RESET);
                for (int k = 0; k < Array.unnamedStreet[i][j].length; k++) {
                    //System.out.print("\u001B[0m" + Array.unnamedStreet[i][j][k] +" ");
                    switch (k) {
                        case 0:
                            System.out.print("Прописано: " + Array.unnamedStreet[i][j][k] + " чел. ");
                            break;
                        case 1:
                            System.out.print("Бюджет: " + Array.unnamedStreet[i][j][k] + "руб. ");
                            break;
                        case 2:
                            System.out.print("Долг: " + Array.unnamedStreet[i][j][k] + "руб." + "\n");
                            break;
                        default:
                            System.out.println(Color.RED_UNDERLINED + "Что-то пошло не так :|" + Color.RESET);
                    }
                }
            }
            System.out.println("\n");
        }
        System.out.println("Ending");
    }
}
