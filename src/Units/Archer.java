package Units;

public class Archer implements Warrior{
    private int health;
    private int damage;
    private String squadName;

    @Override
    public int attack() {
        return 0;
    }

    @Override
    public void takeDamage(int damage) {

    }

    @Override
    public boolean isAlive() {
        return false;
    }

    @Override
    public void setSquadName(String name) {

    }

    @Override
    public String toString() {      //Переопределить метод toString() класса Object для бойца, чтобы он выводил его
                                    // имя, класс и принадлежность к отряду.
        return "Squad{}";
    }


    @Override                       //Переопределить метод clone(), создающий копию бойца.
    public Object clone(){
        return null;
    }
}
