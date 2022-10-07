import java.util.*;

public class 겉넓이 구하기 {
    final static int[] dx = {0,0,1,-1};
    final static int[] dy = {1,-1,0,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[102][102];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        //윗면 아랫면 저장
        int ans = 2*n*m;
        for (int x=1; x<=n; x++) {
            for (int y=1; y<=m; y++) {
                for (int k=0; k<4; k++) {
                    int nx = x+dx[k];
                    int ny = y+dy[k];
                    if (a[x][y]-a[nx][ny] >= 0) {
                        ans += a[x][y]-a[nx][ny];
                    }
                }
            }
        }
        System.out.println(ans);
    }
}