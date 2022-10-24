import java.util.*;

public class 아기 상어 {
    static class Pair {
        int dist, x, y;
        Pair(int dist, int x, int y) {
            this.dist = dist;
            this.x = x;
            this.y = y;
        }
    }

    static final int[] dx = {0,0,1,-1};
    static final int[] dy = {1,-1,0,0};
    static Pair bfs(int[][] a, int sx, int sy, int size) {
        int n = a.length;
        ArrayList<Pair> ans = new ArrayList<>();
        int[][] d = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                d[i][j] = -1;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(sx); q.add(sy);
        d[sx][sy] = 0;
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < n && d[nx][ny] == -1) {
                    boolean ok = false;
                    boolean eat = false;
                    // 아기 상어는 자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없고, 나머지 칸은 모두 지나갈 수 있다.
                    if (a[nx][ny] == 0) {
                        ok = true;
                    } else if (a[nx][ny] < size) { // 아기 상어는 자신의 크기보다 작은 물고기만 먹을 수 있다.
                        ok = eat = true;
                    } else if (a[nx][ny] == size) { // 크기가 같은 물고기는 먹을 수 없지만, 그 물고기가 있는 칸은 지나갈 수 있다.
                        ok = true;
                    }
                    if (ok) {
                        q.add(nx); q.add(ny);
                        d[nx][ny] = d[x][y] + 1;
                        if (eat) {
                            ans.add(new Pair(d[nx][ny], nx, ny));
                        }
                    }
                }
            }
        }
        if (ans.isEmpty()) {
            return null;
        }
        Pair best = ans.get(0);
        for (Pair p : ans) {
            if (best.dist > p.dist) {
                best = p;
            } else if (best.dist == p.dist && best.x > p.x) {
                best = p;
            } else if (best.dist == p.dist && best.x == p.x && best.y > p.y) {
                best = p;
            }
        }
        return best;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        int x = 0, y = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                a[i][j] = sc.nextInt();
                if (a[i][j] == 9) {
                    x = i; y = j;
                    a[i][j] = 0;
                }
            }
        }
        int ans = 0;
        int size = 2;
        int exp = 0;
        while (true) {
            Pair p = bfs(a, x, y, size);
            if (p == null) break;
            a[p.x][p.y] = 0;
            ans += p.dist;
            exp += 1;
            if (size == exp) {
                size += 1;
                exp = 0;
            }
            x = p.x;
            y = p.y;
        }
        System.out.println(ans);
    }
}