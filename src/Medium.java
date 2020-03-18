import java.io.IOException;
import java.io.*;


public class Medium {
    public static void main() {
        /*Scanner scanner = new Scanner(System.in);
        float x = scanner.nextFloat();
        float x = scanner.nextFloat();
        */
        System.out.println("\n" + "Medium task :)");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); //создаем новый объект класса
                                                                                    // BufferedReader c именем input
        System.out.println("Введите число a");
        String sA = null;                       //читаем строку с клавиатуры
        try {                                   // Не знаю что это (а лучше бы знать), но IDEA сам предложил
                                                // вместо String sA = input.readLine();  иначе ошибка :(
            sA = input.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //добавить проверку на ввод чисел ??

        System.out.println("Введите число b");
        String sB = null; //читаем строку с клавиатуры
        try {
            sB = input.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //добавить проверку на ввод чисел ??

        float floatA = Float.parseFloat(sA);
        float floatB = Float.parseFloat(sB);

        System.out.println("Сумма: " + (floatA + floatB));
        System.out.println("Разность: " + (floatA - floatB));
        System.out.println("Множество: " + floatA * floatB);
        System.out.println("Частное: " + floatA / floatB);
    }

}
