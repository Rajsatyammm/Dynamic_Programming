package DynamicProgramming;

public class MountainRanges {
    public static int mountainRangesTab(int n) {
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        for(int i=2; i<=n; i++) {
            for(int j=0; j<i; j++) {
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println(mountainRangesTab(n));
    }
}
