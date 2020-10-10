public class Player implements SockerPlayer {
    private String nickName;
    private int ratingPoints;
    private League league;
    private Country country;

    Player(String nickName, int ratingPoints, League league, Country country) {
        this.nickName = nickName;
        this.ratingPoints = ratingPoints;
        this.league = league;
        this.country = country;
    }

    @Override
    public String getNickName() {
        return nickName;
    }

    @Override
    public Integer getPoints() {
        return ratingPoints;
    }

    @Override
    public League getLeague() {
        return league;
    }

    @Override
    public Country getCountry() {
        return country;
    }
}
