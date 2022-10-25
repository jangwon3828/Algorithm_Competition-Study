import java.util.*;

public class 레이저 통신 {
    static class Pair {
        int first;
        int second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    static final int[] dx = {0,0,1,-1};
    static final int[] dy = {1,-1,0,0};
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        String[] a = new String[n];
        int[][] d = new int[n][m];
        int sx,sy,ex,ey;
        sx=sy=ex=ey=-1;
        for (int i=0; i<n; i++) {
            a[i] = sc.next();
            for (int j=0; j<m; j++) {
                d[i][j] = -1;

                if (a[i].charAt(j) == 'C') {
                    if (sx == -1) {
                        sx = i;
                        sy = j;
                    } else {
                        ex = i;
                        ey = j;
                    }
                }
            }
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sx,sy));
        d[sx][sy] = 0;
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.first;
            int y = p.second;
            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                while (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (a[nx].charAt(ny) == '*') break;
                    if (d[nx][ny] == -1) {
                        d[nx][ny] = d[x][y] + 1;
                        q.add(new Pair(nx,ny));
                    }
                    nx += dx[k];
                    ny += dy[k];
                }
            }
        }
        System.out.println(d[ex][ey]-1);
    }
}