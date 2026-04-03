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
            
            int[] p = new int[n];
            int[] q = new int[n];
            boolean[] usedP = new boolean[n + 1];
            boolean[] usedQ = new boolean[n + 1];
            
            boolean possible = true;
            
            // 1. Base Assignment
            for (int i = 0; i < n; i++) {
                int x = a[i];
                if (!usedP[x]) {
                    p[i] = x;
                    usedP[x] = true;
                } else if (!usedQ[x]) {
                    q[i] = x;
                    usedQ[x] = true;
                } else {
                    possible = false;
                    break;
                }
            }
            
            if (!possible) {
                out.println("NO");
                continue;
            }
            
            long[] blanksP = new long[n];
            long[] blanksQ = new long[n];
            int pCount = 0, qCount = 0;
            
            // 2. Gather blanks using bit-packing: Upper 32 bits = bound, Lower 32 bits = index
            for (int i = 0; i < n; i++) {
                if (p[i] == 0) blanksP[pCount++] = ((long) a[i] << 32) | i;
                if (q[i] == 0) blanksQ[qCount++] = ((long) a[i] << 32) | i;
            }
            
            // 3. Sort blanks by bounds
            Arrays.sort(blanksP, 0, pCount);
            Arrays.sort(blanksQ, 0, qCount);
            
            // 4. Greedily fill the blanks using ascending missing numbers
            int mP = 1, mQ = 1;
            for (int k = 0; k < pCount; k++) {
                while (usedP[mP]) mP++;
                int idx = (int) blanksP[k]; // casting cleanly truncates to lower 32 bits (the index)
                p[idx] = mP++;
            }
            
            for (int k = 0; k < qCount; k++) {
                while (usedQ[mQ]) mQ++;
                int idx = (int) blanksQ[k]; 
                q[idx] = mQ++;
            }
            
            // 5. Final Verification check
            for (int i = 0; i < n; i++) {
                if (Math.max(p[i], q[i]) != a[i]) {
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
                out.println("YES");
                for (int i = 0; i < n; i++) out.print(p[i] + (i == n - 1 ? "" : " "));
                out.println();
                for (int i = 0; i < n; i++) out.print(q[i] + (i == n - 1 ? "" : " "));
                out.println();
            } else {
                out.println("NO");
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