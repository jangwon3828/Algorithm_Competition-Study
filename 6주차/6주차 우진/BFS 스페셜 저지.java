import java.util.*;

public class BFS 스페셜 저지 {
    static ArrayList<Integer>[] a;
    static int[] check;
    static int[] dist;
    static int go(int x, int p) {
        // -2: found cycle and not included
        // -1: not found cycle
        // 0~n-1: found cycle and start index
        if (check[x] == 1) {
            return x;
        }
        check[x] = 1;
        for (int y : a[x]) {
            if (y == p) continue;
            int res = go(y, x);
            if (res == -2) return -2;
            if (res >= 0) {
                check[x] = 2;
                if (x == res) return -2;
                else return res;
            }
        }
        return -1;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = new ArrayList[n];
        dist = new int[n];
        check = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = new ArrayList<>();
        }
        for (int i=0; i<n; i++) {
            int u = sc.nextInt()-1;
            int v = sc.nextInt()-1;
            a[u].add(v);
            a[v].add(u);
        }
        go(0, -1);

        //BFS
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<n; i++) {
            if (check[i] == 2) {
                dist[i] = 0;
                q.add(i);
            } else {
                dist[i] = -1;
            }
        }
        while (!q.isEmpty()) {
            int x = q.remove();
            for (int y : a[x]) {
                if (dist[y] == -1) {
                    q.add(y);
                    dist[y] = dist[x]+1;
                }
            }
        }
        for (int i=0; i<n; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }
}