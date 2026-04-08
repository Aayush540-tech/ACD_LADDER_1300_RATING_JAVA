import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt(); // Permutation size
            int m = sc.nextInt(); // Sequence size
            int d = sc.nextInt(); // Max distance
            
            int[] p = new int[n + 1];
            int[] pos = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                p[i] = sc.nextInt();
                pos[p[i]] = i; // Store index of each value
            }
            
            int[] a = new int[m + 1];
            for (int i = 1; i <= m; i++) {
                a[i] = sc.nextInt();
            }
            
            int minSwaps = Integer.MAX_VALUE;
            boolean alreadyGood = false;
            
            for (int i = 1; i < m; i++) {
                int p1 = pos[a[i]];
                int p2 = pos[a[i+1]];
                int dist = p2 - p1;
                
                // If the condition is already broken
                if (dist <= 0 || dist > d) {
                    alreadyGood = true;
                    break;
                }
                
                // Option 1: Move a[i+1] before a[i]
                minSwaps = Math.min(minSwaps, dist);
                
                // Option 2: Move them apart beyond distance d
                int need = d + 1 - dist;
                int available = (p1 - 1) + (n - p2); // Empty slots outside the pair
                
                if (available >= need) {
                    minSwaps = Math.min(minSwaps, need);
                }
            }
            
            if (alreadyGood) {
                System.out.println(0);
            } else {
                System.out.println(minSwaps);
            }
        }
    }
}