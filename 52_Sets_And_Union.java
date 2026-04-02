import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            
            List<Set<Integer>> sets = new ArrayList<>();
            Set<Integer> totalUnion = new HashSet<>();
            
            // 1. Read sets and build the total universe of elements
            for (int i = 0; i < n; i++) {
                int k = fr.nextInt();
                Set<Integer> currentSet = new HashSet<>();
                for (int j = 0; j < k; j++) {
                    int val = fr.nextInt();
                    currentSet.add(val);
                    totalUnion.add(val);
                }
                sets.add(currentSet);
            }
            
            int maxSize = 0;
            
            // 2. Iterate through every element to act as the "missing" element
            for (int excludeElem : totalUnion) {
                Set<Integer> currentUnion = new HashSet<>();
                
                for (Set<Integer> s : sets) {
                    // Only merge sets that don't contain the excluded element
                    if (!s.contains(excludeElem)) {
                        currentUnion.addAll(s);
                    }
                }
                
                maxSize = Math.max(maxSize, currentUnion.size());
            }
            
            out.println(maxSize);
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