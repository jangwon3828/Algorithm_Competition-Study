package 그래프;

import java.util.*;

public class 뱀과 사다리 게임 {
    static char[][] a;
    static boolean[][] check;
    static int n, m;
    final static int[] dx = {0,0,1,-1};
    final static int[] dy = {1,-1,0,0};
    static boolean go(int x, int y, int px, int py, char color) {
        if (check[x][y]) {
            return true;
        }
        check[x][y] = true;
        for (int k=0; k<4; k++) {
            int nx = x+dx[k];
            int ny = y+dy[k];
            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                if (!(nx == px && ny == py)) {
                    if (a[nx][ny] == color) {
                        if (go(nx, ny, x, y, color)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new char[n][m];
        check = new boolean[n][m];
        for (int i=0; i<n; i++) {
            a[i] = sc.next().toCharArray();
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (check[i][j]) continue;
                boolean ok = go(i, j, -1, -1, a[i][j]);
                if (ok) {
                    System.out.println("Yes");
                    System.exit(0);
                }
            }
        }
        System.out.println("No");
    }
}