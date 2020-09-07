public class ExtraIcecream extends BaseIcecream {
    private String[] drink;

    public ExtraIcecream(String type, String[] flavor, String[] drink, int cost) {
        super(type, flavor, cost, "Мороженое-экстра ");
        this.drink = drink;
    }

    @Override
    public void addToppings(String[] toppings, int cost) {
        System.err.println("В мороженое-экстра нельзя добавить топпинг!");
    }

    @Override
    public String toString() {
        String string = ("\n" + getName() + getContainerType() + ". \n" +
                "Вкусы: ");
        String[] flavor = getFlavor();
        for (int i = 0; i < flavor.length; i++) {
            if (flavor[i] != null) {
                if (i == 0) {
                    string += (flavor[i]);
                } else string += (", " + flavor[i]);
            }
        }
        string += (".");
        string += ("\n" + "Напиток: " + drink[0] + ".");
        string += ("\n" + "Итоговая стоимость: " + getCost() + " руб.");
        return string;
    }
}

