import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            String[] grid = new String[2];
            grid[0] = fr.next();
            grid[1] = fr.next();
            
            boolean[][] vis = new boolean[2][n];
            Queue<int[]> q = new LinkedList<>();
            
            q.offer(new int[]{0, 0});
            vis[0][0] = true;
            
            boolean found = false;
            int[] dr = {-1, 1, 0, 0};
            int[] dc = {0, 0, -1, 1};
            
            while (!q.isEmpty()) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                
                // Win condition
                if (r == 1 && c == n - 1) {
                    found = true;
                    break;
                }
                
                for (int i = 0; i < 4; i++) {
                    // 1. Free move
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    
                    if (nr >= 0 && nr < 2 && nc >= 0 && nc < n) {
                        // 2. Forced move based on the arrow
                        int forcedC = nc + (grid[nr].charAt(nc) == '>' ? 1 : -1);
                        
                        if (forcedC >= 0 && forcedC < n && !vis[nr][forcedC]) {
                            vis[nr][forcedC] = true;
                            q.offer(new int[]{nr, forcedC});
                        }
                    }
                }
            }
            
            out.println(found ? "YES" : "NO");
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