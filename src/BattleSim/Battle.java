package BattleSim;/*
Битва происходит по следующему алгоритму: вывести дату и время начала сражения, взять
случайного бойца первой и второй команды, первый боец атакует второго,
перематывается время, проверяется победа первой команды, снова берутся
случайные бойцы, второй атакует первого, проверяется победа второй
команды и так далее до победы. В конце вывести имя победившего отряда и общее время поединка.
*/

import BattleSim.Units.Warrior;

public class Battle {

    private Squad squad1;
    private Squad squad2;
    private DateHelper timeline;
    private StringBuffer log;
    private String winSquad;

    public Battle(Squad squad1, Squad squad2) {
        this.squad1 = squad1;
        this.squad2 = squad2;
        log = new StringBuffer();
        timeline = new DateHelper();
    }

    public String getWinSquad() {
        return winSquad;
    }

    private void setWinSquad(String winSquad) {
        this.winSquad = winSquad;
    }

    public StringBuffer getLog() {
        return log;
    }

    private DateHelper gettimeLine() {
        return timeline;
    }

    public static void main(String[] args) {
        int alphaQntty = 5;
        int omegaQntty = 5;
        Squad alpha = new Squad(alphaQntty, "Альфа");
        Squad omega = new Squad(omegaQntty, "Омега");
        Battle consoleBattle = new Battle(alpha, omega);
        consoleBattle.startBattle();
    }

    public void startBattle() {
        log.append("Битва началась в " + gettimeLine().getFormattedStartDate() + " года.\n");
        while (squad1.hasAliveWarriors() && squad2.hasAliveWarriors()) {       // T && T = T

            if (attack(squad1, squad2, gettimeLine())) {
                break;
            }
            log.append("\n\n" + gettimeLine().getFormattedCurrentTime() + "\n");
            gettimeLine().skipTime();
            if (attack(squad2, squad1, gettimeLine())) {
                break;
            }
            log.append("\n\n" + gettimeLine().getFormattedCurrentTime() + "\n");
            gettimeLine().skipTime();

        }
        System.out.println(log);
    }


    private boolean attack(Squad alpha, Squad omega, DateHelper timeLine) {
        Warrior attackWarrior1;
        Warrior attackWarrior2;
        attackWarrior1 = alpha.getRandomWarrior();
        attackWarrior2 = omega.getRandomWarrior();
        attackWarrior2.takeDamage(attackWarrior1.attack());
        log.append(attackWarrior1.toString() + " проводит атаку, нанося " + attackWarrior1.attack() + " очков урона.\n"
                + attackWarrior2.toString());
        if (attackWarrior2.getHealth() > 0) {
            log.append(" защишается. Его здоровье составляет " + attackWarrior2.getHealth() + "HP.");
        } else {
            log.append(" получает смертельный урон.");
        }
        alpha.returnRandomWarrior(attackWarrior1);
        omega.returnRandomWarrior(attackWarrior2);
        if (!omega.hasAliveWarriors()) {
            log.append("\n\nПобедил отряд " + alpha.toString() + "!!!\nПродолжительность битвы составила: "
                    + timeLine.getFormattedDiff() + " минут.");
            setWinSquad(alpha.toString());
            return true;
        }
        return false;
    }

    /*public static void main(String[] args) {
        //System.out.println("Симулятор битвы v1.0. \nВведите численность отряда Альфа:");
        int alphaQntty = 3;
        //System.out.println("\nВведите численность отряда Омега:");
        int omegaQntty = 3;
        Squad alpha = new Squad(alphaQntty, "Альфа");
        Squad omega = new Squad(omegaQntty, "Омега");
        DateHelper timeLine = new DateHelper();

        System.out.println("Битва началась в " + timeLine.getFormattedStartDate() + " года.");
        while (alpha.hasAliveWarriors() && omega.hasAliveWarriors()) {       // T && T = T
            Battle battle = new Battle();
            if (battle.attack(alpha, omega, timeLine)) {
                break;
            }
            System.out.println("\n\n" + timeLine.getFormattedCurrentTime());
            timeLine.skipTime();
            if (battle.attack(omega, alpha, timeLine)) {
                break;
            }
            System.out.println("\n\n" + timeLine.getFormattedCurrentTime());
            timeLine.skipTime();

        }
    }

    private boolean attack(Squad alpha, Squad omega, DateHelper timeLine) {
        Warrior attackWarrior1;
        Warrior attackWarrior2;
        attackWarrior1 = alpha.getRandomWarrior();
        attackWarrior2 = omega.getRandomWarrior();
        attackWarrior2.takeDamage(attackWarrior1.attack());
        System.out.print(attackWarrior1.toString() + " проводит атаку, нанося " + attackWarrior1.attack() + " очков урона.\n"
                + attackWarrior2.toString());
        if (attackWarrior2.getHealth() > 0) {
            System.out.print(" защишается. Его здоровье составляет " + attackWarrior2.getHealth() + "HP.");
        } else {
            System.out.print(" получает смертельный урон.");
        }
        alpha.returnRandomWarrior(attackWarrior1);
        omega.returnRandomWarrior(attackWarrior2);
        if (!omega.hasAliveWarriors()) {
            System.out.println("\n\nПобедил отряд " + alpha.toString() + "!!!\nПродолжительность битвы составила: "
                    + timeLine.getFormattedDiff() + " минут.");
            return true;
        }
        return false;
    }*/
}
