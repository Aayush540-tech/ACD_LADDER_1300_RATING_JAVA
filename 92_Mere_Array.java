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
            int[] sortedA = new int[n];
            int m = Integer.MAX_VALUE;
            
            // Read array and find the minimum element
            for (int i = 0; i < n; i++) {
                a[i] = fr.nextInt();
                sortedA[i] = a[i];
                if (a[i] < m) {
                    m = a[i];
                }
            }
            
            // Sort the copy
            Arrays.sort(sortedA);
            
            boolean possible = true;
            
            // Check if any out-of-place element is locked
            for (int i = 0; i < n; i++) {
                if (a[i] != sortedA[i] && a[i] % m != 0) {
                    possible = false;
                    break;
                }
            }
            
            out.println(possible ? "YES" : "NO");
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