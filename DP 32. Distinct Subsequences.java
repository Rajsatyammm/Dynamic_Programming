// Recursion

import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
        // System.out.println("Hello, World!");
        String s1 = "babgbag", s2 = "bag";
        int n = s1.length();
        int m = s2.length();
        System.out.println(helperRec(n, m, s1, s2));
    }
    
    static int helperRec(int i, int j, String s1, String s2) {
        
        if(j == 0) return 1;
        if(i == 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i-1) == s2.charAt(j-1)) {
            return helper(i-1, j-1, s1, s2) + helper(i-1, j, s1, s2);
        }
        else {
            return helper(i-1, j, s1, s2);
        }
    }
}


// Memoisation

import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
        // System.out.println("Hello, World!");
        String s1 = "babgbag", s2 = "bag";
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] a : dp) Arrays.fill(a, -1);
        System.out.println(helperMem(n, m, s1, s2, dp));
    }
    
    static int helperMem(int i, int j, String s1, String s2, int[][] dp) {
        
        if(j == 0) return 1;
        if(i == 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i-1) == s2.charAt(j-1)) {
            return dp[i][j] = helper(i-1, j-1, s1, s2, dp) + helper(i-1, j, s1, s2, dp);
        }
        else {
            return dp[i][j] = helper(i-1, j, s1, s2, dp);
        }
    }
}

// Tabulation

import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
        // System.out.println("Hello, World!");
        String s1 = "babgbag", s2 = "bag";
        int n = s1.length();
        int m = s2.length();
        System.out.println(helperTab(n, m, s1, s2));
    }
    
    static int helperTab(int n, int m, String s1, String s2) {
        
        int[][] dp = new int[n+1][m+1];
        //init
        for(int i=0; i<=n; i++) dp[i][0] = 1;
        for(int j=1; j<=m; j++) dp[0][j] = 0;
        
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }
}
