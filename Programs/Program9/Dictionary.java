public class Dictionary<K,V> {
    private KeyValuePair<K,V>[] hashTable;
    private final KeyValuePair<K,V> DELETED = new KeyValuePair<K,V>(null, null);

    /**
     * Inits a hash table to back the dictionary
     */
    @SuppressWarnings("unchecked") // Suppresses the warning in editor
    public Dictionary() {
        hashTable = (KeyValuePair<K, V>[]) new KeyValuePair[2];
    }

     /**
      * Inserts a value into the dictionary based on thr key and value provided
      * @param key The key used to represent the value
      * @param value the value to be stored
      */
    public void insert(K key, V value){
        int m = hashTable.length;
        int p = key.hashCode();
        int attempt = 1;

        while (attempt < m) {
            int index = hashLinear(p, attempt);
            if (hashTable[index] == null || hashTable[index] == DELETED) {
                hashTable[index] = new KeyValuePair<K,V>(key, value);
                return;
            }
            else if(hashTable[index].getKey() == key){
                hashTable[index].setValue(value);
                return;
            }
            attempt++;
        }
        if (attempt >= m) {
            increaseSize();
            insert(key, value);
        }
    }

    /**
     * Searches the dictionary for the key provided and returns the matching value
     * @param key The key to look for
     * @return V The value stored with the key
     */
    public V search(K key){
        int p = key.hashCode();
        int attempt = 1;
        int index = hashLinear(p, attempt);
        while (hashTable[index] != null){
            if(hashTable[index].getKey() == key){
                return hashTable[index].getValue();
            }

            attempt++;
            index = hashLinear(p, attempt);
        }
        return null;
    }

    /**
     * Marks the provided key as "Deleted"
     * @param key The key to be deleted 
     */
    public void delete(K key){
        int p = key.hashCode();
        int attempt = 1;
        int index = hashLinear(p, attempt);
        while (hashTable[index] != null){
            if(hashTable[index].getKey() == key){
                hashTable[index] = DELETED;
            }

            attempt++;
            index = hashLinear(p, attempt);
        }
    }

    private int hashLinear(int p, int attempt){
        return (hashDiv(p) + (attempt - 1)) % hashTable.length;
    }

    private int hashDiv(int p){
        return p % hashTable.length;
    }

    @SuppressWarnings("unchecked") // Suppresses the warning in editor
    private void increaseSize(){
        int m = hashTable.length;
        KeyValuePair<K,V>[] oldTable = hashTable.clone();
        hashTable = (KeyValuePair<K, V>[]) new KeyValuePair[2 * m];

        for (KeyValuePair<K,V> keyValuePair : oldTable) {
            if(keyValuePair != null){
                insert(keyValuePair.getKey(), keyValuePair.getValue());
            }
        }
    }
}
