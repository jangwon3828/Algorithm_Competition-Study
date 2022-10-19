import java.util.*;

public class 연구소 {
    static class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m;
    static int[][] a = new int[10][10];
    static int[][] b = new int[10][10];
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int bfs() {
        Queue<Pair> q = new LinkedList<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                b[i][j] = a[i][j];
                if (b[i][j] == 2) {
                    q.add(new Pair(i, j));
                }
            }
        }
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (b[nx][ny] == 0) {
                        b[nx][ny] = 2;
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }
        int cnt = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (b[i][j] == 0) {
                    cnt += 1;
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int ans = 0;
        for (int x1=0; x1<n; x1++) {
            for (int y1=0; y1<m; y1++) {
                if (a[x1][y1] != 0) continue;
                for (int x2=0; x2<n; x2++) {
                    for (int y2=0; y2<m; y2++) {
                        if (a[x2][y2] != 0) continue;
                        for (int x3=0; x3<n; x3++) {
                            for (int y3=0; y3<m; y3++) {
                                if (a[x3][y3] != 0) continue;
                                if (x1 == x2 && y1 == y2) continue;
                                if (x1 == x3 && y1 == y3) continue;
                                if (x2 == x3 && y2 == y3) continue;
                                a[x1][y1] = 1;
                                a[x2][y2] = 1;
                                a[x3][y3] = 1;
                                int cur = bfs();
                                if (ans < cur) ans = cur;
                                a[x1][y1] = 0;
                                a[x2][y2] = 0;
                                a[x3][y3] = 0;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}