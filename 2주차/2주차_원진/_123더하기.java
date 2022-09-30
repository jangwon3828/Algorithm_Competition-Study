package baekjoon;

import java.util.Scanner;

public class _123더하기 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[]a=new int[12];
        a[1]=1;
        a[2]=2;
        a[3]=4;

        for (int i = 4; i < 12; i++) {
            a[i]=a[i-1]+a[i-2]+a[i-3];
        }

        for (int i = 0; i < n; i++) {
            int num=sc.nextInt();
            System.out.println(a[num]);
        }

    }
}
