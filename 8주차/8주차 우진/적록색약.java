import java.util.*;

public class 적록색약 {
    static final int[] dx = {0,0,1,-1};
    static final int[] dy = {1,-1,0,0};
    static boolean can(boolean blind, char from, char to) {
        if (from == to) return true;
        if (blind) {
            if (from == 'R' && to == 'G') return true;
            if (from == 'G' && to == 'R') return true;
        }
        return false;
    }
    static int go(String[] a, boolean blind) {
        int n = a.length;
        boolean[][] check = new boolean[n][n];
        int ans = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (!check[i][j]) {
                    ans += 1;
                    Queue<Integer> q = new LinkedList<>();
                    q.add(i); q.add(j);
                    check[i][j] = true;
                    while (!q.isEmpty()) {
                        int x = q.remove();
                        int y = q.remove();
                        for (int k=0; k<4; k++) {
                            int nx = x+dx[k];
                            int ny = y+dy[k];
                            if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                                if (check[nx][ny]) continue;
                                if (can(blind,a[x].charAt(y),a[nx].charAt(ny))) {
                                    check[nx][ny] = true;
                                    q.add(nx); q.add(ny);
                                }
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] a = new String[n];
        for (int i=0; i<n; i++) {
            a[i] = sc.next();
        }
        System.out.println(go(a,false) + " " + go(a,true));
    }
}