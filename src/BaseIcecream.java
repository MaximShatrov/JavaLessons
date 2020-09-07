public class BaseIcecream {
    private String name;
    private String containerType;
    private String[] flavor;
    private int cost;
    private String[] toppings;

    public BaseIcecream() {

    }

    public BaseIcecream(String type, String[] flavor, int cost) {
        this.containerType = type;
        this.flavor = flavor;
        this.cost = cost;
        setName("Мороженное ");
    }

    public BaseIcecream(String type, String[] flavor, int cost, String name) {
        this.containerType = type;
        this.flavor = flavor;
        this.cost = cost;
        setName(name);
    }

    public void addToppings(String[] toppings, int cost) {
        this.toppings = toppings;
        this.cost = this.cost + cost;
    }

    public String getContainerType() {
        return containerType;
    }

    public String[] getFlavor() {
        return flavor;
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String string = (this.name + containerType + ". \n" +
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
