import java.util.*;

public class 점프 점프 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] d = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
            d[i] = -1;
        }
        d[0] = 0;
        for (int i=1; i<n; i++) {
            for (int j=0; j<i; j++) {
                if (d[j] != -1 && i-j <= a[j]) {
                    if (d[i] == -1 || d[i] > d[j] + 1) {
                        d[i] = d[j] + 1;
                    }
                }
            }
        }
        System.out.println(d[n-1]);
    }
}