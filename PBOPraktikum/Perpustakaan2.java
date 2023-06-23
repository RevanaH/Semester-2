import java.util.Scanner;
import java.text.DecimalFormat;

class Index {
    private int categories;
    private String[] types;
    private int[] requested;
    private String[][] title;
    private String[][] writer;
    private String[][] year;
    private String[][] synopsis;
    private double[][] sold;
    private int[][] royalties;
    public DecimalFormat rupiah = new DecimalFormat("Rp ###,###.00");

    public Index(int categories, String[] types, int[] requested, String[][] title,
            String[][] writer, String[][] year, String[][] synopsis, double[][] sold,
            int[][] royalties) {
        this.categories = categories;
        this.types = types;
        this.requested = requested;
        this.title = title;
        this.writer = writer;
        this.year = year;
        this.synopsis = synopsis;
        this.sold = sold;
        this.royalties = royalties;
    }

    public String Capitals(int category, int book) {
        String snipets = this.synopsis[category][book];
        String[] changes = snipets.split("(?<=[.!?])\\s+");
        snipets = "";
        for(int i = 0; i < changes.length; i++){
            snipets = snipets + changes[i].substring(0,1).toUpperCase() + changes[i].substring(1) + " ";           
        }
        return snipets;
    }
    

    public int Count(int category, int book) {
        String words = this.synopsis[category][book];
        String[] yeah = words.split("[ .!?]+");
        return yeah.length;
    }
    
    

    String hitungRoyalti(double sold) {
        double royalti = sold * 0.1;
        return rupiah.format(royalti);

    }

    String hitungRoyalti(double sold, double royalties) {
        double royalti = sold * royalties / 100;
        return rupiah.format(royalti);

    }

    void Print() {
        System.out.println("\nBerikut adalah daftar buku yang tersedia di Perpustakaan:");
        for (int i = 0; i < categories; i++) {
            System.out.println("Kategori " + types[i] + " :");
            for (int j = 0; j < requested[i]; j++) {
                System.out.print((j + 1) + ". " + title[i][j] + ", oleh ");
                System.out.print(writer[i][j] + ", ");
                System.out.println("Tahun " + year[i][j]);
                String snips = Capitals(i,j);
                System.out.println("Sinopsis buku ke -" + (j + 1) + " :" + snips);
                int length = Count(i,j);
                System.out.println("Jumlah Kata dalam sinopsis: " + length);
                String royalti10 = hitungRoyalti(sold[i][j]);
                String royaltiX = hitungRoyalti(sold[i][j], royalties[i][j]);
                System.out.println("Royalti 10% buku : " + royalti10);
                System.out.println("Royalti " + royalties[i][j] + "% buku : " + royaltiX);
            }
            System.out.println();
        }
    }
}

public class Perpustakaan2 {
    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            System.out.println("Selamat datang di Perpustakaan");
            System.out.println("Masukkan jumlah kategori:");
            int categories = s.nextInt();s.nextLine();
            String[] types = new String[categories];
            String[][] title = new String[categories][];
            String[][] writer = new String[categories][];
            String[][] year = new String[categories][];
            String[][] synopsis = new String[categories][];
            double[][] sold = new double[categories][];
            int[][] royalties = new int[categories][];
            int[] requested = new int[categories];

            for (int i = 0; i < categories; i++) {
                System.out.println("Masukkan nama kategori ke-" + (i + 1) + ":");
                types[i] = s.nextLine();
                System.out.println("Masukkan jumlah buku untuk kategori " + types[i] + ":");
                requested[i] = s.nextInt();
                s.nextLine();
                title[i] = new String[requested[i]];
                writer[i] = new String[requested[i]];
                year[i] = new String[requested[i]];
                synopsis[i] = new String[requested[i]];
                sold[i] = new double[requested[i]];
                royalties[i] = new int[requested[i]];
                for (int j = 0; j < requested[i]; j++) {
                    System.out.println("Masukkan judul buku ke-" + (j + 1) + " untuk kategori " + types[i] + ":");
                    title[i][j] = s.nextLine();
                    System.out.println("Masukkan penulis buku ke-" + (j + 1) + " untuk kategori " + types[i] + ":");
                    writer[i][j] = s.nextLine();
                    System.out.println("Masukkan tahun terbit buku ke-" + (j + 1) + " untuk kategori " + types[i] + ":");
                    year[i][j] = s.nextLine();
                    System.out.println("Masukkan sinopsis buku ke-" + (j + 1) + " untuk kategori " + types[i] + ":");
                    synopsis[i][j] = s.nextLine();
                    System.out.println("Jumlah keuntungan buku tersebut bulan ini :");
                    sold[i][j] = s.nextInt();
                    System.out.println("Masukan royalti buku tersebut :");
                    royalties[i][j] = s.nextInt();s.nextLine();
                }
            }
            
            int placeHolder = 0;
            Index index = new Index(categories, types, requested, title, writer, year, synopsis, sold, royalties);
            index.Capitals(placeHolder, placeHolder);
            index.Count(placeHolder, placeHolder);
            index.hitungRoyalti(placeHolder);
            index.hitungRoyalti(placeHolder, placeHolder);
            index.Print();
            
        }
    }
}