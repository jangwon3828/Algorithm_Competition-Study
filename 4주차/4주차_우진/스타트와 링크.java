import java.util.*;

public class 스타트와 링크 {
    static boolean next_permutation(int[] a) {
        int i = a.length-1;
        while (i > 0 && a[i-1] >= a[i]) {
            i -= 1;
        }

        if (i <= 0) {
            return false;
        }

        int j = a.length-1;
        while (a[j] <= a[i-1]) {
            j -= 1;
        }

        int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;

        j = a.length-1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int[] b = new int[n];
        for (int i=0; i<n/2; i++) {
            b[i] = 1;
        }
        Arrays.sort(b);
        int ans = 2147483647;
        do {
            ArrayList<Integer> first = new ArrayList<>();
            ArrayList<Integer> second = new ArrayList<>();
            for (int i=0; i<n; i++) {
                if (b[i] == 0) {
                    first.add(i);
                } else {
                    second.add(i);
                }
            }
            int one = 0;
            int two = 0;
            for (int i=0; i<n/2; i++) {
                for (int j=0; j<n/2; j++) {
                    if (i == j) continue;
                    one += a[first.get(i)][first.get(j)];
                    two += a[second.get(i)][second.get(j)];
                }
            }
            int diff = one-two;
            if (diff < 0) diff = -diff;
            if (ans > diff) ans = diff;
        } while(next_permutation(b));
        System.out.println(ans);
    }
}