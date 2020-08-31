public class BaseIcecream {
    String name;
    String containerType;
    String[] flavor;
    int cost;
    String[] toppings;


    public BaseIcecream() {

    }

    public BaseIcecream(String type, String[] flavor, int cost) {
        this.containerType = type;
        this.flavor = flavor;
        this.cost = cost;
        this.name = "Мороженное ";
    }

    public void addToppings(String[] toppings, int cost) {
        this.toppings = toppings;
        this.cost = this.cost + cost;
    }

    @Override
    public String toString() {
        String string = (name + containerType + ". \n" +
                "Вкусы: ");
        for (int i = 0; i < flavor.length; i++) {
            if (flavor[i] != null) {
                if (i == 0) {
                    string += flavor[i];
                } else string += (", " + flavor[i]);
            }
        }
        string += (".");
        string += ("\n" + "Топпинги: ");
        for (int i = 0; i < toppings.length; i++) {
            if (toppings[i] != null) {
                if (i == 0) {
                    string += (toppings[i]);
                } else string += (", " + toppings[i]);
            }
        }
        string += (".");
        string += ("\n" + "Итоговая стоимость: " + this.cost + " руб.");
        return string;
    }
}
