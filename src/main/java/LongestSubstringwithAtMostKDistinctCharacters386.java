import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringwithAtMostKDistinctCharacters386 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }

        Set<Character> data = new HashSet<>();
        int j = 1;
        int m = 0;
        int n = s.length();
        for (int i = 0; i < s.length(); i++) {
            j = i;

            while (j < s.length() && data.size() <= k) {
                data.add(s.charAt(j));
                if (data.size() > k) {
                    break;
                }
                String str = s.substring(i, j + 1);
                int n2 = str.length();
                j++;
            }

            m = Math.max(m, j - i );
            data = new HashSet<>();
        }
        return m;
    }


    public int lengthOfLongestSubstringKDistinct2(String s, int k) {
        // write your code here
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }

        Map<Character, Integer> data = new HashMap<>();
        int j = 0;
        int m = 0;
        int n = s.length();
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && data.size() <= k) {
                if (data.size() == k && !data.containsKey(s.charAt(j))) {
                    break;
                }
                data.put(s.charAt(j), data.getOrDefault(s.charAt(j), 0) + 1);
                String str = s.substring(i, j + 1);
                int n2 = str.length();
                j++;
            }
            m = Math.max(m, j - i );
            if (data.get(s.charAt(i)) == 1) {
                data.remove(s.charAt(i));
            }else{
                data.put(s.charAt(i), data.get(s.charAt(i)) - 1);
            }
        }
        return m;
    }

    public static void main(String[] args) {
        String s = "nutdrgzdrkrvfdfcvzuunxwlzegjukhkjpvqruitobiahxhgdrpqttsebjsg";
        int k = 11;
        LongestSubstringwithAtMostKDistinctCharacters386 l = new LongestSubstringwithAtMostKDistinctCharacters386();
        System.out.println(l.lengthOfLongestSubstringKDistinct2(s, k));


    }
}
