package BattleSim;

import BattleSim.Units.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    /*public Squad(String squadName, Warrior[] squad1, Warrior[] squad2) {
        this.squadName = squadName;
        List<Warrior> list1 = Arrays.asList(squad1);
        List<Warrior> list2 = Arrays.asList(squad2);
        list1.addAll(list2);
        for (Warrior w : list1) {
            w.setSquadName(squadName);
        }
        massive = list1.toArray(new Warrior[0]);
    }*/

    public Squad(Squad squad1, Squad squad2, String squadName) {
        this.squadName = squadName;
        Warrior[] massive1 = squad1.getWarriorMassive();
        Warrior[] massive2 = squad2.getWarriorMassive();
        ArrayList<Warrior> arrayList = new ArrayList<>(Arrays.asList(massive1));
        ArrayList<Warrior> arrayList2 = new ArrayList<>(Arrays.asList(massive2));
        arrayList.addAll(arrayList.size() - 1, arrayList2);
        massive = arrayList.toArray(new Warrior[arrayList.size()]);
        /*for (int i = 0; i < massive.length ; i++) {
            massive[i].setSquadName(squadName);
        }*/
    }

    public Squad(Warrior[] warriors, String squadName) {
        this.massive = warriors;
        this.squadName = squadName;
    }

    public Warrior getRandomWarrior() {
        int randomUnit = random.nextInt(massive.length - 1);
        while (true) {
            if (massive[randomUnit].isAlive()) {
                massive[massive.length - 1] = massive[randomUnit];
                massive[randomUnit] = null;
                return massive[massive.length - 1];
            } else {
                randomUnit = random.nextInt(massive.length - 1);
            }
        }

    }

    void returnRandomWarrior(Warrior warrior) {
        for (int i = 0; i < massive.length - 1; i++) {
            if (massive[i] == null) {
                massive[i] = warrior;
                massive[massive.length - 1] = null;
            }
        }
    }


    boolean hasAliveWarriors() {
        for (int i = 0; i < massive.length - 1; i++) {
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

    private Warrior[] getWarriorMassive() {
        return massive;
    }

    public void squadList() {
        for (int i = 0; i < massive.length - 1; i++) {
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

