public class SurpriseIcecream extends BaseIcecream {
    String name = "Мороженое-сюрприз ";

    public SurpriseIcecream(String type, String[] flavor, int cost) {
        super(type, flavor, cost);  //при вызове toString используется name родительского класса. Почему?
        // super(type, flavor, cost, "Мороженое-сюрприз ");
        //name = "Мороженое-сюрприз";
    }
}
