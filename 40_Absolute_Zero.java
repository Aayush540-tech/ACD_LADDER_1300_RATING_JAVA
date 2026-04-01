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
            
            // 1. Check for mixed parities
            int firstParity = a[0] % 2;
            boolean possible = true;
            for (int i = 1; i < n; i++) {
                if (a[i] % 2 != firstParity) {
                    possible = false;
                    break;
                }
            }
            
            if (!possible) {
                out.println("-1");
                continue;
            }
            
            // 2. Apply the Halving Strategy
            ArrayList<Integer> ops = new ArrayList<>();
            for (int step = 0; step < 40; step++) {
                int min = a[0];
                int max = a[0];
                for (int i = 1; i < n; i++) {
                    if (a[i] < min) min = a[i];
                    if (a[i] > max) max = a[i];
                }
                
                if (max == 0) break;
                
                // Pick the exact middle
                int x = (min + max) / 2;
                ops.add(x);
                
                // Update the array
                for (int i = 0; i < n; i++) {
                    a[i] = Math.abs(a[i] - x);
                }
            }
            
            // Output results
            out.println(ops.size());
            if (!ops.isEmpty()) {
                for (int x : ops) {
                    out.print(x + " ");
                }
                out.println();
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