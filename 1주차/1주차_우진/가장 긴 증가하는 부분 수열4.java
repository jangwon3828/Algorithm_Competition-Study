import java.util.Scanner;

public class 가장 긴 증가하는 부분 수열4 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int max = 0;
        int[] A = new int[N];
        int[] D = new int[N];
        int[] S = new int[N];
        for(int i=0; i<N; i++)
            A[i] = sc.nextInt();
        for(int i=0; i<N; i++) {
            D[i] = 1;
            S[i] = -1;
            for(int j=0; j<i; j++)
                if(D[j]>=D[i] && A[i]>A[j]) {
                    D[i] = D[j]+1;
                    S[i] = j;
                    max = (D[i]>D[max])?i:max;
                }
        }
        String ans = "";
        for(int i=max;i>=0;i=S[i])
            ans = A[i] + " " + ans;
        System.out.print(D[max] + "\n" + ans);
    }
}
