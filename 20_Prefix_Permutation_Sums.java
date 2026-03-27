import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] p = new long[n - 1];
            for (int i = 0; i < n - 1; i++) p[i] = sc.nextLong();

            // Total sum of a permutation 1..n must be n*(n+1)/2
            long totalExpected = (long) n * (n + 1) / 2;
            
            // If the last given prefix sum is greater than the total expected, it's impossible
            if (p[n - 2] > totalExpected) {
                System.out.println("NO");
                continue;
            }

            long[] diffs = new long[n - 1];
            diffs[0] = p[0];
            for (int i = 1; i < n - 1; i++) diffs[i] = p[i] - p[i - 1];

            boolean[] seen = new boolean[n + 1];
            List<Long> illegal = new ArrayList<>();
            for (long d : diffs) {
                if (d <= n && !seen[(int) d]) seen[(int) d] = true;
                else illegal.add(d);
            }

            List<Integer> missing = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (!seen[i]) missing.add(i);
            }

            // Case 1: The last prefix sum was missing. 
            // We should have 0 illegal diffs and 1 missing number (which is a_n).
            if (illegal.isEmpty() && missing.size() == 1) {
                System.out.println("YES");
            } 
            // Case 2: A middle prefix sum was missing.
            // We should have 1 illegal diff and 2 missing numbers that sum up to it.
            else if (illegal.size() == 1 && missing.size() == 2) {
                if (missing.get(0) + missing.get(1) == illegal.get(0)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } 
            else {
                System.out.println("NO");
            }
        }
    }
}