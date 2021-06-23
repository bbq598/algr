import java.util.*;

public class WordSearchI132 {

    public List<String> wordSearchII(char[][] board, List<String> words) {
        // write your code here




        int[] moveX = {0, 0, 1, -1};
        int[] moveY = {1, -1, 0, 0};
        List<String> res = new ArrayList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        Map<String, List<String>> data = new HashMap<>();
        Set<String> dict = new HashSet<>();

        for (int i = 0; i < words.size(); i++) {
            dict.add(words.get(i));
        }

        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.get(i).length(); j++) {
                String word = words.get(i);
                String pre = word.substring(0, j + 1);
                String left = word.substring(j + 1, word.length());
                if (left.length() == 0) {
                    left = word;
                }
                List<String> list = new ArrayList<>();
                if (data.containsKey(pre)) {
                    list = data.get(pre);
                }
                list.add(left);
                data.put(pre, list);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                find(board, visited, res, data, "", moveX, moveY, dict, j, i);
            }
        }

        return res;

    }


    private void find(char[][] board,boolean[][] visited,  List<String> res, Map<String, List<String>> data, String word, int[] moveX, int[] moveY, Set<String> dict, int x, int y ) {

        word = word + board[y][x];
        if (dict.contains(word)) {
            dict.remove(word);
            List<String> list = data.get(word);
            for (int i = 0; i < list.size(); i++) {
                if (word.equals(list.get(i))) {
                    res.add(word);
                    for (int j = 0; j < word.length(); j++) {
                        String pre = word.substring(0, j + 1);
                        String left = word.substring(j + 1, word.length());
                        if (data.get(pre).size() == 1) {
                            data.remove(pre);
                        }else if(left.length() == 0){
                            List<String> removestr = data.get(pre);
                            removestr.remove(pre);
                        }else{
                            List<String> removestr = data.get(pre);
                            removestr.remove(left);
                        }
                    }
                }
            }
            if (!data.containsKey(word)) {
                return;
            }
        }

        if (visited[y][x]) {
            return;
        }

        //        int[] moveX = {0, 0, 1, -1};
        //        int[] moveY = {1, -1, 0, 0};
        visited[y][x] =true;
                for (int k = 0; k < moveX.length; k++) {
                        int newX = x + moveX[k];
                        int newY = y + moveY[k];
                        if (newX < 0 || newX >= board[0].length) {
                            continue;
                        }

                    if (newY < 0 || newY >= board.length) {
                        continue;
                    }

                    if (visited[newY][newX]) {
                        continue;
                    }

                    if (data.containsKey(word + board[newY][newX])) {
                        find(board, visited, res, data, word, moveX, moveY, dict, newX, newY);
                    }
                }
                visited[y][x] = false;

    }



    public static void main(String[] args) {
        char[][] board = {{'a', 'b', 'c', 'e'}, {'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'}};
        //char[][] board = {{'b'},{'a'},{'b'},{'b'},{'a'}};
        List<String> list = new ArrayList<>();
        //list.add("a");
        //list.add("b");
        //list.add("ba");
        //list.add("babbab");
        list.add("as");
        list.add("ab");
        list.add("cf");
        list.add("da");
        list.add("ee");
        list.add("e");
        list.add("adee");
        list.add("eeda");
        WordSearchI132 w = new WordSearchI132();
        w.wordSearchII(board, list);

    }

}
