package File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class FileOutput {
    public static void main(String[] args) {
        String namaFIle, data;
        byte[] bufferData = new byte[1024];
        Scanner input = new Scanner(System.in);

        System.out.print("Masukan nama file yang akan dibuat: ");
        namaFIle = input.nextLine();
        System.out.print("\nMasukan data Teks: ");
        try{
            System.in.read(bufferData);
        }catch(IOException e){
            System.err.println("Data Tak Terbaca");
        }
        try{
            FileOutputStream fileOutput = new FileOutputStream(namaFIle);
            fileOutput.write(bufferData, 0, bufferData.length);
            fileOutput.close();
        }
        catch(IOException e){
            System.err.println("Maaf file gagal dibuat & ditulis skill issue lmao xd");
            System.exit(1);
        }
        System.out.print("\nFile berahasil dibuat lets gooo\n");
    }
}
