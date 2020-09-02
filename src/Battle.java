/*
Битва происходит по следующему алгоритму: вывести дату и время начала сражения, взять
случайного бойца первой и второй команды, первый боец атакует второго,
перематывается время, проверяется победа первой команды, снова берутся
случайные бойцы, второй атакует первого, проверяется победа второй
команды и так далее до победы. В конце вывести имя победившего отряда и общее время поединка.
*/

import Units.Warrior;

import java.util.Scanner;

public class Battle {
    private Squad alpha;
    private Squad omega;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Warrior attackWarrior1;
        Warrior attackWarrior2;
        //System.out.println("Симулятор битвы v1.0. \nВведите численность отряда Альфа:");
        int alphaQntty = 5;
        //System.out.println("\nВведите численность отряда Омега:");
        int omegaQntty = 5;
        Squad alpha = new Squad(alphaQntty, "Альфа");
        Squad omega = new Squad(omegaQntty, "Омега");
        DateHelper timeLine = new DateHelper();

        System.out.println("Битва началась в " + timeLine.getFormattedStartDate() + " года.");
        while (alpha.hasAliveWarriors(alpha) && omega.hasAliveWarriors(omega)) {       // T && T = T
            if (attack(alpha, omega, timeLine)) break;
            /*System.out.println("Для следующей атаки нажмите ENTER.");
            input.nextLine();*/

            timeLine.skipTime();
            if (attack(alpha, omega, timeLine)) break;
            System.out.println("\n\n" + timeLine.getFormattedCurrentTime());
            timeLine.skipTime();
            /*System.out.println("Для следующей атаки нажмите ENTER.");
            input.nextLine();*/


        }
    }

    private static boolean attack(Squad alpha, Squad omega, DateHelper timeLine) {
        Warrior attackWarrior1;
        Warrior attackWarrior2;
        attackWarrior1 = alpha.getRandomWarrior(alpha);
        attackWarrior2 = omega.getRandomWarrior(omega);
        attackWarrior2.takeDamage(attackWarrior1.attack());
        System.out.print("\n" + attackWarrior1.toString() + " проводит атаку, нанося " + attackWarrior1.attack() + " очков урона.\n"
                + attackWarrior2.toString());
        if (attackWarrior2.getHealth() > 0) {
            System.out.print(" защишается. Его здоровье составляет " + attackWarrior2.getHealth() + "HP.");
        } else {
            System.out.print(" получает смертельный урон.");
        }
        alpha.returnRandomWarrior(alpha, attackWarrior1);
        omega.returnRandomWarrior(omega, attackWarrior2);
        if (!omega.hasAliveWarriors(omega)) {
            System.out.println("\n\nПобедил отряд " + alpha.toString() + "!!!\nПродолжительность битвы составила: "
                    + timeLine.getFormattedDiff() + " минут.");
            return true;
        }
        return false;
    }
}
