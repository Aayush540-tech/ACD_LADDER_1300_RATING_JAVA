import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            
            // 1. Count frequencies of last digits
            int[] counts = new int[10];
            for (int i = 0; i < n; i++) {
                int num = fr.nextInt();
                counts[num % 10]++;
            }
            
            // 2. Build compressed array
            ArrayList<Integer> compressed = new ArrayList<>();
            for (int digit = 0; digit < 10; digit++) {
                int limit = Math.min(3, counts[digit]);
                for (int i = 0; i < limit; i++) {
                    compressed.add(digit);
                }
            }
            
            // 3. Brute force all triplets in the small array
            boolean found = false;
            int m = compressed.size();
            for (int i = 0; i < m && !found; i++) {
                for (int j = i + 1; j < m && !found; j++) {
                    for (int k = j + 1; k < m && !found; k++) {
                        if ((compressed.get(i) + compressed.get(j) + compressed.get(k)) % 10 == 3) {
                            found = true;
                        }
                    }
                }
            }
            
            if (found) {
                out.println("YES");
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