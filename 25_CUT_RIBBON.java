import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        // dp[i] stores the max pieces for a ribbon of exact length i
        int[] dp = new int[n + 1];
        
        // Initialize with -1 to represent unreachable lengths
        Arrays.fill(dp, -1);
        dp[0] = 0; // 0 pieces for length 0

        // Build the DP table from bottom up
        for (int i = 1; i <= n; i++) {
            if (i >= a && dp[i - a] != -1) {
                dp[i] = Math.max(dp[i], dp[i - a] + 1);
            }
            if (i >= b && dp[i - b] != -1) {
                dp[i] = Math.max(dp[i], dp[i - b] + 1);
            }
            if (i >= c && dp[i - c] != -1) {
                dp[i] = Math.max(dp[i], dp[i - c] + 1);
            }
        }

        // The answer for exactly length n
        System.out.println(dp[n]);
    }
}