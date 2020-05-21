package maxim;

class Family {
    private int humans;
    private int budget;
    private int bills;
    private int salary;
    private boolean onWork;
//Конструкторы

    Family(int humans, int budget, int bills) {
        this.humans = humans;
        this.budget = budget;
        this.bills = bills;
    }

    Family() {
        this.humans = RandomizeValues.getRandInt(0, 3);
        this.budget = (RandomizeValues.getRandInt(5, 15)) * 1000;
        this.salary = (RandomizeValues.getRandInt(10, 30)) * 1000;
        this.bills = (RandomizeValues.getRandInt(1, 6)) * 1000;
    }

    @Override
    public String toString() {
        return "Family{" +
                "humans=" + humans +
                ", budget=" + budget +
                ", bills=" + bills +
                ", onWork=" + onWork +
                '}';
    }

    public void setHumans(int humans) {
        this.humans = humans;
    }

    int getHumans() {
        return humans;
    }

    void killHuman() {
        this.humans = this.humans - 1;
    }

    void birthHuman() {
        this.humans = this.humans + 1;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    void salaryDay() {
        this.budget = this.budget + salary;
    }

    void decreaseBudget(int budget) {
        this.budget = this.budget - budget;
    }

    void payday() {
        this.budget = this.budget - bills;
    }

    int getBudget() {
        return budget;
    }

    public void setBills(int bills) {
        this.bills = bills;
    }

    int getBills() {
        return bills;
    }

    boolean getOnWork() {
        return onWork;
    }

    void setOnWork(boolean set) {
        this.onWork = set;
    }
}
