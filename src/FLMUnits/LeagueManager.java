package FLMUnits;

import Library.Country;
import Library.League;

public interface LeagueManager {
    //сгенерировать случайного игрока player и добавить в базу
    public void addPlayer(SockerPlayer player);

    //удалить игрока player из базы
    public void removePlayer(SockerPlayer player);

    //вызвать инфу по игроку name
    public SockerPlayer getPlayer(String name);

    //вывести рейтинг всех игроков из базы
    public SockerPlayer[] getAllPlayers();

    //вывести рейтинг игроков лиги league
    public SockerPlayer[] getPlayers(League league);

    //вывести рейтинг игроков страны country
    public SockerPlayer[] getPlayers(Country country);

    //поднять рейтинг игрока name на points очков
    public void addPoints(String name, int points);

}
