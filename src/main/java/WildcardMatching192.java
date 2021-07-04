public class WildcardMatching192 {

    public boolean isMatch(String s, String p) {
        // write your code here
        if (p == null || p.length() == 0) {
            return true;
        }
        if (s.length() == 0) {
            s = "";
        }
        boolean[][] visited = new boolean[s.length()][p.length()];
        boolean[][] data = new boolean[s.length()][p.length()];
        return match2(s, p, 0, 0,visited, data);

    }

    private boolean match2(String s, String p, int sindex, int pindex, boolean[][] visited, boolean[][] data) {

        if (pindex == p.length()) {
            return s.length() == sindex;
        }

        if (sindex == s.length()) {
            for (int i = pindex; i < p.length(); i++) {
                if (p.charAt(i) != '*') {
                    return false;
                }
            }
            return true;
        }
        if (visited[sindex][pindex]) {
            return data[sindex][pindex];
        }

        boolean match = false;

        if (p.charAt(pindex) != '*') {
            match = matchChar(s, p, sindex, pindex) && match2(s, p, sindex + 1, pindex + 1, visited, data);
        }else{
            for (int i = sindex; i <= s.length(); i++) {
                if( match2(s, p, i, pindex + 1, visited, data)){
                    match = true;
                    break;
                }
            }
        }



        visited[sindex][pindex] = true;
        data[sindex][pindex] = match;
        return match;
    }

    private boolean matchChar(String s, String p, int sindex, int pindex) {

        if (s.charAt(sindex) == p.charAt(pindex) || p.charAt(pindex) == '?') {
            return true;
        }
        return false;

    }



    public static void main(String[] args) {
        WildcardMatching192 w = new WildcardMatching192();
        String s = "aa";
        String p = "a";
        System.out.println(w.isMatch(s, p));
    }






    private boolean mathc(String s, String p, int sindex, int pindex) {

        if ( pindex >= p.length()) {
            return true;
        }

        for (int i = sindex; i < s.length(); i++) {

            if (pindex == p.length()) {
                return false;
            }

            if (s.charAt(i) == p.charAt(pindex)) {
                pindex++;
                continue;
            }

            if (p.charAt(pindex) == '?') {
                pindex++;
                continue;
            }

            if (p.charAt(pindex) == '*') {
                for (int j = i; j < s.length(); j++) {
                    if (mathc(s, p, j, pindex + 1)) {
                        return true;
                    }
                }
            }
            if (s.charAt(i) != p.charAt(pindex)) {
                return false;
            }
        }
        return p.length() == pindex || (p.length() == pindex + 1 && p.charAt(p.length() - 1) == '*');
    }









}
