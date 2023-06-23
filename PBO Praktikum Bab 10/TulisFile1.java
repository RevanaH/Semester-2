import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TulisFile1 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Masukkan teks yang akan disimpan: ");
        String text = keyboard.nextLine();
        
        try (FileWriter writer = new FileWriter("test.txt", true)) {
            writer.write(text);
            System.out.println("Teks berhasil ditulis ke file.");
        } catch (IOException e) {
            System.err.println("Gagal menulis ke file: " + e.getMessage());
        }
        
        keyboard.close();
    }
}
