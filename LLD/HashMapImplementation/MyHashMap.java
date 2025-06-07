package HashMapImplementation;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap<K,V> {
    private int capacity; // number of buckets possible
    private int size; // number of elements in map
    private List<MapEntry<K,V>> buckets;

    public MyHashMap() {
        this.capacity = 16;
        this.size = 0;
        this.buckets = new ArrayList<>();
        for(int i=0;i<capacity;i++){
            buckets.add(null);
        }
    }

    public V get(K key){
        // converts the key to hashcode
        int hash = getBucketIndex(key);

        // find the index in the buckets list corresponding to the hash value
        MapEntry<K,V> entry = buckets.get(hash);
        // System.out.println(entry + "entry");
        while(entry !=null){
            // System.out.println(entry.key.equals(key));
            if(entry.key.equals(key)){
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    private void rehash(){
        this.capacity = this.capacity*2;
        List<MapEntry<K,V>> oldBuckets = this.buckets; 

        buckets = new ArrayList<>();

        for(int i=0;i<capacity;i++){
            buckets.add(null);
        }

        for(MapEntry<K,V> entry : oldBuckets){
            while(entry != null){
                put(entry.key,entry.value);
                entry = entry.next;
            }
        }
    }

    

    public void put(K key,V value){
        // get the index of the bucket
        int index = getBucketIndex(key);

        MapEntry<K,V> head = buckets.get(index);

        if(head==null){
            head = new MapEntry<>(key, value);
            buckets.set(index,head);
        }
        else{
            MapEntry<K,V> current = head;
            MapEntry<K,V> prevNode = null;
            while(current!=null){
                if(current.key.equals(key)){
                    current.value = value;
                    return;
                }
                prevNode = current;
                current = current.next;
            }
            MapEntry<K,V> entry = new MapEntry<>(key, value);
            prevNode.next = entry;
            entry.prev = prevNode;
        }
        this.size++;
        float LOAD_FACTOR = 0.75f;
        if((float)(size/capacity)> LOAD_FACTOR){
            rehash();
        }
    }

    public int size(){
        return this.size;}

    public void remove(K key){
        int index = getBucketIndex(key);

        MapEntry<K,V> current = buckets.get(index);

        while(current!=null){
            if(current.key.equals(key)){
                if(current.prev!=null){
                    current.prev.next = current.next;
                }
                else{
                    buckets.set(index, current.next);
                }

                if(current.next!=null){
                    current.next.prev = current.prev;
                }
                this.size--;
                return;
            }
            current = current.next;
        }
    }

    private int getBucketIndex(K key){
        return (key.hashCode() % this.capacity);
    }

    private static class MapEntry<K,V>{
        K key;
        V value;
        MapEntry<K,V> next;
        MapEntry<K,V> prev;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    
        
    }
}


