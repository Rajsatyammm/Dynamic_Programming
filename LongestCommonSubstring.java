package DynamicProgramming;

public class LongestCommonSubstring {
    private static int lcsRec(String str1, String str2, int i, int j) {
        int max = 0;
        if(i == 0 || j == 0) return 0;
        if(str1.charAt(i-1) == str2.charAt(j-1)) {
            int val =  1 + lcsRec(str1, str2, i-1, j-1);
            max = Math.max(max, val);
            return val;
        }
        else {
            return 0;
        }
    }

    private static int lcsTab(String str1, String str2) {
        int max = 0;
        int N = str1.length();
        int M = str2.length();
        int[][] dp = new int[N+1][M+1];
        for(int i=0; i<N; i++) {
            dp[i][0] = 0;
        }
        for(int j=0; j<M; j++)
            dp[0][j] = 0;

        for(int i=1; i<N; i++) {
            for(int j=1; j<M; j++) {
                if(str1.charAt(i-1) == str2.charAt(i-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    max = Math.max(max, dp[i][j]);
                }
                else {
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "abgce";
//        System.out.println(lcsRec(str1, str2, str1.length(), str2.length()));
        System.out.println(lcsTab(str1, str2));
    }
}
