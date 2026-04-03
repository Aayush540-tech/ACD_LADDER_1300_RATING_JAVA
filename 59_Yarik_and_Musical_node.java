import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            
            // Use HashMap to count frequencies
            Map<Integer, Long> counts = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int val = fr.nextInt();
                counts.put(val, counts.getOrDefault(val, 0L) + 1L);
            }
            
            long ans = 0;
            
            // 1. Add pairs of identical numbers
            for (long count : counts.values()) {
                if (count > 1) {
                    ans += (count * (count - 1)) / 2L;
                }
            }
            
            // 2. Add the special (2, 4) exception pairs
            long count2 = counts.getOrDefault(2, 0L);
            long count4 = counts.getOrDefault(4, 0L);
            ans += (count2 * count4);
            
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
    }
}