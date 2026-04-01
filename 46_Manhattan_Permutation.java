import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            long k = fr.nextLong(); // k can be up to 10^11, MUST use long
            
            // Calculate max possible distance (M)
            long maxK = 0;
            for (int i = 0; i < n; i++) {
                maxK += Math.abs((n - i) - (i + 1));
            }
            
            // 1. Check Parity and Bounds
            if (k % 2 != 0 || k > maxK) {
                out.println("NO");
                continue;
            }
            
            out.println("YES");
            
            // 2. Start with identity permutation
            int[] p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = i + 1;
            }
            
            // 3. Greedy Swapping
            int left = 0;
            int right = n - 1;
            
            while (k > 0 && left < right) {
                long maxGain = 2L * (right - left);
                
                if (k >= maxGain) {
                    // Swap extremes
                    int temp = p[left];
                    p[left] = p[right];
                    p[right] = temp;
                    
                    k -= maxGain;
                    left++;
                    right--;
                } else {
                    // Exact swap to finish
                    int shift = (int) (k / 2);
                    int temp = p[left];
                    p[left] = p[left + shift];
                    p[left + shift] = temp;
                    
                    k = 0;
                }
            }
            
            for (int i = 0; i < n; i++) {
                out.print(p[i] + (i == n - 1 ? "" : " "));
            }
            out.println();
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