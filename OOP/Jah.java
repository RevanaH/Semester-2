public class Jah {

      public static void main (String[] args){
        Mahasiswa mhs1 = new Mahasiswa();
        Mahasiswa mhs2 = new Mahasiswa();
        mhs2.printNama();
        mhs1.printNama();
      }
    }
    class Mahasiswa{
        String nama = "lmao";
        String NIM;

        Mahasiswa() {}

        void printNama() {
            System.out.println(nama);

        }
    }
    

