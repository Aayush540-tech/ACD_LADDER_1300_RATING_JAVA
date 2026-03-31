import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        
        String firstLine = br.readLine();
        if (firstLine == null) return;
        
        int t = Integer.parseInt(firstLine.trim());
        
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            
            if (n % 2 == 0) {
                // Even case: pair them adjacently
                for (int i = 1; i <= n / 2; i++) {
                    out.print(i + " " + i + " ");
                }
                out.println();
            } else {
                // Odd case
                if (n < 27) {
                    out.println("-1");
                } else {
                    int[] ans = new int[n + 1];
                    
                    // Pythagorean Triple base
                    ans[1] = 1; ans[10] = 1; ans[26] = 1;
                    
                    // Bridge
                    ans[11] = 2; ans[27] = 2;
                    
                    int curr = 3;
                    // Fill gaps
                    for (int i = 2; i <= 9; i += 2) {
                        ans[i] = curr; ans[i+1] = curr++;
                    }
                    for (int i = 12; i <= 25; i += 2) {
                        ans[i] = curr; ans[i+1] = curr++;
                    }
                    for (int i = 28; i <= n; i += 2) {
                        ans[i] = curr; ans[i+1] = curr++;
                    }
                    
                    // Build the final string for this test case
                    for (int i = 1; i <= n; i++) {
                        out.print(ans[i] + (i == n ? "" : " "));
                    }
                    out.println();
                }
            }
        }
        out.flush();
    }
}