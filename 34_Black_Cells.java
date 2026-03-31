import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = fr.nextLong();
            }
            
            if (n % 2 == 0) {
                // Even case
                long ans = 1;
                for (int i = 0; i < n; i += 2) {
                    ans = Math.max(ans, a[i+1] - a[i]);
                }
                out.println(ans);
            } else {
                // Odd case
                long globalMin = Long.MAX_VALUE;
                
                // Brute force removing a[i]
                for (int i = 0; i < n; i++) {
                    long currentMax = 1;
                    int prevIndex = -1;
                    
                    for (int j = 0; j < n; j++) {
                        if (i == j) continue; // Skip the removed element
                        
                        if (prevIndex == -1) {
                            prevIndex = j; // First element of the new pair
                        } else {
                            // Second element of the new pair, calculate distance
                            currentMax = Math.max(currentMax, a[j] - a[prevIndex]);
                            prevIndex = -1; // Reset for the next pair
                        }
                    }
                    globalMin = Math.min(globalMin, currentMax);
                }
                out.println(globalMin);
            }
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