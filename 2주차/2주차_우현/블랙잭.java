import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = search(arr, N, M);
        System.out.println(result);
    }

    public static int search(int[] arr, int N, int M) {
        int result = 0;

        for(int i = 0; i < N - 2; i++){
            for(int j = i + 1; j < N - 1; j++) {
                for(int k = j + 1; k < N; k++) {
                    int temp = arr[i] + arr[j] +arr[k];

                    if(M == temp) {
                        return temp;
                    }

                    if(result < temp && temp < M) {
                        result = temp;
                    }
                }
            }
        }
        return result;
    }
}
