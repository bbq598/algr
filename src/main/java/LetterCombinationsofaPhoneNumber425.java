import java.util.*;

public class LetterCombinationsofaPhoneNumber425 {


    public List<String> letterCombinations(String digits) {
        // write your code here

        if (digits == null ) {
            return null;
        }
        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        Map<Character, List<Character>> res = new HashMap<>();

        char c = '1';
        char a = 'a';

        for (int i = 0; i < 8; i++) {
            c = (char) (c + 1);
            List<Character> list = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                list.add(a);
                if (a == 'p' || a == 'w') {
                    j--;
                }
                a = (char) (a + 1);
            }
            res.put(c, list);
        }

        List<List<Character>> result = new ArrayList<>();
        find(digits, res,0, new ArrayList<>(), result);
        List<String> r = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            List<Character> characters = result.get(i);
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < characters.size(); j++) {
                str.append(characters.get(j));
            }
            r.add(str.toString());
        }
        return r;
    }

    private void find(String digits, Map<Character, List<Character>> data,int index,  List<Character> path, List<List<Character>> result) {
        if (path.size() == digits.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        if (index >= digits.length()) {
            return;
        }

        List<Character> list = data.get(digits.charAt(index));

        for (int i = 0; i < list.size(); i++) {
            path.add(list.get(i));
            find(digits, data, index + 1, path, result);
            path.remove(path.size() - 1);
        }
    }


    public static void main(String[] args) {
        String s = "23";
        LetterCombinationsofaPhoneNumber425 l = new LetterCombinationsofaPhoneNumber425();
        l.letterCombinations(s).stream().forEach(System.out::println);
        System.out.println((char)('2' + 1));
    }
}
