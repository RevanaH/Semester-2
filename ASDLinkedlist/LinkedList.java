
public class LinkedList {

    Node kepala;
    Node ekor;
    int size;

    public LinkedList(){
        kepala = null;
        ekor = null;
        size = 0;

    }
    public void addLast(int nilai){
        Node nodeTemp = new Node();
        nodeTemp.data = nilai;

        addLast (nodeTemp);
    }

    public void addLast(Node nodeBaru){
        if(kepala == null){
            kepala = ekor = nodeBaru;

        }
        else{
        ekor.pointer = nodeBaru;
        ekor = nodeBaru;
        ekor.pointer = null;
        }
        size += 1;

    }
    public void addFirst(Node nodeBaru){
        if(kepala == null){
            kepala = ekor = nodeBaru;
        }
        else{
            nodeBaru.pointer = kepala;
            kepala = nodeBaru;
        }
        size += 1;
    }
    public void addAfter(int key, Node nodeBaru){
        Node temp = kepala;
        while (temp != null){
            if (key == temp.data){
            nodeBaru.pointer = temp.pointer;
            temp.pointer = nodeBaru;
            size += 1;
            break;
            }
        
        temp = temp.pointer;
        }
    }
    public int get(int index){
        Node temp = kepala;
        if(index <= size){
        for(int i = 1; i <= index; i++){  //sama seperti array, linked list juga dimulai dari 0
            temp = temp.pointer;
        }
        return temp.data;
    } else{
        return -1;
    }
        
        }
    public void print(){
        
        Node temp = kepala;
        while (temp != null){
        System.out.print(temp.data + "->");
        temp = temp.pointer;
        }
    
}
    public void deleteFirst(){
        if(kepala != null){
        kepala = kepala.pointer;
        size--;
        }
    }
    public void deleteLast(){
        Node temp = kepala;
        if(kepala != ekor){
        while (temp.pointer != ekor){
            temp = temp.pointer;
        }
        ekor = temp;
        ekor.pointer = null;
    }else{//jika jumlah node = 1
        kepala = ekor = null;
    }
    size--;
  }
}
    

