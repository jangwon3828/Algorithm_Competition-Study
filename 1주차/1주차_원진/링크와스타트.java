import java.util.Scanner;

public class 링크와스타트 {

    public static int n;
    public static int[][] map;
    public static boolean[] visit;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        check(0, 0);
        System.out.println(min);

    }

    private static void check(int dep, int idx) {

        if (dep == n) {
            diff();
            return;
        }
        visit[dep] = true;
        check(dep + 1, idx);
        visit[dep] = false;
        check(dep + 1, idx);


    }

    private static void diff() {
        int start = 0;
        int link = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visit[i] != visit[j]) continue;
                if (visit[i]) start += map[i][j] + map[j][i];
                else link += map[i][j] + map[j][i];
            }

        }

        int re = Math.abs(start - link);
        if (re == 0) {
            System.out.println(0);
            System.exit(0);
        }
        min = Math.min(re, min);
    }
}
