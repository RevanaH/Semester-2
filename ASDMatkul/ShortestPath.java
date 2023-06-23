import java.util.NoSuchElementException;

public class ShortestPath {
    private int[][] graph;
    private boolean[] visited;
    private int start;
    private int finish;

    public ShortestPath(int[][] graph, int start, int finish) {
        this.graph = graph;
        this.start = start;
        this.finish = finish;
        visited = new boolean[graph.length];
    }

    public void dfs() {
        Stack<Integer> stack = new Stack<>(graph.length);
        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            visited[node] = true;

            if (node == finish) {
                System.out.print(node + " ");
                return;
            }

            for (int i = 0; i < graph[node].length; i++) {
                if (graph[node][i] == 1 && !visited[i]) {
                    stack.push(i);
                }
            }

            System.out.print(node + " ");
        }
    }

    public void bfs() {
        Queue<Integer> queue = new Queue<>(graph.length);
        queue.enqueue(start);

        while (!queue.isEmpty()) {
            int node = queue.dequeue();
            visited[node] = true;

            if (node == finish) {
                System.out.print(node + " ");
                return;
            }

            for (int i = 0; i < graph[node].length; i++) {
                if (graph[node][i] == 1 && !visited[i]) {
                    queue.enqueue(i);
                }
            }

            System.out.print(node + " ");
        }
    }
}
class Stack<T> {
    private Object[] elements;
    private int size;
    private int top;

    public Stack(int capacity) {
        elements = new Object[capacity];
        size = capacity;
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void push(T data) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full");
        }
        top++;
        elements[top] = data;
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        T data = (T) elements[top];
        top--;
        return data;
    }
}

class Queue<T> {
    private Object[] elements;
    private int size;
    private int front;
    private int rear;

    public Queue(int capacity) {
        elements = new Object[capacity];
        size = capacity;
        front = 0;
        rear = -1;
    }

    public boolean isEmpty() {
        return rear == front - 1 || front == rear + 1;
    }

    public boolean isFull() {
        return rear == size - 1;
    }

    public void enqueue(T data) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        rear++;
        if (rear == size) {
            rear = 0;
        }
        elements[rear] = data;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        T data = (T) elements[front];
        front++;
        if (front == size) {
            front = 0;
        }
        return data;
    }
}
