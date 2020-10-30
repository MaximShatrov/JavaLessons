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
    private final int MIN_RATIO = 0;
    private final int MAX_RATIO = 100;
    private PrintData printData = new PrintData();
    private ScanData scanData = new ScanData();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        final int MENU_ADD_PLAYER = 1;
        final int MENU_DELETE_PLAYER = 2;
        final int MENU_PLAYER_INFO = 3;
        final int MENU_FULL_RAITING = 4;
        final int MENU_LEAGUE_RAITING = 5;
        final int MENU_COUNTRY_RAITING = 6;
        final int MENU_PLAYER_ADD_RPOINTS = 7;
        final int MENU_EXIT = 8;
        LeagueManager leagueManager = new FLManager();
        Console console = new Console();
        SockerPlayer[] sockerPlayer;
        System.out.println("Добро пожаловать в Менеджер футбольной лиги.\n");
        boolean menuRepeat = true;
        while (menuRepeat) {
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
            switch (menuSelect) {
                case MENU_ADD_PLAYER:
                    leagueManager.addPlayer(new Player(console.selectName(), console.getRatio("new"),
                            console.selectParam(League.class), console.selectParam(Country.class)));
                    console.pressEnter();
                    break;
                case MENU_DELETE_PLAYER:
                    leagueManager.removePlayer(new Player(console.selectName(), 0, null, null));
                    console.pressEnter();
                    break;
                case MENU_PLAYER_INFO:
                    SockerPlayer player = leagueManager.getPlayer(console.selectName());
                    if (player != null) {
                        System.out.println(player);
                    } else System.out.println("Данного игрока нет ни в одной лиге!");
                    console.pressEnter();
                    break;
                case MENU_FULL_RAITING:
                    sockerPlayer = leagueManager.getAllPlayers();
                    console.printData.printArrayToTable(sockerPlayer, "\n\nМировой рейтинг игроков");
                    console.pressEnter();
                    break;
                case MENU_LEAGUE_RAITING:
                    sockerPlayer = leagueManager.getPlayers(console.selectParam(League.class));
                    console.printData.printArrayToTable(sockerPlayer, "\n\nРейтинг игроков лиги");
                    console.pressEnter();
                    break;
                case MENU_COUNTRY_RAITING:
                    sockerPlayer = leagueManager.getPlayers(console.selectParam(Country.class));
                    console.printData.printArrayToTable(sockerPlayer, "\n\nРейтинг игроков страны");
                    console.pressEnter();
                    break;
                case MENU_PLAYER_ADD_RPOINTS:
                    leagueManager.addPoints(console.selectName(), console.getRatio("update"));
                    console.pressEnter();
                    break;
                case MENU_EXIT:
                    System.out.println("Завершение работы.");
                    menuRepeat = false;
                    break;
                default:
                    System.out.println("Неправильный пункт меню!");
            }
        }
    }

    private String selectName() {
        System.out.println("Введите имя и фамилию игрока:");
        return scanData.inputLine();
    }

    private int getRatio(String string) {
        while (true) {
            if(string.equals("new")){
                System.out.println("Введите рейтинг игрока (0...100):");
            } else if (string.equals("update")){
                System.out.println("Задайте новый рейтинг игрока (0...100):");
            }
            int ratio = scanData.inputInt(scanner);
            if (ratio <= MAX_RATIO && ratio >= MIN_RATIO) {
                return ratio;
            } else {
                System.out.println("Рейтинг должен быть в пределе от 0 до 100! ");
            }
        }
    }

    private <T> T selectParam(Class<T> targetClass) {
        if (targetClass.equals(Country.class)) {
            while (true) {
                System.out.println("Выберите страну игрока:");
                int counter = 1;
                for (Country country : Country.values()) {
                    System.out.println(counter + ". " + country);
                    counter++;
                }
                System.out.println("Ваш выбор: ");
                int menuSelect = scanData.inputInt(scanner);
                if (menuSelect <= Country.values().length) {
                    return (T) Country.values()[menuSelect - 1];
                } else {
                    System.out.println("Неправильный выбор!");
                }
            }
        } else {
            while (true) {
                System.out.println("Выберите футбольную лигу игрока:");
                int counter = 1;
                for (League league : League.values()) {
                    System.out.println(counter + ". " + league);
                    counter++;
                }
                System.out.println("Ваш выбор: ");
                int menuSelect = scanData.inputInt(scanner);
                if (menuSelect <= League.values().length) {
                    return (T) League.values()[menuSelect - 1];
                } else {
                    System.out.println("Неправильный выбор!");
                }
            }
        }
    }

    private void pressEnter() {
        System.out.println("\nНажмите ENTER для продолжения.");
        scanData.pressAnyKey(scanner);
    }
}
