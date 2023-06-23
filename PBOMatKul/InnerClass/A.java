package InnerClass;

//  class A {
//     private int y = 20;
//     int x = 15;
    
//     class B{
//         static int x = 10;
//         void methodPadaB(){
//             System.out.println("Hello. saya method di kelas B");
//             System.out.println("Kelas B berada dalam kelas A");
//             System.out.println("y = "+ y);
//             System.out.println("x di B = " + x);
//             System.out.println("x di A = "+ A.this.x);
//         }
//     }
//     void methodPadaA(){
//         B b = new B();
//         System.out.println("Hello, saya method kelas A");
//         System.out.println("Saya membuat object dari inner class B");
//         b.methodPadaB();
//     }
    
// }

class A{
    void methodDiA(){
        class B{
            int i = 10;
            void methodDiB(){
                System.out.println("i = " + i);
            }
        }
        B b = new B();
        b.methodDiB();
    }
}
