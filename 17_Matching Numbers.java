import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            
            if (n % 2 == 0) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
                
                // We pair 1..n with n+1..2n
                // Let m = (n+1)/2
                // Odd numbers i: 1, 3, 5... pair with (n + m + (i-1)/2)
                // Even numbers i: 2, 4, 6... pair with (n + (i/2))
                
                int m = (n + 1) / 2;
                
                // Pair odd i with the "upper" half of the second set
                for (int i = 1; i <= n; i += 2) {
                    System.out.println(i + " " + (n + m + (i / 2)));
                }
                
                // Pair even i with the "lower" half of the second set
                for (int i = 2; i <= n; i += 2) {
                    System.out.println(i + " " + (n + (i / 2)));
                }
            }
        }
        sc.close();
    }
}