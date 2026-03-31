import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            long k = fr.nextLong();
            
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = fr.nextInt();
            }
            
            int[] h = new int[n];
            for (int i = 0; i < n; i++) {
                h[i] = fr.nextInt();
            }
            
            int maxLen = 0;
            long currentSum = 0;
            int left = 0;
            
            for (int right = 0; right < n; right++) {
                // 1. If the height condition breaks, snap 'left' to 'right' and reset
                if (right > 0 && h[right - 1] % h[right] != 0) {
                    left = right;
                    currentSum = 0;
                }
                
                // 2. Add current fruit
                currentSum += a[right];
                
                // 3. Shrink window if sum is too large
                while (currentSum > k && left <= right) {
                    currentSum -= a[left];
                    left++;
                }
                
                // 4. Record max length
                maxLen = Math.max(maxLen, right - left + 1);
            }
            
            out.println(maxLen);
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