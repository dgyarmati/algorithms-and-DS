import java.util.NoSuchElementException;

// remove from the front, insert to the end
class FixedSizeQueue {
    private int[] arr;
    private int front, rear, currentSize;
    private int capacity;

    FixedSizeQueue(int size) {
        this.arr = new int[size];
        this.capacity = size;
        this.front = 0;
        this.rear = -1;
        this.currentSize = 0;
    }

    // adss an item to the end of the queue - that is, 0, 1, ...
    public void enqueue(int item) {
        if (!isFull()) {
            rear = (rear + 1) % capacity;
            arr[rear] = item;
            currentSize++;
        }
    }

    // remove item from queue from front, that is, starting from 0
    public int dequeue() {
        if (!isEmpty()) {
            int frontElement = arr[front];
            currentSize--;

            int[] reducedArray = new int[currentSize];
            System.arraycopy(arr, front + 1, reducedArray, 0, currentSize);
            arr = reducedArray;

            return frontElement;
        }
        throw new NoSuchElementException("Queue is empty");
    }

    public boolean isFull() {
        return currentSize == capacity;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public int size() {
        return currentSize;
    }

    public int peek() {
        if (!isEmpty()) {
            return arr[front];
        }
        throw new NoSuchElementException("Queue is empty");
    }

    public void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        FixedSizeQueue q = new FixedSizeQueue(3);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(5);

        System.out.print("array: ");
        q.print(); // [2, 3, 5]

        System.out.println(q.peek()); // 2

        int n = q.dequeue(); // 2
        int n1 = q.dequeue(); // 3

        System.out.println("last two elements dequeued: " + n + ", " + n1);

        System.out.print("array: ");
        q.print(); // [5]

    }
}
