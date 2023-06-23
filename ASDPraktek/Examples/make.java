package Examples;

import java.util.Scanner;

class NodeCSLL {
    NodeCSLL next;
    String data;

    NodeCSLL() {
    }

    NodeCSLL(String namaInput) {
        this.data = namaInput;

    }
}

class CSLL {
    NodeCSLL head;
    NodeCSLL tail;
    int size;
    NodeCSLL balon;

    boolean isEmpty() {
        return head == null && tail == null;
    }

    int getSize() {
        return size;
    }

    void addFirst(String newData) {
        NodeCSLL newNode = new NodeCSLL(newData);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
        size++;
        balon = newNode;
    }

    void addLast(String newData) {
        NodeCSLL newNode = new NodeCSLL(newData);
        NodeCSLL temp = head;
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        balon = newNode;
    }

    void printList() {
        NodeCSLL temp = head.next;
        if (isEmpty()) {
            System.out.println("List masih kosong.");
        } else if (getSize() == 1) {
            System.out.println(temp.data + " -> ");
        } else {
            System.out.print(head.data + " -> ");
            while (temp != head) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("");
        }
    }

    void balloonPass() {
        if (isEmpty()) {
            System.out.println("List masih kosong.");
        } else if (getSize() == 1) {
            System.out.println("Tidak bisa oper.");
        } else {
            balon = balon.next;
        }
    }

    void balloonLocation() {
        if (isEmpty()) {
            System.out.println("List masih kosong.");
        } else {
            System.out.println("Balon ada pada " + balon.data + ".");
        }
    }

    void balloonExplode() {
        if (isEmpty()) {
            System.out.println("List masih kosong.");
        } else {
            System.out.println("Boom! " + balon.data + " kalah.");

            System.exit(0);
        }
    }
}

public class make {
    public static void main(String[] args) {
        CSLL list = new CSLL();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String command = "";
        String[] splitted = new String[2];
        for (int i = 0; i < n; i++) {
            command = sc.nextLine();
            splitted = command.split(" ");

            if (splitted[0].toLowerCase().equals("addfirst")) {
                list.addFirst(splitted[1]);

            } else if (splitted[0].toLowerCase().equals("addlast")) {
                list.addLast(splitted[1]);

            } else if (splitted[0].toLowerCase().equals("print")) {
                list.printList();

            } else if (splitted[0].toLowerCase().equals("balloon")) {
                if (splitted[1].toLowerCase().equals("loc")) {
                    list.balloonLocation();
                } else if (splitted[1].equals("pass")) {
                    list.balloonPass();

                } else if (splitted[1].toLowerCase().equals("boom")) {
                    list.balloonExplode();

                }
            }
        }
    }
}