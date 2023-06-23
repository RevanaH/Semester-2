
public class ASDC {

    public static void main (String [] args){
        // LinkedList barisan = new LinkedList();

        // Node node1 = new Node();
        // node1.data=10;
        // //node1.pointer=null;
        // barisan.addLast(node1);

        // Node node2 = new Node();
        // node2.data = 15;
        // barisan.addLast(node2);
        
        // Node node3 = new Node();
        // node3.data = 30;
        // barisan.addLast(node3);

        // Node node4 = new Node();
        // node4.data = 5;
        // barisan.addFirst(node4);

        // Node node5 = new Node();
        // node5.data = 13;
        // barisan.addAfter(10, node5); // seua diatas buat single linked list

        //for (int i = 0; i < 10; i++){
          //  node1 = new Node();
            //node1.data = i;
            //barisan.addLast(node1);

        //}

       // System.out.println(barisan.kepala.data); // untuk print kepala
       // System.out.println(barisan.ekor.data); // untuk print ekor

       //barisan.deleteFirst(); // untuk menghapus node pertama dan dapat digunakan seterusnya
       //barisan.deleteLast(); // untuk mendelete ekor dan hanya dapat dipakai sekali saja
       //System.out.println(barisan.size);
    //    System.out.println(barisan.get(4));// linked list mirip array, mulai dari 0 indexnya
    //    System.out.println(barisan.size);
    //     barisan.print();

    // sekarang semua buat double linked list

    DoubleLL barisan = new DoubleLL();

    NodeDouble node1 = new NodeDouble();
    node1.data = 5;
    barisan.addFirst(node1);

    NodeDouble node2 = new NodeDouble();
    node2.data = 10;
    barisan.addFirst(node2);

    barisan.print();

    }
    
    
}
