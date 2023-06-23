package Stack;

public class Queuemain {
    public static void main(String[] args) {
        QueueArray ant = new QueueArray(5);
        ant.enqueue(10);
        ant.enqueue(20);
        ant.dequeue();

        ant.display();
    }
    
}
