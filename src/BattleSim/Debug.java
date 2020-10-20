package BattleSim;

import BattleSim.Units.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Debug {
    static Random random = new Random();
    private int first = 100;
    static ArrayList<Warrior> arrayList;
    private static String squadName = "NullName";

    public static void main(String[] args) throws CloneNotSupportedException {
        Archer archer = new Archer("Alpha");
        Archer archer1 = archer.clone();
        System.out.print("Исходник Archer: ");
        System.out.println(archer);
        System.out.print("Клон Archer: ");
        System.out.println(archer1);
        System.err.println("Изменяем Исходник Archer");
        archer.setSquadName("123");
        archer.takeDamage(50);
        System.out.print("Исходник Archer: ");
        System.out.println(archer + " hp " + archer.getHealth());
        System.out.print("Клон Archer: ");
        System.out.println(archer1+ " hp " + archer1.getHealth());
        System.out.println();
        Warrior warrior = new Archer("Alpha");
        Warrior warrior1 = (Warrior) warrior.clone();
        System.out.print("Исходник Warrior: ");
        System.out.println(warrior);
        System.out.print("Клон Warrior: ");
        System.out.println(warrior1);
        System.err.println("Изменяем Исходник Warrior");
        warrior.setSquadName("123");
        warrior.takeDamage(50);
        System.out.print("Исходник Warrior: ");
        System.out.println(warrior + " hp " + warrior.getHealth());
        System.out.print("Клон Warrior: ");
        System.out.println(warrior1 + " hp " + warrior1.getHealth());


        System.out.println();
        System.out.println();
        System.err.println("Создаем ArrayList<Archer> из archer и archer1");
        ArrayList<Archer> archerArrayList = new ArrayList<>();
        archerArrayList.add(archer);
        archerArrayList.add(archer1);
        System.err.println("Клонируем ArrayList<Archer> через (ArrayList<Archer>) archerArrayList.clone()");
        ArrayList<Archer> newAL = (ArrayList<Archer>) archerArrayList.clone();
        ArrayList<Archer> newAL_foreach = new ArrayList<>(newAL.size());
        for (Archer a:newAL) {
            newAL_foreach.add(a.clone());
        }
        System.err.println("Изменяем Исходник archer.");
        archer.setSquadName("321");
        archer.takeDamage(10);
        System.out.println("Выводим данные из массива клона");
        System.out.println(newAL.get(0) + " hp " + newAL.get(0).getHealth());
        System.out.println(newAL.get(1) + " hp " + newAL.get(1).getHealth());


        /*System.out.println();
        System.out.println();
        ArrayList<Warrior> archerArrayList = new ArrayList<>();
        archerArrayList.add(warrior);
        archerArrayList.add(warrior1);
        ArrayList<Warrior> newAL = (ArrayList<Warrior>) archerArrayList.clone();
        warrior.setSquadName("321");
        warrior.takeDamage(10);
        System.err.println(newAL.get(0) + " hp " + newAL.get(0).getHealth());
        System.err.println(newAL.get(1) + " hp " + newAL.get(1).getHealth());*/



    }
}

