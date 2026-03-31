import java.io.*;
import java.util.*;

public class Main {
    
    // Helper function to calculate GCD
    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = fr.nextLong();
            }
            
            if (n == 1) {
                out.println(1);
                continue;
            }
            
            Arrays.sort(a);
            
            // 1. Find the optimal step size 'x' (GCD of all differences)
            long x = 0;
            for (int i = 1; i < n; i++) {
                x = gcd(x, a[i] - a[i-1]);
            }
            
            // 2. Calculate base operations
            long max_val = a[n-1];
            long base_ops = 0;
            HashSet<Long> set = new HashSet<>();
            
            for (int i = 0; i < n; i++) {
                base_ops += (max_val - a[i]) / x;
                set.add(a[i]);
            }
            
            // 3. Find the best place to insert the new element
            long k = 1;
            while (set.contains(max_val - k * x)) {
                k++;
            }
            
            // We either pay 'k' to insert below, or 'n' to insert a new maximum
            long best_insertion_cost = Math.min(k, (long) n);
            
            out.println(base_ops + best_insertion_cost);
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