package Examples;


class Node<T>{
    Node <T> left,right;
    T data;

    Node(T data){
        this.data = data;
    }

}

class TreeQueue<T>{
    Node<T> front,rear;
    int size;

    boolean isEmpty(){
        return front == null || rear == null;
    }
    void enqueue(T data){
        Node<T> newNode = new Node<> (data);
        if(isEmpty()){
         front=rear=newNode;

        }else{
            newNode.left = rear;
            rear.right = newNode;
        }
        size++;


    }
    T dequeue(){
        try{
            T returnValue;
            if (front == rear){
                returnValue = front.data;
                front = rear = null;
            }else{
                returnValue = front.data;
                front = front.right;
                front.right.left = null;
                front.left = null;
            }
            size--;
            return returnValue;
        }catch (NullPointerException e){
            return null;
        }
    }

}
class CompleteBinaryTree<T>{
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
            TreeQueue<Node<T>> queue = new TreeQueue<>();
            queue.enqueue(root);
            while(!queue.isEmpty()){
                pointer = queue.dequeue();

                if (pointer.left == null){
                    pointer.left = newNode;
                    return;
                }else{
                    queue.enqueue(pointer);
                }
                if(pointer.right == null){
                    pointer.right = newNode;
                    return;
                }else{
                    queue.enqueue(pointer);
                }
            }
        }
    }

}

class BSTNode{
    BSTNode left,right;
    int data;

    BSTNode(int data){
        this.data = data;
    }
    BSTNode(){}

}

class BSTCuyh{
    BSTNode root;

    boolean isEmpty(){
        return root == null;
    }
    void insert (int data){
        if (isEmpty()){
            root = new BSTNode(data);
        }else{
            insertRec(data,root);
        }
    }
    void insertRec(int data , BSTNode currentNode){
        if(data < currentNode.data){
            if(currentNode.left == null){
                currentNode.left = new BSTNode(data);
            }else{
                insertRec(data, currentNode.left);

            }

        }else if(data > currentNode.data){
            if(currentNode.right == null){
                currentNode.right = new BSTNode(data);

            }else{
                insertRec(data, currentNode.right);
            }
        }else{
            System.out.println("Data sudah ada");
        }

    }
    void printPreOrder(){
        if(isEmpty()){
            System.out.println("Kosong");
        }else{
            printPreOrderRec(root);
        }

    }
    private void printPreOrderRec(BSTNode currentNode){
        if(currentNode != null){
            System.out.println(currentNode.data);
            printPreOrderRec(currentNode.left);
            printPreOrderRec(currentNode.right);
        }

    }
}

// class MyTreeNode<T>{
//     MyTreeNode<T> left,right;
//     T data;

//     MyTreeNode(T data){
//         this.data = data;
//     }
// }

// class BinarySearchTree<T>{
//     MyTreeNode<T> root;
//     int size = 0;

//     boolean isEmpty(){
//         return root == null;

//     }
//     void insert(int data){
//         if(isEmpty()){
//             root = new BSTNode(data);
//         }else{
//             insertRec(data, root);
//         }

//     }
//     private void insertRec(T data, MyTreeNode<T> currentNode){
//         if(data < currentNode.data){
//             if(currentNode.left == null){
//                 currentNode.left = new BSTNode(data);

//             }else{
//                 insertRec(data, currentNode.left);

//             }

//         }else if(data > currentNode.data){
//             if(currentNode.right == null){
//                 currentNode.right = new BSTNode(data);

//             }else{
//                 insertRec(data, currentNode.right);
//             }
//         }else{
//             System.out.println("Data sudah ada");
//         }

//     }

//     void printPreaOrder(){
//         if(isEmpty()){
//             System.out.println("Kosong");
//         }else{
//             printPreOrderRec(root);
//         }

//     }
//     private void printPreOrderRec(BSTNode currentNode){
//         if(currentNode != null){
//             System.out.println(currentNode.data);
//             printPreOrderRec(currentNode.left);
//             printPreOrderRec(currentNode.right);
//         }

//     }

//}

public class Tree {
    public static void main(String[] args) {
        BSTCuyh tree = new BSTCuyh();
        tree.insert(10);
        tree.insert(20);
        tree.insert(3);
        tree.insert(5);
        tree.printPreOrder();
        
    }
    
}
