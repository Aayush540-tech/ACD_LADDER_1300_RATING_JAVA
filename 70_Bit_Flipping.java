import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            int k = fr.nextInt();
            String s = fr.next();
            
            int[] c = new int[n];
            int remK = k;
            
            // 1. Greedily assign operations from left to right
            for (int i = 0; i < n; i++) {
                if (i == n - 1) {
                    // Dump all remaining operations into the last element
                    c[i] = remK;
                    break;
                }
                
                int originalBit = s.charAt(i) - '0';
                int currentVal = (originalBit + k) % 2;
                
                // If it would end up as '0' and we have operations left, fix it
                if (currentVal == 0 && remK > 0) {
                    c[i] = 1;
                    remK--;
                }
            }
            
            // 2. Reconstruct the final string
            StringBuilder finalStr = new StringBuilder();
            for (int i = 0; i < n; i++) {
                int originalBit = s.charAt(i) - '0';
                // Final parity is affected by total k and the specific times it was chosen
                int finalBit = (originalBit + k + c[i]) % 2;
                finalStr.append(finalBit);
            }
            
            out.println(finalStr.toString());
            for (int i = 0; i < n; i++) {
                out.print(c[i] + (i == n - 1 ? "" : " "));
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