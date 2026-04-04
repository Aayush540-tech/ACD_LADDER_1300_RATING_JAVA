import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = fr.nextInt();
            }
            
            boolean possible = true;
            
            // We only need to check at most the first 22 elements
            int limit = Math.min(n, 22);
            for (int i = 0; i < limit; i++) {
                boolean foundEscape = false;
                
                // Original 1-based index is i + 1
                // We check divisors from 2 up to (i + 2)
                for (int j = 2; j <= i + 2; j++) {
                    if (a[i] % j != 0) {
                        foundEscape = true;
                        break;
                    }
                }
                
                // If this element is divisible by everything from 2 to i+2, we are stuck
                if (!foundEscape) {
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
                out.println("YES");
            } else {
                out.println("NO");
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
    }
}