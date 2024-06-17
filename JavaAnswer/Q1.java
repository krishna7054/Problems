import java.util.*;

class HashMap {
    private class Pair {
        int key;
        int value;
        
        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private List<List<Pair>> map;
    private int size;
    
    public HashMap(int size) {
        this.size = size;
        map = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            map.add(new LinkedList<>());
        }
    }
    
    private int hash(int key) {
        return key % size;
    }
    
    public void put(int key, int value) {
        int hashValue = hash(key);
        List<Pair> bucket = map.get(hashValue);
        for (Pair pair : bucket) {
            if (pair.key == key) {
                pair.value = value;
                return;
            }
        }
        bucket.add(new Pair(key, value));
    }
    
    public int get(int key) {
        int hashValue = hash(key);
        List<Pair> bucket = map.get(hashValue);
        for (Pair pair : bucket) {
            if (pair.key == key) {
                return pair.value;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int hashValue = hash(key);
        List<Pair> bucket = map.get(hashValue);
        bucket.removeIf(pair -> pair.key == key);
    }
    
    public static void main(String[] args) {
        HashMap hashMap = new HashMap(100);
        hashMap.put(1, 10);
        hashMap.put(2, 20);
        System.out.println(hashMap.get(1));  // Output: 10
        System.out.println(hashMap.get(3));  // Output: -1
        hashMap.put(2, 30);
        System.out.println(hashMap.get(2));  // Output: 30
        hashMap.remove(2);
        System.out.println(hashMap.get(2));  // Output: -1
    }
}
