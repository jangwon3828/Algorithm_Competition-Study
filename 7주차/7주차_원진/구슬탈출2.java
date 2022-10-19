package baekjoon;

import java.util.Scanner;

class Result {
    boolean moved, hole;
    int x, y;
    Result(boolean moved, boolean hole, int x, int y) {
        this.moved = moved;
        this.hole = hole;
        this.x = x;
        this.y = y;
    }
}
public class 구슬탈출2 {

        static int[] dx = {0,0,1,-1};
        static int[] dy = {1,-1,0,0};
        static final int LIMIT = 10;
        static int[] gen(int k) {
            int[] dir = new int[LIMIT];
            for (int i=0; i<LIMIT; i++) {
                dir[i] = (k&3);
                k >>= 2;
            }
            return dir;
        }
        static Result simulate(char[][] a, int k, int x, int y) {
            int n = a.length;
            int m = a[0].length;
            if (a[x][y] == '.') return new Result(false, false, x, y);
            boolean moved = false;
            while (true) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    return new Result(moved, false, x, y);
                }
                char ch = a[nx][ny];
                if (ch == '#') {
                    return new Result(moved, false, x, y);
                } else if (ch == 'R' || ch == 'B') {
                    return new Result(moved, false, x, y);
                } else if (ch == '.') {
                    char temp = a[nx][ny];
                    a[nx][ny] = a[x][y];
                    a[x][y] = temp;
                    x = nx;
                    y = ny;
                    moved = true;
                } else if (ch == 'O') {
                    a[x][y] = '.';
                    moved = true;
                    return new Result(moved, true, x, y);
                }
            }
        }
        static int check(char[][] a, int[] dir) {
            int n = a.length;
            int m = a[0].length;
            int hx = 0, hy = 0;
            int rx = 0, ry = 0;
            int bx = 0, by = 0;
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    if (a[i][j] == 'O') {
                        hx = i; hy = j;
                    } else if (a[i][j] == 'R') {
                        rx = i; ry = j;
                    } else if (a[i][j] == 'B') {
                        bx = i; by = j;
                    }
                }
            }
            int cnt = 0;
            for (int k : dir) {
                cnt += 1;
                boolean hole1 = false, hole2 = false;
                while (true) {
                    Result p1 = simulate(a, k, rx, ry);
                    rx = p1.x; ry = p1.y;
                    Result p2 = simulate(a, k, bx, by);
                    bx = p2.x; by = p2.y;
                    if (p1.moved == false && p2.moved == false) {
                        break;
                    }
                    if (p1.hole) hole1 = true;
                    if (p2.hole) hole2 = true;
                }
                if (hole2) return -1;
                if (hole1) return cnt;
            }
            return -1;
        }
        static boolean valid(int[] dir) {
            int l = dir.length;
            for (int i=0; i+1<l; i++) {
                if (dir[i] == 0 && dir[i+1] == 1) return false;
                if (dir[i] == 1 && dir[i+1] == 0) return false;
                if (dir[i] == 2 && dir[i+1] == 3) return false;
                if (dir[i] == 3 && dir[i+1] == 2) return false;
                if (dir[i] == dir[i+1]) return false;
            }
            return true;
        }
        public static void main(String args[]) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();
            String[] map = new String[n];
            char[][] a = new char[n][m];
            for (int i=0; i<n; i++) {
                map[i] = sc.next();
            }
            int ans = -1;
            for (int k=0; k<(1<<(LIMIT*2)); k++) {
                int[] dir = gen(k);
                if (!valid(dir)) continue;
                for (int i=0; i<n; i++) {
                    a[i] = map[i].toCharArray();
                }
                int cur = check(a, dir);
                if (cur == -1) continue;
                if (ans == -1 || ans > cur) ans = cur;
            }
            System.out.println(ans);
        }

}
