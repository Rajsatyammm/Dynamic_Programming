package DynamicProgramming;
import DynamicProgramming.LongestCommonSubsequence;

import static DynamicProgramming.LongestCommonSubsequence.* ;

public class StringConversion {
    private static int lcs(String str1, String str2) {
        int N = str1.length();
        int M = str2.length();
        int[][] dp = new int[N+1][M+1];
        for(int i=0; i<N; i++) {
            dp[i][0] = 0;
        }
        for(int j=0; j<M; j++) {
            dp[0][j] = 0;
        }

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
    public static void main(String[] args) {
        String str1 = "pear";
        String str2 = "sea";

//        String str1 = "abcdef";
//        String str2 = "aceg";

        int lcsVal = lcsTab(str1, str2);
        int delete = str1.length() - lcsVal;
        int insert = str2.length() - lcsVal;
        System.out.println("deleted : " + delete+ " inserted : " + insert + " total : " + (delete+insert));
    }
}
