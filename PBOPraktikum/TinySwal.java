import java.util.*;
import java.text.DecimalFormat;

public class TinySwal {
    static Scanner s = new Scanner(System.in);
    static ArrayList<Akun> listAkun = new ArrayList<Akun>();
    static ArrayList<Handphone> listProduk = new ArrayList<Handphone>();
    static DecimalFormat rupiah = new DecimalFormat("Rp ###,###.00");

    static void MainMenu() {
        System.out.println();
        System.out.println("Silahkan pilih pelayanan yang tersedia:");
        System.out.println("1. Transaksi\n2. Akun\n0. Exit");
        System.out.print("Silahkan tentukan pilihan anda : ");
        int pilihanMenu = s.nextInt();
        s.nextLine();
        switch (pilihanMenu) {
            case 1:
                MenuTransaksi();
                MainMenu();
                break;

            case 2:
                MenuAkun();
                MainMenu();
                break;

            case 0:
                System.out.println();
                System.out.println("Terimakasih sudah menggunakan pelayanan kami!");
                System.exit(0);
                break;
        }
    }

    static void MenuTransaksi() {
        System.out.println();
        System.out.println("Bentuk Pelayanan yang tersedia:");
        System.out.println("1. Pembeliann\n2. Isi Saldo / Top-Up\n9. Kembali\n0. Exit");
        System.out.print("Silahkan tentukan pilihan anda: ");
        int pilihanMenu = s.nextInt();
        s.nextLine();
        switch (pilihanMenu) {
            case 1:
                pembelian();
                MenuTransaksi();
                break;

            case 2:
                isiSaldo();
                MenuTransaksi();
                break;

            case 9:
                MainMenu();
                break;

            case 0:
                System.out.println();
                System.out.println("Terimakasih sudah menggunakan pelayanan kami!");
                System.exit(0);
                break;
        }

    }

    static void MenuAkun() {
        System.out.println();
        System.out.println("Bentuk Pelayanan yang tersedia:");
        System.out.println(
                "1. Datar Akun\n2. Cek Akun\n3. Ganti Nama Akun\n4. Tarik Saldo\n9. Kembali\n0. Exit");
        System.out.print("Silahkan tentukan pilihan anda: ");
        int pilihanMenu = s.nextInt();
        s.nextLine();
        switch (pilihanMenu) {
            case 1:
                daftarAkun();
                MenuAkun();
                break;

            case 2:
                cekAkun();
                MenuAkun();
                break;

            case 3:
                gantiNama();
                MenuAkun();
                break;

            case 4:
                tarikSaldo();
                MenuAkun();
                break;

            case 9:
                MainMenu();
                break;

            case 0:
                System.out.println();
                System.out.println("Terimakasih sudah menggunakan pelayanan kami!");
                System.exit(0);
                break;
        }

    }

    static void daftarAkun() {
        System.out.println();
        System.out.print("Silahkan masukan nama akun anda:");
        String nama = s.nextLine();
        System.out.print("Silahkan pilih jenis rekening yang akan dibuat (Silver/Gold/Platinum) :");
        String jenisAkun = s.nextLine();
        System.out.print("Silahkan masukan saldo anda (minimal saldo Rp.100.000,00) :");
        double saldo = s.nextDouble();
        s.nextLine();
        System.out.print("Masukan PIN untuk akun baru anda (minimal 7 digit) :");
        String pin = s.nextLine();
        System.out.println();
        System.out.println("Akun anda telah berhasil dibuat. Terima kasih sudah memilih Tiny Swalayan.");
        System.out.println();
        Akun akun = new Akun(nama, jenisAkun, saldo, pin);
        listAkun.add(akun);

    }

    static void cekAkun() {
        System.out.println();
        System.out.print("Silahkan masukan nama akun anda: ");
        String cekAkun = s.nextLine();
        System.out.print("Silahkan masukan PIN akun anda: ");
        String cekPIN = s.nextLine();
        boolean accountExists = false;
        for (Akun element : listAkun) {
            if (element.getNama().contains(cekAkun)) {
                accountExists = true;
                if (element.pin.contains(cekPIN) && element.isBlocked == false) {
                    System.out.println("Nama Akun: " + element.getNama());
                    System.out.println("No.Pelanggan: " + element.getNomorPelanggan());
                    System.out.println("Saldo Akun: " + rupiah.format(element.getSaldo()));
                    blokir(element, false);
                } else {
                    blokir(element, true);
                }
                break;
            }
        }
        if (!accountExists) {
            System.out.println(
                    "Akun tidak ada. Silahkan dicoba lagi atau hubungi customer service untuk info mengenai akun anda.");
        }
        System.out.println();
    }

    static void gantiNama() {
        System.out.println();
        System.out.print("Silahkan masukan nama akun anda: ");
        String cekAkun = s.nextLine();
        System.out.print("Silahkan masukan PIN akun anda: ");
        String cekPIN = s.nextLine();
        boolean accountExists = false;
        for (Akun element : listAkun) {
            if (element.getNama().contains(cekAkun)) {
                accountExists = true;
                if (element.getPin().contains(cekPIN) && element.isBlocked == false) {
                    System.out.println("Apakah anda yakin ingin mengubah naka Akun anda?");
                    System.out.print("(Yes/No):");
                    String confirm = s.nextLine();
                    if (confirm.equalsIgnoreCase("Yes")) {
                        // System.out.print("Masukan nama baru untuk Akun anda: ");
                        // namaBaru = s.nextLine();
                        // element.nama = namaBaru;
                        element.setNama();
                        System.out.println("Nama anda telah diubah menjadi : " + element.getNama());
                        break;
                    } else if (confirm.equalsIgnoreCase("No")) {
                        break;
                    }
                } else {
                    blokir(element, !element.getPin().contains(cekPIN));
                }
            }
        }
        if (!accountExists) {
            System.out.println(
                    "Akun tidak ada. Silahkan dicoba lagi atau hubungi customer service untuk info mengenai akun anda.");
        }
        System.out.println();
    }

    static void isiSaldo() {
        System.out.println();
        System.out.print("Silahkan masukan nomor akun anda: ");
        String cekNoAkun = s.nextLine();
        System.out.print("Silahkan masukan PIN akun anda: ");
        String cekPIN = s.nextLine();
        boolean accountExists = false;
        for (Akun element : listAkun) {
            if (element.getNomorPelanggan().contains(cekNoAkun)) {
                accountExists = true;
                if (element.getPin().contains(cekPIN) && element.isBlocked == false) {
                    while (true) {
                        System.out.print("Silahkan masukan nomial yang ingin di deposit: ");
                        double tambahSaldo = s.nextDouble();
                        s.nextLine();
                        element.saldo += tambahSaldo;
                        System.out.println("Apakah anda ingin menambah saldo lagi?");
                        System.out.print("(Yes/No):");
                        String confirm = s.nextLine();
                        if (confirm.equalsIgnoreCase("Yes")) {
                            continue;
                        } else if (confirm.equalsIgnoreCase("No")) {
                            System.out.println("Saldo anda untuk saat ini adalah :" + rupiah.format(element.saldo));
                            break;
                        }
                    }
                } else {
                    blokir(element, !element.getPin().contains(cekPIN));
                }
            }
        }
        if (!accountExists) {
            System.out.println(
                    "Akun tidak ada. Silahkan dicoba lagi atau hubungi customer service untuk info mengenai akun anda.");
        }
        System.out.println();
    }

    static void tarikSaldo() {
        System.out.println();
        System.out.print("Silahkan masukan nomor akun anda: ");
        String cekNoAkun = s.nextLine();
        System.out.print("Silahkan masukan PIN akun anda: ");
        String cekPIN = s.nextLine();
        boolean accountExists = false;
        for (Akun element : listAkun) {
            if (element.getNomorPelanggan().contains(cekNoAkun)) {
                accountExists = true;
                if (element.getPin().contains(cekPIN) && element.isBlocked == false) {
                    while (true) {
                        System.out.print("Silahkan masukan nominal yang ingin di tarik: ");
                        double kurangSaldo = s.nextDouble();
                        s.nextLine();
                        if (kurangSaldo > element.getSaldo() || element.getSaldo() - kurangSaldo <= 10.000) {
                            System.out.println("Saldo tidak cukup");
                            continue;
                        }
                        element.saldo -= kurangSaldo;
                        System.out.println("Apakah anda ingin menarik saldo lagi?");
                        System.out.print("(Yes/No):");
                        String confirm = s.nextLine();
                        if (confirm.equalsIgnoreCase("Yes")) {
                            continue;
                        } else if (confirm.equalsIgnoreCase("No")) {
                            System.out.println("Saldo anda untuk saat ini adalah :" + rupiah.format(element.saldo));
                            break;
                        }
                    }
                } else {
                    blokir(element, !element.getPin().contains(cekPIN));

                }
            }
        }
        if (!accountExists) {
            System.out.println(
                    "Akun tidak ada. Silahkan dicoba lagi atau hubungi customer service untuk info mengenai akun anda.");
        }
        System.out.println();
    }

    static void pembelian() {
        System.out.println();
        System.out.print("Silahkan masukan nomor akun anda: ");
        String cekNoAkun = s.nextLine();
        System.out.print("Silahkan masukan PIN akun anda: ");
        String cekPIN = s.nextLine();
        boolean accountExists = false;
        for (Akun akun : TinySwal.listAkun) {
            if (akun.getNomorPelanggan().contains(cekNoAkun)) {
                accountExists = true;
                if (akun.getPin().contains(cekPIN) && !akun.isBlocked) {
                    System.out.println();
                    System.out.println("Berikut ini adalah produk yang tersedia:");
                    for (int i = 0; i < TinySwal.listProduk.size(); i++) {
                        System.out.print((i + 1) + ". " + TinySwal.listProduk.get(i).getNamaHP()
                                + " " + rupiah.format(TinySwal.listProduk.get(i).getHargaHP()) + "\n");
                    }
                    System.out.println();
                    System.out.print("Pilih nomor produk yang akan dibeli: ");
                    int noProduk = s.nextInt();
                    s.nextLine();
                    if (noProduk <= TinySwal.listProduk.size() && noProduk > 0) {
                        Handphone hp = TinySwal.listProduk.get(noProduk - 1);
                        System.out.println(
                                "Anda membeli " + hp.getNamaHP() + " seharga " + rupiah.format(hp.getHargaHP()));
                        for (Akun a : TinySwal.listAkun) {
                            if (a.getNomorPelanggan().contains(cekNoAkun)) {
                                if (a.getNomorPelanggan().contains("38") && hp.getHargaHP() >= 1000000
                                        && a.getSaldo() > 10000) {
                                        if(a.saldo - hp.hargaHP < 10000){
                                            System.out.println("Maaf saldo anda tidak mencukupi minimal saldo pada akun anda.");
                                            return;
                                        }else{
                                        a.saldo -= hp.hargaHP;
                                    a.saldo += (hp.hargaHP * 5 / 100);
                                    System.out.println(
                                            "Anda mendapatkan cashback sebesar 5%, cashback sudah dikembalikan ke saldo anda");
                                    System.out.println("Sisa saldo anda adalah " + rupiah.format(a.getSaldo()));
                                    break;
                                        }
                                } else if (a.getNomorPelanggan().contains("56") && hp.getHargaHP() >= 1000000
                                        && a.getSaldo() > 10000) {
                                            if(a.saldo - hp.hargaHP < 10000){
                                                System.out.println("Maaf saldo anda tidak mencukupi minimal saldo pada akun anda.");
                                                return;
                                            }else{
                                            a.saldo -= hp.hargaHP;
                                    a.saldo += (hp.hargaHP * 7 / 100);
                                    System.out.println(
                                            "Anda mendapatkan cashback sebesar 7%, cashback sudah dikembalikan ke saldo anda");

                                    System.out.println("Sisa saldo anda adalah " + rupiah.format(a.getSaldo()));
                                    break;
                                            }
                                } else if (a.getNomorPelanggan().contains("56") && hp.getHargaHP() < 1000000
                                        && a.getSaldo() > 10000) {
                                            if(a.saldo - hp.hargaHP < 10000){
                                                System.out.println("Maaf saldo anda tidak mencukupi minimal saldo pada akun anda.");
                                                return;
                                            }else{
                                            a.saldo -= hp.hargaHP;
                                    a.saldo += (hp.hargaHP * 2 / 100);
                                    System.out.println(
                                            "Anda mendapatkan cashback sebesar 2%, cashback sudah dikembalikan ke saldo anda");

                                    System.out.println("Sisa saldo anda adalah " + rupiah.format(a.getSaldo()));
                                    break;
                                            }

                                } else if (a.getNomorPelanggan().contains("74") && hp.getHargaHP() >= 1000000
                                        && a.getSaldo() > 10000) {
                                            if(a.saldo - hp.hargaHP < 10000){
                                                System.out.println("Maaf saldo anda tidak mencukupi minimal saldo pada akun anda.");
                                                return;
                                            }else{
                                            a.saldo -= hp.hargaHP;
                                    a.saldo += (hp.hargaHP * 10 / 100);
                                    System.out.println(
                                            "Anda mendapatkan cashback sebesar 10%, cashback sudah dikembalikan ke saldo anda");

                                    System.out.println("Sisa saldo anda adalah " + rupiah.format(a.getSaldo()));
                                    break;
                                            }
                                } else if (a.getNomorPelanggan().contains("74") && hp.getHargaHP() < 1000000
                                        && a.getSaldo() > 10000) {
                                            if(a.saldo - hp.hargaHP < 10000){
                                                System.out.println("Maaf saldo anda tidak mencukupi minimal saldo pada akun anda.");
                                                return;
                                            }else{
                                            a.saldo -= hp.hargaHP;
                                    a.saldo += (hp.hargaHP * 5 / 100);
                                    System.out.println(
                                            "Anda mendapatkan cashback sebesar 5%, cashback sudah dikembalikan ke saldo anda");

                                    System.out.println("Sisa saldo anda adalah " + rupiah.format(a.getSaldo()));
                                    break;
                                            }

                                } else {
                                    System.out.println("Maaf saldo anda tidak mencukupi.");
                                    break;
                                }

                            }
                        }
                    } else {
                        System.out.println("Nomor produk yang anda pilih tidak valid!");
                    }
                    break;
                } else {
                    blokir(akun, !akun.getPin().contains(cekPIN));
                }
            }

        }
        if (!accountExists) {
            System.out.println(
                    "Akun tidak ada. Silahkan dicoba lagi atau hubungi customer service untuk info mengenai 0akun anda.");
        }
        System.out.println();
    }

    static void blokir(Akun account, boolean countAttempt) {
        if (countAttempt) {
            account.attempt++;
            if (account.attempt >= 3) {
                account.isBlocked = true;
                System.out.println(
                        "Akun " + account.noPelanggan + " telah diblokir karena tiga kali memasukan PIN yang salah.");
                System.out.println();
            } else {
                System.out.println("PIN salah. Kesempatan mencoba: " + (3 - account.attempt));
            }
        }
    }

    public static void main(String[] args) {
        Akun daftarAkun = new Akun("John", "Silver", 20000000, "6754321");
        Akun daftarAkun2 = new Akun("Doe", "Gold", 20000000, "8965432");
        Akun daftarAkun3 = new Akun("Moe", "Platinum", 20000000, "1234567");
        Akun daftarAkun4 = new Akun("Kale", "Platinum", 200, "4536247");
        Akun daftarAkun5 = new Akun("Yanny", "Gold", 509000, "5736247");
        Handphone hp1 = new Handphone("Bing Andromeda 5s", 1000000);
        Handphone hp2 = new Handphone("Oppa Smart Phone 2x", 2000000);
        Handphone hp3 = new Handphone("ELJI Smart Phone 3h", 3000000);
        Handphone hp4 = new Handphone("NokYeah Brick FON 777", 500000);
        listAkun.add(daftarAkun);
        listAkun.add(daftarAkun2);
        listAkun.add(daftarAkun3);
        listAkun.add(daftarAkun4);
        listAkun.add(daftarAkun5);
        listProduk.add(hp1);
        listProduk.add(hp2);
        listProduk.add(hp3);
        listProduk.add(hp4);
        System.out.print("Selamat datang di Tiny Swalayan! ");
        MainMenu();
        daftarAkun();

    }
}

class Akun {
    public boolean isBlocked;
    public int attempt;
    private String nama;
    public String jenisAkun;
    public double saldo;
    public String pin;
    public String noPelanggan;
    public int max = 999999999;
    public int min = 10000000;
    public int random = min + (int) (Math.random() * ((max - min) + 1));
    public String temp = String.valueOf(random);
    Scanner s = new Scanner(System.in);

    public Akun(String nama, String jenisAkun, double saldo, String pin) {
        this.nama = nama;
        this.jenisAkun = jenisAkun;
        this.saldo = saldo;
        this.pin = pin;
        switch (jenisAkun) {
            case "Silver":
                this.noPelanggan = "38" + this.temp;
                break;
            case "Gold":
                this.noPelanggan = "56" + this.temp;
                break;
            case "Platinum":
                this.noPelanggan = "74" + this.temp;
                break;
        }

    }

    public String getNama() {
        return this.nama;
    }

    public String getPin() {
        return this.pin;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public String getNomorPelanggan() {
        return this.noPelanggan;
    }

    public void setNama() {
        System.out.print("Silakan masukkan nama Baru :");
        this.nama = s.nextLine();

    }

}

class Handphone {

    public String namaHP;
    public double hargaHP;
    Scanner s = new Scanner(System.in);

    public Handphone(String namaHP, double hargaHP) {
        this.namaHP = namaHP;
        this.hargaHP = hargaHP;
    }

    public String getNamaHP() {
        return this.namaHP;
    }

    public double getHargaHP() {
        return this.hargaHP;
    }

}