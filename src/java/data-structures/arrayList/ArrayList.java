class ArrayList<T> {
    private int capacity;
    private T[] data;
    private int currentSize;

    public ArrayList() {
        this.capacity = 5;
        this.data = (T[]) new Object[this.capacity];
        this.currentSize = 0;
    }

    public void add(T item) {
        if (capacity <= currentSize) {
            int size = capacity;
            capacity += capacity;
            Object[] enlargedArray = new Object[capacity];
            System.arraycopy(data, 0, enlargedArray, 0, size);
            data = (T[]) enlargedArray;
        }
        data[currentSize] = item;
        currentSize++;
    }

    public T get(int index) {
        if (index >= 0 && index < currentSize) {
            return data[index];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public T remove(int index) {
        if (index >= 0 && index < currentSize) {
            T toRemove = data[index];
            if (index != currentSize - 1) {
                for (int i = index + 1; i < currentSize; i++) {
                    T item = data[i];
                    data[i - 1] = item;
                    data[i] = null;
                }
            }
            data[currentSize - 1] = null;
            currentSize--;
            return toRemove;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int size() {
        return currentSize;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < currentSize; i++) {
            sb.append(data[i]);
            if (i < currentSize - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
