import java.util.*;
import java.text.DecimalFormat;

public class CVKalk {
    static DecimalFormat rupiah = new DecimalFormat("Rp ###,###.00");
    static final double bahanA = 100000;
    static final double bahanB = 125000;
    static final double bahanC = 175000;
    static int barangA, barangB, barangC, barangABC;
    static double sumA, sumB, sumC, sumABC;
    static Scanner s = new Scanner(System.in);

    static void MainMenu() {
        System.out.println();
        System.out.println("Banyak Barang yang ada dalam Pesan:");
        System.out.println("Barang A : " + barangA);
        System.out.println("Barang B : " + barangB);
        System.out.println("Barang C : " + barangC);
        System.out.println();
        System.out.println("Berikut Pilihan yang tersedia:");
        System.out.println(
                "1. Memesan Barang\n2. Mengubah Jumlah Barang\n3. Cek Total Harga\n4. Informasi Pembelian Grosir\n0. Exit");
        System.out.print("Silahkan tentukan pilihan anda: ");
        int pilihanMenu = s.nextInt();
        s.nextLine();
        switch (pilihanMenu) {
            case 1:
                pesanBarang();
                MainMenu();
                break;

            case 2:
                ubah();
                break;

            case 3:
                prosesNota();
                printNota();
                MainMenu();

                break;
            case 4:
                diskon();
                MainMenu();
                break;

            case 0:
                System.out.println();
                System.out.println("Terimakasih sudah menggunakan pelayanan kami!");
                System.exit(0);
                break;

            default:
                System.out.println("Silahkan berikan input yang valid!");
                MainMenu();
                break;

        }
    }

    static void diskon() {
        System.out.println();
        System.out.println(
                "Kami akan memberikan Potongan Harga jika Pesanan Jaket Memenuhi jumlah dibawah:");
        System.out.println(" 95 atau lebih pesanan Jaket dengan Bahan A =  8% Potongan Harga");
        System.out.println("100 atau lebih pesanan Jaket dengan Bahan B = 10% Potongan Harga");
        System.out.println("120 atau lebih pesanan Jaket dengan Bahan C = 15% Potongan Harga");
        System.out.println();
    }

    static void pesanBarang() {
        barangA = 0;
        barangB = 0;
        barangC = 0;
        System.out.println();
        System.out.println("Harga Stauan Barang:");
        System.out.println("Barang A = " + rupiah.format(bahanA));
        System.out.println("Barang B = " + rupiah.format(bahanB));
        System.out.println("Barang C = " + rupiah.format(bahanC));
        System.out.println();
        System.out.println("Silahkan Masukan banyak barang yang ingin dipesan");
        System.out.println();
        System.out.print("Barang A : ");
        int tempA = s.nextInt();
        barangA += tempA;
        System.out.print("Barang B : ");
        int tempB = s.nextInt();
        barangB += tempB;
        System.out.print("Barang C : ");
        int tempC = s.nextInt();
        barangC += tempC;
        s.nextLine();
        tempA = 0;
        tempB = 0;
        tempC = 0;
        System.out.println();
        System.out.println("Banyak Barang yang anda Pesan:");
        System.out.println("Barang A : " + barangA);
        System.out.println("Barang B : " + barangB);
        System.out.println("Barang C : " + barangC);
        System.out.print("Apakah anda sudah yakin dengan pesanan anda? (y/n)");
        String pilih = s.nextLine();
        System.out.println();
        switch (pilih) {
            case "y":
                barangABC = barangA + barangB + barangC;
                System.out.println("Pesanan anda telah tersimpan");
                MainMenu();
                break;
            case "n":
                pesanBarang();
                break;
            default:
                System.out.println("Silahkan berikan input yang valid!");
                pesanBarang();
                break;
        }
    }

    static void ubah() {
        if (barangA == 0 && barangB == 0 && barangC == 0) {
            System.out.println();
            System.out.println("Anda belum menaruh pesanan");
            MainMenu();
        }
        System.out.println("");
        System.out.println("Perubahan yang dapat dilakukan pada Pesanan:");
        System.out.println("1. Tambah Barang\n2. Kurangi Barang\n3. Pesan Ulang\n0. Kembali");
        System.out.print("Silahkan tentukan pilihan anda: ");
        int pilihanMenu = s.nextInt();
        s.nextLine();
        switch (pilihanMenu) {
            case 1:
                System.out.println();
                System.out.println("Pesanan mana yang ingin ditambah?");
                System.out.println("1. Jaket Bahan A\n2. Jaket Bahan B\n3. Jaket Bahan C\n0. Kembali");
                System.out.print("Silahkan tentukan pilihan anda: ");
                int pilih = s.nextInt();
                s.nextLine();
                switch (pilih) {
                    case 1:
                        System.out.println();
                        System.out.println("Pesanan Jaket Bahan A anda Sekarang :" + barangA);
                        System.out.print("Tentukan banyak Barang yang ingin Ditambah:");
                        int tambah = s.nextInt();
                        s.nextLine();
                        barangA += tambah;
                        tambah = 0;
                        System.out.println("Barang berhasil ditambah");
                        System.out.println("Pesanan Jaket Bahan A anda Sekarang :" + barangA);
                        System.out.print("Apakah ada Pesanan lain yang ingin di ubah?(y/n)");
                        String pilihan = s.nextLine();
                        System.out.println();
                        switch (pilihan) {
                            case "y":
                                ubah();
                                break;
                            case "n":
                                System.out.println("Pesanan anda telah tersimpan");
                                MainMenu();
                                break;
                            default:
                                System.out.println("Silahkan berikan input yang valid!");
                                ubah();
                                break;
                        }
                    case 2:
                        System.out.println();
                        System.out.println("Pesanan Jaket Bahan B anda Sekarang :" + barangB);
                        System.out.print("Tentukan banyak Barang yang ingin Ditambah:");
                        tambah = s.nextInt();
                        s.nextLine();
                        barangB += tambah;
                        System.out.println("Barang berhasil ditambah");
                        System.out.println("Pesanan Jaket Bahan B anda Sekarang :" + barangB);
                        System.out.print("Apakah ada Pesanan lain yang ingin di ubah?(y/n)");
                        pilihan = s.nextLine();
                        System.out.println();
                        switch (pilihan) {
                            case "y":
                                ubah();
                                break;
                            case "n":
                                System.out.println("Pesanan anda telah tersimpan");
                                MainMenu();
                                break;
                            default:
                                System.out.println("Silahkan berikan input yang valid!");
                                ubah();
                                break;
                        }
                    case 3:
                        System.out.println();
                        System.out.println("Pesanan Jaket Bahan C anda Sekarang :" + barangC);
                        System.out.print("Tentukan banyak Barang yang ingin Ditambah:");
                        tambah = s.nextInt();
                        s.nextLine();
                        barangC += tambah;
                        System.out.println("Barang berhasil ditambah");
                        System.out.println("Pesanan Jaket Bahan C anda Sekarang :" + barangC);
                        System.out.print("Apakah ada Pesanan lain yang ingin di ubah?(y/n)");
                        pilihan = s.nextLine();
                        System.out.println();
                        switch (pilihan) {
                            case "y":
                                ubah();
                                break;
                            case "n":
                                System.out.println("Pesanan anda telah tersimpan");
                                MainMenu();
                                break;
                            default:
                                System.out.println("Silahkan berikan input yang valid!");
                                ubah();
                                break;
                        }

                    case 0:
                        ubah();
                        break;
                    default:
                        System.out.println("Silahkan berikan input yang valid!");
                        ubah();
                        break;
                }
                break;

            case 2:
                System.out.println();
                System.out.println("Pesanan mana yang ingin dikurangi?");
                System.out.println("1. Jaket Bahan A\n2. Jaket Bahan B\n3. Jaket Bahan C\n0. Kembali");
                System.out.print("Silahkan tentukan pilihan anda: ");
                pilih = s.nextInt();
                s.nextLine();
                switch (pilih) {
                    case 1:
                        System.out.println();
                        System.out.println("Pesanan Jaket Bahan A anda Sekarang :" + barangA);
                        System.out.print("Tentukan banyak Barang yang ingin Dikurangi:");
                        int kurang = s.nextInt();
                        s.nextLine();
                        if (barangA - kurang < 0) {
                            System.out.println();
                            System.out.println("Barang tidak bisa kurang dari 0");
                            ubah();
                        }
                        barangA -= kurang;
                        kurang = 0;
                        System.out.println("Barang berhasil dikurangi");
                        System.out.println("Pesanan Jaket Bahan A anda Sekarang :" + barangA);
                        System.out.print("Apakah ada Pesanan lain yang ingin di ubah?(y/n)");
                        String pilihan = s.nextLine();
                        System.out.println();
                        switch (pilihan) {
                            case "y":
                                ubah();
                                break;
                            case "n":
                                System.out.println("Pesanan anda telah tersimpan");
                                MainMenu();
                                break;
                            default:
                                System.out.println("Silahkan berikan input yang valid!");
                                ubah();
                                break;
                        }

                    case 2:
                        System.out.println();
                        System.out.println("Pesanan Jaket Bahan B anda Sekarang :" + barangB);
                        System.out.print("Tentukan banyak Barang yang ingin Dikurangi:");
                        kurang = s.nextInt();
                        s.nextLine();
                        if (barangB - kurang < 0) {
                            System.out.println();
                            System.out.println("Barang tidak bisa kurang dari 0");
                            ubah();
                        }
                        barangB -= kurang;
                        kurang = 0;
                        System.out.println("Barang berhasil dikurangi");
                        System.out.println("Pesanan Jaket Bahan B anda Sekarang :" + barangB);
                        System.out.print("Apakah ada Pesanan lain yang ingin di ubah?(y/n)");
                        pilihan = s.nextLine();
                        System.out.println();
                        switch (pilihan) {
                            case "y":
                                ubah();
                                break;
                            case "n":
                                System.out.println("Pesanan anda telah tersimpan");
                                MainMenu();
                                break;
                            default:
                                System.out.println("Silahkan berikan input yang valid!");
                                ubah();
                                break;
                        }
                    case 3:
                        System.out.println();
                        System.out.println("Pesanan Jaket Bahan C anda Sekarang :" + barangC);
                        System.out.print("Tentukan banyak Barang yang ingin Dikurangi:");
                        kurang = s.nextInt();
                        s.nextLine();
                        if (barangC - kurang < 0) {
                            System.out.println();
                            System.out.println("Barang tidak bisa kurang dari 0");
                            ubah();
                        }
                        barangC -= kurang;
                        kurang = 0;
                        System.out.println("Barang berhasil dikurangi");
                        System.out.println("Pesanan Jaket Bahan C anda Sekarang :" + barangC);
                        System.out.print("Apakah ada Pesanan lain yang ingin di ubah?(y/n)");
                        pilihan = s.nextLine();
                        System.out.println();
                        switch (pilihan) {
                            case "y":
                                ubah();
                                break;
                            case "n":
                                System.out.println("Pesanan anda telah tersimpan");
                                MainMenu();
                                break;
                            default:
                                System.out.println("Silahkan berikan input yang valid!");
                                ubah();
                                break;
                        }
                    case 0:
                        ubah();
                        break;
                    default:
                        System.out.println("Silahkan berikan input yang valid!");
                        ubah();
                        break;

                }
                break;

            case 3:
                pesanBarang();
                break;

            case 0:
                MainMenu();
                break;

            default:
                System.out.println("Silahkan berikan input yang valid!");
                ubah();
                break;

        }

    }

    static void prosesNota() {
        if (barangA < 95) {
            sumA = Kalkulator.kali(barangA, bahanA);
        } else {
            sumA = Kalkulator.kurang(Kalkulator.kali(barangA, bahanA),
                    Kalkulator.kali(Kalkulator.bagi(bahanA, 8), barangA));
        }
        if (barangB < 100) {
            sumB = Kalkulator.kali(barangB, bahanB);
        } else {
            sumB = Kalkulator.kurang(Kalkulator.kali(barangB, bahanB),
                    Kalkulator.kali(Kalkulator.bagi(bahanB, 10), barangB));
        }
        if (barangC < 120) {
            sumC = Kalkulator.kali(barangC, bahanC);
        } else {
            sumC = Kalkulator.kurang(Kalkulator.kali(barangC, bahanC),
                    Kalkulator.kali(Kalkulator.bagi(bahanC, 15), barangC));
        }
        sumABC = Kalkulator.tambah(Kalkulator.tambah(sumA, sumB), sumC);

    }

    static void printNota() {
        if (sumA == 0 && sumB == 0 && sumC == 0) {
            System.out.println();
            System.out.println("Anda belum menaruh pesanan");
            MainMenu();
        }
        System.out.println();
        System.out.println("Berikut Adalah Jumlah Harga dan Barang dari Pesanan Anda:");
        System.out.println();
        System.out.printf("%-18s%-18s%-20s\n", "Bahan Jaket", "Banyak Barang", "Jumlah Harga Barang");
        System.out.printf("%-22s%-16d%-20s\n", "Bahan A", barangA, rupiah.format(sumA));
        System.out.printf("%-22s%-16d%-20s\n", "Bahan B", barangB, rupiah.format(sumB));
        System.out.printf("%-22s%-16d%-20s\n", "Bahan C", barangC, rupiah.format(sumC));
        System.out.println("--------------------------------------------------------");
        System.out.printf("%-22s%-16d%-20s\n", "Total Pesanan", barangABC, rupiah.format(sumABC));
        System.out.println();
        System.out.print("Apakah anda sudah ingin memfinalisasi Pemesanan Anda?(y/n)");
        String pilih = s.nextLine();
        switch (pilih) {
            case "y":
                System.out.println("Pesanan anda sudah di terima.");
                System.out.println("Terima Kasih telah berbelanja di CV. Labkomdas!");
                System.exit(0);
                break;

            case "n":
                System.out.println("Bila ada perubahan atau pembatalan Maka Anda akan dikembalikan ke Menu awal");
                MainMenu();
                break;

            default:
                System.out.println("Bila ada perubahan atau pembatalan Maka Anda akan dikembalikan ke Menu awal");
                MainMenu();
                break;

        }

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println();
        System.out.println("Selamat datang di CV. Labkomdas");
        CVKalk.MainMenu();
        s.close();
    }

}

class Kalkulator {
    double a, b;

    public static double tambah(double a, double b) {
        return a + b;
    }

    public static double kurang(double a, double b) {
        return a - b;
    }

    public static double kali(double a, double b) {
        return a * b;
    }

    public static double bagi(double a, double b) {
        return a / b;
    }
}