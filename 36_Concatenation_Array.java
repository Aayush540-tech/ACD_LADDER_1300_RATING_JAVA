import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            int[][] pairs = new int[n][2];
            
            for (int i = 0; i < n; i++) {
                pairs[i][0] = fr.nextInt();
                pairs[i][1] = fr.nextInt();
            }
            
            // Sort by the sum of the two elements
            Arrays.sort(pairs, (a, b) -> Integer.compare(a[0] + a[1], b[0] + b[1]));
            
            for (int i = 0; i < n; i++) {
                out.print(pairs[i][0] + " " + pairs[i][1] + " ");
            }
            out.println();
        }
        out.flush();
    }

    // Standard Fast I/O class for competitive programming
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