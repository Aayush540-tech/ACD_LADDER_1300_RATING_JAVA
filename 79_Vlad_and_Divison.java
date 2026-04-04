import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int t = fr.nextInt();
        // Mask representing 31 bits of 1s
        int mask = 2147483647; 
        
        while (t-- > 0) {
            int n = fr.nextInt();
            
            Map<Integer, Integer> freq = new HashMap<>();
            int groups = 0;
            
            for (int i = 0; i < n; i++) {
                int x = fr.nextInt();
                int comp = x ^ mask;
                
                // If the complement is available, pair them up!
                if (freq.getOrDefault(comp, 0) > 0) {
                    freq.put(comp, freq.get(comp) - 1);
                } else {
                    // Otherwise, x needs its own group for now
                    groups++;
                    freq.put(x, freq.getOrDefault(x, 0) + 1);
                }
            }
            
            out.println(groups);
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