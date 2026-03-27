import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            long n = sc.nextLong();
            long x = sc.nextLong();
            
            if (x == 0) {
                if (n == 1) System.out.println("-1");
                else if (n % 2 == 0) System.out.println(n);
                else System.out.println(n + 3);
            } 
            else if (x == 1) {
                if (n % 2 != 0) System.out.println(n);
                else System.out.println(n + 3);
            } 
            else {
                // Count set bits (popcount)
                long c = Long.bitCount(x);
                if (n <= c) {
                    System.out.println(x);
                } else {
                    long extra = n - c;
                    // If the number of 1s we add is odd, 
                    // and x is even, we just add n-c.
                    // If x is odd and extra is odd, we need one more 1.
                    if (extra % 2 == 0) {
                        System.out.println(x + extra);
                    } else {
                        // Logic check: if x is even, x XOR 1 is x+1. 
                        // If x is odd, x XOR 1 is x-1.
                        // In both cases, x + extra + 1 covers the parity shift.
                        if (x % 2 == 0) System.out.println(x + extra);
                        else System.out.println(x + extra + 1);
                    }
                }
            }
        }
        sc.close();
    }
}