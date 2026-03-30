import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            int k = fr.nextInt();
            
            // 1-based indexing for easier math
            long[] a = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = fr.nextLong();
            }
            
            // CASE 1: No slack, fixed partition
            if (n == k) {
                long cost = 1;
                for (int i = 2; i <= n; i += 2) {
                    if (a[i] == cost) {
                        cost++;
                    } else {
                        break;
                    }
                }
                out.println(cost);
            } 
            // CASE 2: We have slack, answer is either 1 or 2
            else {
                boolean canMakeOne = false;
                
                // Check valid starting positions for B2
                for (int i = 2; i <= n - k + 2; i++) {
                    if (a[i] != 1) {
                        canMakeOne = true;
                        break;
                    }
                }
                
                if (canMakeOne) {
                    out.println(1);
                } else {
                    out.println(2);
                }
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