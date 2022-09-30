package baekjoon;

import java.util.Scanner;

public class 정수삼각형 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        int[][] d = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<=i; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        d[0][0] = a[0][0];
        for (int i=1; i<n; i++) {
            for (int j=0; j<=i; j++) {
                d[i][j] = d[i-1][j] + a[i][j];
                if (j-1 >= 0 && d[i][j] < d[i-1][j-1] + a[i][j]) {
                    d[i][j] = d[i-1][j-1] + a[i][j];
                }
            }
        }
        int ans = d[n-1][0];
        for (int i=0; i<n; i++) {
            if (ans < d[n-1][i]) {
                ans = d[n-1][i];
            }
        }
        System.out.println(ans);
    }
}
