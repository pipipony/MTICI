import java.util.LinkedList;


public class HashTable<K, V>{
    private static final int SIZE = 16;
    private LinkedList<Entry<K,V>>[] buckets;
    private int num = 0;

    private static class Entry<K, V>{
        private K key;
        private V value;

        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
        public K getKey(){
            return key;
        }
        public V getValue(){
            return value;
        }
        public void setValue(V value){
            this.value = value;
        }
    }
    @SuppressWarnings("unchecked")
    public HashTable(){
        buckets = new LinkedList[SIZE];
        num = 0;
    }
    private int hash(K key){
        return Math.abs(hashCode())%buckets.length;
    }
    public void put(K key, V value){
        int index = hash(key);
        if(buckets[index] == null){
            buckets[index] = new LinkedList<>();
        }
        for(Entry<K, V> entry: buckets[index]){
            if(entry.getKey().equals(key)){
                entry.setValue(value);
                return;
            }
        }
        buckets[index].add(new Entry<>(key, value));
        num++;
    }
    public V get(K key){
        int index = hash(key);
        if(buckets[index]!=null){
            for (Entry<K,V> entry: buckets[index]){
                if(entry.getKey().equals(key)){
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    public void remove(K key){
        int index = hash(key);
        if(buckets[index]!=null){
            for(Entry<K,V> entry: buckets[index]){
                if (entry.getKey().equals(key)){
                    buckets[index].remove(entry);
                    num--;
                    return;
                }
            }
        }
    }
    public int size(){
        return num;
    }

    public boolean isEmpty() {
        return num == 0;
    }
    public static void main(String[] args) {
        HashTable<Integer, String> table = new HashTable<>();

        System.out.println("Таблица пустая - " + table.isEmpty());

        table.put(101, "Ivan");
        table.put(305, "Petr");
        table.put(555, "Anna");

        System.out.println("Размер таблицы - " + table.size());

        System.out.println("Получим пользователя 101 - " + table.get(101));
        System.out.println("Получим пользователя 305 - " + table.get(305));
        System.out.println("Получим пользователя 555 - " + table.get(555));
        System.out.println("Получим пользователя 770 - " + table.get(770));

        table.put(101, "Nikolay");

        System.out.println("Обновили ник пользователя 101 - " + table.get(101));

        table.remove(305);
        System.out.println("Размер таблицы после удаления элемента - " + table.size());
        System.out.println("Номера 305 теперь нет - " + table.get(305));

        table.remove(101);
        table.remove(555);
        System.out.println("Таблица пустая - " + table.isEmpty());
    }

}
