import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
            String line = reader.readLine()
                    .replaceAll("(Q|R|W)(1|2|4)", ".") // Заменяем комбинации символов на точку
                    .replaceAll("[QRW124]", " "); // Заменяем символы на пробелы

            // Находим максимальную длину слова
            int maxLen = Arrays.stream(line.split("\\s+"))
                    .mapToInt(String::length)
                    .max()
                    .orElse(0); // Возвращаем 0, если строка пустая

            System.out.println(maxLen);
        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
