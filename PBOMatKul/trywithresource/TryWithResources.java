package trywithresource;

import java.io.FileOutputStream;
public class TryWithResources {
    public static void main(String args[]) {
        // Using try-with-resources  
        try ( FileOutputStream fileOutputStream = new FileOutputStream("C:/Users/Grego/Documents/FILKOM.txt")) {
            String msg = "Selamat Datang di Filkom!";
            byte byteArray[] = msg.getBytes(); //converting string into byte array      
            fileOutputStream.write(byteArray);
            System.out.println("Pesan sudah ditulis dengan sukses!");
        } catch (Exception exception) {
            System.out.println(exception);
            
        }
    }
}
