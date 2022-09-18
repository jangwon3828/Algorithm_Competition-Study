import java.util.*;

public class 이모티콘 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] d = new int[n+1][n+1];
        for (int i=0; i<=n; i++) {
            Arrays.fill(d[i], -1);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(0);
        d[1][0] = 0;
        while (!q.isEmpty()) {
            int s = q.remove();
            int c = q.remove();
            if (d[s][s] == -1) {
                d[s][s] = d[s][c] + 1;
                q.add(s); q.add(s);
            }
            if (s+c <= n && d[s+c][c] == -1) {
                d[s+c][c] = d[s][c] + 1;
                q.add(s+c); q.add(c);
            }
            if (s-1 >= 0 && d[s-1][c] == -1) {
                d[s-1][c] = d[s][c] + 1;
                q.add(s-1); q.add(c);
            }
        }
        int ans = -1;
        for (int i=0; i<=n; i++) {
            if (d[n][i] != -1) {
                if (ans == -1 || ans > d[n][i]) {
                    ans = d[n][i];
                }
            }
        }
        System.out.println(ans);
    }
}