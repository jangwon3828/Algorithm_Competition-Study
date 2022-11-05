import java.util.Scanner;

public class Quiz2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] event = new int[100001];
        while (m-- > 0){
            int k = sc.nextInt();
            while (k-- > 0){
                event[sc.nextInt()]++;
            }
        }

        int max = 0;
        for (int i = 0; i < 100001; i++) {
            if (max < event[i])
                max = event[i];
        }

        for (int i = 100000; i > 0; i--) {
            if (event[i] == max)
                System.out.print(i + " ");
        }
    }
}