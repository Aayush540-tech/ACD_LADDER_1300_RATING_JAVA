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
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            
            int lastDiff = 0;
            
            for (int i = 0; i < n - 1; i++) {
                // Update the position whenever the environment type flips
                if (i > 0 && s.charAt(i) != s.charAt(i - 1)) {
                    lastDiff = i;
                }
                
                out.print((lastDiff + 1));
                if (i != n - 2) {
                    out.print(" ");
                }
            }
            out.println();
        }
        out.flush();
    }
}