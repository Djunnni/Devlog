```java

import java.util.LinkedList;

public class Hash<K,V> {
    class IteratorHelper<T> implements Iterator<T> {
        T[] keys;
        int position;

        public IteratorHelper() {
            keys = (T[]) Object[numElements];
            int p = 0;
            for(int i = 0; i < tableSize; i++) {
                LinkedList<HashElement<K,V>> list = harray[i];
                for(HashElement<K,V> h : list) {
                    keys[p++] = (T) h.key();
                }
            }
            position = 0;
        }
        public boolean hasNext() {
            return position < keys.length;
        }
        public T next() {
            return(!hasNext()) return null;
            return keys[position++];
        }
    }
    class HashElement<K, V> implements Comparable<HashElement<K,V>> {
        K key;
        V value;
        public HashElement(K key, V value) {
            this.key = key;
            this.value = value;
        }
        @Override
        public int compareTo(HashElement<K, V> o) {
            return (((Comparable<K>) this.key).compareTo(o.key));
        }
    }

    int numElements;
    int tableSize;
    double maxLoadFactor; // 최대 적재율
    LinkedList<HashElement<K,V>>[] harray;

    public Hash(int  tableSize) {
        this.tableSize = tableSize;
        harray = (LinkedList<HashElement<K,V>>[]) new LinkedList[tableSize];

        for(int i = 0; i < tableSize; i++) {
            harray[i] = new LinkedList<HashElement<K,V>>();
        }
        maxLoadFactor = 0.75; // tableSize를 모를 때, 기본적으로 적당한 값
        numElements = 0;
    }

    public boolean add(K key, V value) {
            if(loadFactor() > maxLoadFactor) {
                resize(tableSize * 2);
            }
            HashElement<K,V> he = new HashElement(key, value);
            int hashVal = key.hashCode();
            hashVal &= 0x7FFFFFFF;
            hashVal %= tableSize;
            harray[hashVal].add(he);
            numElements++;
            return true;
    }
    public boolean remove(K key, V value) {
            HashElement<K,V> he = new HashElement(key, value);
            int hashVal = key.hashCode();
            hashVal &= 0x7FFFFFFF;
            hashVal %= tableSize;
            harray[hashVal].remove(he);

            numElements--;
            return true;
    }
    public V getValue(K key) {
        int hashVal = key.hashCode();
        hashVal &= 0x7FFFFFFF;
        hashVal %= tableSize;
        for(HashElement<K,V> he : harray[hashVal]) {
            if(((Comparable<K>) key).compareTo(he.key) == 0) {
                return he.val;
            }
        }
        return null;
    }
    public double loadFactor() {
        return numElements / tableSize;
    }
    public void resize(int newSize) {
        LinkedList<HashElement<K,V>>[] new_array = (LinkedList<HashElement<K,V>[]) new LinkedList[newSize];

        for(int i = 0; i < newSize; i++) {
            new_array[i] = new LinkedList<HashElement<K,V>>();
        }

        for(K key : this) {
            V val = getValue(key);
            HashElement<K,V> he = new HashElement<K,V>(key, value);

            int hashVal = (key.hashCode() & 0x7FFFFFFF) % newSize;
            new_array[hashVal].add(he);
        }
        harray = new_array;
        tableSize = newSize;
    }
}
```