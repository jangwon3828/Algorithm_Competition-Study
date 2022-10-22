import java.util.*;
import java.io.*;

public class 벽 부수고 이동하기4 {
    static int n, m;
    static int[][] a;
    static boolean[][] check;
    static int[][] group;
    static ArrayList<Integer> group_size = new ArrayList<>();
    final static int[] dx = {0,0,1,-1};
    final static int[] dy = {1,-1,0,0};
    static void bfs(int sx, int sy) {
        int g = group_size.size();
        Queue<Integer> q = new LinkedList<>();
        q.add(sx); q.add(sy);
        check[sx][sy] = true;
        group[sx][sy] = g;
        int cnt = 1;
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (a[nx][ny] == 0 && !check[nx][ny]) {
                        q.add(nx); q.add(ny);
                        check[nx][ny] = true;
                        group[nx][ny] = g;
                        cnt += 1;
                    }
                }
            }
        }
        group_size.add(cnt);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] st = bf.readLine().split(" ");
        n = Integer.parseInt(st[0]);
        m = Integer.parseInt(st[1]);
        a = new int[n][m];
        check = new boolean[n][m];
        group = new int[n][m];
        for (int i=0; i<n; i++) {
            String s = bf.readLine();
            for (int j=0; j<m; j++) {
                a[i][j] = s.charAt(j) - '0';
                check[i][j] = false;
                group[i][j] = -1;
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (a[i][j] == 0 && !check[i][j]) {
                    bfs(i, j);
                }
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (a[i][j] == 0) {
                    bw.write("0");
                } else {
                    HashSet<Integer> near = new HashSet<>();
                    for (int k=0; k<4; k++) {
                        int x = i+dx[k];
                        int y = j+dy[k];
                        if (0 <= x && x < n && 0 <= y && y < m) {
                            if (a[x][y] == 0) {
                                near.add(group[x][y]);
                            }
                        }
                    }
                    int ans = 1;
                    for (int g : near) {
                        ans += group_size.get(g);
                    }
                    bw.write(String.valueOf(ans%10));
                }
            }
            bw.write("\n");
        }
        bw.flush();
    }
}