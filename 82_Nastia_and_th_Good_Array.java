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
            
            int minVal = Integer.MAX_VALUE;
            int pos = -1;
            
            // Read array and simultaneously find the minimum
            for (int i = 0; i < n; i++) {
                a[i] = fr.nextInt();
                if (a[i] < minVal) {
                    minVal = a[i];
                    pos = i;
                }
            }
            
            // We do exactly n-1 operations
            out.println(n - 1);
            
            // Reconstruct the array around the minimum anchor
            for (int i = 0; i < n; i++) {
                if (i != pos) {
                    // 1-based indexing for Codeforces output
                    int x = minVal;
                    int y = minVal + Math.abs(i - pos);
                    out.println((pos + 1) + " " + (i + 1) + " " + x + " " + y);
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
    }
}