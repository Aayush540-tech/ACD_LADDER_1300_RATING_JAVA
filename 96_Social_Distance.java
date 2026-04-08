import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();
            
            List<Integer> positions = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') {
                    positions.add(i);
                }
            }
            
            int count = 0;
            if (positions.isEmpty()) {
                // Case: Row is entirely empty
                count = (n - 1) / (k + 1) + 1;
            } else {
                // Case: Leading zeros
                count += positions.get(0) / (k + 1);
                
                // Case: Middle zeros
                for (int i = 0; i < positions.size() - 1; i++) {
                    int gap = positions.get(i + 1) - positions.get(i) - 1;
                    count += (gap - k) / (k + 1);
                }
                
                // Case: Trailing zeros
                int lastPos = positions.get(positions.size() - 1);
                count += (n - 1 - lastPos) / (k + 1);
            }
            System.out.println(count);
        }
    }
}