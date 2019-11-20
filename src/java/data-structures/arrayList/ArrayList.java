// WIP
class ArrayList {
    private int capacity;
    private int[] data;
    private int currentSize;

    public ArrayList() {
        this.capacity = 5;
        this.data = new int[this.capacity];
        this.currentSize = 0;
    }

    public void add(int item) {
        if (capacity <= currentSize) {
            int size = capacity;
            capacity += capacity;
            int[] enlargedArray = new int[capacity];
            System.arraycopy(data, 0, enlargedArray, 0, size);
            data = enlargedArray;
        }
        data[currentSize] = item;
        currentSize++;
    }

    public int get(int index) {
        if (index < currentSize) {
            return data[index];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int size() {
        return currentSize;
    }

    public void print() {
        for (int item : data) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList al = new ArrayList();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);
        al.add(6);
        al.add(7);
        al.add(8);
        al.add(9);
        al.add(10);
        al.add(11);
        al.add(12);
        al.add(13);

        al.print();

        System.out.println(al.get(0));
        System.out.println(al.get(11));
        System.out.println(al.get(12));
    }
}
