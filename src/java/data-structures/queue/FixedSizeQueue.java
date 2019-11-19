import java.util.NoSuchElementException;

// you retrieve the elements in the order they were added
// remove from the front, insert to the end
// standard implementation; dequeue doesn't actually remove element, only if it's followed by enqueue
class FixedSizeQueue<T> {
    private int front, rear, currentSize;
    private int capacity;
    private int[] array;

    FixedSizeQueue(int capacity) {
        this.array = new int[capacity];
        this.capacity = capacity;
        this.front = 0;
        this.rear = -1;
        this.currentSize = 0;
    }

    void enqueue(int item) {
        if (!isFull()) {
            rear = (rear + 1) % capacity;
            array[rear] = item;
            currentSize++;
        }
    }

    int dequeue() {
        if (!isEmpty()) {
            int item = array[front];
            array[front] = 0;
            front = (front + 1) % capacity;
            currentSize--;
            return item;
        }
        throw new NoSuchElementException("Queue is empty");
    }

    int peek() {
        if (!isEmpty()) {
         return array[front];
        }
        throw new NoSuchElementException("Queue is empty");
    }

    public int size() {
        return currentSize;
    }

    private boolean isFull() {
        return currentSize == capacity;
    }

    private boolean isEmpty() {
        return currentSize == 0;
    }

    public void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        FixedSizeQueue q = new FixedSizeQueue(3);

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        q.print();

        System.out.println(q.dequeue()); // 1
        System.out.println(q.dequeue()); // 2
        System.out.println(q.dequeue()); // 3

        q.print(); // [0, 0, 0]

        q.enqueue(1);
        q.print(); // [1, 0, 0]
    }
}
