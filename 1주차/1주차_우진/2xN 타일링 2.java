import java.util.Scanner;

public class 2xN 타일링 2.java {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N+1];
        arr[1] = 1;
        arr[2] = 3;
        for(int i = 3; i <= N; i++){
            arr[i] = arr[i-1] + arr[i-2] * 2;
            arr[i] %= 10007;
        }
        System.out.println(arr[N]);
    }
}