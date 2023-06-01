package DynamicProgramming;
import java.util.*;
public class RodCutting {
    private static int rodCuttingRec(int[] len, int[] price, int rodlen, int n) {
        if(n == len.length || rodlen == 0) {
            return 0;
        }
        if(len[n] <= rodlen) { // valid condition
            // include
            int include = price[n] + rodCuttingRec(len, price, rodlen-len[n], n);
            // exclude
            int exclude = rodCuttingRec(len, price, rodlen, n+1);
            return Math.max(include, exclude);
        }
        else {
            return rodCuttingRec(len, price, rodlen, n+1);
        }
    }
    private static int rodCuttingMem(int[] len, int[] price, int rodlen, int n, int[][] dp) {
        if(n == len.length || rodlen == 0) {
            return 0;
        }
        if(dp[n][rodlen] != -1) return dp[n][rodlen];
        if(len[n] <= rodlen) { // valid condition
            // include
            int include = price[n] + rodCuttingMem(len, price, rodlen-len[n], n, dp);
            // exclude
            int exclude = rodCuttingMem(len, price, rodlen, n+1, dp);
            dp[n][rodlen] =  Math.max(include, exclude);
            return dp[n][rodlen];
        }
        else {
            dp[n][rodlen] =  rodCuttingRec(len, price, rodlen, n+1);
            return dp[n][rodlen];
        }
    }
    private static int rodCuttingTab(int[] len, int[] price, int rodlen) {
        int N = len.length;
        int[][] dp = new int[N+1][rodlen + 1];
        for(int i=0; i<N; i++) {
            dp[i][0] = 0;
        }
        for(int j=0; j<dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=rodlen; j++) {
                int v = len[i-1];
                int p = price[i-1];
                if(v <= j ) { // valid condition
                    // include
                    dp[i][j] = Math.max(p + dp[i][j-v] , dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
//        for(int[] arr : dp) {
//            for(int a : arr) {
//                System.out.print(a + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
        return dp[N][rodlen];
    }

    public static void main(String[] args) {
        int[] len = {1, 2, 3, 4, 5, 6, 7, 8 };
        int[] price = {1, 5, 8, 9 ,10, 17, 17, 20};
        int rodlen = 8;
        int[][] dp = new int[len.length+1][rodlen+1];
        for(int[] arr : dp)
            Arrays.fill(arr, -1);

        System.out.println(rodCuttingTab(len, price, rodlen));
        System.out.println(rodCuttingRec(len, price, rodlen, 0));
        System.out.println(rodCuttingMem(len, price, rodlen, 0, dp));
    }
}
