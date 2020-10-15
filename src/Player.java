import java.util.Objects;
import java.util.Random;

public class Player implements SockerPlayer, Comparable<Player> {
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
    //Имя каждого игрока уникально. Тезки не допустимы!
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(nickName, player.nickName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickName);
    }

    @Override
    public String toString() {
        return "\n" + nickName + ": рейтинг - " + ratingPoints + ", страна - " + country + ", лига - " + league;
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


    public int compareTo(Player comparePlayer) {
        if (this.ratingPoints > comparePlayer.ratingPoints) {
            return -1;
        } else if (this.ratingPoints < comparePlayer.ratingPoints) {
            return 1;
        } else {
            return 0;
        }
    }
}
