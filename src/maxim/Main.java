/*
  В рамках задания вам предлагается смоделировать жизнедеятельность на улице города С.
  Для этого:
  • постройте на улице дома;
  • в каждом доме постройте квартиры (наполните подмассив каждого дома номерами квартир);
  • в каждую квартиру заселите жильцов (запишите число проживающих в подмассивы квартир);
  • можете добавить любые другие свойства жильцов, квартир или домов на ваше усмотрение (например,
  семейный бюджет, долг по квартплате каждой квартиры и т.п.);
  При этом число домов, квартир в каждом доме и число жильцов должно быть случайным, но не превышающим какоголибо конечного разумного значения (например, не нужно создавать 1000 домов, достаточно 5-10, и т.д.).
  После того как дома будут построены и заселены жителями, создайте следующие методы:
  • метод для подсчета числа дней с момента создания и заселения улицы (отвечающий за отсчет, изменение и
  вывод на экран модельного времени);
  • методы для доставки почты (посылок) и еды в квартиру (доставка производится в случайную квартиру
  случайного дома, в случайный момент времени). Учтите, что если никого нет дома, то доставка не должна быть
  произведена. Если у вас будет информация о бюджете жильцов, то можете уменьшать его на сумму доставки с
  каждой новой доставкой и проверять хватает ли средств для заказа новой доставки перед её вызовом;
  • методы для выхода жильцов из квартиры (например, на работу) и для возвращения обратно в квартиру;
  • методы для вселения и выселения жильцов;
  • методы, отвечающие за демографию (рождение жильцов, их смертность);
  • любые другие методы, которые сочтете уместными (например, списывание квартплаты каждый месяц).
  Также создайте главный метод, осуществляющий все вышеописанные действия в случайном порядке (используйте для
  этого генератор случайных чисел), но с учетом течения модельного времени (дней внутри вашей модели). Добавьте
  вывод данных в стандартный поток вывода и постарайтесь, чтобы ваша модель улицы «вела себя» как можно более
  реалистично (люди не рождались или умирали слишком часто, чтобы не было слишком много доставок в одну и ту же
  квартиру, чтобы уходили на работу по определенному графику и т.п.).
  Смоделируйте таким образом несколько дней, недель или месяцев жизни вашей улицы.
 */
package maxim;

public class Main {

    public static void main(String[] args) {
        Array.streetCreation();
        Array.streetFilling();
        System.out.println(Color.GREEN_BOLD_BRIGHT + "Добро пожаловать в Сити 17! Сами вы его выбрали или его выбрали за вас — это лучший город из оставшихся." + Color.RESET);
        System.out.println("Выберите желаемый пункт меню:");
        System.out.println("1. Смоделировать 1 день;");
        System.out.println("2. Смоделировать 1 неделю;");
        System.out.println("3. Смоделировать 1 месяц;");
        System.out.println("\n" + "Ваш выбор:");



        //Меню
        //1.Открыть "карту" Безымянной улицы;
        //2.Посмотреть данные конкретной квартиры
            //Введите адрес(дом,квартира);
        //3.Смоделировать 1 день;
        //4.Смоделировать 1 неделю;
        //5.Смоделировать 1 месяц;
        //
        //
    }
}
