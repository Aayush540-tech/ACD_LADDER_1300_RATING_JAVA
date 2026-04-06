import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int t = fr.nextInt();
        while (t-- > 0) {
            int a = fr.nextInt();
            int b = fr.nextInt();
            int c = fr.nextInt();
            int d = fr.nextInt();
            
            // 1. Evaluate Sign
            boolean isNegative = (a + b) % 2 != 0;
            boolean isPositive = !isNegative;
            
            // 2. Evaluate Magnitude capabilities
            boolean canBeLarge = (a + d) > 0;
            boolean canBeSmall = (b + c) > 0;
            
            // 3. Match and Print ("Ya" / "Tidak")
            out.print((isNegative && canBeLarge ? "Ya" : "Tidak") + " ");
            out.print((isNegative && canBeSmall ? "Ya" : "Tidak") + " ");
            out.print((isPositive && canBeSmall ? "Ya" : "Tidak") + " ");
            out.println(isPositive && canBeLarge ? "Ya" : "Tidak");
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