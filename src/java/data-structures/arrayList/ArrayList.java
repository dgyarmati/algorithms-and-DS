import java.util.List;

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
        if (index >= 0 && index < currentSize) {
            return data[index];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int remove(int index) {
        if (index >= 0 && index < currentSize) {
            int toRemove = data[index];
            if (index != currentSize - 1) {
                for (int i = index + 1; i < currentSize; i++) {
                    int item = data[i];
                    data[i - 1] = item;
                    data[i] = 0;
                }
            }
            data[currentSize - 1] = 0;
            currentSize--;
            return toRemove;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int size() {
        return currentSize;
    }

    public void print() {
        for (int i = 0; i < currentSize; i++) {
            System.out.print(data[i] + " ");

        }
        System.out.println();
    }
}
