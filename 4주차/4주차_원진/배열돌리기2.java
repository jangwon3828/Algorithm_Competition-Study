package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class 배열돌리기2 {


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
        ArrayList<ArrayList<Integer>> groups = new ArrayList<>();
        int groupn = Math.min(n,m)/2;
        for (int k=0; k<groupn; k++) {
            ArrayList<Integer> group = new ArrayList<>();
            for (int j=k; j<m-k; j++) {
                group.add(a[k][j]);
            }
            for (int i=k+1; i<n-k-1; i++) {
                group.add(a[i][m-k-1]);
            }
            for (int j=m-k-1; j>k; j--) {
                group.add(a[n-k-1][j]);
            }
            for (int i=n-k-1; i>k; i--) {
                group.add(a[i][k]);
            }
            groups.add(group);
        }
        for (int k=0; k<groupn; k++) {
            ArrayList<Integer> group = groups.get(k);
            int len = group.size();
            int index = r % len;
            for (int j=k; j<m-k; j++, index = (index+1) % len) {
                a[k][j] = group.get(index);
            }
            for (int i=k+1; i<n-k-1; i++, index = (index+1) % len) {
                a[i][m-k-1] = group.get(index);
            }
            for (int j=m-k-1; j>k; j--, index = (index+1) % len) {
                a[n-k-1][j] = group.get(index);
            }
            for (int i=n-k-1; i>k; i--, index = (index+1) % len) {
                a[i][k] = group.get(index);
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

    }

}
