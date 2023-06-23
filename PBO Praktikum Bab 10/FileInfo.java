import java.io.File;

public class FileInfo {
    public static void main(String[] args) {
        String fileName = "test.txt";
        File file = new File(fileName);
        System.out.println("Nama File: " + fileName);
        double fileSize = 0;
        if (file.length() > 1024 * 1024) {
            fileSize = file.length() / (1024.0 * 1024.0);
            System.out.printf("Ukuran file: %.2f MB\n", fileSize);
           
        } else {
            fileSize = file.length() / 1024.0;
            System.out.printf("Ukuran file: %.2f KB\n", fileSize);
           
        }
    }
}
