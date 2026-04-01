import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int t = fr.nextInt();
        while (t-- > 0) {
            long n = fr.nextLong();
            
            // 1. Edge Case: If n is a power of 2
            if ((n & (n - 1)) == 0) {
                out.println(1);
                out.println(n);
                continue;
            }
            
            ArrayList<Long> seq = new ArrayList<>();
            
            // 2. Extract bits from highest to lowest
            for (int j = 61; j >= 0; j--) {
                long mask = 1L << j;
                // If the bit is set to 1
                if ((n & mask) != 0) {
                    // XOR turns that specific bit to 0
                    seq.add(n ^ mask);
                }
            }
            
            // 3. Add original number
            seq.add(n);
            
            out.println(seq.size());
            for (int i = 0; i < seq.size(); i++) {
                out.print(seq.get(i) + (i == seq.size() - 1 ? "" : " "));
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
        long nextLong() { return Long.parseLong(next()); }
    }
}