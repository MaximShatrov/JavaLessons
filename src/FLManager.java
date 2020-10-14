import java.util.HashSet;
import java.util.Random;

public class FLManager implements LeagueManager {
    private HashSet<Player> playerHashSet = new HashSet();
    private Random random = new Random();

public FLManager(){
    fillPlayerHashSet();
    System.out.println(playerHashSet);
}

    private void fillPlayerHashSet() {

        for (int i = 0; i < League.values().length; i++) {
            //League cacheLeague = League.values()[i];
            for (int j = 0; j < 5; j++) {
                playerHashSet.add(new Player(League.values()[i],Country.values()[random.nextInt(Country.values().length)]));
            }
        }
    }

    @Override
    public void addPlayer(SockerPlayer player) {
    }

    @Override
    public void removePlayer(SockerPlayer player) {

    }

    @Override
    public SockerPlayer getPlayer(String name) {
        return null;
    }

    @Override
    public SockerPlayer[] getAllPlayers() {
        return new SockerPlayer[0];
    }

    @Override
    public SockerPlayer[] getPlayers(League league) {
        return new SockerPlayer[0];
    }

    @Override
    public SockerPlayer[] getPlayers(Country country) {
        return new SockerPlayer[0];
    }

    @Override
    public void addPoints(String name, int points) {

    }
}
