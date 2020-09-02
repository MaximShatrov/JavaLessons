/*
Битва происходит по следующему алгоритму: вывести дату и время начала сражения, взять
случайного бойца первой и второй команды, первый боец атакует второго,
перематывается время, проверяется победа первой команды, снова берутся
случайные бойцы, второй атакует первого, проверяется победа второй
команды и так далее до победы. В конце вывести имя победившего отряда и общее время поединка.
*/

import java.util.Scanner;

public class Battle {
    private Squad alpha;
    private Squad omega;
    private Scanner input = new Scanner();
    public static void main(String[] args) {
        //System.out.println("Симулятор битвы v1.0. \nВведите численность отряда Альфа:");
        int alphaQntty = 10;
        //System.out.println("\nВведите численность отряда Омега:");
        int omegaQntty = 10;
        Squad alpha = new Squad(alphaQntty, "Альфа");
        Squad omega = new Squad(omegaQntty, "Омега");
        DateHelper timeLine = new DateHelper();

        System.out.println("Битва началась " + timeLine.getFormattedStartDate()+" года.");
        while (alpha.hasAliveWarriors(alpha) && omega.hasAliveWarriors(omega)) {       // T && T = T
            omega.getRandomWarrior(omega).takeDamage(alpha.getRandomWarrior(alpha).attack());
            if (!omega.hasAliveWarriors(omega)) {
                System.out.println("Победил отряд " + alpha.toString() + "!!!\nПродолжительность битвы составила: "
                        + timeLine.getFormattedDiff() + " минут.");
            }
            System.out.println("Для следующей атаки нажмите ENTER.");

            timeLine.skipTime();
            alpha.getRandomWarrior(alpha).takeDamage(alpha.getRandomWarrior(omega).attack());
            if (!alpha.hasAliveWarriors(alpha)) {
                System.out.println("Победил отряд " + omega.toString() + "!!!\nПродолжительность битвы составила: "
                        + timeLine.getFormattedDiff() + " минут.");
            }
            timeLine.skipTime();

        }
    }

    /*private Squad squadAttack(Squad squad1, Squad squad2){
        squad2.getRandomWarrior(squad2).takeDamage(squad1.getRandomWarrior(squad1).attack());
        if (!squad2.hasAliveWarriors(squad2)){
            System.out.println("Победил отряд " + squad1.toString() + "!!!");
        }
        return
    }*/
}
