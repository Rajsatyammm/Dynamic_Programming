package DynamicProgramming;
import static DynamicProgramming.CatalanNumber.catalanTab;

public class CountingTrees {
    public static int countBST(int n) {
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        for(int i=2; i<=n; i++) {
            for(int j=0; j<i; j++) {
                int leftSubtree = dp[j];
                int rightSubtree = dp[i-j-1];
                dp[i] += leftSubtree * rightSubtree;
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 6;
        System.out.println(countBST(n));
    }
}
