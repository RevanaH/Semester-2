package BST;

public class display {
    public static void main(String[] args) {
        BST pohon = new BST();

        Node n1 = new Node(40);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(80);
        Node n5 = new Node(60);
        Node n6 = new Node(50);
        Node n7 = new Node(25);

        pohon.insert(n1);
        pohon.insert(n2);
        pohon.insert(n3);
        pohon.insert(n4);
        pohon.insert(n5);
        pohon.insert(n6);
        pohon.insert(n7);
        pohon.inorder(pohon.root);
        System.out.println();
        pohon.search(pohon.root, 80);


        
    }
    
}
