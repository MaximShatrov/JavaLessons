package BattleSim.Units;

public interface Warrior extends Cloneable {
    int attack();

    void takeDamage(int damage);

    boolean isAlive();

    void setSquadName(String name);

    public int getHealth();

    public Object clone() throws CloneNotSupportedException;
}

