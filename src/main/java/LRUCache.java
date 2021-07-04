import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {

    LinkedHashMap<Integer, Integer> data;
    int size;

    public LRUCache(int capacity) {
        // do intialization if necessary
        data = new LinkedHashMap<>();
        this.size = capacity;
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if (data.containsKey(key)) {
            int val = data.get(key);
            data.remove(key);
            data.put(key, val);
            return val;
        }else{
            return -1;
        }
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        if (data.containsKey(key)) {
            data.remove(key);
            data.put(key, value);
        }else{
            if (data.size() < size) {
                data.put(key, value);
            }else{
                data.remove(data.entrySet().iterator().next().getKey());
                data.put(key, value);
            }
        }
    }

    public static void main(String[] args) {
        LRUCache c = new LRUCache(2);
        c.set(2, 1);
        c.set(1, 1);
        System.out.println(c.get(2));
        c.set(4, 1);
        System.out.println(c.get(1));
        System.out.println(c.get(2));

    }


}













