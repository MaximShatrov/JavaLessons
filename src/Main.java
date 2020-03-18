import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        System.out.println("Выберите нужное задание:");
        System.out.println("1. Изи");
        System.out.println("2. Медиум");
        System.out.println("3. Хард");
        System.out.println("Ваш выбор:");
        BufferedReader choose = new BufferedReader(new InputStreamReader(System.in));
        String inch = null;
        try {
            inch = choose.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int ch = Integer.parseInt(inch);
        System.out.println(inch);
        if (ch == 1){
            Easy.main();
        } else if (ch == 2){
            Medium.main();
        }
        if (ch == 3) {
            System.out.println("Hard в разработке :)");
        }

    }
}

