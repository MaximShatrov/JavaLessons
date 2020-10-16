package BattleSim.Units;

public interface Warrior {
    int attack();

    void takeDamage(int damage);

    boolean isAlive();

    void setSquadName(String name);

    public int getHealth();
}

