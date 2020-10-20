package BattleSim;

import BattleSim.Units.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Squad implements Cloneable {
    private ArrayList<Warrior> massive;
    private String squadName;


    public Squad(Squad squad) {
        this.squadName = squad.toString();
        this.massive = (ArrayList<Warrior>) squad.getWarriorMassive().clone();
    }

    public Squad(int quantity, String squadName) {
        this.squadName = squadName;
        massive = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            massive.add((Warrior) makeRandomUnit(squadName));
        }
    }

    public Squad(Squad squad1, Squad squad2, String squadName) {
        this.squadName = squadName;
        ArrayList<Warrior> warriors1 = squad1.getWarriorMassive();
        ArrayList<Warrior> warriors2 = squad2.getWarriorMassive();
        warriors1.addAll(warriors2);
        massive = warriors1;

        for (int i = 0; i < massive.size(); i++) {
            Warrior warrior = massive.get(i);
            warrior.setSquadName(squadName);
            massive.set(i, warrior);
        }
    }

    public Squad(ArrayList<Warrior> warriors, String squadName) {
        this.massive = warriors;
        this.squadName = squadName;
    }

    public Warrior getRandomWarrior() {
        Random random = new Random();
        int randomUnit = random.nextInt(massive.size());
        while (true) {
            if (massive.get(randomUnit).isAlive()) {
                Warrior randomWarrior = massive.get(randomUnit);
                //massive[massive.length - 1] = massive[randomUnit];
                massive.remove(randomUnit);
                return randomWarrior;
            } else {
                randomUnit = random.nextInt(massive.size() - 1);
            }
        }

    }

    void returnRandomWarrior(Warrior warrior) {
        if (warrior.getHealth() > 0) {
            massive.add(warrior);
        }
    }


    boolean hasAliveWarriors() {
        for (int i = 0; i < massive.size(); i++) {
            if (massive.get(i).isAlive()) {
                return true;
            }
        }
        return false;
    }

    private Object makeRandomUnit(String squadName) {
        final int ARCHER = 0;
        final int KNIGHT = 1;
        final int PRIEST = 2;
        final int VIKING = 3;
        Warrior generatedUnit = null;
        Random random = new Random();
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

    private ArrayList<Warrior> getWarriorMassive() {
        return massive;
    }

    public StringBuilder squadList() {
        StringBuilder squadList = new StringBuilder();
        for (int i = 0; i < massive.size(); i++) {
            squadList.append((i + 1) + ".   " + massive.get(i).toString() + ".    Здоровье: " + massive.get(i).getHealth() + "\n");
        }
        return squadList;
    }

    @Override
    public String toString() {      //Переопределить метод toString() класса Object для отряда, чтобы он выводил его имя.
        return this.squadName;
    }


    @Override                       //Переопределить метод clone(), создающий копию отряда.
    // При этом должен быть создан новый отряд, содержащий новый массив новых бойцов, идентичных исходным.
    public Squad clone() throws CloneNotSupportedException {
        ArrayList<Warrior> clone = new ArrayList<>(this.massive.size());
        for (Warrior w :this.massive) {
            clone.add((Warrior) w.clone());
        }
        return new Squad(clone, this.squadName);

    }
}

