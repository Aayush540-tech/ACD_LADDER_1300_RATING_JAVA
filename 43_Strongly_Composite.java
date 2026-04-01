import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            HashMap<Integer, Integer> primeCounts = new HashMap<>();
            
            // 1. Pool all prime factors from the entire array
            for (int i = 0; i < n; i++) {
                int num = fr.nextInt();
                
                // Trial division for prime factorization
                for (int d = 2; d * d <= num; d++) {
                    while (num % d == 0) {
                        primeCounts.put(d, primeCounts.getOrDefault(d, 0) + 1);
                        num /= d;
                    }
                }
                if (num > 1) {
                    primeCounts.put(num, primeCounts.getOrDefault(num, 0) + 1);
                }
            }
            
            int ans = 0;
            int leftovers = 0;
            
            // 2. Greedily make pairs, and count the single leftovers
            for (int count : primeCounts.values()) {
                ans += count / 2;
                leftovers += count % 2;
            }
            
            // 3. Group all leftovers into triplets
            ans += leftovers / 3;
            
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