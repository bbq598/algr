import java.util.HashMap;
import java.util.Map;

public class RegularExpressionMatching154 {
    //这题的题目解释的什么玩意
    public boolean isMatch(String s, String p) {
        // write your code here

        Map<Character, Integer> sdata = new HashMap<>();
        Map<Character, Integer> pdata = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sdata.put(c, sdata.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < p.length(); i++) {
            char a = p.charAt(i);
            if (a == '*') {
                pdata.put(p.charAt(i - 1), Integer.MAX_VALUE);
                continue;
            }

            if (pdata.containsKey(a) && pdata.get(a) == Integer.MAX_VALUE) {
                continue;
            }
            pdata.put(a, pdata.getOrDefault(a, 0) + 1);
        }

        for (char c : sdata.keySet()) {
            int cnum = sdata.get(c);
            if (pdata.containsKey(c) && pdata.get(c) >= cnum) {
                pdata.remove(c);
                continue;
            }

            if (pdata.containsKey(c) && pdata.get(c) + pdata.getOrDefault('.', 0) > cnum) {
                int newn = pdata.get(c) + pdata.get('.') - cnum;
                pdata.put('.', newn);
                continue;
            }

            if (pdata.containsKey('.') && pdata.getOrDefault('.', 0) > cnum) {
                int newn = pdata.get('.') - cnum;
                pdata.put('.', newn);
                continue;
            }
            return false;
        }


        for (char c : pdata.keySet()) {
            if (c != '.' && c != '*' && pdata.get(c) != Integer.MAX_VALUE) {
                return false;
            }
        }


        return true;
    }


    public static void main(String[] args) {

        RegularExpressionMatching154 r = new RegularExpressionMatching154();
        String s = "aa";
        String p = "aa";
        System.out.println(r.isMatch(s, p));

    }

}
