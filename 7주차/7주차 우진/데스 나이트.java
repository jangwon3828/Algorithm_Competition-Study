import java.util.*;

public class 데스 나이트 {
    final static int[] dx = {-2,-2,0,0,2,2};
    final static int[] dy = {-1,1,-2,2,-1,1};
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sx = sc.nextInt();
        int sy = sc.nextInt();
        int ex = sc.nextInt();
        int ey = sc.nextInt();
        int[][] dist = new int[n][n];
        for (int i=0; i<n; i++) {
            Arrays.fill(dist[i], -1);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(sx); q.add(sy);
        dist[sx][sy] = 0;
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            for (int k=0; k<6; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (dist[nx][ny] == -1) {
                        q.add(nx); q.add(ny);
                        dist[nx][ny] = dist[x][y] + 1;
                    }
                }
            }
        }
        System.out.println(dist[ex][ey]);
    }
}