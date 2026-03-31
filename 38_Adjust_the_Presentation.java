import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            int m = fr.nextInt();
            int q = fr.nextInt(); // q is 0 for the easy version
            
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = fr.nextInt();
            }
            
            int[] b = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = fr.nextInt();
            }
            
            int expectedPtr = 0;
            // Use a boolean array for O(1) lookups instead of a HashSet for speed
            boolean[] seen = new boolean[n + 1]; 
            boolean possible = true;
            
            for (int i = 0; i < m; i++) {
                int person = b[i];
                if (!seen[person]) {
                    if (expectedPtr < n && person == a[expectedPtr]) {
                        seen[person] = true;
                        expectedPtr++;
                    } else {
                        possible = false;
                        break;
                    }
                }
            }
            
            if (possible) {
                out.println("YA");
            } else {
                out.println("TIDAK");
            }
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