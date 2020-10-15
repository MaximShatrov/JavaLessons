import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class FLManager implements LeagueManager {
    private HashSet<SockerPlayer> playerHashSet = new HashSet();
    private Random random = new Random();
    private final int FLBASE_SIZE = 5;

    public FLManager() {
        fillPlayerHashSet();
        //System.out.println(playerHashSet);
    }

    private void fillPlayerHashSet() {

        for (int i = 0; i < League.values().length; i++) {
            //League cacheLeague = League.values()[i];
            for (int j = 0; j < FLBASE_SIZE; j++) {
                playerHashSet.add(new Player(League.values()[i], Country.values()[random.nextInt(Country.values().length)]));
            }
        }
        System.err.println("ОТЛАДКА.В базе игроков: " + playerHashSet.size());
    }

    @Override
    public void addPlayer(SockerPlayer player) {
        playerHashSet.add(player);
    }

    @Override
    public void removePlayer(SockerPlayer player) {
        playerHashSet.remove(player);

    }

    @Override
    public SockerPlayer getPlayer(String name) {    //Вывести инфу по игроку.
        SockerPlayer sockerPlayer = new Player(name, 0, null, null);
        if (playerHashSet.contains(sockerPlayer)) {
            for (SockerPlayer player : playerHashSet) {
                if (player.equals(sockerPlayer)) {
                    System.out.println(player);
                }
            }
        } else {
            System.out.println("Данного игрока нет ни в одной лиге!");
        }
        return null;
    }

    //вывести рейтинг всех игроков из базы
    @Override
    public SockerPlayer[] getAllPlayers() {
        TreeSet treeSet = new TreeSet(playerHashSet);
        //System.out.println(treeSet);
        return (SockerPlayer[]) treeSet.toArray(new SockerPlayer[treeSet.size()]);
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
        return (SockerPlayer[]) treeSet.toArray(new SockerPlayer[treeSet.size()]);
    }

    //вывести рейтинг игроков страны country
    @Override
    public SockerPlayer[] getPlayers(Country country) {
        return new SockerPlayer[0];
    }

    //поднять рейтинг игрока name на points очков
    @Override
    public void addPoints(String name, int points) {

    }
}
