import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            int[] a = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = fr.nextInt();
            }
            
            int[] rightCost = new int[n + 1];
            int[] leftCost = new int[n + 1];
            
            rightCost[1] = 1;
            leftCost[n] = 1;
            
            // 1. Determine local 1-step costs
            for (int i = 2; i < n; i++) {
                int distLeft = a[i] - a[i - 1];
                int distRight = a[i + 1] - a[i];
                if (distRight < distLeft) {
                    rightCost[i] = 1;
                    leftCost[i] = distLeft;
                } else {
                    rightCost[i] = distRight;
                    leftCost[i] = 1;
                }
            }
            
            // 2. Build Prefix Sums for traveling Right (Using LONG to prevent overflow)
            long[] prefR = new long[n + 1];
            for (int i = 2; i <= n; i++) {
                prefR[i] = prefR[i - 1] + rightCost[i - 1];
            }
            
            // 3. Build Prefix Sums for traveling Left
            long[] prefL = new long[n + 1];
            for (int i = n - 1; i >= 1; i--) {
                prefL[i] = prefL[i + 1] + leftCost[i + 1];
            }
            
            int m = fr.nextInt();
            // 4. Answer Queries in O(1)
            while (m-- > 0) {
                int x = fr.nextInt();
                int y = fr.nextInt();
                if (x < y) {
                    out.println(prefR[y] - prefR[x]);
                } else {
                    out.println(prefL[y] - prefL[x]);
                }
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