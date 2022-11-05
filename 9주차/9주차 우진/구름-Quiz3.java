import java.util.Scanner;

public class Quiz3 {
    static int n;
    static int s;
    static int[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int ans = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 2; k < n; k++) {
                    int temp = go(i, j, k);
                    if ((ans == -1 || ans > temp) && temp != -1)
                        ans = temp;
                }
            }
        }

        System.out.println(ans);
    }

    public static int go(int i, int j, int k){
        int result = 0;

        if (i + k > n || j + k > n)
            return -1;

        for (int l = i; l < i + k; l++) {
            for (int m = j; m < j + k; m++) {
                result += map[l][m];
            }
        }

        return s < result ? k : -1;
    }
}