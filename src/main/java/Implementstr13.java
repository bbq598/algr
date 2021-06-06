public class Implementstr13 {

  public int strStr(String source, String target) {
    // Write your code here
    for (int i = 0; i <= source.length() - target.length(); i++) {
      for (int j = 0; j < target.length(); j++) {
        if (source.charAt(i + j) == target.charAt(j)) {
          j++;
          if (j == target.length() - 1) {
            return i;
          }
        }else{
            break;
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    //
    String source = "abcdabcdefg";
    String target = "bcd";
    System.out.println(new Implementstr13().strStr(source, target));
  }
}
