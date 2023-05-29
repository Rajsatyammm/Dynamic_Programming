
 package DynamicProgramming;
import java.util.*;

public class ClimbingStairs { // Allowed 1 & 2 stairs
    public static int climbRec(int n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;
        return climbRec(n - 1) + climbRec(n - 2);
    }

    // Memoisation
    public static int climbMem(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        if (n < 0)
            return 0;
        if (n == 0)
            return 1;
        if (dp[n] != -1)
            return dp[n];
        dp[n] = climbRec(n - 1) + climbRec(n - 2);
        return dp[n];
    }

    // Tabulation
    public static int climbTab(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (n == 1)
                dp[n] = dp[n - 1];
            else
                dp[n] = dp[n - 1] + dp[n - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(climbRec(n));
        System.out.println(climbMem(n));
        System.out.println(climbRec(n));
    }
}
