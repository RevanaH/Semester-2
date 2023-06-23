package Examples;
class Node{
    String data;
    Node under;

    public Node(String data){
        this.data = data;
    }
    Node(){}
}
class Stack {
    Node top;
    int size = 0;

    boolean isEmpty(){
        return top == null;
    }
    void makeEmpty(){
      top = null;
    }
    void push (String newData){
       Node newNode = new Node(newData);

       if(isEmpty()){
        top  = newNode;

       }else{
        top = newNode;
       }size++;
    }
    String peek(){
        return (isEmpty()) ? "kosong" : top.data;
    }

    String pop(){
        if (isEmpty()){

            return "stack kosong";

        }else{
            String data = top.data;
            top = top.under;
            size--;
            return data;
        }
        
    }
}

class queue{
    Node head, tail;
    int size = 0;

    boolean isEmpty(){
        return head == null;

    }

    void enqueue(String newData){

    }
    String dequeue(){
        return"";
    }
}
public class StackandQueue {
    public static void main(String[] args) {
        
    }

    
}
