import java.util.*;

public class WordBreakII582 {

    public List<String> wordBreak(String s, Set<String> wordDict) {
        // write your code here

        int max = 0;
        for (String str : wordDict) {
            max = Math.max(str.length(), max);
        }

        List<List<String>> res = new ArrayList<>();
        return find( s, wordDict, max, 0, new HashMap<Integer, List<String>>());

    }


    private List<String> find(String s, Set<String> wordDict, int max, int index, HashMap<Integer, List<String>> data) {
        List<String> path = new ArrayList<>();

        if (index == s.length() ) {
            path.add(s.substring(index));
            return path;
        }

        if (data.containsKey(index)) {
            return data.get(index);
        }

        for (int i = index + 1; i < s.length() + 1; i++) {
            if (i - index > max) {
                break;
            }

            String word = s.substring(index, i);
            if (!wordDict.contains(word)) {
                continue;
            }

            if (i == s.length()) {
                path.add(word);
                break;
            }
            List<String> sub = find(s, wordDict, max, i, data);
            for (String str : sub) {
                path.add(word + " " + str);
            }
        }
        data.put(index, path);

        return path;
    }




    public static void main(String[] args) {
        WordBreakII582 w = new WordBreakII582();
        String s = "lintcode";
        Set<String> set = new HashSet<>();
        set.add("de");
        set.add("ding");
        set.add("co");
        set.add("code");
        set.add("lint");
        //set.add("aaaaa");
        //set.add("aaaaaa");
        //set.add("aaaaaaa");
        //set.add("aaaaaaaa");
        //set.add("aaaaaaaaa");
        //set.add("aaaaaaaaaa");
        System.out.println(w.wordBreak(s,set).toString());
    }


}
