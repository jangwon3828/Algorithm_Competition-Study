import java.util.*;

public class 배열복원하기 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[][] a = new int[h+x][w+y];
        for (int i=0; i<h+x; i++) {
            for (int j=0; j<w+y; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        for (int i=0; i<h; i++) {
            for (int j=0; j<w; j++) {
                a[i+x][j+y] -= a[i][j];
            }
        }
        for (int i=0; i<h; i++) {
            for (int j=0; j<w; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}