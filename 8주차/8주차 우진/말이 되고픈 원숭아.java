import java.util.*;

public class baekjoon1600 {
    static final int[] dx = {0,0,1,-1,-2,-1,1,2,2,1,-1,-2};
    static final int[] dy = {1,-1,0,0,1,2,2,1,-1,-2,-2,-1};
    static final int[] cost = {0,0,0,0,1,1,1,1,1,1,1,1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] a = new int[n][m];
        int[][][] d = new int[n][m][l+1];

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                a[i][j] = sc.nextInt();
                Arrays.fill(d[i][j],-1);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(0); q.add(0); q.add(0);
        d[0][0][0] = 0;
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            int c = q.remove();
            for (int k=0; k<12; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                int nc = c+cost[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (a[nx][ny] == 1) continue;
                    if (nc <= l) {
                        if (d[nx][ny][nc] == -1) {
                            d[nx][ny][nc] = d[x][y][c] + 1;
                            q.add(nx); q.add(ny); q.add(nc);
                        }
                    }
                }
            }
        }
        int ans = -1;
        for (int i=0; i<=l; i++) {
            if (d[n-1][m-1][i] == -1) continue;
            if (ans == -1 || ans > d[n-1][m-1][i]) {
                ans = d[n-1][m-1][i];
            }
        }
        System.out.print(ans);
    }
}