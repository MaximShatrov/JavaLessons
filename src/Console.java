import FLMUnits.FLManager;
import FLMUnits.LeagueManager;
import FLMUnits.Player;
import FLMUnits.SockerPlayer;
import IO.PrintData;
import IO.ScanData;
import Library.Country;
import Library.League;

import java.util.Scanner;

public class Console {
    private final int MENU_ADD_PLAYER = 1;
    private final int MENU_DELETE_PLAYER = 2;
    private final int MENU_PLAYER_INFO = 3;
    private final int MENU_FULL_RAITING = 4;
    private final int MENU_LEAGUE_RAITING = 5;
    private final int MENU_COUNTRY_RAITING = 6;
    private final int MENU_PLAYER_ADD_RPOINTS = 7;
    private final int MENU_EXIT = 8;
    private PrintData printData = new PrintData();
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
            if (menuSelect == console.MENU_ADD_PLAYER) {
                leagueManager.addPlayer(new Player(console.selectName(), console.selectRating(), console.selectLeague(), console.selectCountry()));
                console.pressEnter();
            } else if (menuSelect == console.MENU_DELETE_PLAYER) {
                leagueManager.removePlayer(new Player(console.selectName(), 0, null, null));
                console.pressEnter();
            } else if (menuSelect == console.MENU_PLAYER_INFO) {
                SockerPlayer player = leagueManager.getPlayer(console.selectName());
                if (player != null) {
                    System.out.println(player);
                } else System.out.println("Данного игрока нет ни в одной лиге!");
                console.pressEnter();
            } else if (menuSelect == console.MENU_FULL_RAITING) {
                SockerPlayer[] sockerPlayer = leagueManager.getAllPlayers();
                console.printData.printArrayToTable(sockerPlayer, "\n\nМировой рейтинг игроков");
                console.pressEnter();
            } else if (menuSelect == console.MENU_LEAGUE_RAITING) {
                SockerPlayer[] sockerPlayer = leagueManager.getPlayers(console.selectLeague());
                console.printData.printArrayToTable(sockerPlayer, "\n\nРейтинг игроков лиги");
                console.pressEnter();
            } else if (menuSelect == console.MENU_COUNTRY_RAITING) {
                SockerPlayer[] sockerPlayer = leagueManager.getPlayers(console.selectCountry());
                console.printData.printArrayToTable(sockerPlayer, "\n\nРейтинг игроков страны");
                console.pressEnter();
            } else if (menuSelect == console.MENU_PLAYER_ADD_RPOINTS) {
                leagueManager.addPoints(console.selectName(), console.addPoints());
                console.pressEnter();
            } else if (menuSelect == console.MENU_EXIT) {
                System.out.println("Завершение работы.");
                break;
            } else
                System.out.println("Неправильный пункт меню!");
        }
    }


    private String selectName() {
        System.out.println("Введите имя и фамилию игрока:");
        return scanData.inputLine();
    }

    private int selectRating() {
        while (true) {
            System.out.println("Введите рейтинг игрока (0...100):");
            int ratio = scanData.inputInt(scanner);
            if (ratio <= 100 && ratio >= 0) {
                return ratio;
            } else {
                System.out.println("Рейтинг должен быть в пределе от 0 до 100! ");
            }
        }
    }

    private int addPoints() {
        while (true) {
            System.out.println("На сколько поднять рейтин игрока? (0...100):");
            int ratio = scanData.inputInt(scanner);
            if (ratio <= 100 && ratio >= 0) {
                return ratio;
            } else {
                System.out.println("Рейтинг должен быть в пределе от 0 до 100! ");
            }
        }
    }

    private League selectLeague() {
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
                return League.values()[menuSelect - 1];
            } else {
                System.out.println("Неправильный выбор!");
            }
        }
    }

    private Country selectCountry() {
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
                return Country.values()[menuSelect - 1];
            } else {
                System.out.println("Неправильный выбор!");
            }
        }
    }

    private void pressEnter() {
        System.out.println("\nНажмите ENTER для продолжения.");
        scanData.pressAnyKey(scanner);
    }
}
