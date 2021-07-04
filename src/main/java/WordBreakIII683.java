import java.util.*;

public class WordBreakIII683 {

    public int wordBreak3(String s, Set<String> dict) {
        // Write your code here

        if (dict == null || dict.size() == 0) {
            return 0;
        }
        int max = 0;
        Set<String> newDict = new HashSet<>();
        for (String str : dict) {
            max = Math.max(str.length(), max);
            newDict.add(str.toLowerCase());
        }
        newDict.add("");


        return find2(max, newDict, 1, s.toLowerCase(), new HashMap<>());
    }

    private int find2(int max, Set<String> dict, int index, String s, Map<String, Integer> data ) {


        if (s.length() == 0) {
            return 1;
        }

        if (data.containsKey(s)) {
            return data.get(s);
        }

        int count = 0;

        for (int i = index; i < s.length() + 1; i++) {
            if (i > max) {
                break;
            }
            String pre = s.substring(0, i);
            if (!dict.contains(pre)) {
                continue;
            }
            count += find2(max, dict,  1, s.substring(i), data);
        }
        data.put(s, count);

        return count;

    }



    private void find(List<String> path,List<Integer> res,String r, String s, Set<String> dict) {
        if (r.equals(s.toLowerCase())) {
            res.set(0, res.get(0) + 1);
            System.out.println(path.toString());
            return;
        }

        if (r.length() >= s.length()) {
            return;
        }

        for (String str : dict) {
            path.add(str);

            find(path, res, r + str, s, dict);

            path.remove(path.size() - 1);
        }

    }

    public static void main(String[] args) {

        WordBreakIII683 w = new WordBreakIII683();
        String s = "qoeKmvHseopurbx";
        Set<String> dict = new HashSet<>();
        dict.add("qoe");
        dict.add("Qoe");
        dict.add("kmv");
        dict.add("kmvHseoPurbx");
        dict.add("hseoPurbx");
        dict.add("Purbx");
        dict.add("Hseo");
        dict.add("qoekmv");
        System.out.println(w.wordBreak3(s, dict));

    }

}
