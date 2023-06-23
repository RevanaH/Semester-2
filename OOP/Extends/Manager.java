package Extends;

public class Manager extends Pegawai{
    public String departemen;

    public Manager(){
        System.out.println("Konstruktor Manager");
    }
    void isiGaji(double gaji){
        super.gaji = gaji;
    }

    public Manager(String departemen){
        this.departemen = departemen;
    }
    public Manager(String departemen, String nama, double gaji){
        super(nama, gaji);
        this.departemen = departemen;

    }
    public void cetakData(){
        super.cetakData();
        System.out.println("Departemen: "+ departemen);

    }
}

    

