import java.util.*;

public class 부분합 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] a = new int[n+1];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        int i=0;
        int j=0;
        int sum=a[0];
        int ans=n+1;
        while (i <= j && j < n) {
            if (sum < s) {
                j += 1;
                sum += a[j];
            } else if (sum == s) {
                ans = Math.min(j-i+1,ans);
                j += 1;
                sum += a[j];
            } else if (sum > s) {
                ans = Math.min(j-i+1,ans);
                sum -= a[i];
                i++;
            }
        }
        if (ans > n) {
            ans = 0;
        }
        System.out.println(ans);
    }
}