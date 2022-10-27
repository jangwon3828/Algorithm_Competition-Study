import java.util.*;

public class 연구소 2 {

    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] a;
    static int[][] d;
    static final int[] dx = {0,0,1,-1};
    static final int[] dy = {1,-1,0,0};
    static int n, m;
    static ArrayList<Pair> candi = new ArrayList<>();
    static int ans = -1;
    static void bfs() {
        for (int i=0; i<n; i++) {
            Arrays.fill(d[i], -1);
        }
        Queue<Pair> q = new LinkedList<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (a[i][j] == 3) {
                    q.add(new Pair(i,j));
                    d[i][j] = 0;
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
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (a[nx][ny] != 1 && d[nx][ny] == -1) {
                        d[nx][ny] = d[x][y] + 1;
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }
        int cur = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (a[i][j] != 1) {
                    if (d[i][j] == -1) return;
                    if (cur < d[i][j]) cur = d[i][j];
                }
            }
        }
        if (ans == -1 || ans > cur) {
            ans = cur;
        }
    }
    static void go(int index, int cnt) {
        if (index == candi.size()) {
            if (cnt == m) {
                bfs();
            }
        } else {
            int x = candi.get(index).x;
            int y = candi.get(index).y;
            a[x][y] = 3;
            go(index+1, cnt+1);
            a[x][y] = 0;
            go(index+1, cnt);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][n];
        d = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                a[i][j] = sc.nextInt();
                if (a[i][j] == 2) {
                    a[i][j] = 0;
                    candi.add(new Pair(i,j));
                }
            }
        }
        go(0,0);
        System.out.println(ans);
    }
}