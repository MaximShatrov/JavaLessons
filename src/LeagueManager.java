public interface LeagueManager {
    public void addPlayer(SockerPlayer player);

    public void removePlayer(SockerPlayer player);

    public SockerPlayer getPlayer(String name);

    public SockerPlayer[] getAllPlayers();

    public SockerPlayer[] getPlayers(League league);

    public SockerPlayer[] getPlayers(Country country);

    public void addPoints(String name, int points);

}
