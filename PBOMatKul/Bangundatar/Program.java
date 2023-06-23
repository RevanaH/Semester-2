package Bangundatar;

public class Program {
    public static void main(String[] args) {
        Persegi psg = new Persegi(3);
        PersegiPanjang  psgpjg = new PersegiPanjang(5,7);
        Lingkaran lgkr = new Lingkaran(7);
        Segitiga sgt = new Segitiga(5,5);
    

    psg.cetak();
    System.out.println("Rumus Persegi\n=====");
    System.out.println("Luas Persegi     : "+psg.luas());
    System.out.println("Keliling Persegi : "+psg.keliling());
     
    psgpjg.cetak();
    System.out.println("Rumus Persegi Panjang\n=====");
    System.out.println("Luas Persegi Panjang     : "+psgpjg.luas());
    System.out.println("Keliling Persegi Panjang : "+psgpjg.keliling());
    
    lgkr.cetak();
    System.out.println("Rumus Lingkaran\n=====");
    System.out.println("Luas Lingkaran     : "+lgkr.luas());
    System.out.println("Keliling Lingkaran : "+lgkr.keliling());

    sgt.cetak();
    System.out.println("Rumus Segitiga\n=====");
    System.out.println("Luas Segitiga     : "+sgt.luas());
    System.out.println("Keliling Segitiga : "+sgt.keliling());

    

    }
    
    
}
