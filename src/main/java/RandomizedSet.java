import java.util.*;

public class RandomizedSet {



    public Map<Integer, Integer> index;
    public int[] data;
    public int size;
    public Random r = new Random();

    public RandomizedSet() {
        index = new HashMap<>();
        data = new int[10];
        size = 0;
    }

    /*
     * @param val: a value to the set
     * @return: true if the set did not already contain the specified element or false
     */
    public boolean insert(int val) {
        // write your code here
        if (index.containsKey(val)) {
            return false;
        }

        if (data.length == size + 1) {
            int[] newData = new int[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
        data[size] = val;
        size++;
        index.put(val, size);
        return true;
    }

    /*
     * @param val: a value from the set
     * @return: true if the set contained the specified element or false
     */
    public boolean remove(int val) {
        // write your code here
        if (!index.containsKey(val)) {
            return false;
        }

        int n = index.get(val);
        index.remove(val);
        if (n != size) {
            data[n] = data[size - 1];
            size--;
            index.put(data[n], n);
        }else{
            size--;
        }
        return true;
    }

    /*
     * @return: Get a random element from the set
     */
    public int getRandom() {
        // write your code here
        if (size == 0) {
            return -1;
        }
        int n = r.nextInt(size);
        return data[n];
    }


    public static void main(String[] args) {
        int[] i = new int[10];
        System.out.println(i.length);
    }



}
