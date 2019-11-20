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
            capacity += capacity;
            int[] enlargedArray = new int[capacity];
            System.arraycopy(data, 0, enlargedArray, 0, capacity);
            data = enlargedArray;
        }
        data[currentSize] = item;
        currentSize++;
    }

    public int size() {
        return data.length;
    }
}
