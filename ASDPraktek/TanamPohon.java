
import java.util.*;


class Node<T> {
     Node <T> left,right;
    T data;

    Node(T data){
        this.data = data;
    }

  
}

class Queue<T> {
    Node<T> front,rear;
    int size = 0;

    boolean isEmpty(){
        return front == null && rear == null;
    }
    public void enqueue(T data){
        Node<T> newNode = new Node<> (data);
        if(isEmpty()){
         front = rear = newNode;
        }else{
            newNode.left = rear;
            rear.right = newNode;
            rear = newNode;
        }
        size++;
    }
    
    public T dequeue(){
        try{
            T temp;
            if (front == rear){
                temp = front.data;
                front = rear = null;
                
            }else{
                temp = front.data;
                front = front.right;
                front.left = null;
                
            }
            size--;
            return temp;
        }catch (NullPointerException e){
            return null;
        }
    }

}

class CompleteBinaryTree<T> {
    Node <T> root;
    int size = 0;

    boolean isEmpty(){
        return root == null;
    }

    void insert(T data){
        Node <T> newNode = new Node<>(data);
        if(isEmpty()){
            root = newNode;
        }else{
            Node<T> pointer;
            Queue<Node<T>> queue = new Queue<>();
            queue.enqueue(root);
            while(!queue.isEmpty()){
                pointer = queue.dequeue();
                if (pointer.left == null){
                    pointer.left = newNode;
                    return;
                }else{
                    queue.enqueue(pointer.left);
                }
                if(pointer.right == null){
                    pointer.right = newNode;
                    return;
                }else{
                    queue.enqueue(pointer.right);
                }
            }
        }
    }
    
    void printCBT(){
        printCBTRec(root,0);
        
    }
    private void printCBTRec(Node<T> curr, int branch){
        for(int i = 0; i < branch; i++){
            System.out.print("--");
        }
        
        System.out.println(curr.data);
        
        if(curr.left != null){
            printCBTRec(curr.left, branch+1);
            
        }
        
        if(curr.right != null){
            printCBTRec(curr.right, branch+1);
           
        }
        
    }
}

public class TanamPohon {

    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
      
         CompleteBinaryTree CBT = new CompleteBinaryTree();

          
          String command = ""; 
          String[] splitted = new String[2];
          while(true){
              command = sc.nextLine();
              splitted = command.split(" ");
  
              if (splitted[0].toLowerCase().equals("insert")) {
                CBT.insert(splitted[1]);
              } else if (command.equals("print")) {
                CBT.printCBT();
                break;
              }
        }sc.close();
    }
}