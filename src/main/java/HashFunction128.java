public class HashFunction128 {

    public int hashCode(char[] key, int HASH_SIZE) {
        // write your code here

        long hash = 0;
        for (int i = 0; i < key.length; i++) {
            hash = (hash * 33 + (int)key[i]) % HASH_SIZE;
        }
        return (int)hash;


    }


    public int hashCode2(char[] key, int HASH_SIZE) {
        // write your code here

        long hash = 0;
        for (int i = 0; i < key.length; i++) {
            int l = key.length - 1 -  i;
            hash += (int)key[i] * Math.pow(33, l); ;
        }
        hash = hash % HASH_SIZE;
        return (int)hash;

    }

    public static void main(String[] args) {
        String s = "abcdefghijklmnopqrstuvwxyz";
        HashFunction128 h = new HashFunction128();

        char[] key = s.toCharArray();
        int key2 = 2607;
        System.out.println(h.hashCode(key, key2));

        System.out.println(h.hashCode2(key, key2));

        //System.out.println((10 * 33 ^ 2 + 1 * 33)%5);
        //System.out.println(((0 + 10)%5));
        //System.out.println((0 + 1 ) % 5);
        System.out.println(Long.MAX_VALUE);

    }



}
