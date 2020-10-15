public class Run {

    public static void main(String[] args) {
        LeagueManager leagueManager = new FLManager();
       SockerPlayer sockerPlayers[] = leagueManager.getAllPlayers();
        for (int i = 0; i <sockerPlayers.length ; i++) {
            System.out.println(sockerPlayers[i]);

        }
    }
}
