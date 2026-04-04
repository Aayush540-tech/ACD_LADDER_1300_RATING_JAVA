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
            
            int[] ans = new int[n];
            
            // Process backwards from n down to 1
            for (int i = n; i >= 1; i--) {
                int pos = -1;
                // Find the 0-based index of the current target number 'i'
                for (int j = 0; j < i; j++) {
                    if (a[j] == i) {
                        pos = j;
                        break;
                    }
                }
                
                // If it's already at the end of the prefix, no shift was needed
                if (pos == i - 1) {
                    ans[i - 1] = 0;
                } else {
                    // Calculate the left shift amount
                    ans[i - 1] = i - 1 - pos;
                    
                    // Undo the left shift to restore the array
                    int[] temp = new int[i];
                    int idx = 0;
                    
                    // 1. Elements after 'pos' go to the front
                    for (int j = pos + 1; j < i; j++) {
                        temp[idx++] = a[j];
                    }
                    // 2. Elements up to 'pos' go to the back
                    for (int j = 0; j <= pos; j++) {
                        temp[idx++] = a[j];
                    }
                    // 3. Overwrite the prefix in the original array
                    for (int j = 0; j < i; j++) {
                        a[j] = temp[j];
                    }
                }
            }
            
            // Print the answer
            for (int i = 0; i < n; i++) {
                out.print(ans[i] + (i == n - 1 ? "" : " "));
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