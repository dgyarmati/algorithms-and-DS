import java.util.NoSuchElementException;

// you retrieve the elements the opposite order they were added
class FixedSizeStack {
    private int[] arr;
    private int top, capacity;

    FixedSizeStack(int capacity) {
        this.arr = new int[capacity];
        this.capacity = capacity;
        this.top = -1;
    }

    public void push(int item) {
        if (!isFull()) {
            arr[++top] = item;
        }
    }

    public int pop() {
        if (!isEmpty()) {
            int item = arr[top];
            arr[top--] = 0;
            return item;
        }
        throw new NoSuchElementException("Stack is empty");
    }

    public int peek() {
        if (!isEmpty()) {
            return arr[top];
        }
        throw new NoSuchElementException("Stack is empty");
    }

    private boolean isFull() {
        return top == capacity - 1;
    }

    private boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return arr.length;
    }

    public void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        FixedSizeStack s = new FixedSizeStack(3);
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println(s.pop()); // 3
        System.out.println(s.pop()); // 2
        System.out.println(s.pop()); // 1

        s.print(); // [0, 0, 0]

        s.push(1);

        s.print(); // [1, 0, 0]
    }

}
