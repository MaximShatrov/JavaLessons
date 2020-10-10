enum Country {
    RU("Россия"),
    UK("Великобритания"),
    DE("Германия"),
    JP("Япония"),
    IT("Италия"),
    BR("Бразилия"),
    EG("Египет"),
    US("США"),
    PT("Португалия"),
    SK("Словакия"),
    FR("Франция");

    private final String name;

    Country(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
