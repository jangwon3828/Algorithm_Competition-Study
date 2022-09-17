import java.util.*;

public class 숨바꼭질 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] visit = new int[100001];

        Queue<Integer> q = new LinkedList<>();
        visit[N] = 1;
        q.add(N);

        int[] s = new int[3];

        while (!q.isEmpty()) {
            int next = q.poll();

            if (next == K) break;

            s[0] = next + 1;
            s[1] = next - 1;
            s[2] = next * 2;

            for (int i = 0; i < 3; i++) {
                if (s[i] <= 100000 && s[i] >= 0 && visit[s[i]] == 0) {
                    visit[s[i]] = visit[next] + 1;
                    q.add(s[i]);
                }
            }
        }
        System.out.println(visit[K] - 1);
    }
}