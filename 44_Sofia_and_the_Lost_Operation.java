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
            for (int i = 0; i < n; i++) a[i] = fr.nextInt();
            
            int[] b = new int[n];
            HashSet<Integer> targetSet = new HashSet<>();
            for (int i = 0; i < n; i++) {
                b[i] = fr.nextInt();
                targetSet.add(b[i]);
            }
            
            int m = fr.nextInt();
            int[] d = new int[m];
            HashMap<Integer, Integer> available = new HashMap<>();
            for (int i = 0; i < m; i++) {
                d[i] = fr.nextInt();
                available.put(d[i], available.getOrDefault(d[i], 0) + 1);
            }
            
            // 1. The Last Operation Trap
            if (!targetSet.contains(d[m - 1])) {
                out.println("NO");
                continue;
            }
            
            // 2. Tally required changes
            HashMap<Integer, Integer> required = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if (a[i] != b[i]) {
                    required.put(b[i], required.getOrDefault(b[i], 0) + 1);
                }
            }
            
            // 3. Verify we have enough tools
            boolean possible = true;
            for (Map.Entry<Integer, Integer> entry : required.entrySet()) {
                int val = entry.getKey();
                int countNeeded = entry.getValue();
                
                if (available.getOrDefault(val, 0) < countNeeded) {
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
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