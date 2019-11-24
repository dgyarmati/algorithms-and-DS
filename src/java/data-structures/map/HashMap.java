/*
    A HashMap has an array of linked lists, AKA buckets. Inserting and getting elements are based on their hash code (an int).
    We use buckets since there can be an infinite number of elements but int is finite, two different object can have the same
    hash code (collision).

    The solution to that problem is that if there is a collision (teo objects reside at the same index), we go through the linked
    list residing at that index, and insert/retrieve the element accordingly.
 */

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

    /*
        1. calculate the key's hash code
        2. calculate the index of the key using the hash code and the array length (hashCode (key) % array_length)
        3. if the bucket already exists at given index, go through the bucket and insert accordingly, otherwise create new bucket at index
     */
    public void put(K key, V value) {
        Entry<K, V> entry = new Entry<>(key, value, null);

        int bucketIdx = getHash(key) % getBucketSize();

        Entry<K, V> existing = buckets[bucketIdx];

        if (existing == null) {
            buckets[bucketIdx] = entry;
            size++;
        } else {
            while (existing.next != null) {
                if (existing.key.equals(key)) {
                    existing.value = value;
                    return;
                }
                existing = existing.next;
            }

            if (existing.key.equals(key)) {
                existing.value = value;
            } else {
                existing.next = entry;
                size++;
            }
        }
    }

    /*
        1. calculate the hash code from the key, then calculate the index from the hash code
        2. get the bucket at given index, and search it for the key
     */
    public V get(K key) {
        Entry<K, V> bucketIdx = buckets[getHash(key) % getBucketSize()];

        while (bucketIdx != null) {
            if (key == bucketIdx.key) {
                return bucketIdx.value;
            }
            bucketIdx = bucketIdx.next;
        }
        return null;
    }

    public int size() {
        return size;
    }

    private int getBucketSize() {
        return buckets.length;
    }

    private int getHash(K key) {
        return key == null ? 0 : Math.abs(key.hashCode());
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
