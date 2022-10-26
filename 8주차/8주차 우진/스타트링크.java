import java.util.*;

public class 스타트링크 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int f = sc.nextInt();
        int s = sc.nextInt();
        int g = sc.nextInt();
        int u = sc.nextInt();
        int d = sc.nextInt();
        int[] dist = new int[f+1];
        boolean[] check = new boolean[f+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        check[s] = true;
        while (!q.isEmpty()) {
            int now = q.remove();
            if (now + u <= f && !check[now + u]) {
                dist[now+u] = dist[now] + 1;
                check[now+u] = true;
                q.add(now+u);
            }
            if (now - d >= 1 && !check[now - d]) {
                dist[now-d] = dist[now] + 1;
                check[now-d] = true;
                q.add(now-d);
            }
        }
        if (check[g]) {
            System.out.println(dist[g]);
        } else {
            System.out.println("use the stairs");
        }
    }
}