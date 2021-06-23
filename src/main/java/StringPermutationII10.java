import java.util.*;

public class StringPermutationII10 {



    public List<String> stringPermutation2(String str) {
        // write your code here
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            List<String> r = new ArrayList<>();
            r.add("");
            return r;
        }

        char[] data = str.toCharArray();
        Arrays.sort(data);

        StringBuilder path = new StringBuilder();
        List<String> res = new ArrayList<>();
        boolean[] visited = new boolean[str.length()];
        find(data, res, visited, 0, path);
        return res;
    }

    private void find(char[] data,  List<String> res, boolean[] visited, int index, StringBuilder path) {
        if (path.length() == data.length) {
            res.add(path.toString());
            return;
        }

        for (int i = 0; i < data.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && data[i] == data[i - 1] && !visited[i - 1]) {
                continue;
            }

            path.append(data[i]);
            visited[i] = true;
            find(data, res, visited, i, path);
            path.deleteCharAt(path.length() - 1);
            visited[i] = false;
        }

    }


    public static void main(String[] args) {

        String str = "abb";
        StringPermutationII10 s = new StringPermutationII10();
        s.stringPermutation2(str).forEach(a -> System.out.println(a));


    }

}
