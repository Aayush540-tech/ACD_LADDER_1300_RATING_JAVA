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
            
            boolean hasZero = false;
            boolean hasOne = false;
            
            for (int i = 0; i < n; i++) {
                int b = fr.nextInt();
                if (b == 0) hasZero = true;
                if (b == 1) hasOne = true;
            }
            
            if (hasZero && hasOne) {
                out.println("Yes");
            } else {
                boolean isSorted = true;
                for (int i = 0; i < n - 1; i++) {
                    if (a[i] > a[i + 1]) {
                        isSorted = false;
                        break;
                    }
                }
                
                if (isSorted) {
                    out.println("Yes");
                } else {
                    out.println("No");
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