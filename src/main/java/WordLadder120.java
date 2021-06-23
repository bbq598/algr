import java.util.*;

public class WordLadder120 {



    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here

        dict.add(start);
        dict.add(end);
        HashMap<String, List<String>> data = new HashMap<String, List<String>>();
        dataBuild(data, dict);
        Set<String> visited = new HashSet<>();
        visited.add(start);
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(start);
        int time = 1;
        while (!queue.isEmpty()) {
            int r = queue.size();
            time++;
            for (int j = 0; j < r; j++) {
                String word = queue.poll();
                List<String> poll = data.get(word);
                for (int i = 0; i < poll.size(); i++) {
                    String nextWord = poll.get(i);
                    if (visited.contains(nextWord)) {
                        continue;
                    }

                    if (nextWord.equals(end)) {
                        return time;
                    }

                    queue.add(nextWord);
                    visited.add(nextWord);
                }
            }
        }
        return 0;
    }

    private void dataBuild(HashMap<String, List<String>> data, Set<String> dict) {
        for (String s : dict) {
            List<String> list = new ArrayList<>();
            for (String str : dict) {
                if (str != s) {
                    int count = 0;
                    for (int i = 0; i < str.length(); i++) {
                        if (str.charAt(i) != s.charAt(i)) {
                            count++;
                        }
                    }
                    if (count <= 1) {
                        list.add(str);
                    }
                }
            }
            data.put(s, list);
        }
    }


    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        //dict.add("a");
        dict.add("b");
        //dict.add("c");
        WordLadder120 w = new WordLadder120();
        System.out.println(w.ladderLength("a","c",dict));
    }

}
