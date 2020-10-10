public interface SockerPlayer {
    //  Получение ФИО игрока
    String getNickName();
    // Рейтинг игрока
    Integer getPoints();
    // Лига игрока
    League getLeague();
    // Страна происхождения
    Country getCountry();

}
