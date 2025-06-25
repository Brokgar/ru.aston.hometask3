public class FileReadWriteExample {

    public static void main(String[] args) {

        String filename = "my_data.txt";
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
