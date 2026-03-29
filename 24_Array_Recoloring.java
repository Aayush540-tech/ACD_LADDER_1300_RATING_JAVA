import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            int k = fr.nextInt();
            
            long[] a = new long[n];
            long maxMid = -1; // To store the maximum element strictly inside the array
            
            for (int i = 0; i < n; i++) {
                a[i] = fr.nextLong();
                if (i > 0 && i < n - 1) {
                    maxMid = Math.max(maxMid, a[i]);
                }
            }
            
            // CASE 1: k == 1 and array has middle elements
            if (k == 1 && n > 2) {
                long leftCombined = a[0] + maxMid;
                long rightCombined = a[n - 1] + maxMid;
                long edgesCombined = a[0] + a[n - 1];
                
                long res = Math.max(leftCombined, Math.max(rightCombined, edgesCombined));
                out.println(res);
            } 
            // CASE 2: k > 1 or small array (n <= 2)
            else {
                // Sort ascending, then sum the largest (k + 1) elements from the end
                Arrays.sort(a);
                long totalCost = 0;
                
                int elementsToTake = Math.min(n, k + 1);
                for (int i = 0; i < elementsToTake; i++) {
                    totalCost += a[n - 1 - i]; // taking from the largest values at the back
                }
                out.println(totalCost);
            }
        }
        out.flush(); // Crucial for Fast I/O
    }

    // Fast I/O Template
    static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try { 
                    st = new StringTokenizer(br.readLine()); 
                } catch (IOException e) { 
                    e.printStackTrace(); 
                }
            }
            return st.nextToken();
        }
        
        int nextInt() { 
            return Integer.parseInt(next()); 
        }
        
        long nextLong() { 
            return Long.parseLong(next()); 
        }
    }
}