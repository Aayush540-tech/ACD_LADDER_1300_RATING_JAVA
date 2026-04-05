import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            int[] x = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = fr.nextInt();
            }
            
            int[] y = new int[n];
            y[0] = 0; // Lexicographically smallest choice for the first element
            int z_prev = x[0];
            
            for (int i = 1; i < n; i++) {
                // Find bits that are 1 in z_prev but 0 in x[i]
                y[i] = z_prev & ~x[i];
                
                // Update z_prev to be the bitwise OR of x[i] and the previous required bits
                z_prev = x[i] | z_prev; 
            }
            
            for (int i = 0; i < n; i++) {
                out.print(y[i] + (i == n - 1 ? "" : " "));
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