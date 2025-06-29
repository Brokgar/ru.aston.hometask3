import java.util.Scanner;

public class FileReadWriteExample {

    public static void main(String[] args) {

        if (args.length > 0) {
            System.out.println("Файл для записи: " + args[0]);
        } else {
            System.out.println("Введите имя файла для записи:");
        }

        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine() + ".txt";

        String dataToWrite = "Это тестовые данные для записи в файл.";

        try {
            FileReadWrite.writeDataToFile(filename, dataToWrite);
            System.out.println("Данные успешно записаны в файл.");

            String dataRead = FileReadWrite.readDataFromFile(filename);
            System.out.println("Данные, прочитанные из файла:\n" + dataRead);

            dataRead = FileReadWrite.readDataFromFile("nonexistent_file.txt");
            System.out.println("Данные, прочитанные из файла:\n" + dataRead);

        } catch (FileOperationException e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
        }
    }

}
