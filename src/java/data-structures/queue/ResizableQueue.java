import java.util.ArrayList;
import java.util.List;

class ResizableQueue {
    private List<Integer> array;

    public ResizableQueue() {
        this.array = new ArrayList<>();
    }

    public void enqueue(int item) {
        array.add(item);
    }

    public int dequeue() {
        int item = array.get(0);
        array.remove(0);
        return item;
    }

    public int peek() {
        return array.get(0);
    }

    public void print() {
        for (Integer integer : array) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ResizableQueue rq = new ResizableQueue();

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
