import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            int m = fr.nextInt();
            
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                grid[i] = fr.next().toCharArray();
            }
            
            // 1. The Impossible Case
            if (grid[0][0] == '1') {
                out.println("-1");
                continue;
            }
            
            List<String> ans = new ArrayList<>();
            
            // 2. The Backwards Sweep
            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {
                    if (grid[i][j] == '1') {
                        if (j > 0) {
                            // Horizontal domino (1-based index)
                            ans.add((i + 1) + " " + j + " " + (i + 1) + " " + (j + 1));
                        } else {
                            // Vertical domino
                            ans.add(i + " " + (j + 1) + " " + (i + 1) + " " + (j + 1));
                        }
                    }
                }
            }
            
            out.println(ans.size());
            for (String op : ans) {
                out.println(op);
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