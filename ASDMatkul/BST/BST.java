package BST;

public class BST {
    Node root;

    public void insert(Node nodebaru){

        if(root == null){
            root = nodebaru;
        }
        else{
            Node temp = root;
            Node parent = temp;
            while(temp != null){
                parent = temp;
                if(nodebaru.data <= temp.data){
                    temp = temp.aki;
                }else{
                    temp = temp.aka;
                }
            }
            if(nodebaru.data <= parent.data){
                parent.aki = nodebaru;
                nodebaru.parent = parent;
            }else{
                parent.aka = nodebaru;
                nodebaru.parent = parent;
            }
        }

        

    }

    public void inorder(Node node){
        if(node != null){
            inorder(node.aki);
            System.out.print(node.data + " ");
            inorder(node.aka);
        }
    }

    public void search (Node root, int key){
        Node temp = root;
        while(temp!= null){
            if(key == temp.data){
                System.out.println("key "+ key +" Ketemu");
                break;
            }
            else{
                if (key<=temp.data){
                    temp = temp.aki;
                }
                else{
                    temp = temp.aka;
                }
            }
            if (temp == null){
                System.out.println("Tidak ketemu mas");
            }
        }
    }

    
}
