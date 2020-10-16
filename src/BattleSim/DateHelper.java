package BattleSim;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

class DateHelper {

    private Date now = new Date();
    private Date battleTime;
    private Date battleBeginTime;
    private Calendar calendar = Calendar.getInstance();
    private DateFormat dfFull = new SimpleDateFormat("HH:mm, dd MMMM YYY");
    private DateFormat dfTimeOnly = new SimpleDateFormat("HH:mm");
    //private DateFormat dfFull = new SimpleDateFormat("dd MMMM YYY");


    {
        calendar.add(Calendar.YEAR, -1500);
        battleTime = calendar.getTime();
        battleBeginTime = battleTime;
    }

    DateHelper() {

    }

    String getFormattedStartDate() {
        //возвращает отформатированную
        //(в формате на ваш выбор) дату и время начала сражения.
        //Дата должна соответствовать текущей минус 1500 лет.
        return dfFull.format(battleBeginTime);
    }

    void skipTime() {
        calendar.add(Calendar.MINUTE, 45);
        battleTime = calendar.getTime();
        //проматывает константное время (длительность)
        // одного раунда сражения, например, 45 минут
    }

    String getFormattedCurrentTime() {
        //возвращает отформатированную
        //(в формате на ваш выбор) дату и время начала сражения.
        //Дата должна соответствовать текущей минус 1500 лет.
        return dfTimeOnly.format(battleTime);
    }

    long getFormattedDiff() {                //Возвращает значение равное колличеству прошедших минут боя
        TimeUnit timeUnit = TimeUnit.MINUTES;
        //возвращает отформатированную (в формате на ваш выбор) длительность сражения, как разницу между
        //временем, на которое проматывалось время сражения, и временем начала сражения.
        return timeUnit.convert(battleTime.getTime()-battleBeginTime.getTime(),TimeUnit.MILLISECONDS);
    }
}
