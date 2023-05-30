package DynamicProgramming;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;

public class LongestIncreasingSubsequence {
    public static int LCSubsequnce(int[] arr) {

        Set<Integer> s = new HashSet<>();
        for(int i : arr) {
            s.add(i);
        }

        int[] arr2 = new int[s.size()];
        int idx = 0;
        for(int i : s) {
            arr2[idx] = i;
            idx++;
        }
        Arrays.sort(arr2);

        int N = arr.length;
        int M = arr2.length;
        int[][] dp = new int[N+1][M+1];
        for(int i=0; i<N; i++) {
            dp[i][0] = 0;
        }
        for(int j=0; j<M; j++) {
            dp[0][j] = 0;
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                int v = arr[i-1];
                int w = arr2[j-1];
                if(v == w) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[N][M];
    }
    public static void main(String[] args) {
        int[] arr = {50, 3, 10, 7, 40, 80};

        System.out.println(LCSubsequnce(arr));
    }
}
