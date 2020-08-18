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
        System.out.print("\n" + name + containerType + ". \n" +
                "Вкусы: ");
        for (int i = 0; i < flavor.length; i++) {
            if (flavor[i] != null) {
                if (i == 0) {
                    System.out.print(flavor[i]);
                } else System.out.print(", " + flavor[i]);
            }
        }
        System.out.print(".");
        System.out.print("\n" + "Топпинги: ");
        for (int i = 0; i < toppings.length; i++) {
            if (toppings[i] != null) {
                if (i == 0) {
                    System.out.print(toppings[i]);
                } else System.out.print(", " + toppings[i]);
            }
        }
        System.out.print(".");
        System.out.println("\n" + "Итоговая стоимость: " + this.cost + " руб.");
        return null;
    }
}
