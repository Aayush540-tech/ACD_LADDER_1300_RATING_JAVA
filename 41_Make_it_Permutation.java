import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            long c = fr.nextLong(); // Cost to remove
            long d = fr.nextLong(); // Cost to insert
            
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = fr.nextInt();
            }
            
            Arrays.sort(a);
            
            // Extract unique elements
            ArrayList<Integer> uniqueA = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (i == 0 || a[i] != a[i - 1]) {
                    uniqueA.add(a[i]);
                }
            }
            
            int m = uniqueA.size();
            long duplicates = n - m;
            long baseCost = duplicates * c;
            
            // Edge case: Remove everything, insert '1'
            long minCost = (n * c) + d;
            
            for (int i = 0; i < m; i++) {
                long val = uniqueA.get(i);
                long countExisting = i + 1;
                
                long missingToInsert = val - countExisting;
                long elementsToRemove = m - countExisting;
                
                long currentCost = baseCost + (missingToInsert * d) + (elementsToRemove * c);
                if (currentCost < minCost) {
                    minCost = currentCost;
                }
            }
            
            out.println(minCost);
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