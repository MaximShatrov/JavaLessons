import Units.*;

import java.util.Random;

public class Squad {
    private Warrior[] massive;
    private String squadName;
    private Random random = new Random();
    private final int ARCHER = 0;
    private final int KNIGHT = 1;
    private final int PRIEST = 2;
    private final int VIKING = 3;

    public Squad(int quantity, String squadName) {
        this.squadName = squadName;
        massive = new Warrior[quantity + 1];
        for (int i = 0; i < massive.length - 1; i++) {
            massive[i] = (Warrior) makeRandomUnit(squadName);
        }
    }

    Warrior getRandomWarrior() {
        int randomUnit = random.nextInt(massive.length - 1);
        while (true) {
            if (massive[randomUnit].isAlive()) {
                massive[massive.length - 1] = massive[randomUnit];
                massive[randomUnit] = null;
                return massive[massive.length - 1];
            } else {
                randomUnit = random.nextInt(massive.length-1);
            }
        }

    }

    void returnRandomWarrior(Warrior warrior){
        for (int i=0; i<massive.length - 1;i++){
            if (massive[i]==null){
                massive[i] = warrior;
                massive[massive.length-1] = null;
            }
        }
    }


    boolean hasAliveWarriors() {
        for (int i = 0; i < massive.length-1; i++) {
            if (massive[i].isAlive()) {
                return true;
            }
        }
        return false;
    }

    private Object makeRandomUnit(String squadName) {
        Warrior generatedUnit = null;
        switch (random.nextInt(4)) {
            case ARCHER:
                generatedUnit = new Archer(squadName);
                break;
            case KNIGHT:
                generatedUnit = new Knight(squadName);
                break;
            case PRIEST:
                generatedUnit = new Priest(squadName);
                break;
            case VIKING:
                generatedUnit = new Viking(squadName);
                break;
            default:
                System.err.println("Что-то пошло не так");
                break;
        }
        return generatedUnit;
    }

    public void squadList( ) {
        for (int i = 0; i < massive.length-1; i++) {
            System.out.println((i + 1) + ". " + massive[i].toString() + " Здоровье: " + massive[i].getHealth());
        }
    }

    @Override
    public String toString() {      //Переопределить метод toString() класса Object для отряда, чтобы он выводил его имя.
        return this.squadName;
    }


    @Override                       //Переопределить метод clone(), создающий копию отряда.
    // При этом должен быть создан новый отряд, содержащий новый массив новых бойцов, идентичных исходным.
    public Object clone() {
        return null;
    }
}

