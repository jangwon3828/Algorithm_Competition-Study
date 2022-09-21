import java.util.*;

public class 경사로 {
    static boolean go(int[] a, int l) {
        // 한 줄 검사
        int n = a.length;
        boolean[] c = new boolean[n];
        for (int i=1; i<n; i++) {
            if (a[i-1] != a[i]) {
                // 인접한 칸의 높이가 다르면, 경사로를 놓아야 한다.
                int diff = a[i]-a[i-1];
                if (diff < 0) diff = -diff;
                if (diff != 1) {
                    // 낮은 칸과 높은 칸의 높이 차이는 1이어야 한다.
                    return false;
                }
                if (a[i-1] < a[i]) {
                    for (int j=1; j<=l; j++) {
                        if (i-j < 0) {
                            // 경사로를 놓다가 범위를 벗어나는 경우
                            return false;
                        }
                        if (a[i-1] != a[i-j]) {
                            // 낮은 지점의 칸의 높이가 모두 같지 않거나, L개가 연속되지 않은 경우

                            return false;
                        }
                        if (c[i-j]) {
                            // 경사로를 놓은 곳에 또 경사로를 놓는 경우
                            return false;
                        }
                        c[i-j] = true;
                    }
                } else {
                    // a[i-1] > a[i]
                    for (int j=0; j<l; j++) {
                        if (i+j >= n) {
                            // 경사로를 놓다가 범위를 벗어나는 경우
                            return false;
                        }
                        if (a[i] != a[i+j]) {
                            // 낮은 지점의 칸의 높이가 모두 같지 않거나, L개가 연속되지 않은 경우

                            return false;
                        }
                        if (c[i+j]) {
                            // 경사로를 놓은 곳에 또 경사로를 놓는 경우
                            return false;
                        }
                        c[i+j] = true;
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int[][] a = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int ans = 0;
        for (int i=0; i<n; i++) {
            // 행 검사
            int[] d = new int[n];
            for (int j=0; j<n; j++) {
                d[j] = a[i][j];
            }
            if (go(d, l)) ans += 1;
        }
        for (int j=0; j<n; j++) {
            // 열 검사
            int[] d = new int[n];
            for (int i=0; i<n; i++) {
                d[i] = a[i][j];
            }
            if (go(d, l)) ans += 1;
        }
        System.out.println(ans);
    }
}