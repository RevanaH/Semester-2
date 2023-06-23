package File;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class FileReinder {
    
    public static void main(String[] args) {
        String namaFile;
        int jumlahByte = 0;
        byte[] bufferData = new byte[1024];
        Scanner in = new Scanner(System.in);
        System.out.print("Masukan nama File yang akan dibaca: ");
        namaFile = in.next();
        FileReader fileInput = null;
        try{
            fileInput = new FileReader(namaFile);
        }
        catch(IOException e){
            System.err.println("Maaf, file tidak daoat dibuka skill issue ngl");
            System.exit(1);
        }
        BufferedReader streamInput = new BufferedReader(fileInput);
        try{
            while(true){
                String barisanData = streamInput.readLine();
                if(barisanData==null) break;
                System.out.println(barisanData);
            }
        }
        catch (IOException e){
            System.err.println("Maaf, gagal membaca data lmao L ratio");
            System.exit(1);

        }
        try{
            fileInput.close();
        }
        catch(IOException e){
            System.err.println("Maaf, Ada kesalah swaktu menutup file bruh");
            System.exit(1);
        }
    }
}
