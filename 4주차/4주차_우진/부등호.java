import java.util.*;
public class 부등호 {
    static boolean prev_permutation(int[] a) {
        int i = a.length-1;
        while (i > 0 && a[i-1] <= a[i]) {
            i -= 1;
        }

        if (i <= 0) {
            return false;
        }

        int j = a.length-1;
        while (a[j] >= a[i-1]) {
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
    static boolean check(int[] perm, char[] a) {
        for (int i=0; i<a.length; i++) {
            if (a[i] == '<' && perm[i] > perm[i+1]) {
                return false;
            }
            if (a[i] == '>' && perm[i] < perm[i+1]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        char[] a = new char[k];
        for (int i=0; i<k; i++) {
            a[i] = sc.next().charAt(0);
        }
        int[] small = new int[k+1];
        int[] big = new int[k+1];
        for (int i=0; i<=k; i++) {
            small[i] = i;
            big[i] = 9-i;
        }
        do {
            if (check(small, a)) {
                break;
            }
        } while(next_permutation(small));
        do {
            if (check(big, a)) {
                break;
            }
        } while(prev_permutation(big));
        for (int i=0; i<big.length; i++) {
            System.out.print(big[i]);
        }
        System.out.println();
        for (int i=0; i<small.length; i++) {
            System.out.print(small[i]);
        }
        System.out.println();
    }
}
