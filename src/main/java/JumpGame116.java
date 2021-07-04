public class JumpGame116 {


    public boolean canJump(int[] A) {
        // write your code here

        boolean[] res = new boolean[A.length];

        res[0] = true;

        for (int i = 0; i < A.length ; i++) {
            if (!res[i]) {
                return false;
            }
            int n = A[i];
            for (int j = i; j < res.length; j++) {
                if (n < 0) {
                    break;
                }
                res[j] = true;
                n -= 1;
            }
        }
        return true;
    }


    public boolean canJump2(int[] A) {

        boolean[] res = new boolean[A.length];
        res[0] = true;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (res[j] && A[j] + j >= i) {
                    res[i] = true;
                }
            }
        }

        return res[res.length - 1];

    }




        public static void main(String[] args) {
        JumpGame116 j = new JumpGame116();
        int[] A = {2, 3, 1, 1, 4};
        System.out.println(j.canJump2(A));


    }
}
