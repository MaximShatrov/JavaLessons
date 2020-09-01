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
        massive = new Warrior[quantity];
        for (int i = 0; i < massive.length; i++) {
            massive[i] = (Warrior) makeRandomUnit(squadName);
        }
    }

    public Warrior getRandomWarrior(Squad squad) {
        int randomUnit = random.nextInt(squad.massive.length);
        while (true) {
            if (squad.massive[randomUnit].isAlive()) {
                return squad.massive[randomUnit];
            } else {
            }
        }

    }


    public boolean hasAliveWarriors(Squad squad) {
        for (int i = 0; i < squad.massive.length; i++) {
            if (squad.massive[i].isAlive()) {
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

    public void squadList(Squad squad){
        for (int i=0;i<squad.massive.length;i++){
            System.out.println(squad.massive.toString());
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

