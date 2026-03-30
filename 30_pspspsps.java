import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder out = new StringBuilder();
        
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            
            boolean hasP = false;
            boolean hasS = false;
            
            // Sweep through the string to find strict constraints
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                
                // A 'p' at any position EXCEPT the very end is a strict constraint
                if (c == 'p' && i != n - 1) {
                    hasP = true;
                }
                // An 's' at any position EXCEPT the very beginning is a strict constraint
                if (c == 's' && i != 0) {
                    hasS = true;
                }
            }
            
            // If we have conflicting strict constraints, it's impossible
            if (hasP && hasS) {
                out.append("NO\n");
            } else {
                out.append("YES\n");
            }
        }
        System.out.print(out);
    }
}