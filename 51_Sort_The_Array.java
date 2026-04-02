import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int n = fr.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = fr.nextInt();
        }
        
        int L = -1, R = -1;
        
        // 1. Find boundaries of the decreasing segment
        for (int i = 0; i < n - 1; i++) {
            if (a[i] > a[i + 1]) {
                L = i;
                break;
            }
        }
        
        // Edge Case: Already sorted
        if (L == -1) {
            out.println("yes\n1 1");
            out.flush();
            return;
        }
        
        for (int i = n - 1; i > 0; i--) {
            if (a[i] < a[i - 1]) {
                R = i;
                break;
            }
        }
        
        // 2. Reverse the segment manually in-place
        for (int i = L, j = R; i < j; i++, j--) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        
        // 3. Verify if fully sorted
        boolean sorted = true;
        for (int i = 0; i < n - 1; i++) {
            if (a[i] > a[i + 1]) {
                sorted = false;
                break;
            }
        }
        
        if (sorted) {
            out.println("yes");
            out.println((L + 1) + " " + (R + 1));
        } else {
            out.println("no");
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