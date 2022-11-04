import java.util.*;

public class 평벙한 배낭 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] w = new int[n + 1];
        int[] v = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        int[][] d = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                d[i][j] = d[i - 1][j];
                if (j - w[i] >= 0) {
                    d[i][j] = Math.max(d[i][j], d[i - 1][j - w[i]] + v[i]);
                }
            }
        }
        System.out.println(d[n][k]);
    }
}