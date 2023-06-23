import java.util.Scanner;

class Node {
    String data;
    Node next;
    Node(){}
    
    Node(String input){
        this.data= input;
        this.next= null;
    }
}

class SLL {
    Node head;
    Node tail;
    int size;
  
    boolean isEmpty() {
        return head == null && tail == null;
    }

    int getSize() {
        return this.size;
    }
  
    void addLast(String input) {
        Node newNode = new Node(input);
        if (isEmpty()){
            head = tail = newNode; 
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        this.size++;
    }
  
  	void addFirst(String input) {
        Node newNode = new Node(input);
        if (isEmpty()){
            head = tail = newNode; 
        }else{
            newNode.next = head;
            head = newNode;
        }
        this.size++;
    }

    void removeFirst(){
        if (isEmpty()) {
            System.out.println("List masih kosong.");
        } else {
            head = head.next;
            this.size--;
            if (head == null) {
                tail = null;
            }
        }
    }
    
    void removeLast(){
        if (isEmpty()) {
            System.out.println("List masih kosong.");
        } 
        else if(getSize() == 1){
            head = tail = null;
            this.size--;
        }
        else {
            Node pointer = head;
            while(pointer.next != tail){
                pointer = pointer.next;
            }
            tail = pointer;
            tail.next = null;
            this.size--;
        }
    }
    
  
    void printList(){
        if (isEmpty()){
            System.out.println("List masih kosong.");
        }else{
            Node pointer = head;
            while(pointer != null){
                System.out.print(pointer.data+" -> ");
                pointer = pointer.next;
            }
             System.out.println();
        }
    }
}

public class MogaSLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      
      	SLL list = new SLL();

          int n = sc.nextInt(); // jumlah loop/input yg mau dimasukkan
          sc.nextLine(); // consume new line, tanya chatGPT aja kalo gatau
  
          String command = ""; // -> digunakan untuk input, misal : "MAKAN JAGUNG"
          String[] splitted = new String[2]; // -> split dari command, akan berisi [MAKAN, JAGUNG]
          for (int i = 0; i < n; i++) {
              command = sc.nextLine();
              splitted = command.split(" ");
  
              if (splitted[0].toLowerCase().equals("addfirst")) {
                list.addFirst(splitted[1]);
              } else if (splitted[0].toLowerCase().equals("addlast")) {
                list.addLast(splitted[1]);
              } else if (splitted[0].toLowerCase().equals("print")) {
                list.printList();
              } else if (splitted[0].toLowerCase().equals("remove")) {
                  if (splitted[1].toLowerCase().equals("last")) {
                    list.removeLast();
                  } else if (splitted[1].toLowerCase().equals("first")) {
                    list.removeFirst();
                  }
              }
          }sc.close();
      }
  }