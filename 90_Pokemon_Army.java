import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            int q = fr.nextInt(); // q is always 0 in the easy version
            
            // Create array of size n + 1, the default value of the last element is 0
            long[] a = new long[n + 1]; 
            for (int i = 0; i < n; i++) {
                a[i] = fr.nextLong();
            }
            
            long ans = 0;
            
            // Sum all positive down-slopes
            for (int i = 0; i < n; i++) {
                if (a[i] > a[i + 1]) {
                    ans += (a[i] - a[i + 1]);
                }
            }
            
            out.println(ans);
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