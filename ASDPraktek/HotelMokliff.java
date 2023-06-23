import java.util.Scanner;

public class HotelMokliff {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int time = s.nextInt();
        s.nextLine();
        int vehicle = s.nextInt();
        s.nextLine();

        Mobil cars = new Mobil();
        Motor Mcycle = new Motor();

        String command = "";
        String[] splitted = new String[3];
        for (int i = 0; i < vehicle; i++) {
            command = s.nextLine();
            splitted = command.split(" ");
            if (splitted[0].equals("mobil")) {
                cars.masuk(splitted[1], Integer.parseInt(splitted[2]));
            } else if (splitted[0].equals("motor")) {
                Mcycle.masuk(splitted[1], Integer.parseInt(splitted[2]));
            }
        }

        System.out.println("Kendaraan selamat : ");
        cars.cek_selamat(time);
        Mcycle.cek_selamat(time);
        System.out.println();
        System.out.println("Kendaraan tertimbun : ");
        cars.cek_timbun();
        Mcycle.cek_timbun();
        System.out.println();
        System.out.print("Total korban tertimbun sebanyak " + (cars.trapped + Mcycle.trapped) + " orang.");

        s.close();
    }
}

class Node {
    Node next;
    String LPlate;
    int priority;

    Node(String data1, int data2) {
        this.LPlate = data1;
        this.priority = data2;
        this.next = null;
    }

    Node(String data1, int data2, Node next) {
        this.LPlate = data1;
        this.priority = data2;
        this.next = next;
    }
}

class Mobil {
    Node top;
    int trapped = 0;

    boolean isEmpty() {
        return top == null;
    }

    void masuk(String LPlate, int passanger) {
        Node newNode = new Node(LPlate, passanger, top);
        top = newNode;
    }

    void keluar() {
        if (isEmpty()) {
            return;
        } else {
            top = top.next;
        }
    }

    void cek_selamat(int durasi) {
        String inside = "";

        if (isEmpty()) {
            System.out.println("Tidak ada mobil di dalam basement.");
        } else {
            while (top != null && durasi != 0) {
                inside = inside + top.LPlate + ", ";
                keluar();
                durasi--;
            }
            System.out.println("Mobil dengan plat nomor " + inside + "berhasil keluar dengan selamat.");
            if (isEmpty()) {
                System.out.println("Semua mobil berhasil keluar dengan selamat.");
            }

        }

    }

    void cek_timbun() {
        String inside = "";

        if (isEmpty()) {
            System.out.println("Tidak ada mobil yang tertimbun.");
        } else {
            Node pointer = top;
            while (pointer != null) {
                trapped += pointer.priority;
                inside = inside + pointer.LPlate + ", ";
                pointer = pointer.next;
            }

            System.out.println("Mobil dengan plat nomor: " + inside + "masih tertimbun reruntuhan.");
        }
    }

}

class Motor {
    Node front, rear;
    int size;
    int trapped = 0;

    boolean isEmpty() {
        return front == null && rear == null;
    }

    void masuk(String LPlate, int cc) {
        Node newNode = new Node(LPlate, cc);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            Node pointer = front;
            if (newNode.priority > front.priority) {
                newNode.next = front;
                front = newNode;
            } else if (newNode.priority == front.priority) {
                newNode.next = front.next;
                front.next = newNode;
            } else if (rear.priority > newNode.priority) {
                rear.next = newNode;
                rear = newNode;
            } else if (newNode.priority > rear.priority) {
                Node prefRear = front;
                while (prefRear.next != rear) {
                    prefRear = prefRear.next;
                }
                newNode.next = rear;
                prefRear.next = newNode;
            } else {
                while (pointer.next.priority > newNode.priority && pointer.next != null) {
                    pointer = pointer.next;
                }

                if (newNode.priority == pointer.next.priority) {
                    pointer = pointer.next;
                    while (pointer.priority == newNode.priority && pointer.next != null) {
                        pointer = pointer.next;
                    }

                    newNode.next = pointer.next;
                    pointer.next = newNode;
                } else {
                    newNode.next = pointer.next;
                    pointer.next = newNode;
                }

            }

        }
        size++;
    }

    Node keluar() {
        Node temp;
        if (isEmpty()) {
            return null;
        } else {
            temp = front;
            front = front.next;
        }
        size--;
        return temp;

    }

    void cek_selamat(int durasi) {
        String inside = "";

        if (isEmpty()) {
            System.out.println("Tidak ada motor di dalam basement.");
        } else {
            while (durasi != 0 && front != null) {
                inside = inside + front.LPlate + ", ";
                keluar();
                durasi--;
            }
            System.out.println("Motor dengan plat nomor " + inside + "berhasil keluar dengan selamat.");
            if (this.size == 0) {
                System.out.println("Semua motor berhasil keluar dengan selamat.");
            }

        }
    }

    void cek_timbun() {
        Mobil reverse = new Mobil();
        String inside = "";

        if (this.size == 0) {
            System.out.println("Tidak ada motor yang tertimbun.");
        } else {
            Node pointerst = front;
            while (pointerst != null) {
                reverse.masuk(pointerst.LPlate, pointerst.priority);
                pointerst = pointerst.next;
            }
            Node pointernd = reverse.top;
            while (pointernd != null) {
                trapped++;
                inside = inside + pointernd.LPlate + ", ";
                pointernd = pointernd.next;
            }

            System.out.println("Motor dengan plat nomor: " + inside + "masih tertimbun reruntuhan.");
        }
    }

}