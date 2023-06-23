class Buku {
    private String judul;
    private String[] penulis;
    private String kategori;

    public Buku(String judul, String[] penulis, String kategori) {
        this.judul = judul;
        this.penulis = penulis;
        this.kategori = kategori;
    }

    public String getJudul() {
        return judul;
    }

    public String[] getPenulis() {
        return penulis;
    }

    public String getKategori() {
        return kategori;
    }
}

class Perpustakaan {
    private Buku[] koleksi;

    public Perpustakaan(Buku[] koleksi) {
        this.koleksi = koleksi;
    }

    public Buku[] getKoleksi() {
        return koleksi;
    }
}

public class Playground {
    public static void main(String[] args) {
        Buku[] koleksiBuku = {
            new Buku("Pemrograman Java", new String[]{"John Doe"}, "teknologi"),
            new Buku("Pemrograman Python", new String[]{"Jane Doe"}, "teknologi"),
            new Buku("The Republic", new String[]{"Plato"}, "filsafat"),
            new Buku("The Art of War", new String[]{"Sun Tzu"}, "sejarah"),
            new Buku("The Bible", new String[]{"Various Authors"}, "agama"),
            new Buku("Man's Search for Meaning", new String[]{"Viktor E. Frankl"}, "psikologi"),
            new Buku("The Communist Manifesto", new String[]{"Karl Marx", "Friedrich Engels"}, "politik"),
            new Buku("1984", new String[]{"George Orwell"}, "fiksi"),
            new Buku("To Kill a Mockingbird", new String[]{"Harper Lee"}, "fiksi"),
            new Buku("The Great Gatsby", new String[]{"F. Scott Fitzgerald"}, "fiksi")
        };

        Perpustakaan perpustakaanX = new Perpustakaan(koleksiBuku);

        // Menampilkan judul buku-buku dalam kategori teknologi
        System.out.println("Buku-buku dalam kategori teknologi:");
        for (Buku buku : perpustakaanX.getKoleksi()) {
            if (buku.getKategori().equals("teknologi")) {
                System.out.println(buku.getJudul());
            }
        }

        // Menampilkan penulis buku-buku dalam kategori politik
        System.out.println("Penulis buku-buku dalam kategori politik:");
        for (Buku buku : perpustakaanX.getKoleksi()) {
            if (buku.getKategori().equals("politik")) {
                System.out.println(String.join(", ", buku.getPenulis()));
            }
        }
    }
}
