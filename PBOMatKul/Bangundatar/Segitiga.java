package Bangundatar;

public class Segitiga extends BangunDatar {
    double sisi;
    double tinggi;

    public Segitiga(double sisi, double tinggi){
        this.sisi = sisi;
        this.tinggi = tinggi;
    }
    
    public double luas(){
        return this.sisi*this.tinggi/2;
    }
    public double keliling(){
    return sisi*3;
}
}
 
    

