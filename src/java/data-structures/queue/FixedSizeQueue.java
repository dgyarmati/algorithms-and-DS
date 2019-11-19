import java.util.NoSuchElementException;

// remove from the front, insert to the end
// standard implementation; dequeue doesn't actually remove element, only if it's followed by enqueue
class FixedSizeQueue {
    int front, rear, currentSize;
    int capacity;
    int[] array;

    FixedSizeQueue(int capacity) {
        this.array = new int[capacity];
        this.capacity = capacity;
        this.front = 0;
        this.rear = -1;
        this.currentSize = 0;
    }

    void enqueue(int item) {
        if (!isFull()) {
            this.rear = (this.rear + 1) % this.capacity;
            this.array[this.rear] = item;
            currentSize++;
        }
    }

    int dequeue() {
        if (!isEmpty()) {
            int item = array[front];
            front = (front + 1) % this.capacity;
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

    public boolean isFull() {
        return currentSize == capacity;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }
}
