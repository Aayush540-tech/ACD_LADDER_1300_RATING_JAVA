import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();
        
        while (t-- > 0) {
            long n = sc.nextLong();
            long l = sc.nextLong();
            long r = sc.nextLong();
            long k = sc.nextLong();
            
            if (n % 2 != 0) {
                // Odd n: All elements are l
                System.out.println(l);
            } else {
                // Even n: We need a_i such that AND = XOR = 0
                // Find smallest x >= l such that (l & x) == 0
                long x = findSmallestValid(l);
                
                if (x > r) {
                    System.out.println("-1");
                } else {
                    // For lexicographical smallest:
                    // a_1 to a_{n-2} = l
                    // a_{n-1} and a_n = x
                    if (k <= n - 2) {
                        System.out.println(l);
                    } else {
                        System.out.println(x);
                    }
                }
            }
        }
        sc.close();
    }
    
    // Finds the smallest x >= l such that l & x == 0
    public static long findSmallestValid(long l) {
        // Find the highest bit set in l
        int highestBit = 0;
        for (int i = 62; i >= 0; i--) {
            if (((l >> i) & 1) == 1) {
                highestBit = i;
                break;
            }
        }
        // The smallest number > l with bit 'highestBit' unset 
        // is 2^(highestBit + 1)
        return 1L << (highestBit + 1);
    }
}