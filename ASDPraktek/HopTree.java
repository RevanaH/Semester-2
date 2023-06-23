import java.util.Scanner;

class NodeQueue<T> {
    NodeQueue<T> left, right;
    T data;

    public NodeQueue(T data) {
        this.data = data;
    }

}

class NodeHeap {
    NodeHeap right, left, parent;
    int data;

    NodeHeap() {
    }

    NodeHeap(int newData) {
        this.data = newData;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}

class Queue<T> {
    NodeQueue<T> fwd, bwd;
    int size = 0;

    boolean isEmpty() {
        return fwd == null || bwd == null;
    }

    void enqueue(T data) {
        NodeQueue<T> newNode = new NodeQueue<>(data);
        if (isEmpty()) {
            fwd = bwd = newNode;
        } else {
            newNode.left = bwd;
            bwd.right = newNode;
            bwd = newNode;
        }
        size++;

    }

    T dequeue() {
        try {
            T returnValue;
            if (fwd == bwd) {
                returnValue = fwd.data;
                fwd = bwd = null;
            } else {
                returnValue = fwd.data;
                fwd = fwd.right;
                fwd.left.right = null;
                fwd.left = null;
            }
            size--;
            return returnValue;
        } catch (NullPointerException e) {
            return null;
        }
    }

    T peek() {
        try {
            return fwd.data;

        } catch (Exception e) {
            return null;
        }
    }

}

class Heap {
    NodeHeap root;
    int size = 0;

    boolean isEmpty() {
        return root == null;
    }

    void insert(int data) {
        NodeHeap newNode = new NodeHeap(data);
        if (isEmpty()) {
            root = newNode;
        } else {
            NodeHeap pointer;
            Queue<NodeHeap> queue = new Queue<>();
            queue.enqueue(root);
            while (!queue.isEmpty()) {
                pointer = queue.dequeue();
                if (pointer.left == null) {
                    pointer.left = newNode;
                    newNode.parent = pointer;
                    break;
                } else {
                    queue.enqueue(pointer.left);
                }
                if (pointer.right == null) {
                    pointer.right = newNode;
                    newNode.parent = pointer;
                    break;
                } else {
                    queue.enqueue(pointer.right);
                }
            }
        }
        maxHeapify(newNode);
    }

    private void maxHeapify(NodeHeap node) {
        if (node == this.root) {
            return;
        } else {
            if (node.data > node.parent.data) {
                int temp = node.parent.data;
                node.parent.data = node.data;
                node.data = temp;
                maxHeapify(node.parent);
            } else {
                return;
            }
        }
    }

    void Recprintorder(NodeHeap currNode, int indent) {
        if (currNode == null) {
            return;
        }

        Recprintorder(currNode.left, indent + 1);
        for (int i = 0; i < indent; i++) {
            System.out.print("--");

        }
        System.out.println(currNode.data);
        Recprintorder(currNode.right, indent + 1);

    }

    void Recprentorder(NodeHeap currNode, int indent) {
        if (currNode == null) {
            return;
        }
        for (int i = 0; i < indent; i++) {
            System.out.print("--");

        }
        System.out.println(currNode.data);
        Recprentorder(currNode.left, indent + 1);
        Recprentorder(currNode.right, indent + 1);

    }

    void Recpostntorder(NodeHeap currNode, int indent) {
        if (currNode == null) {
            return;
        }

        Recpostntorder(currNode.left, indent + 1);
        Recpostntorder(currNode.right, indent + 1);
        for (int i = 0; i < indent; i++) {
            System.out.print("--");

        }
        System.out.println(currNode.data);

    }

    void printorder() {
        Recprintorder(root, 0);
    }

    void prentorder() {
        Recprentorder(root, 0);
    }

    void postntorder() {
        Recpostntorder(root, 0);

    }

    void reroote(NodeHeap roote) {
        // NodeHeap route = root;
        int twig;
        if (roote == this.root) {
            if (roote.data > roote.left.data && roote.data > roote.right.data) {// lebih kecil daripada node-node di bawahnya
                return;
            }
        }
        if (roote.left != null && roote.right != null) {
            if (roote.right.data > roote.data && roote.left.data < roote.right.data) {
                twig = roote.right.data;
                roote.right.data = roote.data;
                roote.data = twig;
                reroote(roote.right);
            } else {
                twig = roote.left.data;
                roote.left.data = roote.data;
                roote.data = twig;
                reroote(roote.left);
            }
        } else if (roote.left != null) {
            if (roote.left.data > roote.data) {
                twig = roote.left.data;
                roote.left.data = roote.data;
                roote.data = twig;
                reroote(roote.left);
            }
        }
    }
}

public class HopTree {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Heap hp = new Heap();

        int req = s.nextInt();
        s.nextLine();

        String command = "";
        String[] splitted = new String[2];
        for (int i = 0; i < req; i++) {
            command = s.nextLine();
            splitted = command.split(" ");

            if (splitted[0].toLowerCase().equals("insert")) {
                hp.insert(Integer.parseInt(splitted[1]));
            }
            if (splitted[0].toLowerCase().equals("newroot")) {
                int rooter = Integer.parseInt(splitted[1]);
                hp.root.data = rooter;
                hp.reroote(hp.root);
                // hp.reroote(new NodeHeap(Integer.parseInt(splitted[1])));
                // int newRoot = Integer.parseInt(splitted[1]);
                // NodeHeap roote = new NodeHeap(newRoot);
                // hp.insert(newRoot);
                // hp.reroote(roote);
            }
            if (splitted[0].toLowerCase().equals("print")) {
                if (splitted[1].equals("inorder")) {
                    if (hp.isEmpty()) {
                        System.out.println("Hasil in-order:");
                        System.out.println("Heap masih kosong.");
                    } else {
                        System.out.println("Hasil in-order:");
                        hp.printorder();
                    }
                } else if (splitted[1].equals("postorder")) {
                    if (hp.isEmpty()) {
                        System.out.println("Hasil post-order:");
                        System.out.println("Heap masih kosong.");
                    } else {
                        System.out.println("Hasil post-order:");
                        hp.postntorder();
                    }
                } else if (splitted[1].equals("preorder")) {
                    if (hp.isEmpty()) {
                        System.out.println("Hasil pre-order:");
                        System.out.println("Heap masih kosong.");
                    } else {
                        System.out.println("Hasil pre-order:");
                        hp.prentorder();
                    }
                }
            }
        }
        s.close();
    }
}
