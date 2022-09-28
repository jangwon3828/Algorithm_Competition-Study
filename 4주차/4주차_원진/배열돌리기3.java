package baekjoon;

import java.util.Scanner;

public class 배열돌리기3 {
    

   static int r;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt();
        int m=sc.nextInt();
        r=sc.nextInt();
        int[][] arr=new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < r; i++) {
            arr=oper1(arr);
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
    private static int[][] oper1(int[][] arr) {
        int n= arr.length;
        int m= arr[0].length;
        int [][] temp=new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][j]=arr[n-i-1][j];
            }
        }


        return temp;
    }
    private static int[][] oper2(int[][] arr) {
        int n= arr.length;
        int m= arr[0].length;
        int [][] temp=new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][j]=arr[i][m-j-1];
            }
        }


        return temp;
    }
    private static int[][] oper3(int[][] arr) {
        int n= arr.length;
        int m= arr[0].length;
        int [][] temp=new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[j][i]=arr[n-i-1][j];
            }
        }


        return temp;
    }
    private static int[][] oper4(int[][] arr) {
        int n= arr.length;
        int m= arr[0].length;
        int [][] temp=new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[j][i]=arr[i][m-1-j];
            }
        }


        return temp;
    }
    private static int[][] oper5(int[][] arr) {
        int n= arr.length;
        int m= arr[0].length;
        int [][] temp=new int[n][m];
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < m/2; j++) {
                temp[i][j]=arr[n/2+i][j];
                temp[i][m/2+j]=arr[i][j];
                temp[n/2+i][m/2+j]=arr[i][m/2+j];
                temp[n/2+i][j]=arr[n/2+i][m/2+j];
            }
        }
        return temp;
    }

    private static int[][] oper6(int[][] arr) {
        int n= arr.length;
        int m= arr[0].length;
        int [][] temp=new int[n][m];
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < m/2; j++) {
                temp[i][j]=arr[i][m/2+j];
                temp[i][m/2+j]=arr[n/2+i][m/2+j];
                temp[n/2+i][m/2+j]=arr[n/2+i][j];
                temp[n/2+i][j]=arr[i][j];
            }
        }
        return temp;
    }


}
