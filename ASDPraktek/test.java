import java.util.*;

class Mobil{
    int nomorMesin;

public Mobil(int nomesin){
    this.nomorMesin = nomesin;
}}
public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Mobil [] arrayMobil = new Mobil[3];

       // Mobil mobil1 = new Mobil();
       // mobil1.nomorMesin = 10;
        for (int i = 0; i < arrayMobil.length; i++){
            arrayMobil[i] = new Mobil(sc.nextInt());
            System.out.println(arrayMobil[i].nomorMesin);
        }
        sc.close();
    }
    
}
