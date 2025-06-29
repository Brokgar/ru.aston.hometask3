import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadWrite {

    public static void writeDataToFile(String filename, String data) throws FileOperationException {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(data);
        } catch (IOException e) {
            throw new FileOperationException("Ошибка записи в файл: " + e.getMessage());
        }
    }

    public static String readDataFromFile(String filename) throws FileOperationException {
        if (filename == null || filename.isEmpty()) {
            throw new FileOperationException("Имя файла не может быть null или пустым");
        }

        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (FileNotFoundException e) {
            throw new FileOperationException("Файл не найден: " + e.getMessage());
        } catch (IOException e) {
            throw new FileOperationException("Ошибка чтения из файла: " + e.getMessage());
        }
        return content.toString();
    }

}
