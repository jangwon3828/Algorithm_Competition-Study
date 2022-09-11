import java.util.Scanner;

public class 가장 긴 감소하는 부분 수열 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
        int[] d = new int[n+1];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
            d[i] = 1;
        }

        int ans = d[0];

        for (int i=0; i<n; i++) {
            for (int j=0; j<i; j++) {
                if (a[j] > a[i] && d[i] < d[j]+1) {
                    d[i] = d[j]+1;
                    ans = Math.max(d[i], ans);
                }
            }
        }
        System.out.println(ans);
    }
}
