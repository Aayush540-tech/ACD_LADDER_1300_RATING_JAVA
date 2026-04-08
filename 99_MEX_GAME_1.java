import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            
            int[] freq = new int[n + 1];
            for (int i = 0; i < n; i++) {
                int val = fr.nextInt();
                if (val <= n) {
                    freq[val]++;
                }
            }
            
            int c1 = 0;
            int ans = 0;
            
            for (int i = 0; i <= n; i++) {
                // If it doesn't exist, MEX stops here
                if (freq[i] == 0) {
                    ans = i;
                    break;
                } 
                // Count elements with exactly 1 copy
                else if (freq[i] == 1) {
                    c1++;
                    // Bob destroys the second vulnerable element
                    if (c1 == 2) {
                        ans = i;
                        break;
                    }
                }
            }
            
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