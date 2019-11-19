import java.util.ArrayList;
import java.util.List;

class ResizableStack {
    List<Integer> array;

    ResizableStack() {
        this.array = new ArrayList<>();
    }

    public void push(int item) {
        array.add(item);
    }

    public int pop() {
        int lastItem = array.get(array.size() - 1);
        array.remove(array.size() - 1);
        return lastItem;
    }

    public int peek() {
        return array.get(array.size() - 1);
    }

    public void print() {
        for (Integer integer : array) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ResizableStack rs = new ResizableStack();

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
