import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int m = fr.nextInt();
        int[] counts = new int[30];
        
        while (m-- > 0) {
            int type = fr.nextInt();
            int v = fr.nextInt();
            
            if (type == 1) {
                // Add 2^v to the multiset
                counts[v]++;
            } else {
                // Try to build the target sum v greedily
                int target = v;
                for (int i = 29; i >= 0; i--) {
                    // target >> i gets how many 2^i fit into the current target
                    int take = Math.min(counts[i], target >> i);
                    
                    // Subtract the taken amount
                    target -= (take << i);
                }
                
                if (target == 0) {
                    out.println("YES");
                } else {
                    out.println("NO");
                }
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