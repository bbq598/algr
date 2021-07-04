public class NumberofSubstringswithAllZeroes1870 {
    public int stringCount(String str) {
        // Write your code here.
        str = str + "1";
        int m = 0;
        int c = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i - 1 >= 0 && str.charAt(i - 1) == '0') {
                m += 1;
            }
            if (str.charAt(i) == '1') {
                int n = 0;
                while (m > 1) {
                    m -= 1;
                    n += 1;
                    c += n;
                }
                m = 0;
            }
            if (str.charAt(i) == '0') {
                c = c + 1;
            }
        }
        return c;
    }


    public int stringCount2(String str) {
        // Write your code here.
        int j = 0;
        int m = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                j = i + 1;
                while (j < str.length() && str.charAt(j) == '0') {
                    j++;
                }
                int n = 0;
                int c = j - i ;
                m += (c * (c + 1)) / 2;
                i = j;
            }
        }
        return m;
    }


    public static void main(String[] args) {
        String str = "00010011";
        NumberofSubstringswithAllZeroes1870 n = new NumberofSubstringswithAllZeroes1870();
        System.out.println(n.stringCount2(str));


    }
}
