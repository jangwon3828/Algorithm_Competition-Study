import java.util.Scanner;

public class 1,2,3 더하기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[11];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        for(int i = 4; i<11; i++){
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
        }

        while (N-- > 0) {
            System.out.println(arr[sc.nextInt()]);
        }
    }
}
