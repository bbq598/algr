public class LongestPalindromicSubstring200 {



  public String longestPalindrome(String s) {
    String max = s.length() > 0 ? String.valueOf(s.charAt(0)) : "";

    for (int i = 1; i < s.length(); i++) {
        int k = 0;
        while ( i - 1 - k >= 0 && i + k < s.length() && s.charAt(i + k) == s.charAt(i - 1 - k)){
            max = max.length() > s.substring(i - 1 - k, i + k + 1).length() ? max : s.substring(i - 1 - k, i + k + 1);
            k++;
        }
        k = 1;
        while (i - k >= 0 && i + k < s.length() && s.charAt(i + k) == s.charAt(i - k)){

            max = max.length() > s.substring(i - k, i + k + 1).length() ? max : s.substring(i - k, i + k + 1);
            k++;
        }
    }

    return max;
  }

  public static void main(String[] args) {
    String s = "a";
    System.out.println(new LongestPalindromicSubstring200().longestPalindrome(s));


  }
}
