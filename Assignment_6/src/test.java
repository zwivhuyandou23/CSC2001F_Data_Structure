public class test {
    int hash = hashFunc(key);
    
        while (table[hash] != null && table[hash].getKey() != key) {
            hash = (hash + 1) % tableSize; // Linear probing
        }
        if (table[hash] == null) {
            return -1; // Key not found
        } else {
            return table[hash].getValue();
        }
}
