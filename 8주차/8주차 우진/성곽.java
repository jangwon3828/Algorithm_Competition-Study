import java.util.*;

public class 성곽 {

    static class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n;
    static int m;
    static int[][] a = new int[50][50];
    static int[][] d = new int[50][50];
    static int[] room = new int[50*50+1];
    static int[] dx = {0,-1,0,1};
    static int[] dy = {-1,0,1,0};
    static int bfs(int sx, int sy, int rooms) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sx, sy));
        d[sx][sy] = rooms;
        int cnt = 0;
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            cnt += 1;
            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (d[nx][ny] != 0) continue;
                if ((a[x][y] & (1<<k)) > 0) continue;
                q.add(new Pair(nx, ny));
                d[nx][ny] = rooms;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int rooms = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (d[i][j] == 0) {
                    rooms += 1;
                    room[rooms] = bfs(i, j, rooms);
                }
            }
        }
        System.out.println(rooms);
        int ans = 0;
        for (int i=1; i<=rooms; i++) {
            if (ans < room[i]) {
                ans = room[i];
            }
        }
        System.out.println(ans);
        ans = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                int x = i;
                int y = j;
                for (int k=0; k<4; k++) {
                    int nx = x+dx[k];
                    int ny = y+dy[k];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if (d[nx][ny] == d[x][y]) continue;
                    if ((a[x][y] & (1<<k)) > 0) {
                        if (ans < room[d[x][y]]+room[d[nx][ny]]) {
                            ans = room[d[x][y]]+room[d[nx][ny]];
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}