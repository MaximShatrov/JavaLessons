public class Run {

    public static void main(String[] args) {
        LeagueManager leagueManager = new FLManager();
       SockerPlayer sockerPlayers[] = leagueManager.getPlayers(League.EFL);
        for (int i = 0; i <sockerPlayers.length ; i++) {
            System.out.println(sockerPlayers[i]);

        }


    }
}
