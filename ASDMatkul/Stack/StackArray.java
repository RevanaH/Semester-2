package Stack;

class StackArray {
    int top;
    int[] tumpukan;
    int array_size;

    public StackArray(int array_size) {
        this.array_size = array_size;
        tumpukan = new int[array_size];
        top = -1;
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (top == array_size - 1) {
            return true;
        } else {
            return false;
        }
    }

    public void push(int value) {
        if (!isFull()) {
            top++;
            tumpukan[top] = value;
        } else {
            System.out.println("Stack penuh, nilai " + value + " gagal masuk");
        }
    }

    public int pop() {
        if (!isEmpty()) {
            int temp = tumpukan[top];
            top--;
            return temp;
        } else {
            System.out.println("Stack is empty");
            return -1;
        }

    }

    public void printStack() {
        for (int i = top; i >= 0; i--) {
            System.out.println(tumpukan[i]);

        }
    }

}
