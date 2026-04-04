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
            
            // Edge case: an array of length 1 is already sorted
            if (n == 1) {
                out.println(0);
                continue;
            }
            
            out.println(n - 1);
            
            // 1. Anchor the ends
            out.println("1 " + n);
            
            // Determine what the ends actually became
            int x;
            if ((a[0] + a[n - 1]) % 2 == 0) {
                x = a[n - 1];
            } else {
                x = a[0];
            }
            
            int p = x % 2; // Parity of the anchor
            
            // 2. Fix the middle
            for (int i = 1; i < n - 1; i++) {
                if (a[i] % 2 == p) {
                    // Same parity -> pair with the right anchor
                    out.println((i + 1) + " " + n);
                } else {
                    // Different parity -> pair with the left anchor
                    out.println("1 " + (i + 1));
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