import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome627 {
  /**
   * @param s: a string which consists of lowercase or uppercase letters
   * @return: the length of the longest palindromes that can be built
   */
  public int longestPalindrome(String s) {


    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i <s.length(); i++) {
      map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
    }
    int max = 0;
    boolean flag = false;
    for ( char c : map.keySet()){
      if (map.get(c) % 2 != 0) {
        flag = true;
      }
      max += (map.get(c) / 2) * 2;
    }
    return max = flag ? max + 1 : max;
  }

  public static void main(String[] args) {

    String a = "aaaa";
    System.out.println(new LongestPalindrome627().longestPalindrome(a));
  }
}
