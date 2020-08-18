public class ExtraIcecream extends BaseIcecream {
    String[] drink;

    public ExtraIcecream(String type, String[] flavor, String[] drink, int cost) {
        super(type, flavor, cost);
        this.drink = drink;
        this.name = "Мороженое-экстра ";
    }

    @Override
    public void addToppings(String[] toppings, int cost) {
        System.err.println("В мороженое-экстра нельзя добавить топпинг!");
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
        System.out.println("\n" + "Напиток: " + drink[0] + ".");
        System.out.println("\n" + "Итоговая стоимость: " + this.cost + " руб.");
        return null;
    }
}

