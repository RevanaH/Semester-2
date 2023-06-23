import java.util.Scanner;

class Node {
    Node next;
    Node prev;
    String song;
    int played;

    Node() {

    }

    public Node(String song, int played) {
        this.song = song;
        this.played = played;
    }
}

class LinkedList {
    Node head;
    Node tail;
    int size;

    boolean isEmpty() {
        return head == null && tail == null;
    }

    void addLast(String song, int played) {
        if (played == 0 || played < 0) {
            return; 
        }

        Node node = new Node(song, played);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        this.size++;
    }

    void BubSort() {
        if (size <= 1) {
            return;
        }

        boolean swapped;
        Node current;
        Node last = null;
        do {
            swapped = false;
            current = head;

            while (current.next != last) {
                if (current.played < current.next.played) {
                    swap(current, current.next);
                    swapped = true;
                }
                current = current.next;
            }
            last = current;
        } while (swapped);
    }

    private void swap(Node node1, Node node2) {
        String tempSong = node1.song;
        int tempPlayed = node1.played;

        node1.song = node2.song;
        node1.played = node2.played;

        node2.song = tempSong;
        node2.played = tempPlayed;
    }

    void PReceptify() {
        System.out.println("=========================================================================");
        System.out.println();
        System.out.println("                              RECEIPTIFY");
        System.out.println("                              This Month");
        System.out.println();
        System.out.println("=========================================================================");
        System.out.println(" NO.  ITEM                                                  TIMES PLAYED");
        System.out.println("-------------------------------------------------------------------------");

        Node Tracks = head;
        int No = 1;
        while (Tracks != null && No <= 10) {
            System.out.printf(" %02d   %-63s %d\n", No, Tracks.song, Tracks.played);
            Tracks = Tracks.next;
            No++;
        }
        if (No <= 10) {
            for (int i = No; i <= 10; i++) {
                System.out.printf(" %02d   %-63s %s\n", i, "-", "-");
            }
        }
    }
}

public class GuSpotify {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        LinkedList tier = new LinkedList();
        int songs = s.nextInt();
        s.nextLine();
        for (int i = 0; i < songs; i++) {
            String track = s.nextLine();
            String[] splits= track.split(" -- ");
            String songer = splits[0];
            int playedTime = Integer.parseInt(splits[1].trim());
            tier.addLast(songer, playedTime);
        }
        s.close();
        tier.BubSort();
        tier.PReceptify();
    }
}
