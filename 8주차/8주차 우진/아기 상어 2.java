import java.util.*;

public class 아기 상어 2 {
    static int[][] a;
    static int[][] d;
    static int n, m;
    final static int[] dx = {0,0,1,-1,1,1,-1,-1};
    final static int[] dy = {1,-1,0,0,1,-1,1,-1};
    static int go(int sx, int sy) {
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                d[i][j] = -1;
            }
        }
        d[sx][sy] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(sx); q.add(sy);
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            for (int k=0; k<8; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (d[nx][ny] == -1) {
                        if (a[nx][ny] == 1) {
                            return d[x][y]+1;
                        } else {
                            q.add(nx); q.add(ny);
                            d[nx][ny] = d[x][y] + 1;
                        }
                    }
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        d = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int ans = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (a[i][j] == 0) {
                    int dist = go(i, j);
                    if (ans < dist) ans = dist;
                }
            }
        }
        System.out.println(ans);
    }
}