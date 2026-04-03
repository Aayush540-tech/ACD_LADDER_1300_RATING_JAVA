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
            
            // 1. If length is odd, it's mathematically impossible
            if (n % 2 != 0) {
                out.println("-1");
                continue;
            }
            
            List<String> segments = new ArrayList<>();
            
            // 2. Process the array in chunks of 2
            for (int i = 0; i < n; i += 2) {
                int l = i + 1; // 1-based index
                int r = i + 2; // 1-based index
                
                // Case 1: Elements are the same -> One segment of length 2
                if (a[i] == a[i+1]) {
                    segments.add(l + " " + r);
                } 
                // Case 2: Elements are different -> Two segments of length 1
                else {
                    segments.add(l + " " + l);
                    segments.add(r + " " + r);
                }
            }
            
            // 3. Print the results
            out.println(segments.size());
            for (String segment : segments) {
                out.println(segment);
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