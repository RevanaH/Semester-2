// import java.util.Scanner;

// class NodeDLL {
//     String data;
//     NodeDLL prev, next;

//     NodeDLL() {
//     }

//     NodeDLL(String newData) {
//         this.data = newData;
//         this.prev = null;
//         this.next = null;
//     }
// }

// class DLL {
//     NodeDLL head, tail;
//     int size;

//     boolean isEmpty() {
//         return head == null && tail == null;
//     }

//     int getSize() {
//         return this.size;
//     }

//     void addFirst(String newData) {
//         NodeDLL newNode = new NodeDLL(newData);
//         if (isEmpty()) {
//             head = tail = newNode;
//         } else {
//             newNode.next = head;
//             head.prev = newNode;
//             head = newNode;
//         }
//         this.size++;
//     }

//     void addLast(String newData) {
//         NodeDLL newNode = new NodeDLL(newData);
//         if (isEmpty()) {
//             head = tail = newNode;
//         } else {
//             newNode.prev = tail;
//             tail.next = newNode;
//             tail = newNode;
//         }
//         this.size++;
//     }

//     void removeFirst() {
//         if (isEmpty()) {
//             System.out.println("List masih kosong.");

//         } else if (getSize() == 1) {
//             head = tail = null;
//             this.size--;
//         } else {

//             head = head.next;
//             head.prev.next = null;
//             head.prev = null;
//             this.size--;
//         }
//     }

//     void removeLast() {

//         if (isEmpty()) {
//             System.out.println("List masih kosong.");

//         } else if (getSize() == 1) {
//             head = tail = null;
//             this.size--;
//         } else {
//             tail = tail.prev;
//             tail.next.prev = null;
//             tail.next = null;
//             this.size--;
//         }
//     }

//     void printForward() {
//         NodeDLL temp = head;
//         if (isEmpty()) {
//             System.out.println("List masih kosong.");

//         } else {
//             while (temp != null) {
//                 System.out.print(temp.data + " <--> ");
//                 temp = temp.next;
//             }
//             System.out.println();

//         }

//     }

//     void printBackward() {
//         NodeDLL temp = tail;
//         if (isEmpty()) {
//             System.out.println("List masih kosong.");

//         } else {
//             while (temp != null) {
//                 System.out.print(temp.data + " <--> ");
//                 temp = temp.prev;
//             }
//             System.out.println();
//         }
//     }
// }

// public class MogaDLL {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         DLL dll = new DLL();

//         int n = sc.nextInt();
//         sc.nextLine();

//         String command = "";
//         String[] splitted = new String[3];
//         for (int i = 0; i < n; i++) {
//             command = sc.nextLine();
//             splitted = command.split(" ");

//             if (splitted[0].toUpperCase().equals("ADD")) {
//                 if (splitted[1].toUpperCase().equals("FIRST")) {
//                     dll.addFirst(splitted[2]);
//                 } else if (splitted[1].toUpperCase().equals("LAST")) {
//                     dll.addLast(splitted[2]);
//                 }
//             } else if (splitted[0].toUpperCase().equals("PRINT")) {
//                 if (splitted[1].toUpperCase().equals("FWD")) {
//                     dll.printForward();
//                 } else if (splitted[1].toUpperCase().equals("BWD")) {
//                     dll.printBackward();
//                 }
//             } else if (splitted[0].toUpperCase().equals("REMOVE")) {
//                 if (splitted[1].toUpperCase().equals("FIRST")) {
//                     dll.removeFirst();
//                 } else if (splitted[1].toUpperCase().equals("LAST")) {
//                     dll.removeLast();
//                 }
//             }
//         }
//     }
// }
