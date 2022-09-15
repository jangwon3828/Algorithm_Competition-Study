import java.util.*;

public class 연결 요소의 개수 {
    public static void dfs(ArrayList<Integer>[] a, boolean[] c, int x) {
        if (c[x]) {
            return;
        }
        c[x] = true;
        for (int y : a[x]) {
            if (c[y] == false) {
                dfs(a, c, y);
            }
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer>[] a = new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            a[i] = new ArrayList<>();
        }
        for (int i=0; i<m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            a[u].add(v);
            a[v].add(u);
        }
        boolean[] check = new boolean[n+1];
        int ans = 0;
        for (int i=1; i<=n; i++) {
            if (check[i] == false) {
                dfs(a, check, i);
                ans += 1;
            }
        }
        System.out.println(ans);
    }
}