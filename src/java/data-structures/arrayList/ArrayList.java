class ArrayList {
    private int capacity;
    private int[] data;
    private int currentIndex;

    public ArrayList() {
        this.capacity = 5;
        this.data = new int[this.capacity];
        this.currentIndex = 0;
    }

    public void add(int item) {
        if (capacity <= currentIndex) {
            capacity += capacity;
            int[] enlargedArray = new int[capacity];
            System.arraycopy(data, 0, enlargedArray, 0, capacity);
            data = enlargedArray;
        }
        data[currentIndex] = item;
        currentIndex++;
    }

    public int size() {
        return data.length;
    }
}
