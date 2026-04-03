import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            
            // pos[x] will store the 1-based index where number x is located
            int[] pos = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                int val = fr.nextInt();
                pos[val] = i;
            }
            
            // For the i-th operation (boost of size i)
            for (int i = 1; i <= n; i++) {
                // Apply it to the suffix starting at the location of (n - i + 1)
                out.print(pos[n - i + 1]);
                if (i != n) {
                    out.print(" ");
                }
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
    }
}