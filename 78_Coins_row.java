import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int t = fr.nextInt();
        while (t-- > 0) {
            int m = fr.nextInt();
            
            int[] row1 = new int[m];
            long sum1 = 0; // Using long to prevent overflow, though max is 10^9 (fits in int)
            for (int i = 0; i < m; i++) {
                row1[i] = fr.nextInt();
                sum1 += row1[i];
            }
            
            int[] row2 = new int[m];
            for (int i = 0; i < m; i++) {
                row2[i] = fr.nextInt();
            }
            
            long sum2 = 0;
            long ans = Long.MAX_VALUE;
            
            // Simulate Alice dropping down at column i
            for (int i = 0; i < m; i++) {
                // Alice takes row1[i], removing it from Zone 1
                sum1 -= row1[i];
                
                // Bob takes the max of the top-right zone and bottom-left zone
                long bobBest = Math.max(sum1, sum2);
                
                // Alice minimizes Bob's max
                ans = Math.min(ans, bobBest);
                
                // Add current bottom element to Zone 2 for the next iteration
                sum2 += row2[i];
            }
            
            out.println(ans);
        }
        out.flush();
    }

    // Standard Fast I/O
    static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
    }
}