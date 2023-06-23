import java.util.Scanner;

class NodeDLL {
    String data;
    NodeDLL prev, next;

    NodeDLL() {
    }

    NodeDLL(String newData) {
        this.data = newData;
        this.prev = null;
        this.next = null;
    }
}

class DLL {
    NodeDLL head, tail;
    int size;

    boolean isEmpty() {
        return head == null && tail == null;
    }

    int getSize() {
        return this.size;
    }

    void addFirst(String newData) {
        NodeDLL newNode = new NodeDLL(newData);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        this.size++;
    }

    void addLast(String newData) {
        NodeDLL newNode = new NodeDLL(newData);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        this.size++;
    }

    void removeFirst() {
        if (isEmpty()) {
            System.out.println("List masih kosong.");

        } else if (getSize() == 1) {
            head = tail = null;
            this.size--;
        } else {

            head = head.next;
            head.prev.next = null;
            head.prev = null;
            this.size--;
        }
    }

    void removeLast() {
        if (isEmpty()) {
            System.out.println("List masih kosong.");
        } else if (getSize() == 1) {
            head = tail = null;
            this.size--;
        } else {
            tail = tail.prev;
            tail.next.prev = null;
            tail.next = null;
            this.size--;
        }
    }

    void addAtIndex(int targetIndex, String newData) {
        NodeDLL newNode = new NodeDLL(newData);
        NodeDLL temp;
        temp = head;
        if (isEmpty()) {
            System.out.println("List masih kosong.");
        } else if (targetIndex > getSize()) {
            System.out.println("Index tidak valid.");
        } else if(targetIndex==0){
            addFirst(newData);

        }else if(targetIndex==getSize()){
            addLast(newData);
        }
        else {
            // if (targetIndex <= size / 2) {
                for (int i = 0; i < targetIndex; i++) {
                    temp = temp.next;
                }
            // } else {
            //         temp = tail;
            //         for (int i = size - 1; i > targetIndex; i--) {
            //         temp = temp.prev;
            //      }
            // }
            // newNode.next = temp.next;
            // newNode.prev = temp;
            // temp.next.prev = newNode;
            // temp.next = newNode;
            // size++;
            newNode.next = temp;
            newNode.prev = temp.prev;
            temp.prev.next = newNode;
            temp.prev = newNode;
            this.size++;
        }
    }



    void removeTarget(String targetData) {
        NodeDLL temp;
        temp = head;
        while ( temp != null && !temp.data.equals(targetData)){
        temp = temp.next;
    }
        if(isEmpty()){
            System.out.println("List masih kosong.");
        }else if(temp == head){
            removeFirst();
        }else if(temp == tail){
            removeLast();
        }else{
            if(temp == null){
                System.out.println("Data tidak ada!");
            }else {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                this.size--;

            }
        }
    }
    //     if(!isEmpty()){
    //             while (temp!= null){
    //                 if (temp.data == targetData){
    //                     if(temp == head){
    //                         removeFirst();
    //                         size--;
    //                         break;
    //                     }
    //                     else{
    //                     if(temp.next == null){
    //                         tail = temp.prev;
    //                         tail.next = null;
    //                     }
    //                     else{
    //                         temp.prev.next = temp.next;
    //                         temp.next.prev = temp.prev;
    //                     }
    //                     size--;
    //                     break;
    //                 }
    //             }
    //             temp = temp.next;
    //         }
    //     }else {
    //         System.out.println("Data is empty.");
    //         size--;
    //     }
    // }
        
    void printForward() {
        NodeDLL temp = head;
        if (isEmpty()) {
            System.out.println("List masih kosong.");

        } else {
            while (temp != null) {
                System.out.print(temp.data + " <--> ");
                temp = temp.next;
            }
            System.out.println();

        }

    }

    void printBackward() {
        NodeDLL temp = tail;
        if (isEmpty()) {
            System.out.println("List masih kosong.");

        } else {
            while (temp != null) {
                System.out.print(temp.data + " <--> ");
                temp = temp.prev;
            }
            System.out.println();
        }
    }
}

public class MogaDLL2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DLL dll = new DLL();

        int n = sc.nextInt();
        sc.nextLine();

        String command = "";
        String[] splitted = new String[3];
        for (int i = 0; i < n; i++) {
            command = sc.nextLine();
            splitted = command.split(" ");

            if (splitted[0].toUpperCase().equals("ADD")) {
                if (splitted[1].toUpperCase().equals("FIRST")) {
                    dll.addFirst(splitted[2]);
                } else if (splitted[1].toUpperCase().equals("LAST")) {
                    dll.addLast(splitted[2]);
                }
            } else if (splitted[0].toUpperCase().equals("REMOVE")) {
                if (splitted[1].toUpperCase().equals("FIRST")) {
                    dll.removeFirst();
                } else if (splitted[1].toUpperCase().equals("LAST")) {
                    dll.removeLast();
                } else if (splitted[1].toUpperCase().equals("TARGET")) {
                    dll.removeTarget(splitted[2]);
                }
            } else if (splitted[0].toUpperCase().equals("INDEX")) {
                dll.addAtIndex(Integer.parseInt(splitted[1]), splitted[2]);
            } else if (splitted[0].toUpperCase().equals("PRINT")) {
                if (splitted[1].toUpperCase().equals("FWD")) {
                    dll.printForward();
                } else if (splitted[1].toUpperCase().equals("BWD")) {
                    dll.printBackward();
                }
            }
        }sc.close();
    }
}