package DynamicProgramming;

public class EditDistance {
    private static int editDist(String str1, String str2, int n, int m) {
        if(n == 0 || m == 0) return 0;
        if(str1.charAt(n-1) == str2.charAt(m-1)) {
            return editDist(str1, str2, n-1, m-1);
        }
        else {
            char ch = str2.charAt(m-1);
            // add last char of str2 to str1
            int ans1 = editDist(str1+"ch", str2, n, m-1) + 1;
            // remove last char of str1
            int ans2 = editDist(str1, str2, n-1, m) + 1;
            // replace char of str1
            String newStr = str1.substring(0, n);
//            char chh = str2.charAt(m-1);
            int ans3 = editDist(newStr+"ch", str2, n-1, m-1) + 1;
            return Math.min(ans1, Math.min(ans2, ans3));
        }
    }

    private static int editDistTab(String str1, String str2) {
        int N = str1.length();
        int M = str2.length();
        int[][] dp = new int[N+1][M+1];
        for(int i=1; i<N; i++) {
            dp[i][0] = i;
        }
        for(int j=1; j<M; j++) {
            dp[0][j] = j;
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1])) + 1;
                }
            }
        }
        return dp[N][M];
    }
    public static void main(String[] args) {
//        String str1 = "intention";
//        String str2 = "execution";
        String str1 = "pear";
        String str2 = "sea";
        int n = str1.length();
        int m = str2.length();
//        System.out.println(editDist(str1, str2, n, m));
        System.out.println(editDistTab(str1, str2));
    }
}
