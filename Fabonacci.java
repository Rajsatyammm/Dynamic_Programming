package DynamicProgramming;
import java.util.*;

public class Fibonacci {

    // Recursion
    public static int fibRec(int n) {
        if (n == 0 || n == 1)
            return n;
        return fibRec(n - 1) + fibRec(n - 2);

    }

    // Memoisation
    public static int fibMem(int n) {
        int[] dp = new int[n + 1];
        if (n == 0 || n == 1)
            return n;
        if (dp[n] != 0)
            return dp[n];
        dp[n] = fibMem(n - 1) + fibMem(n - 2);
        return dp[n];
    }

    // Tabulation
    public static int fibTab(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 7;
        System.out.println(fibRec(n));
        System.out.println(fibMem(n));
        System.out.println(fibTab(n));
    }
}
