public class Dictionary<K, V> {
    private KeyValuePair<K, V>[] table;
    private final KeyValuePair<K,V> DELETED = new KeyValuePair<K,V>(null, null);

    public Dictionary(){
        table = new KeyValuePair[7];
    }
}
