import FLMUnits.FLManager;
import FLMUnits.LeagueManager;
import FLMUnits.Player;
import FLMUnits.SockerPlayer;
import IO.ScanData;
import Library.Country;
import Library.League;

import java.util.Scanner;

public class Console {
    private final int MENU_ITEM_1 = 1;
    private final int MENU_ITEM_2 = 2;
    private final int MENU_ITEM_3 = 3;
    private final int MENU_ITEM_4 = 4;
    private final int MENU_ITEM_5 = 5;
    private final int MENU_ITEM_6 = 6;
    private final int MENU_ITEM_7 = 7;
    private final int MENU_ITEM_8 = 8;
    private ScanData scanData = new ScanData();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        LeagueManager leagueManager = new FLManager();
        Console console = new Console();
        System.out.println("Добро пожаловать в Менеджер футбольной лиги.\n");
        while (true) {
            System.out.println("Выберите нужный пункт меню:");
            System.out.println("1.Добавить в менеджер нового игрока" +
                    "\n2.Удалить игрока из менеджера" +
                    "\n3.Показать информацию об игроке" +
                    "\n4.Вывести рейтинг всех игроков в Менеджере" +
                    "\n5.Вывести рейтинг игроков лиги" +
                    "\n6.Вывести рейтинг игроков определенной страны" +
                    "\n7.Поднять рейтинг игрока" +
                    "\n8.Выход" +
                    "\n\nВаш выбор:");
            int menuSelect = console.scanData.inputInt(console.scanner);
            if (menuSelect == console.MENU_ITEM_1) {
                leagueManager.addPlayer(console.newPlayer());
                continue;
            } else if (menuSelect == console.MENU_ITEM_2) {
                leagueManager.removePlayer(console.namedPlayer());
                System.out.println(2);
            } else if (menuSelect == console.MENU_ITEM_3) {
                System.out.println(3);
            } else if (menuSelect == console.MENU_ITEM_4) {
                System.out.println(3);
            } else if (menuSelect == console.MENU_ITEM_5) {
                System.out.println(3);
            } else if (menuSelect == console.MENU_ITEM_6) {
                System.out.println(3);
            } else if (menuSelect == console.MENU_ITEM_7) {
                System.out.println(3);
            } else {
                System.out.println("Неправильный пункт меню!");
            }
            //сгенерировать случайного игрока player и добавить в базу
            //удалить игрока player из базы
            //вызвать инфу по игроку name
            //вывести рейтинг всех игроков из базы
            //вывести рейтинг игроков лиги league
            //вывести рейтинг игроков страны country
            //поднять рейтинг игрока name на points очков
        }
    }

    private SockerPlayer newPlayer() {
        String name;
        Country selCountry;
        League selLeague;
        int selRating;
        System.out.println("Введите имя и фамилию игрока:");
        name = scanData.inputString();
        while (true) {
            System.out.println("Выберите страну игрока:");
            int i = 1;
            for (Country country : Country.values()) {
                System.out.println(i + ". " + country);
                i++;
            }
            System.out.println("Ваш выбор: ");
            int menuSelect = scanData.inputInt(scanner);
            if (menuSelect <= Country.values().length) {
                selCountry = Country.values()[menuSelect - 1];
                break;
            } else {
                System.out.println("Неправильный выбор!");
                continue;
            }

        }
        while (true) {
            System.out.println("Выберите футбольную лигу игрока:");
            int i = 1;
            for (League league : League.values()) {
                System.out.println(i + ". " + league);
                i++;
            }
            System.out.println("Ваш выбор: ");
            int menuSelect = scanData.inputInt(scanner);
            if (menuSelect <= League.values().length) {
                selLeague = League.values()[menuSelect - 1];
                break;
            } else {
                System.out.println("Неправильный выбор!");
                continue;
            }
        }
        while (true) {
            System.out.println("Введите рейтинг игрока (0...100):");
            int ratio = scanData.inputInt(scanner);
            if (ratio <= 100 && ratio >= 0) {
                selRating = ratio;
                break;
            } else {
                System.out.println("Рейтинг должен быть в пределе от 0 до 100! ");
            }
        }
        return new Player(name, selRating, selLeague, selCountry);
    }

    private SockerPlayer namedPlayer(){
        System.out.println("Введите имя и фамилию игрока:");
        return new Player(scanData.inputString(), 0, null, null);
    }
}
