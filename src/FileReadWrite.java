import java.io.*;

public class FileReadWrite {

    public static void writeDataToFile(String filename, String data) throws FileOperationException {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(data);
        } catch (IOException e) {
            throw new FileOperationException("Ошибка записи в файл: " + e.getMessage(), e);
        }
    }

    public static String readDataFromFile(String filename) throws FileOperationException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (FileNotFoundException e) {
            throw new FileOperationException("Файл не найден: " + e.getMessage(), e);
        } catch (IOException e) {
            throw new FileOperationException("Ошибка чтения из файла: " + e.getMessage(), e);
        }
        return content.toString();
    }

}
