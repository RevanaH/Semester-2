package Library;

import java.util.*;

class TestJavaCollection1 {
    public static void main(String args[]) {
        ArrayList<String> list = new ArrayList<String>();// Creating arraylist
        list.add("Adi");// Adding object in arraylist
        list.add("Putra");
        list.add("Tari");
        list.add("Syila");// Traversing list through Iterator
        list.remove("Putra");
        ArrayList<String> list1 = new ArrayList<String>();
        list.removeAll(list1);
        list1.add("Putra");
        list1.add("Tari");
        list.clear();
        Iterator itr = list.iterator();
        Iterator itr1 = list1.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        while (itr1.hasNext()) {
            System.out.println(itr1.next());
        }
    }
}