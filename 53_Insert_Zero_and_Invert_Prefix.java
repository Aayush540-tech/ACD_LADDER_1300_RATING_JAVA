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
            
            // 1. Impossible condition check
            if (a[n - 1] == 1) {
                out.println("NO");
                continue;
            }
            
            out.println("YES");
            List<Integer> ans = new ArrayList<>();
            int i = n - 1;
            
            // 2. Process blocks from right to left
            while (i >= 0) {
                if (a[i] == 0) {
                    int countOnes = 0;
                    // Count consecutive 1s to the left
                    while (i - 1 >= 0 && a[i - 1] == 1) {
                        countOnes++;
                        i--;
                    }
                    
                    // Add '0' countOnes times
                    for (int j = 0; j < countOnes; j++) {
                        ans.add(0);
                    }
                    // Add the inversion trigger
                    ans.add(countOnes);
                    
                    // Move past the 0
                    i--;
                }
            }
            
            for (int j = 0; j < ans.size(); j++) {
                out.print(ans.get(j) + (j == ans.size() - 1 ? "" : " "));
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