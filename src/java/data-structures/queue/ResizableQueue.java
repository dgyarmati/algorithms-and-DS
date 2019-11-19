import java.util.ArrayList;
import java.util.List;

class ResizableQueue<T> {
    private List<T> array;

    public ResizableQueue() {
        this.array = new ArrayList<>();
    }

    public void enqueue(T item) {
        array.add(item);
    }

    public T dequeue() {
        T item = array.get(0);
        array.remove(0);
        return item;
    }

    public T peek() {
        return array.get(0);
    }

    public void print() {
        for (T item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ResizableQueue<Integer> rq = new ResizableQueue<>();

        rq.enqueue(0);
        rq.enqueue(2);
        rq.enqueue(3);

        rq.print();

        System.out.println();

        System.out.println(rq.dequeue());
        System.out.println(rq.dequeue());
        System.out.println(rq.dequeue());

        rq.enqueue(1);
        rq.enqueue(2);

        System.out.println();

        rq.print();
    }
}
