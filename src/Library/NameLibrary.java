package Library;

import java.util.Random;

public class NameLibrary {
    private StringBuffer cacheString = new StringBuffer();
    Random random = new Random();
    private final String[] firstName = {"Дэйв", "Джон", "Стэн", "Чез", "Максимус", "Стэфан", "Люций", "Аарон", "Филл", "Стьюи", "Марк",
            "Ричард", "Зейн", "Карл", "Джек", "Джерард", "Лео", "Бред", "Сэм", "Дин", "Дэймон", "Себастиян", "Килиан", "Боб", "Коул",
            "Люк", "Дракс", "СтарЛорд", "Зак", "Роберт", "Тор", "Роб", "Карим", "Цыган", "Рик", "Морти", "Дон", "Уильям", "Майк",
            "Клайв", "Кларк", "Алекс", "Макйл", "Мэнни", "Джо", "Чендлер", "Росс", "Дик", "Хью", "Пит", "Зойдберг", "Фрай", "Гомер", "Патрик"};;

    private final String[] lastName = {"Брофловски","Шинода","Шевченко","Комов","Комлев","Бутузов","Кукашенко","Кшиштовский","Боурдон",
            "Спенсер", "Калинкин","Фурсов","Петухов","Котёночкин","Папанов","Шувалов","Звезда","Зидан","Кавалеско","Дауни","Попов","Коуч",
            "Перестукин","Шумилов","Беннингтон","Кук","Джобс","Айв","Плеханов","Чоповалов","Вайтити","Руссо","Тарантино"};

    public String getRandomNickname(){
        cacheString.delete(0,cacheString.length());
        int i = random.nextInt(firstName.length);
        cacheString.append(firstName[i] + " ");
        i = random.nextInt(lastName.length);
        cacheString.append(lastName[i]);
        return cacheString.toString();
    }

}
