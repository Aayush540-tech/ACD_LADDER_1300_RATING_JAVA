import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            int m = fr.nextInt();
            
            // Use long arrays to prevent integer overflow
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = fr.nextLong();
            }
            
            long[] b = new long[n];
            for (int i = 0; i < n; i++) {
                b[i] = fr.nextLong();
            }
            
            long suffixCost = 0;
            
            // 1. Calculate the cost to pass everyone from m to n-1
            for (int i = m; i < n; i++) {
                suffixCost += Math.min(a[i], b[i]);
            }
            
            // 2. Initial answer: stopping exactly at index m-1
            long ans = suffixCost + a[m - 1];
            
            // 3. Try stopping earlier (indices m-2 down to 0)
            for (int i = m - 2; i >= 0; i--) {
                suffixCost += Math.min(a[i + 1], b[i + 1]);
                ans = Math.min(ans, suffixCost + a[i]);
            }
            
            out.println(ans);
        }
        out.flush();
    }

    // Standard Fast I/O is required for N up to 300,000
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