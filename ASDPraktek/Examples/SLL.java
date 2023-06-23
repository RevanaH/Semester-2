// package Examples;
// import java.util.*;

// public class SLL {
//     public static void main(String[] args) {
//         Scanner s = new Scanner(System.in);
//         CSinglyList list = new CSinglyList();

//         list.addFirst(0);

//     }
    
// }
// class CNode{
//     int data;
//     CNode next;

//     CNode(){}
//         CNode(int input){
//         this.data= input;
//         this.next= null;
//         }
//     }

// class CSinglyList{
//     CNode head;
//     CNode tail;
//     int size;


// boolean isEmpty (){
//     return head == null && tail == null;
// }

// int getSize(){
//     return this.size;
// }

// void addLast(int inputData){
//     CNode newNode = new CNode(inputData);
//     if (isEmpty()){
//      head = tail = newNode; 
//     }else{
//         tail.next = newNode;
//         tail = newNode;
//     }
//     this.size++;
// }
// void addFirst(int inputData){
//     CNode newNode = new CNode(inputData);
//     if (isEmpty()){
//      head = tail = newNode; 
//     }else{
//         newNode.next = head;
//         head = newNode;
//     }
//     this.size++;
// }

// void removeFirst(){
//     if (isEmpty()) {
//         System.out.println("List Kosong.");
//     } else {
//         head = head.next;
        
//     }
//     this.size--;
// }
// void removeLast(){
//     CNode pointer = new CNode();
//     if (isEmpty()) {
//         System.out.println("List Kosong.");
//     } 
//     else if(getSize() == 1){
//         head = tail = null;
//         this.size--;


//     }
//     else {
//         pointer = head;
//        while(pointer.next != tail){
//         pointer = pointer.next;
//        }
//        tail = pointer;
//        tail.next = null;
        
//     }
//     this.size--;
// }

// void printList(){
//     CNode pointer = new CNode();
//     if (isEmpty()){
//         System.out.println("List Kosong.");

//     }else{
//         pointer = head;
//         while(pointer != null){
//             System.out.print(pointer.data+"-->");
//             pointer = pointer.next;
//         }
//         System.out.println();
//     }
// }
// }
package Examples;
import java.util.*;

public class SLL {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        CSinglyList list = new CSinglyList();

        list.addFirst(0);
        list.addLast(1);
        list.addLast(2);
        list.printList();
        list.removeFirst();
        list.printList();
        list.removeLast();
        list.printList();
    }    
}

class CNode{
    int data;
    CNode next;

    CNode(){}
    
    CNode(int input){
        this.data= input;
        this.next= null;
    }
}

class CSinglyList{
    CNode head;
    CNode tail;
    int size;

    boolean isEmpty (){
        return head == null && tail == null;
    }

    int getSize(){
        return this.size;
    }

    void addLast(int inputData){
        CNode newNode = new CNode(inputData);
        if (isEmpty()){
            head = tail = newNode; 
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        this.size++;
    }
    
    void addFirst(int inputData){
        CNode newNode = new CNode(inputData);
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
            System.out.println("List Kosong.");
        } else {
            head = head.next;
        }
        this.size--;
    }
    
    void removeLast(){
        if (isEmpty()) {
            System.out.println("List Kosong.");
        } 
        else if(getSize() == 1){
            head = tail = null;
        }
        else {
            CNode pointer = head;
            while(pointer.next != tail){
                pointer = pointer.next;
            }
            tail = pointer;
            tail.next = null;
        }
        this.size--;
    }

    void printList(){
        if (isEmpty()){
            System.out.println("List Kosong.");
        }else{
            CNode pointer = head;
            while(pointer != null){
                System.out.print(pointer.data+"-->");
                pointer = pointer.next;
            }
            System.out.println();
        }
    }
}