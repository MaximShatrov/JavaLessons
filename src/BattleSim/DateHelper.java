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
    private String fullDatePattern = "HH:mm, dd MMMM YYY";
    private DateFormat dfFull = new SimpleDateFormat(fullDatePattern);
    private String timeOnlyPattern = "HH:mm";
    private DateFormat dfTimeOnly = new SimpleDateFormat(timeOnlyPattern);
    private int yearDiff = -1500;
    private int skipTimeMinutes = 45;
    //private DateFormat dfFull = new SimpleDateFormat("dd MMMM YYY");


    {
        calendar.add(Calendar.YEAR, yearDiff);
        battleTime = calendar.getTime();
        battleBeginTime = battleTime;
    }

    DateHelper() {

    }
    /**
     * @return возвращает дату и время начала сражения в формате {@link DateHelper#fullDatePattern}
     */
    String getFormattedStartDate() {
        return dfFull.format(battleBeginTime);
    }

    /**
     * проматывает длительность{@link DateHelper#skipTimeMinutes} одного раунда сражения
     */
    void skipTime() {
        calendar.add(Calendar.MINUTE, skipTimeMinutes);
        battleTime = calendar.getTime();
        //проматывает константное время (длительность)
        // одного раунда сражения, например, 45 минут
    }

    /**
     * @return возвращает дату и время текущего времени{@link DateHelper#battleTime} в формате {@link DateHelper#fullDatePattern}
     */
    String getFormattedCurrentTime() {
        //возвращает отформатированную
        //(в формате на ваш выбор) дату и время начала сражения.
        //Дата должна соответствовать текущей минус 1500 лет.
        return dfFull.format(battleTime);
    }

    /**
     * Функция получения разницы между текущим{@link DateHelper#battleTime} временем и началом боя{@link DateHelper#battleBeginTime}
     * @return Возвращает значение равное колличеству прошедших минут боя
     */
    long getFormattedDiff() {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        return timeUnit.convert(battleTime.getTime()-battleBeginTime.getTime(),TimeUnit.MILLISECONDS);
    }
}
