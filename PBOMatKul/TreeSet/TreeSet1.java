package TreeSet;
import java.util.*;

public class TreeSet1 {
    public static void main(String[] args) {
        //Creating and adding elements
        TreeSet<String> a1 = new TreeSet<String>();
        a1.add("Adi");
        a1.add("Putra");
        a1.add("Tari");
        a1.add("Syila");
        
        //Traversing elements
        Iterator<String> itr = a1.iterator();
        while(itr.hasNext()){
        System.out.println(itr.next());
        }
    }
}
