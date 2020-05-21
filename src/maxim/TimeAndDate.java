package maxim;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimeAndDate {
    private static final java.util.Calendar DATE = new GregorianCalendar();                                  //создание календаря
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd MMMM yyyy");              //формат записи даты

    static void setTime() {
        Date todayTime = GregorianCalendar.getInstance().getTime();                                         //получение текущей даты
        DATE.setTime(todayTime);                                                                            //установка текущей даты в календарь
    }

    static void printDate() {
        System.out.println("\n" + DATE_FORMAT.format(DATE.getTime()));//вывод даты в консоль
    }

    public static void changeDate(int day) {
        DATE.add(Calendar.DAY_OF_MONTH, day);                                                               //

    }

    static void incrementDate() {
        DATE.add(Calendar.DAY_OF_MONTH, 1);                                                         // инкрементируем день в календаре
    }

    static void changeHour(int hour) {
        DATE.add(Calendar.HOUR_OF_DAY, hour);                                                               //
    }

    static int getHour() {                                                                            //
        return DATE.get(Calendar.HOUR);
    }

    static int getDay() {                                                                            //
        return DATE.get(Calendar.DAY_OF_MONTH);
    }
}
