package FLMUnits;

import Library.Country;
import Library.League;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

public class FLManager implements LeagueManager {
    private HashSet<SockerPlayer> playerHashSet = new HashSet();
    private Random random = new Random();
    private final int LEAGUE_SIZE = 20;

    public FLManager() {
        fillPlayerHashSet();
        //System.out.println(playerHashSet);
    }

    private void fillPlayerHashSet() {

        for (int i = 0; i < League.values().length; i++) {
            //Library.League cacheLeague = Library.League.values()[i];
            for (int j = 0; j < LEAGUE_SIZE; j++) {
                playerHashSet.add(new Player(League.values()[i], Country.values()[random.nextInt(Country.values().length)]));
            }
        }
        System.err.println("ОТЛАДКА.В базе игроков: " + (playerHashSet.size()));
    }

    @Override
    public void addPlayer(SockerPlayer player) {
        playerHashSet.add(player);
    }

    @Override
    public void removePlayer(SockerPlayer player) {
        if (playerHashSet.contains(player)) {
            playerHashSet.remove(player);
            System.out.println("Игрок успешно удален из рейтинга.");
        } else {
            System.out.println("Данный игрок не найден в рейтинге.");
        }
    }

    //Вывести инфу по игроку
    @Override
    public SockerPlayer getPlayer(String name) {
        SockerPlayer sockerPlayer = new Player(name, 0, null, null);
        if (playerHashSet.contains(sockerPlayer)) {
            for (SockerPlayer player : playerHashSet) {
                if (player.equals(sockerPlayer)) {
                    return player;
                }
            }
        }
        return null;
    }

    //вывести рейтинг всех игроков из базы
    @Override
    public SockerPlayer[] getAllPlayers() {
        TreeSet treeSet = new TreeSet(playerHashSet);
        //System.out.println(treeSet);
        return (SockerPlayer[]) treeSet.toArray(new SockerPlayer[0]);
    }

    //вывести рейтинг игроков лиги league
    @Override
    public SockerPlayer[] getPlayers(League league) {
        TreeSet treeSet = new TreeSet();
        for (SockerPlayer p : playerHashSet) {
            if (p.getLeague() == league) {
                treeSet.add(p);
            }
        }

        return (SockerPlayer[]) treeSet.toArray(new SockerPlayer[0]);
    }

    //вывести рейтинг игроков страны country
    @Override
    public SockerPlayer[] getPlayers(Country country) {
        TreeSet treeSet = new TreeSet();
        for (SockerPlayer p : playerHashSet) {
            if (p.getCountry() == country) {
                treeSet.add(p);
            }
        }
        System.out.println(treeSet.size());
        return (SockerPlayer[]) treeSet.toArray(new SockerPlayer[0]);
    }

    //поднять рейтинг игрока name на points очков
    @Override
    public void addPoints(String name, int points) {
        Iterator<SockerPlayer> iterator = playerHashSet.iterator();
        SockerPlayer updatePlayer = new Player(name, 0, null, null);
        boolean isNeedUpdate = true;
        if (playerHashSet.contains(updatePlayer)) {
            while (iterator.hasNext()) {
                SockerPlayer player = iterator.next();
                if (player.equals(updatePlayer)) {
                    if (player.getPoints() == 100) {
                        System.out.println("Рейтинг игрока " + updatePlayer.getNickName() + " уже максимальный!");
                        isNeedUpdate = false;
                        break;
                    } else if ((player.getPoints() + points) > 100) {
                        updatePlayer = new Player(player.getNickName(), (100), player.getLeague(), player.getCountry());
                    } else {
                        updatePlayer = new Player(player.getNickName(), (player.getPoints() + points), player.getLeague(), player.getCountry());
                    }
                }
            }
            if (isNeedUpdate) {
                playerHashSet.remove(updatePlayer);
                if (playerHashSet.add(updatePlayer)) {
                    System.out.println("Рейтинг игрока " + updatePlayer.getNickName() + " обновлен!");
                }
            }
        } else {
            System.out.println("Данного игрока нет ни в одной лиге!");
        }
    }
}
