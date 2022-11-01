import java.util.*;

public class 1, 2, 3 더하기 4 {
    static final int limit = 10000;
    static int[] d = new int[limit+1];
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        d[0] = 1;
        for (int i=1; i<=limit; i++) {
            d[i] += d[i-1];
        }
        for (int i=1; i<=limit; i++) {
            if (i-2 >= 0) {
                d[i] += d[i-2];
            }
        }
        for (int i=1; i<=limit; i++) {
            if (i-3 >= 0) {
                d[i] += d[i-3];
            }
        }
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(d[n]);
        }
    }
}