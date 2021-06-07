public class ValidPalindrome415 {



  public boolean isPalindrome(String s) {

    int left = 0;
    int right = s.length() - 1;

    while (left < right) {

      while ( left < s.length() && !isLetter(s.charAt(left))){
        left++;
      }

      if (left == s.length()) {
        return true;
      }

      while (!isLetter(s.charAt(right)) && right > 0) {
        right--;
      }

      if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }



  public static boolean isLetter(char c){

    if (Character.isLetter(c) || Character.isDigit(c)) {
      return true;
    }
    return false;
  }



  public static void main(String[] args) {
    String s = ",'";
    System.out.println(new ValidPalindrome415().isPalindrome(s));
  }
}
