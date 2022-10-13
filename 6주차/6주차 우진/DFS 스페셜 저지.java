import java.util.*;

public class DFS 스페셜 저지 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer>[] a = new ArrayList[n];
        int[] b = new int[n];
        int[] order = new int[n];
        boolean[] check = new boolean[n];
        for (int i=0; i<n; i++) {
            a[i] = new ArrayList<>();
        }
        for (int i=0; i<n-1; i++) {
            int u = sc.nextInt()-1;
            int v = sc.nextInt()-1;
            a[u].add(v);
            a[v].add(u);
        }
        for (int i=0; i<n; i++) {
            b[i] = sc.nextInt()-1;
            order[b[i]] = i;
        }

        //오름차순 정렬
        for (int i=0; i<n; i++) {
            a[i].sort((u, v) -> {
                if (order[u] < order[v]) {
                    return -1;
                } else if (order[u] == order[v]) {
                    return 0;
                } else {
                    return 1;
                }
            });
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        check[0] = true;
        ArrayList<Integer> queue= new ArrayList<>();
        while (!q.isEmpty()) {
            int x = q.remove();
            queue.add(x);
            for (int y : a[x]) {
                if (!check[y]) {
                    check[y] = true;
                    q.add(y);
                }
            }
        }
        boolean ok = true;
        for (int i=0; i<n; i++) {
            if (queue.get(i) != b[i]) {
                ok = false;
                break;
            }
        }
        if (ok) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}