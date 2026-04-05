import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int t = fr.nextInt();
        while (t-- > 0) {
            long n = fr.nextLong();
            long temp = n;
            
            long maxCount = 0;
            long bestPrime = 1;
            
            // 1. Prime Factorization up to sqrt(n)
            for (long d = 2; d * d <= temp; d++) {
                if (temp % d == 0) {
                    long count = 0;
                    while (temp % d == 0) {
                        count++;
                        temp /= d;
                    }
                    // Keep track of the prime that appears the most
                    if (count > maxCount) {
                        maxCount = count;
                        bestPrime = d;
                    }
                }
            }
            
            // If there's a prime factor > sqrt(n) left over
            if (temp > 1) {
                if (1 > maxCount) {
                    maxCount = 1;
                    bestPrime = temp;
                }
            }
            
            // 2. Construct the sequence
            if (maxCount <= 1) {
                out.println(1);
                out.println(n);
            } else {
                out.println(maxCount);
                // Print bestPrime (maxCount - 1) times
                long productSoFar = 1;
                for (int i = 0; i < maxCount - 1; i++) {
                    out.print(bestPrime + " ");
                    productSoFar *= bestPrime;
                }
                // The last element absorbs the rest
                out.println(n / productSoFar);
            }
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