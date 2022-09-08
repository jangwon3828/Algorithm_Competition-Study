import java.util.Scanner;

public class 이친수 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //go1(n);
        go2(n);
    }

    private static void go1(int n){
        long[] d = new long[n+1];
        d[1] = 1;
        if (n >= 2) {
            d[2] = 1;
        }
        for (int i=3; i<=n; i++) {
            d[i] = d[i-1] + d[i-2];
        }
        System.out.println(d[n]);
    }

    private static void go2(int n){
        long[][] d = new long[n+1][2];
        d[1][0] = 0;
        d[1][1] = 1;
        d[2][0] = 1;
        d[2][1] = 0;

        for (int i = 3; i <= n; i++) {
            d[i][0] = d[i-1][0] + d[i-1][1];
            d[i][1] = d[i-1][0];
        }
        System.out.println(d[n][1] + d[n][0]);
    }
}