import java.util.Random;

public class Player implements SockerPlayer {
    private String nickName;
    private int ratingPoints;
    private League league;
    private Country country;
    private NameLibrary nameLibrary;
    private Random random = new Random();

    Player(String nickName, int ratingPoints, League league, Country country) {
        this.nickName = nickName;
        this.ratingPoints = ratingPoints;
        this.league = league;
        this.country = country;
    }

    public Player(League league, Country country) {
        this.league = league;
        this.country = country;
        this.ratingPoints = (random.nextInt(35) + 60);
        this.nickName = nameLibrary.getRandomNickname();
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
