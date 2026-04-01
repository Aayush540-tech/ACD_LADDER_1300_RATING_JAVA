import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            ArrayList<Integer> seq = new ArrayList<>();
            seq.add(n);
            
            // Phase 1: Peel off lowest set bits until 'n' is a power of 2
            while ((n & (n - 1)) != 0) {
                int lowestBit = n & -n;
                n -= lowestBit;
                seq.add(n);
            }
            
            // Phase 2: Halve the power of 2 until it reaches 1
            while (n > 1) {
                n /= 2;
                seq.add(n);
            }
            
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
    }
}