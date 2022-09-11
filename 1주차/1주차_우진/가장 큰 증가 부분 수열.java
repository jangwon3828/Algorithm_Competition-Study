import java.util.Scanner;

public class 가장 큰 증가 부분 수열 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] d = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
            d[i] = a[i];
        }

        int ans = d[0];

        for (int i=0; i<n; i++) {
            for (int j=0; j<i; j++) {
                if (a[j] < a[i] && d[i] < d[j]+a[i]) {
                    d[i] = d[j]+a[i];
                    ans = Math.max(ans, d[i]);
                }
            }
        }

        System.out.println(ans);
    }
}
