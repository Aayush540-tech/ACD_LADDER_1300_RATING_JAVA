import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            String a = fr.next();
            String b = fr.next();
            
            int ways = 1;
            int dropPos = 0;
            
            for (int i = 0; i < n - 1; i++) {
                // Continuing on top row is strictly better
                if (a.charAt(i + 1) < b.charAt(i)) {
                    ways = 1;
                    dropPos = i + 1;
                } 
                // Dropping down now is strictly better (top row is ruined)
                else if (a.charAt(i + 1) > b.charAt(i)) {
                    break;
                } 
                // Both paths yield the same character
                else {
                    ways++;
                }
            }
            
            // Construct the optimal string
            StringBuilder sb = new StringBuilder();
            sb.append(a.substring(0, dropPos + 1));
            sb.append(b.substring(dropPos));
            
            out.println(sb.toString());
            out.println(ways);
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