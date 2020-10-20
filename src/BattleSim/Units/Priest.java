package BattleSim.Units;

public class Priest implements Warrior, Cloneable {
    private int health = 95;
    private int damage = 16;
    private String squadName;
    private String warriorName;
    private String unitType = "Жрец";

    public Priest(int health, int damage, String squadName, String warriorName, String unitType) {
        this.health = health;
        this.damage = damage;
        this.squadName = squadName;
        this.warriorName = warriorName;
        this.unitType = unitType;
    }

    public String getUnitType() {
        return unitType;
    }

    public Priest(String squadName) {
        this.squadName = squadName;
        NameList name = new NameList();
        warriorName = name.getRandomName();
    }

    private Priest(String squadName, String warriorName) {
        this.squadName = squadName;
        this.warriorName = warriorName;
    }

    @Override
    public int attack() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public void takeDamage(int damage) {
        this.health -= damage;
    }

    @Override
    public boolean isAlive() {
        if (this.health <= 0)
            return false;
        else return true;
    }

    @Override
    public void setSquadName(String name) {
        squadName = name;
    }

    @Override
    public String toString() {      //Переопределить метод toString() класса Object для бойца, чтобы он выводил его
        // имя, класс и принадлежность к отряду.
        return (unitType + " " + warriorName + " из отряда " + squadName);
    }


    @Override                       //Переопределить метод clone(), создающий копию бойца.
    public Priest clone() throws CloneNotSupportedException {
        return (Priest) super.clone();
    }
}
