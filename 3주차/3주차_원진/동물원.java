package baekjoon;

import java.util.Scanner;

public class 동물원 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] d = new int[n+1][3];
        d[0][0] = 1;
        for (int i=1; i<=n; i++) {
            d[i][0] = d[i-1][0] + d[i-1][1] + d[i-1][2];
            d[i][1] = d[i-1][0] + d[i-1][2];
            d[i][2] = d[i-1][0] + d[i-1][1];
            for (int j=0; j<3; j++) {
                d[i][j] %= 9901;
            }
        }
        System.out.println((d[n][0] + d[n][1] + d[n][2])%9901);
    }
}
