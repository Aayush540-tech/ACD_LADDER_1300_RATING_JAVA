import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int t = fr.nextInt();
        while (t-- > 0) {
            long n = fr.nextLong();
            
            // Binary search range for 'k' distinct flavors
            long low = 1, high = 2_000_000_000L;
            long bestK = 1;
            
            while (low <= high) {
                long mid = low + (high - low) / 2;
                
                // Calculate mid choose 2: mid * (mid - 1) / 2
                long pairs = mid * (mid - 1) / 2;
                
                if (pairs <= n) {
                    bestK = mid; // This 'k' is valid, but maybe we can go higher
                    low = mid + 1;
                } else {
                    high = mid - 1; // Overshot 'n', go lower
                }
            }
            
            // Calculate how many pairs are formed by 'bestK' distinct flavors
            long pairsFormed = bestK * (bestK - 1) / 2;
            
            // The remaining pairs needed are filled 1-to-1 with duplicate balls
            long remainingNeeded = n - pairsFormed;
            
            // Total balls = distinct flavors + duplicate balls
            out.println(bestK + remainingNeeded);
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
        long nextLong() { return Long.parseLong(next()); }
    }
}