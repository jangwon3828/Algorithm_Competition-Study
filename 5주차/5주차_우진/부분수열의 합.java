import java.util.*;

public class 부분수열의 합 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        boolean[] c = new boolean[20*100000+10];
        int[] a = new int[20];
        int n = sc.nextInt();
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i=0; i<(1<<n); i++) {
            int sum = 0;
            for (int j=0; j<n; j++) {
                if ((i&(1<<j)) != 0) {
                    sum += a[j];
                }
            }
            c[sum] = true;
        }
        for (int i=1;; i++) {
            if (c[i] == false) {
                System.out.println(i);
                break;
            }
        }
    }
}