import java.util.Scanner;

class Node {
    String nama;
    Node after, before = null;
    float ipk;

    Node() {

    }

    Node(String nama, float ipk) {
        this.nama = nama;
        this.ipk = ipk;
    }
}

class QueueLL {
    Node head;
    Node tail;
    int size;
    int num;

    boolean isEmpty() {
        return head == null && tail == null;
    }

    int getSize() {
        return this.size;
    }

    void addQueue(String nama, float ipk) {
        Node newNode = new Node(nama, ipk);
        Node temp = head;

        if (isEmpty()) {
            head = tail = newNode;

        } else if (getSize() == 1) {

            if (newNode.ipk > head.ipk) {
                newNode.after = head;
                head = newNode;

            } else {
                tail.after = newNode;
                tail = newNode;
            }

        } else {

            if (newNode.ipk > head.ipk) {
                newNode.after = head;
                head = newNode;

            } else if (newNode.ipk < tail.ipk) {
                tail.after = newNode;
                tail = newNode;

            } else {

                while (temp.after != null && temp.after.ipk >= newNode.ipk) {
                    temp = temp.after;
                }
                newNode.after = temp.after;
                temp.after = newNode;
            }
        }
        size++;

    }

    void print() {
        Node temp = head;
        for (int i = 0; i < getSize(); i++) {
            System.out.println((++num) + ". " + temp.nama + " (" + temp.ipk + ")");
            temp = temp.after;
        }
    }
}

public class IPKDuel {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        QueueLL queue = new QueueLL();

        int req = s.nextInt();
        s.nextLine();

        String command = "";
        String[] splitted = new String[3];

        for (int i = 0; i < req; i++) {
            command = s.nextLine();
            splitted = command.split(" ");

            String nama = splitted[0];
            float ipk = Float.parseFloat(splitted[1]);
            int sertif = Integer.parseInt(splitted[2]);

            if (sertif == 0) {
                ipk += 0f;
            } else if (sertif == 1) {
                ipk += 0.2f;
            }

            queue.addQueue(nama, ipk);
        }
        queue.print();
        s.close();
    }

}