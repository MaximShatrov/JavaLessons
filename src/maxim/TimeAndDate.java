package maxim;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimeAndDate {
    private static final java.util.Calendar DATE = new GregorianCalendar();                                  //создание календаря
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd MMMM yyy");              //формат записи даты

    public static void setTime(){
        Date todayTime = GregorianCalendar.getInstance().getTime();                                         //получение текущей даты
        DATE.setTime(todayTime);                                                                            //установка текущей даты в календарь
    }

    public static void printDate(){
        System.out.println("\n"+ DATE_FORMAT.format(DATE.getTime()));                                              //вывод даты в консоль
    }

    public static void changeDate(int day){
        DATE.add(Calendar.DAY_OF_MONTH, day);                                                               //

    }

    public static void incrementDate(){
        DATE.add(Calendar.DAY_OF_MONTH, 1);                                                         // инкрементируем день в календаре
    }

    public static void changeHour(int hour){
        DATE.add(Calendar.HOUR_OF_DAY, hour);                                                               //
    }

    public static int getHour(){                                                                            //
        int hour = DATE.get(Calendar.HOUR);
        return hour;
    }

    public static int getDay(){                                                                            //
        int day = DATE.get(Calendar.DAY_OF_MONTH);
        return day;
    }


    public static void main(String[] args){
        TimeAndDate.setTime();
    }
}
