package Extends;

public class Test {
    public static void hitungPajak(Pegawai peg){
        System.out.println(peg instanceof Manager);
        System.out.println(peg instanceof Pegawai);
        if(peg instanceof Manager){
            System.out.println("Pajak Manager"+(peg.gaji)*0.05*0.01);
        }
        else if(peg instanceof Teknisi){
            System.out.println("Pajak Teknisi"+(peg.gaji)*0.05*0.01);
        }

    }

    public static void main (String[] args){
        Pegawai pegawai = new Pegawai("Jeff", 600);
        Pegawai pgw1 = new Manager("yeah", "goobers", 2000);//polymorph hanya bisa dari yang pegawai ke manager tidak bisa sebaliknya (dari clas sinduk ke class anak)
        System.out.println("Nama = "+ pgw1.getNama());
        System.out.println("Gaji = " + pgw1.gaji);
        pgw1.cetakData();
        
        //pegawai.setNama("Jeff");
        //pegawai.gaji = 500;
        System.out.println("Nama = "+ pegawai.getNama());
        System.out.println("Gaji = " + pegawai.gaji);
        Manager manager = new Manager("LimCom", "Dante", 5000 );
        manager.setNama("Dante");
        manager.gaji = 1000000;
        manager.departemen = "Limbus Company";
        manager.cetakData();
        System.out.println("Nama = "+ manager.getNama());
        System.out.println("Gaji = " + manager.gaji);
        System.out.println("Departemen = "+ manager.departemen);

        Pegawai staff[] = new Pegawai[4];
        staff[0] = new Pegawai("bruh", 300);
        staff[1] = new Manager("Based", "Mike Khawks", 69420);
        staff[2] = new Pegawai("Joe Mama", 223030);
        staff[3] = new Manager("Cringe", "Fella Tio", 3938389);
        for (int i = 0; i < staff.length; i++){
            staff[i].cetakData();
        }

        }
    
}
