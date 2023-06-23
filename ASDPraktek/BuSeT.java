import java.util.*;

class Node {
    Node left, right;
    int data;
    Node parent;

    Node() {

    }

    Node(int data) {
        this.data = data;
    }
}

class BinarySearchTree {
    Node root;

    boolean isEmpty() {
        return root == null;

    }

    void insert(int data) {
        if (isEmpty()) {
            root = new Node(data);
        } else {
            root = insertRec(root, data);
        }
    }

    Node insertRec(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    void Recprintorder(Node root) {
        // if (isEmpty()) {
        //     System.out.println("Tree Kosong");
        //     return;
        // }
        if (root != null) {
            Recprintorder(root.left);
            System.out.print(root.data + " ");
            Recprintorder(root.right);
        }

    }

    void Recprentorder(Node root) {
        // if (isEmpty()) {
        //     System.out.println("Tree Kosong");
        //     return;
        // }
        if (root != null) {
            System.out.print(root.data + " ");
            Recprentorder(root.left);
            Recprentorder(root.right);
        }

    }

    void Recpostntorder(Node root) {
        // if (isEmpty()) {
        //     System.out.println("Tree Kosong");
        //     return;
        // }
        if (root != null) {
            Recpostntorder(root.left);
            Recpostntorder(root.right);
            System.out.print(root.data + " ");
        }

    }

    void printorder() {
        Recprintorder(root);
        System.out.println();
    }

    void prentorder() {
        Recprentorder(root);
        System.out.println();
    }

    void postntorder() {
        Recpostntorder(root);
        System.out.println();

    }

    void search(int data) {
        if (search(root, data)) {
            System.out.println(data + " ada di dalam tree");
        } else {
            System.out.println(data + " tidak ada di dalam tree");
        }

    }

    boolean search(Node root, int data) {
        Node temp = root;
        if (temp == null) {
            return false;
        }
        if (data == temp.data) {
            return true;
        }
        else if (data < temp.data) {
            // temp = temp.left;
            return search(temp.left, data);
        } else if (data > temp.data) {
            // temp = temp.right;
            return search(temp.right, data);
        }

        return false;
    }

    public void successor() {
        int temp = successor(root);
        if (temp == 1) {
            System.out.println("0");
        } else {
            System.out.println(temp);
        }

    }

    public void predecessor() {
        int temp = predecessor(root);
        if (temp == 1) {
            System.out.println("0");
        } else {
            System.out.println(temp);
        }

    }

    public int successor(Node root) {
        // if (root == null) {
        // System.out.println("0");
        // return 0;
        // }
        // if(root.right == null){
        // System.out.println("0");
        // return 0;
        // }
        if (root.right != null) {
            root = root.right;
            while (root.left != null) {
                root = root.left;
            }
            return root.data;
        }
        return 1;
    }

    // Node ancestor = null;
    // Node current = root;
    // while (current != null && current != ancestor) {
    // if (current.data < root.data) {
    // ancestor = current;
    // current = current.right;
    // } else {
    // current = current.left;
    // }
    // }
    // return ancestor.data;
    // }

    public int predecessor(Node root) {
        // if (root == null) {
        // System.out.println("0");
        // return 0;
        // }
        // if(root.left == null){
        // while (root.right != null) {
        // root = root.right;
        // }
        // return root.data;
        // }

        if (root.left != null) {
            root = root.left;
            while (root.right != null) {
                root = root.right;
            }
            return root.data;

        }
        return 1;
        // Node ancestor = null;
        // Node current = root;
        // while (current != null && current != ancestor) {
        // if (current.data > root.data) {
        // ancestor = current;
        // current = current.left;
        // } else {
        // current = current.right;
        // }
        // }
        // return ancestor.data;

    }

    public int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    public int maxValue(Node root) {
        int maxValue = root.data;
        while (root.right != null) {
            maxValue = root.right.data;
            root = root.right;
        }
        return maxValue;
    }

    public void trim(int data) {
        if (search(root, data)) {
            root = trimming(root, data);
            System.out.println(data + " berhasil dihapus");
        } else {
            System.out.println(data + " tidak ada di dalam tree");
        }
    }

    Node trimming(Node root, int data) {
        if (root == null) {
            return root;
        }
        if (data > root.data) {
            root.right = trimming(root.right, data);
        } else if (data < root.data) {
            root.left = trimming(root.left, data);
        } else {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right != null) {
                root.data = successor(root);
                root.right = trimming(root.right, root.data);
            } else {
                root.data = predecessor(root);
                root.left = trimming(root.left, root.data);
            }
            // } else if (root.left != null) {
            // root.data = successor(root);
            // root.left = trimming(root.left, root.data);

            // } else {
            // root.data = predecessor(root);
            // root.right = trimming(root.right, root.data);
            // }
        }
        return root;
    }

    // public Node trimming(Node root, int data) {

    // if (root == null) {
    // return root;
    // }

    // if (data < root.data) {
    // root.left = trimming(root.left, data);
    // } else if (data > root.data) {
    // root.right = trimming(root.right, data);
    // } else {

    // if (root.left == null) {
    // return root.right;
    // } else if (root.right == null) {
    // return root.left;
    // }
    // root.data = minValue(root.right);
    // root.right = trimming(root.right, root.data);
    // }
    // return root;
    // }

}

public class BuSeT {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        BinarySearchTree bst = new BinarySearchTree();

        int req = s.nextInt();
        s.nextLine();

        for (int i = 0; i < req; i++) {
            int val = s.nextInt();
            bst.insert(val);
        }
        s.nextLine();

        String command = "";
        String[] splitted = new String[2];
        while (s.hasNextLine()) {
            command = s.nextLine();
            splitted = command.split(" ");

            if (splitted[0].toLowerCase().equals("search")) {
                bst.search(Integer.parseInt(splitted[1]));
            } else if (splitted[0].toLowerCase().equals("delete")) {
                bst.trim(Integer.parseInt(splitted[1]));
            } else if (command.equals("inorder")) {
                if(bst.isEmpty()){
                    System.out.println("Tree Kosong");
                }else{
                bst.printorder();
                }
            } else if (command.equals("postorder")) {
                if(bst.isEmpty()){
                    System.out.println("Tree Kosong");
                }else{
                bst.postntorder();
                }
            } else if (command.equals("preorder")) {
                if(bst.isEmpty()){
                    System.out.println("Tree Kosong");
                }else{
                bst.prentorder();
                }
            } else if (command.equals("successor")) {
                bst.successor();
                // System.out.println(bst.successor(bst.root));
            } else if (command.equals("predecessor")) {
                bst.predecessor();
                // System.out.println(bst.predecessor(bst.root));
            }
        }
        s.close();
    }
}