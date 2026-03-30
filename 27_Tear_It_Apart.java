import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int t = fr.nextInt();
        while (t-- > 0) {
            String s = fr.next();
            int minGlobalOps = Integer.MAX_VALUE;
            
            // Try every possible target character from 'a' to 'z'
            for (char target = 'a'; target <= 'z'; target++) {
                
                // We only care about characters that actually exist in the string
                if (s.indexOf(target) == -1) continue; 
                
                int maxBlockLen = 0;
                int currentBlockLen = 0;
                
                // Find the maximum contiguous block of non-target characters
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == target) {
                        maxBlockLen = Math.max(maxBlockLen, currentBlockLen);
                        currentBlockLen = 0; // Reset counter when we hit a "safe" character
                    } else {
                        currentBlockLen++;
                    }
                }
                // Don't forget to check the last block at the end of the string!
                maxBlockLen = Math.max(maxBlockLen, currentBlockLen);
                
                // Calculate operations to reduce the maxBlockLen to 0
                int ops = 0;
                while (maxBlockLen > 0) {
                    maxBlockLen /= 2; // The halving rule
                    ops++;
                }
                
                // Update our global minimum
                minGlobalOps = Math.min(minGlobalOps, ops);
            }
            
            out.println(minGlobalOps);
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