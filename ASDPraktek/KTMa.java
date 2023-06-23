import java.util.*;

class KTM {
    String nama, nim, jurusan, univ;

    public KTM(String nama, String nim, String jurusan, String univ) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
        this.univ = univ;
    }

    @Override
    public String toString() {
        return nama + ", " + nim + ", " + jurusan + ", " + univ;
    }
}

public class KTMa {

    public static void main(String[] args) {
       try( Scanner s = new Scanner(System.in)){
        int sum = s.nextInt();s.nextLine();
        String[] order = s.nextLine().split(" ");
        KTM[] ID = new KTM[sum];

        for (int i = 0; i < sum; i++) {
            ID[i] = new KTM(s.next(), s.next(), s.next(), s.next());
        }
        for (int i = 0; i < order.length; i++) {
            int request = (Integer.parseInt(order[i]) - 1);
            //System.out.printf("%s, %s, %s, %s\n", ID[request].nama, ID[request].nim, ID[request].jurusan, ID[request].univ);
            System.out.println(ID[request].toString());
        }

    }
}
}
