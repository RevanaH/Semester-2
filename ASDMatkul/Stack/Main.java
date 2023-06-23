package Stack;

public class Main {
    public static void main(String[] args) {
        int terambil;
        StackArray tumpukanarray = new StackArray(10);
        tumpukanarray.push(100);
        tumpukanarray.push(400);
        terambil = tumpukanarray.pop();
        System.out.println("terambil :"+terambil);
        tumpukanarray.push(200);
        terambil = tumpukanarray.pop();
        System.out.println("terambil :"+terambil);
        tumpukanarray.push(600);
        terambil = tumpukanarray.pop();
        System.out.println("terambil :"+terambil);
        tumpukanarray.push(800);
        tumpukanarray.push(900);
        terambil = tumpukanarray.pop();
        System.out.println("terambil :"+terambil);
        terambil = tumpukanarray.pop();
        System.out.println("terambil :"+terambil);
        tumpukanarray.printStack();
    }
    
}
