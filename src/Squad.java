import Units.Warrior;

public class Squad {
    public Warrior getRandomWarrior() {

        return null;
    }

    public boolean hasAliveWarriors() {

        return true;
    }

    @Override
    public String toString() {      //Переопределить метод toString() класса Object для отряда, чтобы он выводил его имя.
        return "Squad{}";
    }


    @Override                       //Переопределить метод clone(), создающий копию отряда.
                                    // При этом должен быть создан новый отряд, содержащий новый массив новых бойцов, идентичных исходным.
    public Object clone(){
        return null;
    }
}
