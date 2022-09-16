package baekjoon;

import java.util.Scanner;

public class _123더하기_5 {
    static final long mod = 1000000009L;
    static final int limit = 100000;
    static long[][] d = new long[limit+1][4];
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        for (int i=1; i<=limit; i++) {
            if (i-1 >= 0) {
                d[i][1] = d[i-1][2] + d[i-1][3];
                if (i == 1) {
                    d[i][1] = 1;
                }
            }
            if (i-2 >= 0) {
                d[i][2] = d[i-2][1] + d[i-2][3];
                if (i == 2) {
                    d[i][2] = 1;
                }
            }
            if (i-3 >= 0) {
                d[i][3] = d[i-3][1] + d[i-3][2];
                if (i == 3) {
                    d[i][3] = 1;
                }
            }
            d[i][1] %= mod;
            d[i][2] %= mod;
            d[i][3] %= mod;
        }
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println((d[n][1] + d[n][2] + d[n][3])%mod);
        }
    }
}
