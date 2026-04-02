import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String line = br.readLine();
        if (line == null) return;
        
        int t = Integer.parseInt(line.trim());
        
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            // 1. Edge Case
            if (m == 1) {
                out.println(0);
                for (int i = 0; i < n; i++) {
                    out.println(0);
                }
            } else {
                // 2. General Case
                out.println(Math.min(n + 1, m));
                
                for (int i = 0; i < n; i++) {
                    // Cap the cyclic shift
                    int shift = Math.min(i, m - 2) + 1;
                    
                    for (int j = 0; j < m; j++) {
                        out.print((j + shift) % m);
                        if (j == m - 1) {
                            out.println();
                        } else {
                            out.print(" ");
                        }
                    }
                }
            }
        }
        out.flush();
    }
}