import java.util.*;

public class 배열돌리기3 {
    static int[][] operation1(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] ans = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                ans[i][j] = a[n-i-1][j];
            }
        }
        return ans;
    }
    static int[][] operation2(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] ans = new int[n][m];;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                ans[i][j] = a[i][m-j-1];
            }
        }
        return ans;
    }
    static int[][] operation3(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] ans = new int[m][n];;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                ans[i][j] = a[n-j-1][i];
            }
        }
        return ans;
    }
    static int[][] operation4(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] ans = new int[m][n];;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                ans[i][j] = a[j][m-i-1];
            }
        }
        return ans;
    }
    static int[][] operation5(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] ans = new int[n][m];;
        for (int i=0; i<n/2; i++) {
            for (int j=0; j<m/2; j++) {
                ans[i][j+m/2] = a[i][j];
                ans[i+n/2][j+m/2] = a[i][j+m/2];
                ans[i+n/2][j] = a[i+n/2][j+m/2];
                ans[i][j] = a[i+n/2][j];
            }
        }
        return ans;
    }
    static int[][] operation6(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] ans = new int[n][m];;
        for (int i=0; i<n/2; i++) {
            for (int j=0; j<m/2; j++) {
                ans[i+n/2][j] = a[i][j];
                ans[i][j] = a[i][j+m/2];
                ans[i][j+m/2] = a[i+n/2][j+m/2];
                ans[i+n/2][j+m/2] = a[i+n/2][j];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();
        int[][] a = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        while (r-- > 0) {
            int op = sc.nextInt();
            if (op == 1) {
                a = operation1(a);
            } else if (op == 2) {
                a = operation2(a);
            } else if (op == 3) {
                a = operation3(a);
            } else if (op == 4) {
                a = operation4(a);
            } else if (op == 5) {
                a = operation5(a);
            } else if (op == 6) {
                a = operation6(a);
            }
        }
        for (int i=0; i<a.length; i++) {
            for (int j=0; j<a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}