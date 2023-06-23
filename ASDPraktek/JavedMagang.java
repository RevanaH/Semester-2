import java.util.*;

class Node {
    String data;
    Node under;
    Node upper;

    public Node(String data) {
        this.data = data;
    }

    Node() {
    }
}

class Stack {
    Node top;
    int size = 0;
    Node temp;

    boolean isEmpty() {
        return top == null;
    }

    void makeEmpty() {
        top = null;
    }

    void push(String newData) {
        Node newNode = new Node(newData);

        if (isEmpty()) {
            top = newNode;

        } else {
            newNode.under = top;
            top.upper = newNode;
            top = newNode;
        }
        size++;
        temp = null;
    }

    String peek() {
        return (isEmpty()) ? "Homepage" : top.data;
    }

    String pop() {
        if (isEmpty()) {
            return "No pages back.";

        } else {
            String data = top.data;
            temp = top; 
            top = top.under;
            size--;
            return data;
        }

    }

    String ford() {
        if (temp == null) { 
            return "No pages forward.";
        } else {
            String data = temp.data;
            temp = temp.under; 
            push(data);
            return data;
        }
    }
}

public class JavedMagang {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Stack stack = new Stack();

        int req = s.nextInt();
        s.nextLine();
        String command = "";
        String[] splitted = new String[2];
        for (int i = 0; i < req; i++) {
            command = s.nextLine();
            splitted = command.split(" ");

            if (splitted[0].toUpperCase().equals("VISIT")) {
                stack.push(splitted[1]);
            } else if (splitted[0].toUpperCase().equals("CURRENT")) {
                stack.peek();
                System.out.println(stack.peek());
            } else if (splitted[0].toUpperCase().equals("BACK")) {
                if (stack.size == 0) {
                    System.out.println(stack.pop());
                } else {
                    stack.pop();
                }
            } else if (splitted[0].toUpperCase().equals("FORWARD")) {
                if (stack.temp == null) {
                    System.out.println(stack.ford());
                } else {
                    stack.ford();
                }
            }

        }s.close();

    }
}
