import java.util.*;

public class 소수의연속합 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] c = new boolean[n+1];
        List<Integer> p = new ArrayList<Integer>();
        for (int i=2; i<=n; i++) {
            if (!c[i]) {
                p.add(i);
                for (int j=i*2; j<=n; j+=i) {
                    c[j] = true;
                }
            }
        }
        int l=0;
        int r=0;
        int sum = p.size() == 0 ? 0 : p.get(0);
        int ans = 0;

        while (l <= r && r < p.size()) {
            if (sum <= n) {
                if (sum == n) {
                    ans += 1;
                }
                r++;
                if (r < p.size()) {
                    sum += p.get(r);
                }
            } else {
                sum -= p.get(l++);
            }
        }
        System.out.println(ans);
    }
}