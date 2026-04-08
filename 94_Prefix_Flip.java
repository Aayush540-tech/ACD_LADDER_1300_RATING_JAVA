import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            char[] a = sc.next().toCharArray();
            char[] b = sc.next().toCharArray();
            List<Integer> operations = new ArrayList<>();

            for (int i = n - 1; i >= 0; i--) {
                if (a[i] != b[i]) {
                    // Step 1: Make sure a[0] won't conflict with b[i] after the big flip
                    if (a[0] == b[i]) {
                        operations.add(1);
                        a[0] = (a[0] == '0') ? '1' : '0';
                    }
                    // Step 2: Flip prefix of length i+1
                    operations.add(i + 1);
                    reverseAndFlip(a, i + 1);
                }
            }

            System.out.print(operations.size());
            for (int op : operations) System.out.print(" " + op);
            System.out.println();
        }
    }

    private static void reverseAndFlip(char[] a, int k) {
        for (int i = 0; i < (k + 1) / 2; i++) {
            char temp = a[i];
            a[i] = (a[k - 1 - i] == '0') ? '1' : '0';
            a[k - 1 - i] = (temp == '0') ? '1' : '0';
        }
    }
}