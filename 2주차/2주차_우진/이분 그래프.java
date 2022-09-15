import java.util.*;

public class 이분 그래프 {
    public static boolean dfs(ArrayList<Integer>[] a, int[] visited, int x, int team) {
        visited[x] = team;
        for (int y : a[x]) {
            if (visited[y] == 0) {
                if (dfs(a, visited, y, 3-team) == false) {
                    return false;
                }
            } else if (visited[y] == visited[x]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
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
            int[] visited = new int[n+1];
            boolean ok = true;
            for (int i=1; i<=n; i++) {
                if (visited[i] == 0) {
                    if (dfs(a, visited, i, 1) == false) {
                        ok = false;
                    }
                }
            }
            if (ok) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }
}