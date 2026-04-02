import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            String sStr = fr.next();
            
            // 1. Impossible Check
            int count0 = 0, count1 = 0;
            for (int i = 0; i < n; i++) {
                if (sStr.charAt(i) == '0') count0++;
                else count1++;
            }
            
            if (count0 != count1) {
                out.println("-1");
                continue;
            }
            
            List<Integer> ans = new ArrayList<>();
            int l = 0;
            StringBuilder s = new StringBuilder(sStr);
            
            // 2. Greedy Insertion
            while (l < s.length() / 2) {
                int right = s.length() - 1 - l;
                
                if (s.charAt(l) != s.charAt(right)) {
                    l++;
                } else if (s.charAt(l) == '0') {
                    int pos = s.length() - l;
                    ans.add(pos);
                    s.insert(pos, "01");
                    l++;
                } else { // s.charAt(l) == '1'
                    int pos = l;
                    ans.add(pos);
                    s.insert(pos, "01");
                    l++;
                }
            }
            
            out.println(ans.size());
            for (int i = 0; i < ans.size(); i++) {
                out.print(ans.get(i) + (i == ans.size() - 1 ? "" : " "));
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