import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            
            long sumEven = 0;
            long sumOdd = 0;
            long maxElement = Long.MIN_VALUE;
            boolean hasPositive = false;
            
            for (int i = 0; i < n; i++) {
                long val = fr.nextLong();
                
                // Track the absolute maximum element for the all-negative edge case
                if (val > maxElement) {
                    maxElement = val;
                }
                
                // If it's positive, add it to its respective parity sum
                if (val > 0) {
                    hasPositive = true;
                    if (i % 2 == 0) {
                        sumEven += val;
                    } else {
                        sumOdd += val;
                    }
                }
            }
            
            // If the array has no positive numbers, we must take the single largest (least negative) number
            if (!hasPositive) {
                out.println(maxElement);
            } else {
                // Otherwise, take the best positive subset sum
                out.println(Math.max(sumEven, sumOdd));
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