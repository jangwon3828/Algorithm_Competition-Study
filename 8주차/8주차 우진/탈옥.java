import java.util.*;

public class 탈옥 {

    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static int[][] bfs(String[] a, int x, int y) {
        int n = a.length;
        int m = a[0].length();
        int[][] d = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                d[i][j] = -1;
            }
        }
        ArrayDeque<Pair> deque = new ArrayDeque<>();
        deque.add(new Pair(x, y));
        d[x][y] = 0;
        while (!deque.isEmpty()) {
            Pair p = deque.poll();
            x = p.x;
            y = p.y;
            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (d[nx][ny] != -1) continue;
                char c = a[nx].charAt(ny);
                if (c == '*') continue;
                if (c == '#') {
                    d[nx][ny] = d[x][y] + 1;
                    deque.addLast(new Pair(nx, ny));
                } else {
                    d[nx][ny] = d[x][y];
                    deque.addFirst(new Pair(nx, ny));
                }
            }
        }
        return d;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            String[] a = new String[n+2];
            for (int i=1; i<=n; i++) {
                a[i] = sc.nextLine();
                a[i] = "." + a[i] + ".";
            }
            n += 2;
            m += 2;
            a[0] = a[n-1] = "";
            for (int j=0; j<m; j++) {
                a[0] += ".";
                a[n-1] += ".";
            }
            int[][] d0 = bfs(a, 0, 0);
            int x1, y1, x2, y2;
            x1 = y1 = x2 = y2 = -1;
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    if (a[i].charAt(j) == '$') {
                        if (x1 == -1) {
                            x1 = i;
                            y1 = j;
                        } else {
                            x2 = i;
                            y2 = j;
                        }
                    }
                }
            }
            int[][] d1 = bfs(a, x1, y1);
            int[][] d2 = bfs(a, x2, y2);
            int ans = n*m;
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    char c = a[i].charAt(j);
                    if (c == '*') continue;
                    if (d0[i][j] == -1 || d1[i][j] == -1 || d2[i][j] == -1) continue;
                    int cur = d0[i][j] + d1[i][j] + d2[i][j];
                    if (c == '#') cur -= 2;
                    if (ans > cur) ans = cur;
                }
            }
            System.out.println(ans);
        }
    }
}