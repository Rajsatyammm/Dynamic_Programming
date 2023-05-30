package DynamicProgramming;
import java.util.*;
public class LongestCommonSubsequence {

    public static int lcsMem(String str1, String str2, int i, int j, int[][] dp) {
        if(i == 0 || j == 0) {
            return 0;
        }

        if(dp[i][j] != -1) return dp[i][j];
        if(str1.charAt(i-1) == str2.charAt(j-1)) {
            dp[i][j] = 1 + lcsMem(str1, str2, i - 1, j - 1, dp);
            return dp[i][j];
        }
        else {
            dp[i][j] =  Math.max(lcsMem(str1, str2, i-1, j, dp) , lcsMem(str1, str2, i, j-1, dp));
            return dp[i][j];
        }
    }

    public static int lcsTab(String str1, String str2) {
        int N = str1.length();
        int M = str2.length();
        int[][] dp = new int[N+1][M+1];
        for(int i=0; i<N; i++) dp[i][0] = 0;
        for(int j=0; j<M; j++) dp[0][j] = 0;

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[N][M];
    }
    private static int lcsRec(String str1, String str2, int i, int j) {
        if(i == 0 || j == 0) return 0;
        if(str1.charAt(i-1) == str2.charAt(j-1)) {
            return lcsRec(str1, str2, i-1, j-1) + 1;
        }
        else {
            return Math.max(lcsRec(str1, str2, i-1, j), lcsRec(str1, str2, i, j-1));
        }
    }
    public static void main(String[] args) {
        String str1 = "abcdge";
        String str2 = "abedg";
        int N = str1.length();
        int M = str2.length();
        int[][] dp = new int[N + 1][M + 1];
        for(int[] arr : dp)
            Arrays.fill(arr, -1);
        System.out.println(lcsRec(str1, str2, N, M));
        System.out.println(lcsMem(str1, str2, N, M, dp));
        System.out.println(lcsTab(str1, str2));
    }
}
