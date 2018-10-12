package me.ryandelap.implementations.datastructures;

import java.util.Arrays;

/**
 * A HashTable implemented. Uses chaining and load factors to expand the HashTable to ensure performance.
 * A load factor of 0.75 (3 elements for every 4 buckets) means an expansion to the hashtable to increase performance.
 * Size is kept in a more manual fashion because transversing the Hashtable every time is inefficent.
 *
 * @param <K> The key type of the hash table.
 * @param <V> The value type of the hash table.
 */
public class HashTable<K, V> {

    private int HASHTABLE_SIZE = 16; //Start off with 16 buckets and grow as needed.

    private int size = 0; //Use a variable because it's faster than accessing the internal array plus its children.

    private HashEntry[] entries = new HashEntry[HASHTABLE_SIZE];

    public V get(K key) {
        int index = getBucket(key);

        if (entries[index] == null) {
            return null;
        }

        HashEntry entry = entries[index];
        while (entry != null) { //Transverse the linked list looking for the correct key from the chain.
            if (entry.key.equals(key)) {
                return (V) entry.value;
            }
            entry = entry.next;
        }
        return null; //Couldn't find value for some reason?
    }

    public void put(K key, K value) {
        this.expandHashtable();

        int index = getBucket(key);
        HashEntry entry = new HashEntry(key, value);

        if (entries[index] == null) { //No collision, no reason to chain values.
            entries[index] = entry;
        } else {
            HashEntry head = entries[index]; //Find the last entry in the linked list and append onto it.
            while (head.next != null) {
                head = head.next;
            }
            head.next = entry; //Append entry
        }
        size++;
    }

    /**
     * An internal method to copy over the old values into a new expanded array.
     */
    private void putNew(K key, K value, HashEntry[] expanded, int index) {
        HashEntry entry = new HashEntry(key, value);

        if (expanded[index] == null) { //No collision, no reason to chain values.
            expanded[index] = entry;
        } else {
            //Find the last entry in the linked list and append onto it.
            HashEntry head = expanded[index];
            while (head.next != null) {
                head = head.next;
            }
            head.next = entry; //Append entry
        }
    }

    /**
     * Removes from multiple cases
     * 1) No node in entries at the specific index.
     * 2) If the previous node does not exist, we just move to the next node, removing the head.
     * 3) If the previous exists, and there is a node after the current, we combine those links together.
     * 4) If there is nothing else to tack on to the end, just set it to null.
     */
    public void remove(K key) {
        int index = getBucket(key);

        if (entries[index] == null) {
            throw new NullPointerException("Key does not exist in HashMap.");
        }


        HashEntry current = entries[index];
        HashEntry previous = null;
        boolean found = false;

        if (current.key.equals(key) && current.next == null) { //Handle removing if first node is what we need to remove.
            entries[index] = null;
            size--;
            return;
        }

        while (current != null) {  //Remove from within chain.
            if (current.key.equals(key)) {
                if (current.next != null) {
                    if (previous == null) { //We are on first node and have one after.
                        entries[index] = current.next;
                    } else {
                        previous.next = current.next; //We are on the chain and need to skip a node to remove it.
                    }
                } else {
                    previous.next = null; // There is no node we need to tack on so just null.
                }
                size--;
                found = true;
                break;
            }

            previous = current;
            current = current.next;
        }
        if (!found) {
            throw new NullPointerException("Key does not exist in HashMap.");
        }
    }

    private int getBucket(K key) {
        return Math.abs(key.hashCode()) % HASHTABLE_SIZE; //Java hashCode can return negative values.
    }

    private void expandHashtable() {

        double ratio = findLoadFactor();

        if (ratio > 0.75) { // We need to double the size of our array.
            HASHTABLE_SIZE = HASHTABLE_SIZE * 2;
            HashEntry[] newEntries = new HashEntry[HASHTABLE_SIZE];
            int newSize = 0;
            for (HashEntry entry : entries) { // Copy all of our values in the HashTable to our new HashTable.
                if (entry == null) continue;

                HashEntry current = entry;
                while (current != null) {
                    int new_index = getBucket((K) current.key);
                    putNew((K) current.key, (K) current.value, newEntries, new_index);
                    current = current.next;
                    newSize++;
                }
            }
            entries = newEntries;
            size = newSize; //Update with new variables.
        }
    }

    /**
     * In order to reduce the number of collions, we will find the ratio of filled buckets to empty ones for the entire
     * hash table. If the number is high, say 90%, and due to the finite number of hashcodes for our size of hashtable,
     * we can conclude we have a lot of chained values internally.
     * So we will use the load factor to determine this to expand our HashTable.
     */
    public double findLoadFactor() {
        return (double) size / (double) HASHTABLE_SIZE;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String output = "{";

        for (HashEntry entry : entries) {
            if (entry == null) continue;

            HashEntry current = entry;
            while (current != null) {
                output += "[" + current.key.toString() + ": " + current.value.toString() + "], ";
                current = current.next;

            }
        }
        output += "}";
        return output;
    }

    private class HashEntry<K, V> {

        private K key;
        private V value;
        private HashEntry next; //Use a linked list for chaining values together.

        public HashEntry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

}
