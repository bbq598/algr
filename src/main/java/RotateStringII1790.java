public class RotateStringII1790 {

  public String RotateString2(String str, int left, int right) {
    int move = left - right;
    int l = str.length();
    if (Math.abs(move) > str.length()) {
      move = move % str.length();
    }

    if (move > 0) {
      return str.substring(move, str.length()).concat(str.substring(0, move));
    } else if (move < 0) {
      return str.substring(str.length() + move, str.length())
          .concat(str.substring(0, str.length() + move));
    }else{
      return str;
    }
  }



  public static void main(String[] args) {
    String str = "GCNJVIhHWPQWHIMIMUJqqLFNzULW";
    int left = 3063, right = 9097;
    System.out.println(new RotateStringII1790().RotateString2(str, left, right));

  }
}
