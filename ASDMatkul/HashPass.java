import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;

class Entry<K, V> {
    private K key;
    private V value;
    Entry<K, V> next;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}


class HashMap<K, V> {
    private Entry<K, V>[] table;
    private final int size = 27;

    public HashMap() {
        table = new Entry[this.size];
    }

    public int hash(K key) {
        if (key == null) {
            return 0; 
        }
        String stringKey = key.toString().toLowerCase(); 
        char firstUnameChar = stringKey.charAt(0);
        int alphabetIndexOrder = firstUnameChar - 'a' + 1; 

        if (alphabetIndexOrder < 1 || alphabetIndexOrder > 26) {
            return 0;
        }

        return Math.abs(alphabetIndexOrder % size); 
    }



    public void put(K key, V value) {
        int hashKey = hash(key);
        Entry<K, V> entry = table[hashKey];

        if (entry == null) {
            table[hashKey] = new Entry<>(key, value);
        } else {
            while (entry.next != null) {
                if (entry.getKey().equals(key)) {
                    entry.setValue(value);
                    return;
                }
                entry = entry.next;
            }

            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }

            entry.next = new Entry<>(key, value);
        }
        
    }
    public Entry<K, V> remove(K key) {
        int hashKey = hash(key);
        Entry<K, V> entry = table[hashKey];

        if (entry == null) {
            return null;
        }

        if (entry.getKey().equals(key)) {
            table[hashKey] = entry.next;
            entry.next = null;
            return entry;
        }

        Entry<K, V> prev = entry;

        while (entry != null) {
            if (entry.getKey().equals(key)) {
                prev.next = entry.next;
                entry.next = null;
                return entry;
            }
            prev = entry;
            entry = entry.next;
        }

        return null;
    }

    public void get(K key) {
        int hashKey = hash(key);
        Entry<K, V> entry = table[hashKey];
    
        while (entry != null) {
            if (entry.getKey().equals(key)) {
                System.out.println(entry.getValue());
                return;
            }
            entry = entry.next;
        }
    
        System.out.println("null");
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print("-- " + i + ": ");
            Entry<K, V> entry = table[i];
            while (entry != null) {
                System.out.print("(" + entry.getKey() + ", " + entry.getValue() + ") ");
                entry = entry.next;
            }
            System.out.println();
        }
    }
}


public class HashPass {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        HashMap<String, String> db = new HashMap<String, String>();

        int req = s.nextInt();
        s.nextLine();
        String account;
        String username;
        String password;

        for (int i = 0; i < req; i++) {
            account = s.nextLine();
            String[] splitted = account.split(" ");
            username = splitted[1];
            password = splitted[2];

            if (splitted[0].equals("put")) { 
                db.put(username, password);
            } else if (splitted[0].equals("print")) {
                db.print();
            }else if (splitted[0].equals("get")){
                db.get(username);
            }else if (splitted[0].equals("remove")){
                db.remove(username);
            }
        }
        s.close();
    }
}
