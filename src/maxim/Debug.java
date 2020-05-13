// Класс только для отладки!
package maxim;
/*
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Deprecated
public class Debug {
    public static void main(String[] args){
        Debug.printStreet();
        //Debug.printDate();
    }
    public static void printDate(){
         Calendar calendar = new GregorianCalendar();                    //создание календаря
        /*calendar.set(TimeAndDate.YEAR, 2017);
        calendar.set(TimeAndDate.MONTH, 0);
        calendar.set(TimeAndDate.DAY_OF_MONTH, 25);
        calendar.set(TimeAndDate.HOUR_OF_DAY, 19);
        calendar.set(TimeAndDate.MINUTE, 42);
        calendar.set(TimeAndDate.SECOND, 12);
        */
/*
        Date todayTime = GregorianCalendar.getInstance().getTime();     //получение текущей даты
        calendar.setTime(todayTime);                                    //установка текущей даты в календарь
        DateFormat df = new SimpleDateFormat("dd MMMM yyy");   //формат даты
        System.out.println(df.format(calendar.getTime()));
        calendar.add(Calendar.DAY_OF_MONTH, 3);
        System.out.println(df.format(calendar.getTime()));

    }
*/
/**
    public static void printStreet(){
        Array.streetCreation();
        Array.streetFilling();
        for (int i = 0; i < Array.unnamedStreet.length; i++) {
            System.out.println(Color.BLUE_BOLD + "Дом #" +(i+1) +":" + Color.RESET);
            for (int j = 0; j < Array.unnamedStreet[i].length; j++) {
                System.out.print(Color.YELLOW + "Квартира #" +(j+1) +": " + Color.RESET);
                System.out.println("\n" + "Человек " + (Array.unnamedStreet[i][j]).getHumans());
                System.out.println("Денег " + (Array.unnamedStreet[i][j]).getBudget());
                System.out.println("Долги " + (Array.unnamedStreet[i][j]).getBills());
                System.out.println("Работает " + (Array.unnamedStreet[i][j]).getWorking());
                System.out.println("\n");
                }
            }
            System.out.println("Конец");

        }

        /*
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

**/