package Extends;

public class Pegawai {
    public String nama;
    public double gaji;
    public Pegawai(){
        System.out.println("Kostruktor Pegawai");
    }
    public void setNama(String nama){
        this.nama = nama;
      }

    public Pegawai(String nama, double gaji){
        this.nama = nama;
        this.gaji = gaji;
    }
  
     public String getNama(){
        return  nama;
     }
     protected void cetakData(){
        System.out.println("Nama: " + nama);
        System.out.println("Gaji: "+ gaji);
     }
    
}
