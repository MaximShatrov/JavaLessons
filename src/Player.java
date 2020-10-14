import java.util.Objects;
import java.util.Random;

public class Player implements SockerPlayer {
    private String nickName;
    private int ratingPoints;
    private League league;
    private Country country;
    private NameLibrary nameLibrary = new NameLibrary();
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
    public String toString() {
        return "\nИмя: " + nickName + "\nРейтинг: " + ratingPoints + "\nСтрана: " + country + "\nЛига: " + league;
    }

    @Override
    public String getNickName() {
        return nickName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return nickName.equals(player.nickName) &&
                country == player.country;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickName, country);
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
