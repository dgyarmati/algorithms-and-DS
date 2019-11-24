class HashMap<K, V> {
    private Entry<K, V>[] buckets;
    private static final int INITIAL_CAPACITY = 16;

    private int size = 0;

    public HashMap() {
        this(INITIAL_CAPACITY);
    }

    public HashMap(int size) {
        this.size = size;
    }

    static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public Entry<K, V> getNext() {
            return next;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) return true;

            if (o instanceof Entry) {
                Entry entry = (Entry) o;

                return key.equals(entry.getKey()) && value.equals((entry.getValue()));
            }

            return false;
        }

        @Override
        public int hashCode() {
            int hash = 13;
            hash = 17 * hash + ((key == null) ? 0 : key.hashCode());
            hash = 17 * hash + ((value == null) ? 0 : value.hashCode());
            return hash;
        }

        @Override
        public String toString() {
            return "{" + key + ", " + value + "}";
        }
    }
}
