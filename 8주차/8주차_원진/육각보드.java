import java.util.*;
public class Main {
    static String[] a;
    static int n, ans;
    static int[][] color = new int[50][50];
    static int[] dx = {-1,-1,0,0,1,1};
    static int[] dy = {0,1,-1,1,-1,0};
    static void dfs(int x, int y, int c) {
        color[x][y] = c;
        ans = Math.max(ans, 1);
        for (int k=0; k<6; k++) {
            int nx = x+dx[k];
            int ny = y+dy[k];
            if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                if (a[nx].charAt(ny) == 'X') {
                    if (color[nx][ny] == -1) {
                        dfs(nx, ny, 1-c);
                    }
                    ans = Math.max(ans, 2);
                    if (color[nx][ny] == c) {
                        ans = Math.max(ans, 3);
                    }
                }
            }
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new String[n];
        for (int i=0; i<n; i++) {
            a[i] = sc.next();
        }
        for (int i=0; i<50; i++) {
            Arrays.fill(color[i], -1);
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (a[i].charAt(j) == 'X' && color[i][j] == -1) {
                    dfs(i, j, 0);
                }
            }
        }
        System.out.println(ans);
    }
}