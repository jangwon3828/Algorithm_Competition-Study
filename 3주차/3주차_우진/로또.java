import java.util.*;

public class 로또 {
    static ArrayList<Integer> lotto = new ArrayList<>();
    static void solve(int[] a, int index, int cnt) {
        if (cnt == 6) {
            for (int num : lotto) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        int n = a.length;
        if (n == index) return;
        lotto.add(a[index]);
        solve(a, index+1, cnt+1);
        lotto.remove(lotto.size()-1);
        solve(a, index+1, cnt);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;
            int[] a = new int[n];
            for (int i=0; i<n; i++) {
                a[i] = sc.nextInt();
            }
            solve(a, 0, 0);
            System.out.println();
        }
    }
}