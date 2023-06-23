import java.util.*;

abstract class CivitasAkademik {
    String nama;
    String prodi;
    String fakultas;
    String alamat;

    public CivitasAkademik(String nama, String prodi, String fakultas, String alamat) {
        this.nama = nama;
        this.prodi = prodi;
        this.fakultas = fakultas;
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    public String getFakultas() {
        return fakultas;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

}

class Dosen extends CivitasAkademik {
    String nidn;
    String gaji;

    public String getNidn() {
        return nidn;
    }

    public void setNidn(String nidn) {
        this.nidn = nidn;
    }

    public String getGaji() {
        return gaji;
    }

    public void setGaji(String gaji) {
        this.gaji = gaji;
    }

    public Dosen(String nidn, String nama, String prodi, String fakultas, String alamat, String gaji) {
        super(nama, prodi, fakultas, alamat);
        this.nidn = nidn;
        this.gaji = gaji;
    }

    void tampilkanData() {
        System.out.println("Data Dosen");
        System.out.println("Nama          : " + this.getNama());
        System.out.println("NIDN          : " + this.getNidn());
        System.out.println("Prodi         : " + this.getProdi());
        System.out.println("Fakultas      : " + this.getFakultas());
        System.out.println("Alamat        : " + this.getAlamat());
        System.out.println("Gaji          : " + this.getGaji());
        System.out.println();

    }
}

class Mahasiswa extends CivitasAkademik {
    String nim;
    String ukt;

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getUkt() {
        return ukt;
    }

    public void setUkt(String ukt) {
        this.ukt = ukt;
    }

    public Mahasiswa(String nim, String nama, String prodi, String fakultas, String alamat, String ukt) {
        super(nama, prodi, fakultas, alamat);
        this.nim = nim;
        this.ukt = ukt;

    }

    void tampilkanData() {
        System.out.println("Data Mahasiswa");
        System.out.println("Nama          : " + this.getNama());
        System.out.println("NIM           : " + this.getNim());
        System.out.println("Prodi         : " + this.getProdi());
        System.out.println("Fakultas      : " + this.getFakultas());
        System.out.println("Alamat        : " + this.getAlamat());
        System.out.println("UKT           : " + this.getUkt());
        System.out.println();

    }

}

class KRS {
    Mahasiswa mhs;
    MataKuliah[] mk = new MataKuliah[24];
    int check;
    

    public KRS() {

    }

    void tambahMatakuliah(MataKuliah matkul) {
        int index = 0;
        int totalSks = 0;
        for (int i = 0; i < mk.length; i++) {
            if (mk[i] != null) {
                totalSks += mk[i].getSks();
                index++;
            }
        }
        if (totalSks + matkul.getSks() <= 24) {
            mk[index] = matkul;
        }

    check = matkul.getSks() + totalSks;
    }


    public void setMahasiswa(Mahasiswa mahasiswa) {
        this.mhs = mahasiswa;
    }

    void tampilKRS() {
        int num = 1;
        System.out.println("KRS milik " + mhs.getNama());
        System.out.println("Nama          : " + mhs.getNama());
        System.out.println("NIM           : " + mhs.getNim());
        System.out.println("Prodi         : " + mhs.getProdi());
        System.out.println("Fakultas      : " + mhs.getFakultas());
        System.out.println("Alamat        : " + mhs.getAlamat());
        System.out.println("UKT           : " + mhs.getUkt());
        System.out.println();
        System.out.println("Mata Kuliah " + mhs.getNama());
        System.out.println();
        for (int i = 0; i < mk.length; i++) {
            if (mk[i] != null) {
                System.out.println("Mata Kuliah ke " + num + " " + mhs.getNama());
                System.out.println();
                System.out.println("Kode Matkul     : " + mk[i].getKodeMatkul());
                System.out.println("Nama Matkul     : " + mk[i].getNamaMatkul());
                System.out.println("SKS             : " + mk[i].getSks());
                System.out.println("Dosen Pengampu  : " + mk[i].getDsn().getNama());
                System.out.println();
            }

            num++;
            
        }
        if (check > 24) {
            System.out.println("Jumlah SKS yang dimasukan sudah melebihi batas maksimum (24 SKS)");
    
        }

    }
    
}

class MataKuliah {
    String kodeMatkul;
    String namaMatkul;
    int sks;
    Dosen dsn;

    public Dosen getDsn() {
        return dsn;
    }

    public void setDsn(Dosen dsn) {
        this.dsn = dsn;
    }

    public String getKodeMatkul() {
        return kodeMatkul;
    }

    public void setKodeMatkul(String kodeMatkul) {
        this.kodeMatkul = kodeMatkul;
    }

    public String getNamaMatkul() {
        return namaMatkul;
    }

    public void setNamaMatkul(String namaMatkul) {
        this.namaMatkul = namaMatkul;
    }

    public int getSks() {
        return this.sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }

    public MataKuliah(String kodeMatkul, String namaMatkul, int sks, Dosen dsn) {
        this.kodeMatkul = kodeMatkul;
        this.namaMatkul = namaMatkul;
        this.sks = sks;
        this.dsn = dsn;

    }

}

public class Main {
    public static void main(String[] args) {

        Dosen d1 = new Dosen("123", "Indriati", "TIF", "FILKOM", "Jalan Mawar", "Rp.20.000.000,00");
        Dosen d2 = new Dosen("124", "Randy", "TIF", "FILKOM", "Jalan Teratai", "Rp.21.000.000,00");
        Dosen d3 = new Dosen("312", "Achmad", "TIF", "FILKOM", "Jalan Soekarno", "Rp.30.000.000,00");
        KRS krsKel = new KRS();
        MataKuliah m1 = new MataKuliah("CIF62002", "SISOP", 4, d1);
        MataKuliah m2 = new MataKuliah("CIF62004", "ASD", 4, d1);
        MataKuliah m3 = new MataKuliah("CIF62006", "STP", 3, d2);
        MataKuliah m4 = new MataKuliah("CIF62003", "PBO", 5, d2);
        MataKuliah m5 = new MataKuliah("CIF62007", "Kewarganegaraan", 2, d3);
        MataKuliah m6 = new MataKuliah("CIF62001", "TES", 10, d3);
        Mahasiswa Andi = new Mahasiswa("225150201110765", "Andi", "TeKom", "FILKOM", "Jalan Bunga Merak","Rp.7.500.00,00");
        Mahasiswa Hera = new Mahasiswa("225150201111675", "Hera", "TI", "FILKOM", "Jalan Cemara", "Rp.7.500.000,00");
        krsKel.setMahasiswa(new Mahasiswa("225150201117965", "Fred", "TIF", "FILKOM", "Jalan Bunga Camelia", "Rp.5.000.000,00"));
        Andi.tampilkanData();
        Hera.tampilkanData();
        d1.tampilkanData();
        d2.tampilkanData();
        d3.tampilkanData();
        krsKel.tambahMatakuliah(m1);
        krsKel.tambahMatakuliah(m2);
        krsKel.tambahMatakuliah(m3);
        krsKel.tambahMatakuliah(m4);
        krsKel.tambahMatakuliah(m5);
        krsKel.tambahMatakuliah(m6);
        krsKel.tampilKRS();

    }
}
