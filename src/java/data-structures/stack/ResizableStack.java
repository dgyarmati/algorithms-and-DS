import java.util.ArrayList;
import java.util.List;

class ResizableStack<T> {
    private List<T> array;

    ResizableStack() {
        this.array = new ArrayList<>();
    }

    public void push(T item) {
        array.add(item);
    }

    public T pop() {
        T item = array.get(array.size() - 1);
        array.remove(array.size() - 1);
        return item;
    }

    public T peek() {
        return array.get(array.size() - 1);
    }

    public void print() {
        for (T item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ResizableStack<Integer> rs = new ResizableStack<>();

        rs.push(1);
        rs.push(2);
        rs.push(3);

        rs.print();

        System.out.println();

        System.out.println(rs.pop());
        System.out.println(rs.pop());
        System.out.println(rs.pop());

        rs.print();

        rs.push(1);
        rs.push(2);

        rs.print();

    }

}
