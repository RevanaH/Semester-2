import java.util.*;

class Kotak<T>{
    T data;
    public Kotak(T data){
        this.data = data;
    }
}
public class kotak {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Kotak <Integer> kotak1 = new Kotak<Integer>(12);
        System.out.println(kotak1.data);
        sc.close();

        String kalimat = sc.nextLine();
        String [] kata = kalimat.split("");
        System.out.println(Arrays.toString(kata));

    }
    
}
