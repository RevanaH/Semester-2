import java.util.*;
public class MatKulK {
    public static void main (String[] args){
     KRS krs = new KRS();
     krs.tambahMataKuliah();
     krs.print();
    }
}
class KRS{
    Scanner s = new Scanner(System.in);
        String mus = s.nextLine();
        int jumlahMataKuliah = Integer.parseInt(mus);
        String [] mataKuliah = new String[jumlahMataKuliah];
        String [] kodeMataKuliah = new String[jumlahMataKuliah];

    void tambahMataKuliah(){
        for(int i = 0; i < jumlahMataKuliah; i++){
            kodeMataKuliah[i] = s.next();
            mataKuliah[i] = s.nextLine();
        }
    }
    void print(){
        if(jumlahMataKuliah <= 5){
        System.out.printf("\nDaftar mata Kuliah :\n");
        for(int i = 0; i < jumlahMataKuliah ; i++){
            System.out.println(i+1 + "." + kodeMataKuliah[i] + ":" + mataKuliah[i]);
        }
    }
        else if(jumlahMataKuliah > 5){
        System.out.printf("\nError : KRS telah penuh\n" + "Daftar mata Kuliah :\n");
        for(int i = 0; i < 5 ; i++){
            System.out.println(i+1+"."+ kodeMataKuliah[i] + ":" + mataKuliah[i]);
        }
    }
    }
}