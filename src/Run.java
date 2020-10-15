import FLMUnits.FLManager;
import FLMUnits.LeagueManager;
import FLMUnits.SockerPlayer;
import Library.Country;

public class Run {

    public static void main(String[] args) {
        LeagueManager leagueManager = new FLManager();
       SockerPlayer sockerPlayers[] = leagueManager.getPlayers(Country.RU);
        for (int i = 0; i <sockerPlayers.length ; i++) {
            System.out.println(sockerPlayers[i]);

        }


    }
}
