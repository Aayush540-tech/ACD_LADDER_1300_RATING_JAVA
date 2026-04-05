import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            long wMax = fr.nextLong();
            
            // Ceiling of W / 2 using integer arithmetic
            long halfW = (wMax + 1) / 2;
            
            List<Integer> ans = new ArrayList<>();
            long currentSum = 0;
            boolean found = false;
            
            for (int i = 1; i <= n; i++) {
                long weight = fr.nextLong();
                
                if (found) continue; // Already solved, just burn through the remaining input
                if (weight > wMax) continue; // Item too heavy
                
                if (weight >= halfW) {
                    // Golden Ticket
                    ans.clear();
                    ans.add(i);
                    found = true;
                } else {
                    // Accumulate small items
                    currentSum += weight;
                    ans.add(i);
                    if (currentSum >= halfW) {
                        found = true;
                    }
                }
            }
            
            if (found) {
                out.println(ans.size());
                for (int i = 0; i < ans.size(); i++) {
                    out.print(ans.get(i) + (i == ans.size() - 1 ? "" : " "));
                }
                out.println();
            } else {
                out.println("-1");
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
        long nextLong() { return Long.parseLong(next()); }
    }
}